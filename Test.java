import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test {
    public static void main(String args[]) {
        /*
         shop内にあるフォルダの一覧を返す 
         */
        List<String> shopList = new ArrayList<String>();
        String path1 = "shop";
        String pathName;

        File file1 = new File(path1);
        File fileArray1[] = file1.listFiles();
    
        // フォルダの一覧
        for (File f: fileArray1){
            if(f.isDirectory()) {
                pathName = f.toString();
                shopList.add(pathName); // フォルダ名をリストに追加
                System.out.println(shopList); // フォルダを表示
            }
        }
        //return shopList;//[shop\あか, shop\くろ]
    }
}