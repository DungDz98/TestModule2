package Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNgaySinh {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String DATE_REGEX = "^\\d{1,2}$";

    public ValidateNgaySinh() {

    }

    public static boolean validate(String regex) {
        pattern = Pattern.compile(DATE_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
