package com.nutomic.syncthingandroid.model;

/**
 * To avoid name confusion:
 * This is the exclude and include items list associated with every folder.
 */
public class FolderIgnoreList
{
    private final String[] expanded;
    private final String[] ignore;

    public FolderIgnoreList( String[] expanded, String[] ignore )
    {
        this.expanded = expanded;
        this.ignore = ignore;
    }

    public FolderIgnoreList()
    {
        this( new String[]{}, new String[]{} );
    }
}
