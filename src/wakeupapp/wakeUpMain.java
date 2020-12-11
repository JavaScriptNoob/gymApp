package wakeupapp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class wakeUpMain {
    public static String personnummer;
    public static void main(String[] args) {
        //SsnValidation ssnvalidation = new SsnValidation();
        //ssnvalidation.doTheThings();
        doTheThings();
    }


    private static void doTheThings() {


        Scanner scanner = new Scanner(System.in);
        int navigateInMenu = 0;

        do {
            System.out.println(
                    "1. Bli medlem\n" +
                            "2. Logga in\n" +
                            "3. Boka plats på aktivitet\n" +
                            "4. Avsluta++++++++");
            System.out.println("Type in your choise");

            navigateInMenu = Integer.parseInt(scanner.next());
            System.out.println(navigateInMenu);

        } while (navigateInMenu < 1 || navigateInMenu > 4);

        System.out.println("Type in SSN");
        personnummer = scanner.next();
        System.out.println(personnummer);

        SsnValidation validation = new SsnValidation(personnummer);

        if (!validation.valid) {
            System.out.println("not enjuph");
            return;
        }

        boolean exit = false;

        do {
            switch (navigateInMenu) {
                case 1:
                    System.out.println("\"1. Bli medlem\\n\"");
                    getTheSubscription();
                    break;
                case 2:
                    System.out.println("2. Logga in\n");
                    System.out.println("Du är inloggad");

                    break;
                case 3:
                    System.out.println("3. Boka plats på aktivitet\n");
                    bookTheActivity();
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
        int monthlyPrice;
        System.out.println("How long do you will stay with us");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        System.out.println(month);
        if (month <= 2) {
            System.out.println(400);
            monthlyPrice = 400;
        } else if (month <= 6) {
            System.out.println("dohera");
            monthlyPrice = 350;
        } else if (month < 12) {
            System.out.println("ewe bolshe");
            monthlyPrice = 300;
        } else {
            monthlyPrice = 200;
        }
        int totalPrice = monthlyPrice + 100;
        System.out.println(totalPrice);
    }

    private static void bookTheActivity() {
        int choiseOfActivity=0;
        do {
            System.out.println(
                    "1. Spinning\n" +
                            "2. Aerobics\n" +
                            "3. Yoga\n");

            System.out.println("Type in your choise");
            Scanner newScanner = new Scanner(System.in);

             choiseOfActivity = newScanner.nextInt();


        } while (choiseOfActivity < 1 || choiseOfActivity > 3);

        do {
            switch (choiseOfActivity) {
                case 1:
                    System.out.println("\"1. Spinningn\"");

                    break;
                case 2:
                    System.out.println("2. Aerobic\n");
                    System.out.println(personnummer);

                    break;
                case 3:
                    System.out.println("3.Yoga\n");

                    break;

            }

        } while (false);
        String[] places = {
                "1a","1b","1c",
                "2a","2b","2c",
                "3a","3b","3c",};
        for ( int i=0;i<places.length;i++){
            File f = new File(choiseOfActivity+places[i]);

                try {

                    if (f.createNewFile()) {
                        System.out.println("Din plats på aktiviteten är " + places[i]);
                        break;
                    } else {
                        if (i == places.length-1){
                            System.out.println("Tyvärr har vi inga lediga platser");
                        }
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();

                }
            }
        }

    }


    



