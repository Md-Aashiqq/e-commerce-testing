package utilities;

public class UtilityMethods {

    public boolean compareString(String actual, String expected) {
        return actual.equals(expected);
    }

    public String generateRandomEmail() {
        return "ashic" + System.currentTimeMillis() + "@gmail.com";
    }

    public String generateRandomPassword() {
        return "Md.ashic" + System.currentTimeMillis();
    }

    public boolean emailValidation(String email) {
//        1. The email address must contain exactly one @ character.
//        2. The local part of the email address (before the @) should not exceed 10 characters.
//        3. The domain part of the email address (after the @) should not exceed 5 characters.
//        4. The total length of the email address should not exceed 25 characters.

        String[] emailParts = email.split("@");
        if(emailParts.length != 2) {
            return false;
        }
        if(emailParts[0].length() > 10) {
            return false;
        }
        String domain = emailParts[1];
        String subDomain = domain.split("\\.")[0];
        if(subDomain.length() > 5) {
            return false;
        }
        if(email.length() > 25) {
            return false;
        }
        return true;
    }

}
