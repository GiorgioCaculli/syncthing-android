package com.nutomic.syncthingandroid.model;

public class Event
{

    private int id;
    private int globalID;
    private String type;
    private String time;
    private Object data;

    public Event( int id, int globalID, String type, String time, Object data )
    {
        this.id = id;
        this.globalID = globalID;
        this.type = type;
        this.time = time;
        this.data = data;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public int getGlobalID()
    {
        return globalID;
    }

    public void setGlobalID( int globalID )
    {
        this.globalID = globalID;
    }

    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime( String time )
    {
        this.time = time;
    }

    public Object getData()
    {
        return data;
    }

    public void setData( Object data )
    {
        this.data = data;
    }
}
