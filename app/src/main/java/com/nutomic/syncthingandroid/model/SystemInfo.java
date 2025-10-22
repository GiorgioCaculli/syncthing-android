package com.nutomic.syncthingandroid.model;

import androidx.annotation.NonNull;

import java.util.Map;
import java.util.Objects;

public record SystemInfo( long alloc, double cpuPercent, int goroutines, String myID, long sys,
                          boolean discoveryEnabled, int discoveryMethods,
                          Map< String, String > discoveryErrors, int urVersionMax )
{
    @Override
    public boolean equals( Object o )
    {
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        SystemInfo that = ( SystemInfo ) o;
        return alloc == that.alloc && Double.compare( cpuPercent, that.cpuPercent ) == 0 && goroutines == that.goroutines && sys == that.sys && discoveryEnabled == that.discoveryEnabled && discoveryMethods == that.discoveryMethods && urVersionMax == that.urVersionMax && Objects.equals( myID, that.myID ) && Objects.equals( discoveryErrors, that.discoveryErrors );
    }

    @NonNull
    @Override
    public String toString()
    {
        return "SystemInfo{" +
                "alloc=" + alloc +
                ", cpuPercent=" + cpuPercent +
                ", goroutines=" + goroutines +
                ", myID='" + myID + '\'' +
                ", sys=" + sys +
                ", discoveryEnabled=" + discoveryEnabled +
                ", discoveryMethods=" + discoveryMethods +
                ", discoveryErrors=" + discoveryErrors +
                ", urVersionMax=" + urVersionMax +
                '}';
    }
}
