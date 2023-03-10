package lesson16.entity;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelperMail {
    private static final String mailRegex = "[A-Za-z\\d!#$%&'*+-\\/=?^_`{|]{1,12}@[A-Za-z\\d.-]{1,253}.[A-Za-z]{2,}";

    public Optional<String> checkOptionalNull(String string) {
        Optional<String> nullCheck = Optional.ofNullable(string);
        if (nullCheck.isPresent() && checkRegex(nullCheck.get().toString(), mailRegex)) {
            return nullCheck;
        }
        return Optional.empty();
    }

    private boolean checkRegex(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}


//public class HelperCheckNull <T>{
//    public Optional checkOptionalNull(T string) {
//        Optional <T> nullCheck = Optional.of(string);
//        return nullCheck;
//    }
//}
