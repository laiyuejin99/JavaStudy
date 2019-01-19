package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class N66PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        int sum = digits[digits.length - 1] + 1;
        if(sum<10){
            digits[digits.length - 1]++;
            return digits;
        }
        digits[digits.length - 1] = sum % 10;
        int index = digits.length - 2;
        while (index >= 0) {
            sum = digits[index] + 1;
            if (sum < 10) {
                digits[index]++;
                return digits;
            } else {
                digits[index] = sum % 10;
                index--;
            }
        }
        int result[] = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = digits[i - 1];
        }
        return result;
    }
}
