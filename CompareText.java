import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


class CompareText {
    public static void main(String args[]) {
        /*
         二つのlistを受け取って、それぞれ比較して
         結果を返す関数
        */
        
        List<String> upgrade_dir = new ArrayList<String>(Arrays.asList("2023/05/15  22:32    <DIR>          sample",
        "2023/05/15  23:16    <DIR>          src","               1 個のファイル                   0 バイト"));
        List<String> result_dir = new ArrayList<String>(Arrays.asList("2023/05/15  22:32    <DIR>          sample",
        "2023/05/15  23:13    <DIR>          src","               1 個のファイル                   0 バイト"));
        List<String> LineComparelist = new ArrayList<String>();
        
        for(int i = 0; i < upgrade_dir.size(); i++){
            //System.out.println(i);
            String upgrade_line = upgrade_dir.get(i);
            String result_line = result_dir.get(i);

            if(upgrade_line.equals(result_line)){
                LineComparelist.add("OK");
                System.out.println(Integer.toString(i) + ":OK");

            }else{
                List<Integer> differences = getDifferentCharacterIndices(upgrade_line, result_line);

                if(differences.get(0) == 16 && differences.size() == 1){
                    String result = compareTime(upgrade_line,result_line);
                    if(result.equals("OK")){
                        LineComparelist.add("OK");
                        System.out.println(Integer.toString(i) + ":OK");

                    }else{
                        LineComparelist.add("NG");
                        System.out.println(Integer.toString(i) + ":NG　秒数的な差異があります");
                    }

                }else{
                    //if(upgrade_line.charAt(4) == '/'){}
                    LineComparelist.add("NG");
                    System.out.println(Integer.toString(i) + ":NG! line " + Integer.toString(differences.get(0)) + "is difference!!");
                }

            }           
        }

        System.out.println(LineComparelist);

         
    }
    public static  List<Integer> getDifferentCharacterIndices(String str1,String str2){
        /*
         * 二つの文字列を比較し、異のある箇所の要素数を返す
         */
        List<Integer> differentIndices = new ArrayList<>();
        int minLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < minLength; i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (char1 != char2) {
                differentIndices.add(i);
            }
        }

        return differentIndices;

    }
    public static String compareTime(String upgrade_line,String result_line){
        String res = null;
        int aT = 0; // 必要に応じて適切な値を設定
        int bT = 0; // 必要に応じて適切な値を設定

        String aChar = Character.toString(upgrade_line.charAt(16)).trim();
        String bChar = Character.toString(result_line.charAt(16)).trim();

            if (!aChar.isEmpty() && !bChar.isEmpty()) {//数値変換を行う前に、空文字列が入力されていないかを確認する
                aT = Integer.parseInt(aChar);
                bT = Integer.parseInt(bChar);
                    

                if(Math.abs(aT - bT) <= 2){
                    res = "OK";
                }else{
                    res = "NG";
                }
            }else{
                System.out.println("空白文字がある");
            }
        return res;
    }
    
}