package main.java.solutions._1;

import java.util.Scanner;

public class TwoSum {
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
        int index1, index2;
        int length = nums.length;
        for (index1 = 0; index1 < length; index1++) {
            index2 = find(nums, target - nums[index1], index1);
            if (index2 > 0) {
                return new int[]{index1, index2};
            }
        }
        return null;
    }

    private static int find(int[] nums, int target, int index1) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == target && i != index1) {
                return i;
            }
        }
        return -1;
    }

}
