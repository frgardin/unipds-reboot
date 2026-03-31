import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        String email = "isidro@isidro.com";
        System.out.println(email.matches("^[\\w.-_]+@[\\w]+\\.[a-zA-Z0-9]{2,6}"));

        String text = "O Cep da residencia é 01234-567";
        Pattern pattern = Pattern.compile("\\d{5}-\\d{3}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
