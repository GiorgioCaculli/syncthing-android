package com.nutomic.syncthingandroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.nutomic.syncthingandroid.R;
import com.nutomic.syncthingandroid.databinding.ActivityVersioningDialogBinding;
import com.nutomic.syncthingandroid.fragments.dialog.ExternalVersioningFragment;
import com.nutomic.syncthingandroid.fragments.dialog.NoVersioningFragment;
import com.nutomic.syncthingandroid.fragments.dialog.SimpleVersioningFragment;
import com.nutomic.syncthingandroid.fragments.dialog.StaggeredVersioningFragment;
import com.nutomic.syncthingandroid.fragments.dialog.TrashCanVersioningFragment;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class VersioningDialogActivity extends ThemedAppCompatActivity
{

    private static final List< String > mTypes = Arrays.asList( "none", "trashcan", "simple", "staggered", "external" );
    private Fragment mCurrentFragment;
    private Bundle mArguments;

    private ActivityVersioningDialogBinding binding;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        binding = ActivityVersioningDialogBinding.inflate( getLayoutInflater() );
        setContentView( binding.getRoot() );

        if ( savedInstanceState != null )
        {
            mArguments = savedInstanceState.getBundle( "arguments" );
        }
        else
        {
            mArguments = getIntent().getExtras();
        }

        updateFragmentView( mTypes.indexOf( Objects.requireNonNull( getIntent().getExtras() ).getString( "type" ) ) );
        initiateFinishBtn();
        initiateSpinner();
    }

    private void initiateFinishBtn()
    {
        binding.finishBtn.setOnClickListener( v ->
        {
            saveConfiguration();
            finish();
        } );
    }

    private void saveConfiguration()
    {
        Intent intent = new Intent();
        assert mCurrentFragment.getArguments() != null;
        intent.putExtras( mCurrentFragment.getArguments() );
        setResult( Activity.RESULT_OK, intent );
    }

    private void initiateSpinner()
    {
        binding.versioningTypeSpinner.setSelection( mTypes.indexOf( Objects.requireNonNull( getIntent().getExtras() ).getString( "type" ) ) );
        binding.versioningTypeSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected( AdapterView< ? > parent, View view, int position, long id )
            {
                if ( position != mTypes.indexOf( Objects.requireNonNull( getIntent().getExtras() ).getString( "type" ) ) )
                {
                    updateVersioningType( position );
                    updateFragmentView( position );
                }
            }

            @Override
            public void onNothingSelected( AdapterView< ? > parent )
            {

            }
        } );
    }

    private void updateVersioningType( int position )
    {
        mArguments.putString( "type", mTypes.get( position ) );
    }

    private void updateFragmentView( int selection )
    {
        if ( mCurrentFragment != null )
        {
            mArguments = mCurrentFragment.getArguments();
        }

        mCurrentFragment = getFragment( selection );
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //This Activtiy (VersioningDialogActivity) contains all the file versioning parameters that have been passed from the FolderActivity in the intent extras, so we simply
        // pass that to the currentfragment.
        mCurrentFragment.setArguments( mArguments );
        transaction.replace( R.id.versioningFragmentContainer, mCurrentFragment );
        transaction.commit();
    }

    private Fragment getFragment( int selection )
    {

        return switch ( selection )
        {
            case 0 -> new NoVersioningFragment();
            case 1 -> new TrashCanVersioningFragment();
            case 2 -> new SimpleVersioningFragment();
            case 3 -> new StaggeredVersioningFragment();
            case 4 -> new ExternalVersioningFragment();
            default -> null;
        };
    }

    @Override
    protected void onSaveInstanceState( @NonNull Bundle outState )
    {
        super.onSaveInstanceState( outState );
        outState.putBundle( "arguments", mCurrentFragment.getArguments() );
    }

    @Override
    public void onBackPressed()
    {
        saveConfiguration();
        super.onBackPressed();
    }
}
