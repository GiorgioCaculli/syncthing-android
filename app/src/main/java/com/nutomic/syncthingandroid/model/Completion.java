package com.nutomic.syncthingandroid.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class caches remote folder and device synchronization
 * completion indicators defined in {@link CompletionInfo#CompletionInfo}
 * according to syncthing's REST "/completion" JSON result schema.
 * Completion model of syncthing's web UI is completion[deviceId][folderId]
 */
public class Completion
{

    private static final String TAG = "Completion";

    HashMap< String, HashMap< String, CompletionInfo > > deviceFolderMap = new HashMap<>();

    /**
     * Removes a folder from the cache model.
     */
    private void removeFolder( String folderId )
    {
        for ( HashMap< String, CompletionInfo > folderMap : deviceFolderMap.values() )
        {
            if ( folderMap.containsKey( folderId ) )
            {
                folderMap.remove( folderId );
                break;
            }
        }
    }

    /**
     * Updates device and folder information in the cache model
     * after a config update.
     */
    public void updateFromConfig( List< Device > newDevices, List< Folder > newFolders )
    {
        HashMap< String, CompletionInfo > folderMap;

        // Handle devices that were removed from the config.
        List< String > removedDevices = new ArrayList<>();
        boolean deviceFound;
        for ( String deviceId : deviceFolderMap.keySet() )
        {
            deviceFound = false;
            for ( Device device : newDevices )
            {
                if ( device.getDeviceID().equals( deviceId ) )
                {
                    deviceFound = true;
                    break;
                }
            }
            if ( !deviceFound )
            {
                removedDevices.add( deviceId );
            }
        }
        for ( String deviceId : removedDevices )
        {
            Log.v( TAG, "updateFromConfig: Remove device '" + deviceId + "' from cache model" );
            deviceFolderMap.remove( deviceId );
        }

        // Handle devices that were added to the config.
        for ( Device device : newDevices )
        {
            if ( !deviceFolderMap.containsKey( device.getDeviceID() ) )
            {
                Log.v( TAG, "updateFromConfig: Add device '" + device.getDeviceID() + "' to cache model" );
                deviceFolderMap.put( device.getDeviceID(), new HashMap<>() );
            }
        }

        // Handle folders that were removed from the config.
        List< String > removedFolders = new ArrayList<>();
        boolean folderFound;
        for ( Map.Entry< String, HashMap< String, CompletionInfo > > device : deviceFolderMap.entrySet() )
        {
            for ( String folderId : device.getValue().keySet() )
            {
                folderFound = false;
                for ( Folder folder : newFolders )
                {
                    if ( folder.getId().equals( folderId ) )
                    {
                        folderFound = true;
                        break;
                    }
                }
                if ( !folderFound )
                {
                    removedFolders.add( folderId );
                }
            }
        }
        for ( String folderId : removedFolders )
        {
            Log.v( TAG, "updateFromConfig: Remove folder '" + folderId + "' from cache model" );
            removeFolder( folderId );
        }

        // Handle folders that were added to the config.
        for ( Folder folder : newFolders )
        {
            for ( Device device : newDevices )
            {
                if ( folder.getDevice( device.getDeviceID() ) != null )
                {
                    // folder is shared with device.
                    folderMap = deviceFolderMap.get( device.getDeviceID() );
                    assert folderMap != null;
                    if ( !folderMap.containsKey( folder.getId() ) )
                    {
                        Log.v( TAG, "updateFromConfig: Add folder '" + folder.getId() +
                                "' shared with device '" + device.getDeviceID() + "' to cache model." );
                        folderMap.put( folder.getId(), new CompletionInfo() );
                    }
                }
            }
        }
    }

    /**
     * Calculates remote device sync completion percentage across all folders
     * shared with the device.
     */
    public int getDeviceCompletion( String deviceId )
    {
        int folderCount = 0;
        double sumCompletion = 0;
        HashMap< String, CompletionInfo > folderMap = deviceFolderMap.get( deviceId );
        if ( folderMap != null )
        {
            for ( Map.Entry< String, CompletionInfo > folder : folderMap.entrySet() )
            {
                sumCompletion += folder.getValue().getCompletion();
                folderCount++;
            }
        }
        if ( folderCount == 0 )
        {
            return 100;
        }
        else
        {
            return ( int ) Math.floor( sumCompletion / folderCount );
        }
    }

    /**
     * Set completionInfo within the completion[deviceId][folderId] model.
     */
    public void setCompletionInfo( String deviceId, String folderId,
                                   CompletionInfo completionInfo )
    {
        // Add device parent node if it does not exist.
        if ( !deviceFolderMap.containsKey( deviceId ) )
        {
            deviceFolderMap.put( deviceId, new HashMap<>() );
        }
        // Add folder or update existing folder entry.
        Objects.requireNonNull( deviceFolderMap.get( deviceId ) ).put( folderId, completionInfo );
    }
}
