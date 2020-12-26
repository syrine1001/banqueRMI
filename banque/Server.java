package banque;

  
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyInterface {

    public Server() throws RemoteException {}

    /**
     *
     * @param s
     * @return
     */
    @Override
   public double lireSolde(Compte s) {
        return s.solde;
    }
    
    /**
     *
     * @param s
     * @param m
     * @return 
     */
    @Override
     public double debiter(Compte s,double m) {
        return s.solde-m;
    }
    
    /**
     *
     * @param s
     * @param m
     * @return 
     */
    @Override
      public double crediter(Compte s,double m) {
        return m+s.solde;
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);
    }
}