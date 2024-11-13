package Medium;

import java.util.*;
import java.util.stream.Collectors;

public class CountTheNumberOfFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int left = i, right = nums.length - 1;
            int leftPivot = 1, rightPivot = 0;
            boolean isLeftPivotInit = false, isRightPivotInit = false;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum >= lower && sum <= upper) {
                    rightPivot = right;
                    isRightPivotInit = true;
                    break;
                }
                right--;
            }

            right = left + 1;
            while (right < rightPivot) {
                int sum = nums[left] + nums[right];
                if (sum >= lower && sum <= upper) {
                    leftPivot = right;
                    isLeftPivotInit = true;
                    break;
                }
                right++;
            }

            System.out.println(nums[left] + ": " + nums[leftPivot] + " - " + nums[rightPivot]);
            if ((isRightPivotInit && !isLeftPivotInit) || (isLeftPivotInit && !isRightPivotInit)) {
                count++;
            } else count += (rightPivot - leftPivot + 1);
        }

        return count;
    }

}
