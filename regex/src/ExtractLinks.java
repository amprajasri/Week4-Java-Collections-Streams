import java.util.regex.*;
import java.util.*;

public class ExtractLinks {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        // Regex to match HTTP/HTTPS URLs
        String regex = "\\bhttps?://[\\w.-]+(?:\\.[\\w\\.-]+)+[/\\w\\.-]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> links = new ArrayList<>();
        while (matcher.find()) {
            links.add(matcher.group());
        }

        System.out.println("Extracted Links:");
        System.out.println(String.join(", ", links));
    }
}
