package com.nutomic.syncthingandroid.model;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import java.util.Objects;

public class IgnoredFolder
{
    private String time = "";
    private String id = "";
    private String label = "";

    public IgnoredFolder( String time, String id, String label )
    {
        this.time = time;
        this.id = id;
        this.label = label;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime( String time )
    {
        this.time = time;
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

    /**
     * Returns the folder label, or the first characters of the ID if the label is empty.
     */
    public String getDisplayLabel()
    {
        return ( TextUtils.isEmpty( label ) )
                ? id.substring( 0, 7 )
                : label;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        IgnoredFolder that = ( IgnoredFolder ) o;
        return Objects.equals( getTime(), that.getTime() ) && Objects.equals( getId(), that.getId() ) && Objects.equals( getLabel(), that.getLabel() );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( getTime(), getId(), getLabel() );
    }

    @NonNull
    @Override
    public String toString()
    {
        return "IgnoredFolder{" +
                "time='" + time + '\'' +
                ", id='" + id + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
