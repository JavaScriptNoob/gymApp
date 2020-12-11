package wakeupapp;

public class SsnValidation {
    private final String ssn;
    public boolean valid;

    public  SsnValidation(String ssnnumber) { // deklarerar konstruktor
        this.ssn = ssnnumber;//ssn är global variable lika med argument
        this.valid = this.ssn.length() == 10 && this.validateCardNumber();//variabeln valid har boolean value som beror på resultat av validation
    }

    private boolean validateCardNumber() {
        String value = this.ssn;
        int n = value.length() - 1; // 9
        int sum = 0;
        int controlNumber = Integer.parseInt(value.substring(n));// vi sparar kontrollnummer i en separat variabeln
        System.out.println(controlNumber + "control");
        String valueWithoutControlNumber = value.substring(0, n);// Vi klipper ut allt förutom controlnummer


        for (int index = 0; index < n; index++) {

            int digit = valueWithoutControlNumber.charAt(index) - '0';//med hjälp av loop och method charAt vi kan jobba med varje karakter  i string separat
            System.out.println(digit);
            if (index % 2 == 0) {// om division till 2 lämnar noll i resten. Numret är jämnt eller noll.Det står i uppgiften att vi måste gå från vänstern till höger


                digit = digit * 2;//multiplicerar med 2
                System.out.println("by2");
                if (digit > 9) {//om value tvåsiffrig då vi subtraherar det med 9. Jag tror att det är stor hack 12 === 1 +2 ===12 - 9
                    digit -= 9;
                }
            }

            sum += digit;//adderar integer till sum
            System.out.println(sum + "sum");
        }
        return ((sum + controlNumber) % 10 == 0);// räknar ut resultat tillsamans med kontrolnummer
    }
}

