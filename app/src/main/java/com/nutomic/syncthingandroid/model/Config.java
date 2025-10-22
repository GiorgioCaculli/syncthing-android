package com.nutomic.syncthingandroid.model;

import java.util.ArrayList;
import java.util.List;

public class Config
{
    private final int version;
    private final List< Device > devices;
    private final List< Folder > folders;
    private final List< RemoteIgnoredDevice > remoteIgnoredDevices;
    private Gui gui;
    private Options options;

    public Config()
    {
        version = 2;
        devices = new ArrayList<>();
        folders = new ArrayList<>();
        gui = new Gui();
        options = new Options();
        remoteIgnoredDevices = new ArrayList<>();
    }

    public int getVersion()
    {
        return version;
    }

    public List< Device > getDevices()
    {
        return devices;
    }

    public boolean addDevice( Device device )
    {
        return devices.add( device );
    }

    public boolean removeDevice( Device device )
    {
        return devices.remove( device );
    }

    public List< Folder > getFolders()
    {
        return folders;
    }

    public boolean addFolder( Folder folder )
    {
        return folders.add( folder );
    }

    public boolean removeFolder( Folder folder )
    {
        return folders.remove( folder );
    }

    public Gui getGui()
    {
        return gui;
    }

    public void setGui( Gui gui )
    {
        this.gui = gui;
    }

    public Options getOptions()
    {
        return options;
    }

    public void setOptions( Options options )
    {
        this.options = options;
    }

    public List< RemoteIgnoredDevice > getRemoteIgnoredDevices()
    {
        return remoteIgnoredDevices;
    }

    public boolean addRemoteIgnoredDevice( RemoteIgnoredDevice device )
    {
        return remoteIgnoredDevices.add( device );
    }

    public boolean removeRemoteIgnoredDevice( RemoteIgnoredDevice device )
    {
        return remoteIgnoredDevices.remove( device );
    }

    /*
     * TODO: Apply a different design pattern fo this class
     */
    public class Gui
    {
        private boolean enabled;
        private String address;
        private String user;
        private String password;
        private boolean useTLS;
        private String apiKey;
        private boolean insecureAdminAccess;
        private String theme;

        public Gui()
        {
            enabled = true;
            address = "http://127.0.0.1:8000";
            user = "";
            password = "";
            useTLS = false;
            apiKey = "";
            insecureAdminAccess = false;
            theme = "default";
        }

        public boolean isEnabled()
        {
            return enabled;
        }

        public void setEnabled( boolean enabled )
        {
            this.enabled = enabled;
        }

        public String getAddress()
        {
            return address;
        }

        public void setAddress( String address )
        {
            this.address = address;
        }

        public String getUser()
        {
            return user;
        }

        public void setUser( String user )
        {
            this.user = user;
        }

        public String getPassword()
        {
            return password;
        }

        public void setPassword( String password )
        {
            this.password = password;
        }

        public boolean isUseTLS()
        {
            return useTLS;
        }

        public void setUseTLS( boolean useTLS )
        {
            this.useTLS = useTLS;
        }

        public String getApiKey()
        {
            return apiKey;
        }

        public void setApiKey( String apiKey )
        {
            this.apiKey = apiKey;
        }

        public boolean isInsecureAdminAccess()
        {
            return insecureAdminAccess;
        }

        public void setInsecureAdminAccess( boolean insecureAdminAccess )
        {
            this.insecureAdminAccess = insecureAdminAccess;
        }

        public String getTheme()
        {
            return theme;
        }

        public void setTheme( String theme )
        {
            this.theme = theme;
        }
    }
}
