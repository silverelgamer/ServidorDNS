import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;



public class Cliente {

    public static void main(String [] args){
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 3323);
            InterfazServidorDNS servidor = (InterfazServidorDNS) registro.lookup("servidorDNS");

            Scanner consola = new Scanner(System.in);
            String lectura = null;
            while (true){
                lectura = consola.nextLine();
                System.out.println(servidor.getIp(lectura));
            }

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

    }
}
