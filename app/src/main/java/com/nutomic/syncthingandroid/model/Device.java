package com.nutomic.syncthingandroid.model;

import android.text.TextUtils;

import java.util.List;

public class Device
{
    private String deviceID;
    private String name = "";
    private List< String > addresses;
    private String compression;
    private String certName;
    private boolean introducer;
    private boolean paused;
    private List< IgnoredFolder > ignoredFolders;

    public Device( String deviceID, String name )
    {
        this.deviceID = deviceID;
        this.name = name;
    }

    public String getDeviceID()
    {
        return deviceID;
    }

    public void setDeviceID( String deviceID )
    {
        this.deviceID = deviceID;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public List< String > getAddresses()
    {
        return addresses;
    }

    public void setAddresses( List< String > addresses )
    {
        this.addresses = addresses;
    }

    public String getCompression()
    {
        return compression;
    }

    public void setCompression( String compression )
    {
        this.compression = compression;
    }

    public String getCertName()
    {
        return certName;
    }

    public void setCertName( String certName )
    {
        this.certName = certName;
    }

    public boolean isIntroducer()
    {
        return introducer;
    }

    public void setIntroducer( boolean introducer )
    {
        this.introducer = introducer;
    }

    public boolean isPaused()
    {
        return paused;
    }

    public void setPaused( boolean paused )
    {
        this.paused = paused;
    }

    public List< IgnoredFolder > getIgnoredFolders()
    {
        return ignoredFolders;
    }

    public void setIgnoredFolders( List< IgnoredFolder > ignoredFolders )
    {
        this.ignoredFolders = ignoredFolders;
    }

    /**
     * Returns the device name, or the first characters of the ID if the name is empty.
     */
    public String getDisplayName()
    {
        return ( TextUtils.isEmpty( name ) )
                ? deviceID.substring( 0, 7 )
                : name;
    }

    public boolean addIgnoredFolder( IgnoredFolder ignoredFolder )
    {
        return ignoredFolders.add( ignoredFolder );
    }
}
