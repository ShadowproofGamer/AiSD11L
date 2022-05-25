import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
    BSTTree rbTree;
    String src;

    public Parser(String src, BSTTree rbTree) {

        this.src = src;
        this.rbTree = rbTree;
    }

    public void load() {
        try (
                BufferedReader br = new BufferedReader(new FileReader(src))
        ) {
            String[] s= br.readLine().split("\\s+|\\.|,");
            int i = 1;
            while (s[0] != null) {
                for (int j = 0; j < s.length; j++) {
                    String[] str = s[j].split("\\.|,|-");
                    rbTree.insertBST(str[0], i);
                }
                i++;
                s = br.readLine().split("\\s+");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex){
            return;
        }
    }
}
