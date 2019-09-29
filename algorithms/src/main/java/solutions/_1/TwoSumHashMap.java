package main.java.solutions._1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * java使用hashMap，数组内容为key，索引为value，循环查找，在put当前数之前进行一次containsKey查询，可以保证[3,3]6这种不会出错
 */
public class TwoSumHashMap {
    private static final String SEPARTOR = ",";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numsStr = scanner.nextLine();
        int target = scanner.nextInt();
        String[] numsStrings = numsStr.split(SEPARTOR);
        int num = numsStrings.length;
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(numsStrings[i]);
        }
        int[] results = twoSum(nums, target);
        if (results == null) {
            return;
        }
        for (int result : results) {
            System.out.println(result);
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        int index1;
        Map<Integer, Integer> hashMap = new HashMap();
        int length = nums.length;
        for (index1 = 0; index1 < length; index1++) {
            int other = target - nums[index1];
            if (hashMap.containsKey(other)) {
                return new int[]{index1, hashMap.get(other)};
            }
            hashMap.put(nums[index1], index1);
        }
        return null;
    }
}
