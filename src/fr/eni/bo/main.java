package fr.eni.bo;

import fr.eni.exception.DepassementCapacitesException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Opération cal = new Opération();
        int a = -15;
        int b = -15;
        int c = 0;
        char operateur;
        boolean saisie = false;
        boolean boucle = true;
        boolean calcul = true;

        // Boucle tant que l'utilisateur ne saisie pas un entier
        do {
            try{
                a = cal.saisieEntier();
                saisie = true;

            }catch (DepassementCapacitesException e){
                System.err.println(e.getMessage());
                saisie = false;
            } catch (Exception e) {
                System.err.println("Saisie incorrecte. Réessayez...");
                saisie = false;
            }
        }while (!saisie);

        //Permet de boucler autant de fois que l'utilisateur le souhaite
        do {
            // Demande à l'utilisateur de saisir l'opérateur qu'il souhaite
            operateur = cal.saisieOperateur();
            //Premet de sortir directement de la boucle s'il rentr le caractère 'q'
            if (operateur == 'q'){

                boucle = false;
                break;
            }

            //Redemande à l'utilisateur de choisir un deuxième entier et boucle jusqu'à ce qu'il le fasse
            do {
                try{
                    b = cal.saisieEntier();
                    saisie = true;

                } catch (Exception e){
                    System.err.println("Saisie incorrecte. Réessayez...");
                    saisie = false;
                }
            }while (!saisie);

            //Sélectionne la méthode de calcul à effectuer en fonction de l'opérateur saisie par l'utilisateur
            switch (operateur){
                case '+' :
                    try {
                        c = cal.ajouter(a,b);
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                        calcul = false;
                    }break;
                case '-' :
                    try {
                        c = cal.soustraire(a,b);
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                        calcul = false;
                    }break;
                case '*' :
                    try {
                        c = cal.multiplier(a,b);
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                        calcul = false;
                    }break;
                case '/' :
                    try {
                        c = a/b;
                    }catch (ArithmeticException e){
                        System.err.println("Division par 0 impossible");
                        calcul = false;
                    }break;
                default:
                    try {
                        c = a%b;
                    }catch (ArithmeticException e){
                        System.err.println("Division par 0 impossible");
                        calcul = false;
                    }break;
            }

            //Donne le résultat du calcul seulement si le calcul s'est fait sans exception
            if (calcul == true) {
                System.out.printf("%d %s %d = %d%n", a, operateur, b, c);
                a = c;
            }
            calcul = true;

        }while (boucle);
        System.out.println("Au revoir");
    }
}
