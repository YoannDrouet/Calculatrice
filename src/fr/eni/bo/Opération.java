package fr.eni.bo;

import fr.eni.exception.DepassementCapacitesException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe Operation contenant les méthodes de calcul
 */
public class Opération {

    /**
     * Permet d'aditionner a et b et lève une exception si le résultat dépasse la capacité d'un int
     * @param a
     * @param b
     * @return a+b
     * @throws DepassementCapacitesException
     */
    public int ajouter(int a, int b) throws DepassementCapacitesException{
        long c = (long)a+(long)b;
        if (c>(long)2147483467 || c<(long)-2147483468){
            throw new DepassementCapacitesException("Capacité maximale dépassée");
        }
        return (int) c;
    }

    /**
     * Permet de soustraire a et b et lève une exception si le résultat dépasse la capacité d'un int
     * @param a
     * @param b
     * @return a-b
     * @throws DepassementCapacitesException
     */
    public int soustraire(int a, int b) throws DepassementCapacitesException{
        long c =(long) a- (long) b;
        if (c>(long)2147483467 || c<(long)-2147483468){
            throw new DepassementCapacitesException("Capacité maximale dépassée");
        }
        return (int) c;
    }

    /**
     * Permet de multiplier a et b et lève une exception si le résultat dépasse la capacité d'un int
     * @param a
     * @param b
     * @return a*b
     * @throws DepassementCapacitesException
     */
    public int multiplier(int a, int b) throws DepassementCapacitesException{
        long c = (long)a*(long)b;
        if (c>(long)2147483467 || c<(long)-2147483468){
            throw new DepassementCapacitesException("Capacité maximale dépassée");
        }
        return (int) c;
    }

    /**
     * Demande à l'utilisateur de saisir un entier, et propage une exception s'il saisie autre chose
     * @return un entier
     * @throws InputMismatchException
     */
    public int saisieEntier() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Saisissez un entier");
        long a = scan.nextLong();
        if (a > Integer.MAX_VALUE || a < Integer.MIN_VALUE){
            throw new DepassementCapacitesException("Capacité maximale dépassée");
        }
        return (int)a;
    }

    /**
     * Boucle jusqu'à ce que l'utilisateur rentre un des caractère autorisé
     * @return opérateur
     */
    public char saisieOperateur(){
        Scanner scan = new Scanner(System.in);
        String o;
        boolean ok = false;
        do {
            System.out.println("Saisissez + - * / % q pour quitter");
            o = scan.next();
            if ((o.charAt(0) == '+' || o.charAt(0) == '-' || o.charAt(0) == '*' || o.charAt(0) == '/' || o.charAt(0) == '%' || o.charAt(0) == 'q') && o.length() == 1){
                ok = true;
            }
        }while (!ok);
        return o.charAt(0);
    }
}
