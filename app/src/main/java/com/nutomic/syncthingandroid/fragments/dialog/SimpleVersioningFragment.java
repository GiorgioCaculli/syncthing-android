package com.nutomic.syncthingandroid.fragments.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nutomic.syncthingandroid.R;
import com.nutomic.syncthingandroid.fragments.NumberPickerFragment;

import java.util.Objects;

/**
 * Contains the configuration options for simple file versioning.
 */

public class SimpleVersioningFragment extends Fragment
{

    private Bundle mArguments;

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState )
    {
        View view = inflater.inflate( R.layout.fragment_simple_versioning, container, false );
        mArguments = getArguments();
        fillArguments();
        updateNumberPicker();
        return view;
    }

    private void fillArguments()
    {
        if ( missingParameters() )
        {
            mArguments.putString( "keep", "5" );
        }
    }

    private boolean missingParameters()
    {
        return !mArguments.containsKey( "keep" );
    }

    //a NumberPickerFragment is nested in the fragment_simple_versioning layout, the values for it are update below.
    private void updateNumberPicker()
    {
        NumberPickerFragment numberPicker = ( NumberPickerFragment ) getChildFragmentManager().findFragmentByTag( "numberpicker_simple_versioning" );
        assert numberPicker != null;
        numberPicker.updateNumberPicker( 100000, 1, getKeepVersions() );
        numberPicker.setOnValueChangedListener( ( picker, oldVal, newVal ) -> updateKeepVersions( ( String.valueOf( newVal ) ) ) );
    }

    private void updateKeepVersions( String newValue )
    {
        mArguments.putString( "keep", newValue );
    }

    private int getKeepVersions()
    {
        return Integer.parseInt( Objects.requireNonNull( mArguments.getString( "keep" ) ) );
    }

}
