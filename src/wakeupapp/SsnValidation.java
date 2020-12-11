package wakeupapp;

public class SsnValidation {
    private final String ssn;
    public boolean valid;

    public  SsnValidation(String ssnnumber) {
        this.ssn = ssnnumber;
        this.valid = this.ssn.length() == 10 && this.validateCardNumber();
    }

    private boolean validateCardNumber() {
        String value = this.ssn;
        int n = value.length() - 1; // 9
        int sum = 0;
        int controlNumber = Integer.parseInt(value.substring(n));
        System.out.println(controlNumber + "control");
        String valueWithoutControlNumber = value.substring(0, n);
        System.out.println(n + " Количество итераций");

        for (int index = 0; index < n; index++) {

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
}

