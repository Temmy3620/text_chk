import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileAppender {
    public static void appendTextToFile(String fileName, String textToAdd) {
        try {
            // ファイルを追加書き込みモードでオープン
            FileWriter fileWriter = new FileWriter(fileName, true);

            // バッファ付きライターを使用してファイルにテキストを書き込む
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textToAdd);
            bufferedWriter.newLine();

            // バッファをフラッシュしてファイルに書き込みを確定
            bufferedWriter.flush();

            // リソースを解放
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "example.txt";
        String textToAdd = "This is the new text to be added.";

        appendTextToFile(fileName, textToAdd);
    }
}