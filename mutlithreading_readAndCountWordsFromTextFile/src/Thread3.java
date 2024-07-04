import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Thread3 extends Thread {

    @Override
    public void run() {
        try {

            String filename = "LOTR_EXCERPT_3.txt";
            String directory = System.getProperty("user.dir");
            String path = "";
            path = directory+ File.separator+filename;

            String line;
            HashMap<String, Integer> wordMap = new HashMap<>();

            try  {
                FileReader fileReader = new FileReader(path);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {

                    Pattern pattern = Pattern.compile("[A-z]+");
                    Matcher matcher = pattern.matcher(line);

                    while (matcher.find()) {
                        String word = matcher.group().toLowerCase();
                        if (wordMap.containsKey(word)) {
                            wordMap.put(word, wordMap.get(word) + 1);
                        } else {
                            wordMap.put(word,1);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(wordMap);

        } catch (InvalidPathException e) {
            e.printStackTrace();
        }
    }
}