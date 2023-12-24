import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
    public static void main(String[] argv) {
        try {
        	String filename = "testinput.txt";
            String fullPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + filename;
            
            System.out.println(fullPath);

            Reader reader = new InputStreamReader(new FileInputStream(fullPath));
            //SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(reader);

            //System.out.println(syntaxAnalyzer.LR());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
