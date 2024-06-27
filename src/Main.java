import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String text = "During a recent social gathering, five individuals introduced themselves," +
                " sharing their names, email addresses, and ages. First, John Doe, a 28-year-old, provided his email address" +
                " as john.doe@example.com. Next was Emily Smith, who is 34 years old and can be reached at emily.smith@example.net." +
                " Michael Brown, aged 45, mentioned that his email is michael.brown@example.org. Then, Sarah Johnson, a young 22-year-old, " +
                "shared her email, which is sarah.johnson@example.com. Lastly, David Williams, who is 30 years old, gave his email address" +
                "as david.williams@example.net.\n";

        Pattern pattern = Pattern.compile("[a-zA-Z0-9.]+@[a-zA-Z0-9]+.[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        Pattern pattern2 = Pattern.compile("@[a-zA-Z0-9]+.[a-zA-Z0-9]+");
        matcher = pattern2.matcher(text);

        String editedText = matcher.replaceAll("@gmail.com");

        matcher = pattern.matcher(editedText);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
