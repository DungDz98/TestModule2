package Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String PHONE_REGEX = "^0\\d{9}$";

    public ValidatePhoneNumber() {

    }

    public static boolean validate(String regex) {
        pattern = Pattern.compile(PHONE_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
