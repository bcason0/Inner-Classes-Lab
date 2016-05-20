package io.bryantcason;

/**
 * Created by bryantcason on 5/19/16.
 */
public interface Connection {
    String getIP();
    String getPort();
    String getProtocol();
    String connect();
    boolean close();
}
