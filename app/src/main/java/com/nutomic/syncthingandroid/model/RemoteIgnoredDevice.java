package com.nutomic.syncthingandroid.model;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import java.util.Objects;

public class RemoteIgnoredDevice
{
    private String time = "";
    private String deviceID = "";
    private String name = "";
    private String address = "";

    public RemoteIgnoredDevice( String time, String deviceID, String name, String address )
    {
        this.time = time;
        this.deviceID = deviceID;
        this.name = name;
        this.address = address;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime( String time )
    {
        this.time = time;
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

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
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

    @Override
    public boolean equals( Object o )
    {
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        RemoteIgnoredDevice that = ( RemoteIgnoredDevice ) o;
        return Objects.equals( getTime(), that.getTime() ) && Objects.equals( getDeviceID(), that.getDeviceID() ) && Objects.equals( getName(), that.getName() ) && Objects.equals( getAddress(), that.getAddress() );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( getTime(), getDeviceID(), getName(), getAddress() );
    }

    @NonNull
    @Override
    public String toString()
    {
        return "RemoteIgnoredDevice{" +
                "time='" + time + '\'' +
                ", deviceID='" + deviceID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
