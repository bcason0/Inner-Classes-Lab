package io.bryantcason;

import org.junit.Test;
import static org.junit.Assert.*;
public class ConnectionManagerSpec {

    @Test
    public void addConnectionTest(){
        ConnectionManager connectionManager = new ConnectionManager(3);
        Connection connection = connectionManager.addConnection("1234", "HTTPs");
        assertNotNull("Add connection", connection);

    }

    @Test
    public void connectLimitTest(){
        ConnectionManager connectionManager = new ConnectionManager(3);
        Connection connection1 = connectionManager.addConnection("1234", "HTTPs");
        Connection connection2 = connectionManager.addConnection("4321", "TCP" );
        Connection connection3 = connectionManager.addConnection("5432", "POP");
        Connection connection4 = connectionManager.addConnection("432112", "HTTPs");
        connectionManager.getConnectionLimit();
        assertNotNull("Add connection", connection1);
        assertNotNull("Add connection", connection2);
        assertNotNull("Add connection", connection3);
        assertNull("Decline connection", connection4);
    }

    @Test
    public void close(){
        ConnectionManager connectionManager = new ConnectionManager(3);
        Connection connection1 = connectionManager.addConnection("4321", "HTTPs");
        Connection connection2 = connectionManager.addConnection("54321", "POP");
        connection2.close();
        assertTrue("Connect 2 is closed", connection2.close());
    }

}
