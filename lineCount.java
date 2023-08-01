import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.IOException; // IOExceptionをインポート

class lineCount {
    public static void main(String args[]) {
        /*
         直下のファイルのdir_upgradeの行数を返す関数
         結果を返す関数
        */
        // ファイルパス
        Path path = Paths.get("dir_upgrade.txt");
        // ファイルの行数
        //long num = Files.lines(path).count();
        try {
            long num = Files.lines(path, Charset.forName("SJIS")).count();
            System.out.println("ファイルの行数: " + num);
        } catch (IOException e) {
            // IOExceptionの処理
            e.printStackTrace();
        }

        // ファイルの行数（文字コードをSJISに指定する場合）
        //long num2 = Files.lines(path, Charset.forName("SJIS")).count();
    }
}