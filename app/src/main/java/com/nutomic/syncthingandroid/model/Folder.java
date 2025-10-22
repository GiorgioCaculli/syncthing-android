package com.nutomic.syncthingandroid.model;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.nutomic.syncthingandroid.service.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Folder
{
    private final boolean ignorePerms;
    private final List< Device > devices;
    private final String filesystemType;
    private final int fsWatcherDelayS;
    private final boolean autoNormalize;
    private final int maxConflicts;
    private final int weakHashThresholdPct;
    private final String markerName;
    private boolean fsWatcherEnabled;
    private String type;
    private String id;
    private String label;
    private String path;
    private int rescanIntervalS;
    private MinDiskFree minDiskFree;
    private Versioning versioning;
    private int copiers;
    private int pullerMaxPendingKiB;
    private int hashers;
    private String order;
    private boolean ignoreDelete;
    private int scanProgressIntervalS;
    private int pullerPauseS;
    private boolean disableSparseFiles;
    private boolean disableTempIndexes;
    private boolean paused;
    private boolean useLargeBlocks;
    private String invalid;

    public Folder( String id, String label, int rescanIntervalS, boolean paused, Versioning versioning )
    {
        this.ignorePerms = true;
        this.devices = new ArrayList<>();
        this.filesystemType = "basic";
        this.type = Constants.FOLDER_TYPE_SEND_RECEIVE;
        this.fsWatcherEnabled = true;
        this.fsWatcherDelayS = 10;
        this.autoNormalize = true;
        this.maxConflicts = 10;
        this.weakHashThresholdPct = 25;
        this.markerName = ".stfolder";
        this.id = id;
        this.label = label;
        this.rescanIntervalS = rescanIntervalS;
        this.versioning = versioning;
        this.paused = paused;
    }

    public boolean isIgnorePerms()
    {
        return ignorePerms;
    }

    public List< Device > getDevices()
    {
        return devices;
    }

    public String getFilesystemType()
    {
        return filesystemType;
    }

    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

    public boolean isFsWatcherEnabled()
    {
        return fsWatcherEnabled;
    }

    public void setFsWatcherEnabled( boolean fsWatcherEnabled )
    {
        this.fsWatcherEnabled = fsWatcherEnabled;
    }


    public int getFsWatcherDelayS()
    {
        return fsWatcherDelayS;
    }

    public boolean isAutoNormalize()
    {
        return autoNormalize;
    }

    public int getMaxConflicts()
    {
        return maxConflicts;
    }

    public int getWeakHashThresholdPct()
    {
        return weakHashThresholdPct;
    }

    public String getMarkerName()
    {
        return markerName;
    }

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel( String label )
    {
        this.label = label;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath( String path )
    {
        this.path = path;
    }

    public int getRescanIntervalS()
    {
        return rescanIntervalS;
    }

    public void setRescanIntervalS( int rescanIntervalS )
    {
        this.rescanIntervalS = rescanIntervalS;
    }

    public MinDiskFree getMinDiskFree()
    {
        return minDiskFree;
    }

    public void setMinDiskFree( MinDiskFree minDiskFree )
    {
        this.minDiskFree = minDiskFree;
    }

    public Versioning getVersioning()
    {
        return versioning;
    }

    public void setVersioning( Versioning versioning )
    {
        this.versioning = versioning;
    }

    public int getCopiers()
    {
        return copiers;
    }

    public void setCopiers( int copiers )
    {
        this.copiers = copiers;
    }

    public int getPullerMaxPendingKiB()
    {
        return pullerMaxPendingKiB;
    }

    public void setPullerMaxPendingKiB( int pullerMaxPendingKiB )
    {
        this.pullerMaxPendingKiB = pullerMaxPendingKiB;
    }

    public int getHashers()
    {
        return hashers;
    }

    public void setHashers( int hashers )
    {
        this.hashers = hashers;
    }

    public String getOrder()
    {
        return order;
    }

    public void setOrder( String order )
    {
        this.order = order;
    }

    public boolean isIgnoreDelete()
    {
        return ignoreDelete;
    }

    public void setIgnoreDelete( boolean ignoreDelete )
    {
        this.ignoreDelete = ignoreDelete;
    }

    public int getScanProgressIntervalS()
    {
        return scanProgressIntervalS;
    }

    public void setScanProgressIntervalS( int scanProgressIntervalS )
    {
        this.scanProgressIntervalS = scanProgressIntervalS;
    }

    public int getPullerPauseS()
    {
        return pullerPauseS;
    }

    public void setPullerPauseS( int pullerPauseS )
    {
        this.pullerPauseS = pullerPauseS;
    }

    public boolean isDisableSparseFiles()
    {
        return disableSparseFiles;
    }

    public void setDisableSparseFiles( boolean disableSparseFiles )
    {
        this.disableSparseFiles = disableSparseFiles;
    }

    public boolean isDisableTempIndexes()
    {
        return disableTempIndexes;
    }

    public void setDisableTempIndexes( boolean disableTempIndexes )
    {
        this.disableTempIndexes = disableTempIndexes;
    }

    public boolean isPaused()
    {
        return paused;
    }

    public void setPaused( boolean paused )
    {
        this.paused = paused;
    }

    public boolean isUseLargeBlocks()
    {
        return useLargeBlocks;
    }

    public void setUseLargeBlocks( boolean useLargeBlocks )
    {
        this.useLargeBlocks = useLargeBlocks;
    }

    public String getInvalid()
    {
        return invalid;
    }

    public void setInvalid( String invalid )
    {
        this.invalid = invalid;
    }

    public boolean addDevice( String deviceId )
    {
        Device d = new Device( deviceId, "" );
        return devices.add( d );
    }

    public Device getDevice( String deviceId )
    {
        for ( Device d : devices )
        {
            if ( d.getDeviceID().equals( deviceId ) )
            {
                return d;
            }
        }
        return null;
    }

    public boolean removeDevice( String deviceId )
    {
        for ( Iterator< Device > it = getDevices().iterator();
              it.hasNext(); )
        {
            String currentId = it.next().getDeviceID();
            if ( currentId.equals( deviceId ) )
            {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @NonNull
    @Override
    public String toString()
    {
        return !TextUtils.isEmpty( label ) ? label : id;
    }

    public static class Versioning implements Serializable
    {
        public String type;
        public Map< String, String > params = new HashMap<>();
    }

    public static class MinDiskFree
    {
        public float value;
        public String unit;
    }
}
