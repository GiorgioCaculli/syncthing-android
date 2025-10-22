package com.nutomic.syncthingandroid.model;

/**
 * According to syncthing REST API
 * https://docs.syncthing.net/rest/db-completion-get.html
 * <p>
 * completion is also returned by the events API
 * https://docs.syncthing.net/events/foldercompletion.html
 */
public class CompletionInfo
{
    /*
    TODO: Figure out the point behind this class since only one variable is present... Why not Interface?
     */
    private double completion;
    /*
     * The following values are only returned by the REST API call
     * to ""/completion". We will need them in the future to show
     * more statistics in the device UI.
     */
    // public long globalBytes = 0;
    // public long needBytes = 0;
    // public long needDeletes = 0;
    // public long needItems = 0;

    public CompletionInfo( double completion )
    {
        setCompletion( completion );
    }

    public CompletionInfo()
    {
        this( 100 );
    }

    public double getCompletion()
    {
        return completion;
    }

    public void setCompletion( double completion )
    {
        this.completion = completion;
    }
}
