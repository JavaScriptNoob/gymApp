package wakeupapp;

import java.util.Scanner;

public class wakeUpMain {
    public static void main(String[] args) {
        doTheThings();
    }


    private static void doTheThings() {
        boolean inloggning = false;
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "1. Bli medlem\n" +
                        "2. Logga in\n" +
                        "3. Boka plats på aktivitet\n" +
                        "4. Avsluta");
        System.out.println("Type in your choise");
        int navigateInMenu = Integer.parseInt(scanner.next());
        System.out.println(navigateInMenu);
        if (navigateInMenu >= 5 || navigateInMenu < 1) {
            doTheThings();
        }
        System.out.println("Type in SSN");
        String personnummer = scanner.next();
        System.out.println(personnummer);
        if (personnummer.length() != 10) {
            System.out.println("not enjuph");
        } else {
            inloggning = validateCardNumber(personnummer);
            System.out.println(inloggning + " v uslovii");
        }
        System.out.println(inloggning + " vne usloviya");
        if (inloggning) {
            do {
                switch (navigateInMenu) {
                    case 1:
                        System.out.println("\"1. Bli medlem\\n\"");
                        getTheSubscription();
                        break;
                    case 2:
                        System.out.println("2. Logga in\n");
                        break;
                    case 3:
                        System.out.println("3. Boka plats på aktivitet\n");
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
    }

    private static boolean validateCardNumber(String cardNummer) {
        String value = cardNummer;
        int sum = 0;
        int controlNumber = Integer.parseInt(value.substring(9, 10));
        System.out.println(controlNumber + "control");
        String valueWithoutControlNumber = value.substring(0, 9);
        int numberOfIterations = valueWithoutControlNumber.length();
        System.out.println(numberOfIterations + " Количество итераций");
        for (int index = 0; index <= numberOfIterations - 1; index++) {
            int digit = valueWithoutControlNumber.charAt(index) - '0';
            System.out.println(digit);
            if (index % 2 == 0) {


                digit = digit * 2;
                System.out.println("by2");
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            System.out.println(sum + "sum");
        }
        return ((sum + controlNumber) % 10 == 0);
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
}





