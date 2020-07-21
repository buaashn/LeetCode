package main.java.solutions._167;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] numbers = {0, 2, 3, 9};
        int taget = 5;
        System.out.println(Arrays.toString(twoSum.twoSum(numbers, taget)));
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> error = new HashMap<>();

        if (target < numbers[0] + numbers[1] || target > numbers[numbers.length - 1] + numbers[numbers.length - 2]) {
            return new int[2];
        }
        for (int i = 0, right = find(numbers, target / 2+1, 1, numbers.length - 1, true); i < right; i++) {
            if (error.containsKey(numbers[i])) {
                continue;
            }
            int index2 = find(numbers, target - numbers[i], i + 1, numbers.length - 1, false);
            if (index2 != -1) {
                return new int[]{i + 1, index2 + 1};
            }
            error.put(numbers[i], i);
        }
        return new int[2];
    }

    public int find(int[] numbers, int target, int left, int right, boolean firstMax) {
        if (left > right || left < 0 || right > numbers.length - 1) {
            return firstMax ? left : -1;
        }
        int mid = left + (right - left) / 2;

        if (numbers[mid] < target) {
            return find(numbers, target, mid + 1, right, firstMax);
        }
        if (numbers[mid] > target) {
            return find(numbers, target, left, mid - 1, firstMax);
        }
        return mid;
    }
}
