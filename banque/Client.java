package banque;



import java.rmi.Naming;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        
        
        try {
            MyInterface service1 = (MyInterface) Naming.lookup("rmi://127.0.0.1:1250/server");
            Scanner scanner = new Scanner( System.in );
            Compte s1=new Compte();
            double c,d;
            int choix=1;
            while(choix!=0){
            System.out.println("si vous voulez lire votre solde tapez 1");
            System.out.println("si vous voulez crediter tapez 2");
            System.out.println("si vous voulez debiter tapez 3");
            System.out.println("si vous voulez quitter tapez 0");
            choix=scanner.nextInt();
            switch(choix){
                case 1: 
          System.out.println("votre solde est: "+service1.lireSolde(s1)+"dt");
            break;
                 case 2: 
                    System.out.println("saisir le montant à crediter:");
            c=scanner.nextDouble();
            s1.solde=service1.crediter(s1,c);
            break;
                case 3:    
            System.out.println("saisir le montant à debiter:");
            d=scanner.nextDouble();
            s1.solde=service1.debiter(s1,d);
            break;
                case 0:    
            System.out.println("le systeme va quitter");
            System.exit(0);
            break;
                default:
                    System.out.println("choix non valide");}
            
            }

        } catch ( Exception e) {
            System.out.println("Error");
            System.out.println(e.toString());
        }
    }

}
