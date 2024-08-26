package com.locadora.locadoraLivro.Renters.Validation;

public class TelephoneFormatter {

    private static final String PHONE_FORMAT = "%s %s-%s";

    public static String formatPhone(String telephone) {
        if (telephone == null) {
            return null;
        }
        // Remove non-digit characters
        String cleanedPhone = telephone.replaceAll("\\D", "");
        if (cleanedPhone.length() == 11) {
            return String.format(PHONE_FORMAT,
                    cleanedPhone.substring(0, 2),
                    cleanedPhone.substring(2, 7),
                    cleanedPhone.substring(7));
        }
        return telephone;
    }
}
