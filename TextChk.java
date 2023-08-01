import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.nio.charset.Charset;

public class TextChk {
    public static void main(String[] args) {
        Charset charset = Charset.forName("UTF-8");
        String filename = "shop/くろ/resulte_dir.log";
        
        int numberOfLinesToRead = 10; // 読み込む行数を指定

        List<String> lines = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            // ファイルの最終行まで進める
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // リストを逆順にして、指定した行数だけ読み込む
        int startIndex = Math.max(0, lines.size() - numberOfLinesToRead);
        int endIndex = lines.size();
        List<String> lastNLines = lines.subList(startIndex, endIndex);

        System.out.println(lastNLines);

        int rmNum = lastNLines.size() - 1;
        lastNLines.remove(rmNum);

        System.out.println(lastNLines);

        
        //javac -encoding UTF-8 TextChk.java
        //java -Dfile.encoding=UTF-8 TextChk.java
        
    }
}
