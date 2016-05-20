package io.bryantcason;

/**
 * Created by bryantcason on 5/19/16.
 */
public class ConnectionManager {
    private int counter = 0 ;
    private int connectionLimit;

    public int getCounter(){
        return counter;
    }

    public int getConnectionLimit(){
        return connectionLimit;
    }

    public ConnectionManager(int connectionLimit){
        this.connectionLimit = connectionLimit;
    }

    public Connection addConnection(String IP, String protocol){
         if (counter < connectionLimit) {
            counter++;
            return this.new ManagedConnection(IP, protocol);
        } else {
            return null;
        }
    }

    private class ManagedConnection implements Connection  {
        String IP, port, protocol;
        String status = "open";

        public ManagedConnection(String IP, String protocol){
            if(protocol.equals("HTTPs") || protocol.equals("TCP") || protocol.equals("POP")){
                this.protocol = protocol;
            }
            this.IP = IP;
            this.protocol = protocol;
        }

        public String getIP(){
            if(status.equals("closed")){
                return "closed";
            }else {
                return IP;
            }
        }

        public String getPort(){
            if(status.equals("closed")) {
                status = "closed";
                return status;
            } else{
                return port;
            }
        }

        public String getProtocol(){
            if(status.equals("closed")){
                status = "closed";
                return status;
            }else {
                return protocol;
            }
        }

        public String connect(){
            return "connect";
        }

        public boolean close(){
            counter--;
            status = "closed";
            return true;

        }
    }
}
