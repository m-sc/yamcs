package org.yamcs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Provides access to build-time information of the Yamcs project.
 */
public class YamcsVersion {

    /*
     * This class read a property file that is generated by Maven.
     * 
     * Previously we generated the java class itself, but that caused
     * Maven to _always_ recompile yamcs-core even without cleaning.
     */
    public static final String VERSION;
    public static final String REVISION;
    
    static {
        String ver = null;
        String rev = null;
        try (InputStream resourceIn = YamcsVersion.class.getResourceAsStream("/org.yamcs.core.properties")) {
            Properties props = new Properties();
            props.load(resourceIn);
            ver = props.getProperty("version");
            rev = props.getProperty("revision");
        } catch (IOException e) {//ignore errors
        }
        VERSION = ver;
        REVISION = rev;
    }

   
}
