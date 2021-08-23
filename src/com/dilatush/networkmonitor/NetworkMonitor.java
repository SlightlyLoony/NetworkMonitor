package com.dilatush.networkmonitor;

import com.dilatush.util.ScheduledExecutor;

import java.util.logging.Logger;

/**
 * The main class for the NetworkMonitor program.  This class is instantiated as a singleton.
 *
 * @author Tom Dilatush  tom@dilatush.com
 */
public class NetworkMonitor {

    public static final NetworkMonitor INSTANCE = new NetworkMonitor();

    private static final int SCHEDULER_THREADS = 6;  // number of threads in the shared scheduler's thread pool...

    public final ScheduledExecutor   scheduledExecutor;

    private final Logger             LOGGER;


    public NetworkMonitor() {

        // set the configuration file location (must do before any logging actions occur)...
        System.getProperties().setProperty( "java.util.logging.config.file", "logging.properties" );
        LOGGER = Logger.getLogger( new Object(){}.getClass().getEnclosingClass().getSimpleName() );

        // set up a scheduled executor service for all to use...
        scheduledExecutor = new ScheduledExecutor( SCHEDULER_THREADS, false );

    }


    private void run() {

        LOGGER.info( "NetworkMonitor is starting..." );
    }


    public static void main( final String[] _args ) {
        INSTANCE.run();
    }
}
