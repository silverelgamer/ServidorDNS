import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Servidor extends UnicastRemoteObject implements InterfazServidorDNS {


    //String[] host = new String[3];
    // String[] ips = new String[3];

    Host[] hosts = new Host[3];


    public Servidor() throws RemoteException {
       /* host [0] = "google.com";
        host [1] = "facebook.com";
        host [2] = "teziutlan.tecnm.mx";

        host [0] = "192.168.16.25";
        host [1] = "192.168.25.35";
        host [2] = "16.111.76.69"; */

        Host obj1 = new Host();
        obj1.setHost("google.com");
        obj1.setIp("192.168.16.25");

        Host obj2 = new Host();
        obj2.setHost("facebook.com");
        obj2.setIp("192.168.25.35");

        Host obj3 = new Host();
        obj3.setHost("teziutlan.tecnm.mx");
        obj3.setIp("16.111.76.69");

        hosts[0] = obj1;
        hosts[1] = obj2;
        hosts[2] = obj3;

    }


    @Override
    public String getIp(String h) throws RemoteException {
        Host res = null;
        for (int i = 0; i < 3; i++) {
            if (h.equalsIgnoreCase(hosts[i].getHost())) {
                res = hosts[i].getIp();

            }

        }
        return res;
    }

        public static void main (String[] args){
            try {
                InterfazServidorDNS servidor = new Servidor();
                System.setProperty("java.rmi.server.hostname", "172.0.0.1");

                Registry registro = LocateRegistry.getRegistry(3323);
                registro.bind("servidorDNS", servidor);

            } catch (RemoteException | AlreadyBoundException e) {
                e.printStackTrace();
            }
        }
}
