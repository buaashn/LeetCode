package main.java.solutions._17_13;

import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreSpace {

    public static void main(String[] args) {
        String[] dictionary = {"ouf",
                "uucuocucoouoffcpuuf",
                "pf",
                "o",
                "fofopupoufuofffffocpocfccuofuupupcouocpocoooupcuu",
                "cf",
                "cffooccccuoocpfupuucufoocpocucpuouofffpoupu",
                "opoffuoofpupcpfouoouufpcuocufo",
                "fopuupco",
                "upocfucuucfucofufu",
                "ufoccopopuouccupooc",
                "fffu",
                "uuopuccfocopooupooucfoufop",
                "occ",
                "ppfcuu",
                "o",
                "fpp",
                "o",
                "oououpuccuppuococcpoucccffcpcucoffupcoppoc",
                "ufc",
                "coupo",
                "ufuoufofopcpfoufoouppffofffuupfco",
                "focfcfcfcfpuouoccupfccfpcooup",
                "ffupfffccpffufuuo",
                "cufoupupppocou",
                "upopupopccffuofpcopouofpoffopcfcuooocppofofuuc",
                "oo",
                "pccc",
                "oupupcccppuuucuuouocu",
                "fuop",
                "ppuocfuppff",
                "focofooffpfcpcupupuuooufu",
                "uofupoocpf",
                "opufcuffopcpcfcufpcpufuupffpp",
                "f",
                "opffp",
                "fpccopc"};
        String sentence = "fofopupoufuofffffocpocfccuofuupupcouocpocoooupcuufffufffufpccopc";

        System.out.println(new RestoreSpace().respace(dictionary, sentence));
    }

    public int respace(String[] dictionary, String sentence) {
        // 用API不行，replaceAll中必须用regex匹配
        // dp   用dp数组实时记录最小值
        int len = sentence.length();
        int[]dp = new int[len+1];
        dp[0] = 0;
        for (int i = 0; i <len ; i++) {
            // 初始化默认字符均没有被匹配
            dp[i+1] = dp[i]+1;
            // 遍历字典，如匹配上则更新dp数组
            for (int j = 0; j <dictionary.length ; j++) {
                int length = dictionary[j].length();
                if (length<=i+1){
                    if (dictionary[j].equals(sentence.substring(i+1-length,i+1))){
                        dp[i+1] = Math.min(dp[i+1],dp[i+1-length]);
                    }
                }
            }

        }
        return dp[len];
    }
//    public int respace(String[] dictionary, String sentence) {
//        int numOfUndefine = 0;
//        Map<Character, List<String>> dicIndex = new HashMap<>();
//        for (String str : dictionary) {
//            if (!dicIndex.containsKey(str.charAt(0))) {
//                dicIndex.put(str.charAt(0), new ArrayList<>());
//            }
//            dicIndex.get(str.charAt(0)).add(str);
//        }
//        int i = 0;
//        OUT:
//        while (i < sentence.length()) {
//            if (dicIndex.containsKey(sentence.charAt(i))) {
//                for (String str : dicIndex.get(sentence.charAt(i))) {
//                    if (i + str.length() <= sentence.length()
//                            && str.equals(sentence.subSequence(i, i + str.length()))) {
//                        i = i + str.length();
//                        continue OUT;
//                    }
//                }
//            }
//            i++;
//            numOfUndefine++;
//        }
//        return numOfUndefine;
//    }

}
