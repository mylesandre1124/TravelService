package data;

import java.util.InputMismatchException;

public class PhoneNumber {
    public PhoneNumber(long phoneNumber) {
        try {
            String stringPhoneNumber = "" + phoneNumber;
            this.phoneNumber = stringPhoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        } catch (NumberFormatException ex) {
            throw new InputMismatchException();
        }


    }

    private String phoneNumber;

    @Override
    public String toString() {
        return phoneNumber;
    }
}
