package banque;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {

    double lireSolde(Compte s)throws RemoteException;
    double debiter(Compte s,double m)throws RemoteException;
    double crediter(Compte s,double m)throws RemoteException;
}


