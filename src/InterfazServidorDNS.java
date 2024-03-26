import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazServidorDNS extends Remote {
    //public String getIP(String host) throws RemoteException;


    public String getIp(String host) throws RemoteException;

}