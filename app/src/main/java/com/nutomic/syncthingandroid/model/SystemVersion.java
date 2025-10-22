package com.nutomic.syncthingandroid.model;

import androidx.annotation.NonNull;

import java.util.Objects;

public record SystemVersion( String arch, String codename, String longVersion, String os,
                             String version )
{
    @Override
    public boolean equals( Object o )
    {
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        SystemVersion that = ( SystemVersion ) o;
        return Objects.equals( os, that.os ) && Objects.equals( arch, that.arch ) && Objects.equals( version, that.version ) && Objects.equals( codename, that.codename ) && Objects.equals( longVersion, that.longVersion );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( arch, codename, longVersion, os, version );
    }

    @NonNull
    @Override
    public String toString()
    {
        return "SystemVersion{" +
                "arch='" + arch + '\'' +
                ", codename='" + codename + '\'' +
                ", longVersion='" + longVersion + '\'' +
                ", os='" + os + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
