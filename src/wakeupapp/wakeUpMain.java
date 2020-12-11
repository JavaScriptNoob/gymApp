package wakeupapp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class wakeUpMain { //vi skapar class
    public static String personnummer; //vi deklarerar variabeln som tillg'nglig i hella
    public static void main(String[] args) {
        //SsnValidation ssnvalidation = new SsnValidation();
        //ssnvalidation.doTheThings();
        doTheThings(); // vi  kallar  initial method
    }


    private static void doTheThings() { // initial method


        Scanner scanner = new Scanner(System.in);
        int navigateInMenu = 0;//deklarerar variabeln som ska hålla kundens val i framtiden

        do { // börjar loop
            System.out.println( //valalternativ
                    "1. Bli medlem\n" +
                            "2. Logga in\n" +
                            "3. Boka plats på aktivitet\n" +
                            "4. Avsluta");
            System.out.println("Skriva in din val");

            navigateInMenu = Integer.parseInt(scanner.next());//omvandlar datatype from scanner till integer


        } while (navigateInMenu < 1 || navigateInMenu > 4);

        System.out.println("Type in SSN");
        personnummer = scanner.next(); //vi scannar personnumer
        System.out.println(personnummer);

        SsnValidation validation = new SsnValidation(personnummer); // skapar en objekt av  klass SsnValidation

        if (!validation.valid) { // om vi returnerar då ssn är felaktigt
            System.out.println("inte tillräckligt");
            return;
        }

        boolean exit = false; // vi behöver det för att bryta do medan loop

        do {
            switch (navigateInMenu) {// switch tar kundens val som argument
                case 1:
                    System.out.println("\"1. Bli medlem\\n\"");
                    getTheSubscription();//vi kallar method d'r vi skapar medlemskap
                    break;
                case 2:
                    System.out.println("2. Logga in\n");
                    System.out.println("Du är inloggad");

                    break;
                case 3:
                    System.out.println("3. Boka plats på aktivitet\n");
                    bookTheActivity();//vi kallar method där vi bokar aktiviteter
                    break;
                case 4:
                    System.out.println("4. Avsluta");
                    break;
                case 5:
                    exit = true;
                    break;
            }

        } while (exit);

    }


    private static void getTheSubscription() {
        int monthlyPrice; //deklarerar price
        System.out.println("How long do you will stay with us");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt(); //scannar antal av månader
        System.out.println(month);
        if (month <= 2) {//om antal av dem mindre  eller lika  två pris  monthlyPrice 400
            System.out.println(400);
            monthlyPrice = 400;
        } else if (month <= 6) { ////om antal av dem mindre  eller lika  sex pris  monthlyPrice 350
            System.out.println("dohera");
            monthlyPrice = 350;
        } else if (month < 12) {//om antal av dem mindre  tolv pris  monthlyPrice 300
            System.out.println("ewe bolshe");
            monthlyPrice = 300;
        } else {//annars monthlyPrice 250
            monthlyPrice = 250;
        }
        int totalPrice = monthlyPrice + 100;
        System.out.println(totalPrice);
    }

    private static void bookTheActivity() {
        int choiseOfActivity=0;// val av aktiviteter
        do {
            System.out.println(
                    "1. Spinning\n" +
                            "2. Aerobics\n" +
                            "3. Yoga\n");

            System.out.println("Type in your choise");
            Scanner newScanner = new Scanner(System.in);

             choiseOfActivity = newScanner.nextInt();// scannar val av aktiviteter


        } while (choiseOfActivity < 1 || choiseOfActivity > 3); // om scanade value out of range type in igen


        String[] places = { // skapar array som innehåller olika varianter för bookningar
                "1a","1b","1c",
                "2a","2b","2c",
                "3a","3b","3c",};
        for ( int i=0;i<places.length;i++){// mest vanlig loop
            File f = new File(choiseOfActivity+places[i]);// vi använder stream för at skapa fill med namn av bookning

                try { //hanterar fel med hjälp av try catch

                    if (f.createNewFile()) {// class file innehåller inbygd method createNewFile som returnerar true om skapandet avslutad
                        System.out.println("Din plats på aktiviteten är " + places[i]);
                        break;
                    } else {//om  fil med samma namn existerar  vi får false och går till else statement där vi väntar till sista itteratrion
                        if (i == places.length-1){
                            System.out.println("Tyvärr har vi inga lediga platser");// om det finns inga lediga namn för filen då finns inga lediga platser kvar
                        }
                    }
                } catch (IOException e) {// Något dåligt har händ
                    System.out.println("An error occurred.");
                    e.printStackTrace();

                }
            }
        }

    }//Enligt min mening är programmet rå och fruktansvärt skrivet för att vara ärlig hade jag inte tillräckligt med tid att avsluta det.
    // Iögonfallande  bristen på felloggning till exempel om du anger 000 000 000 0 som personligt nummer så kommer min fruktansvärda validering inte att fungera.
    // Under alla omständigheter med tanke på att jag arbetade ensam är jag redo att skriva om det men jag skulle vilja ha en mer detaljerad Feedback från dig eftersom jag aldrig har arbetat med OOP tidigare.


    



