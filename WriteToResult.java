import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteToResult {
    public static void main(String[] args) {
        String directoryPath = "result";
        String textToWrite = "Hello, this is a sample text to write into the file.";

        try {
            // ディレクトリを作成
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdir();
                System.out.println("ディレクトリが作成されました。");
            } else {
                System.out.println("ディレクトリは既に存在します。");
            }

            // ファイルを作成してテキストを書き込む
            String filePath = directoryPath + File.separator + "result.txt";
            Path path = Paths.get(filePath);

            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("ファイルが作成されました。");
            } else {
                System.out.println("ファイルは既に存在します。");
            }

            // テキストを書き込む
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textToWrite);
            bufferedWriter.close();

            System.out.println("テキストがファイルに書き込まれました。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}