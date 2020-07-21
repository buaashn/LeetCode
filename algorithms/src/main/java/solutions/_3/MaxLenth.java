package main.java.solutions._3;

public class MaxLenth {

    public static void main(String[] args) {
        MaxLenth maxLenth = new MaxLenth();

        String s1 = " ";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println(maxLenth.lengthOfLongestSubstring(s1));
        System.out.println(maxLenth.lengthOfLongestSubstring(s2));
        System.out.println(maxLenth.lengthOfLongestSubstring(s3));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int maxLenth = 0, maxTemp = 0, start = 0;
        for (int end = 0, length = s.length(); end < length; end++) {
            int index = s.substring(start, end).indexOf(s.charAt(end));
            if (index < 0) {
                maxTemp++;
            } else {
                maxLenth = Math.max(maxLenth, maxTemp);
                start += index + 1;
                maxTemp = end - start + 1;
            }
            maxLenth = Math.max(maxLenth, maxTemp);
        }

        return maxLenth;
    }

}
