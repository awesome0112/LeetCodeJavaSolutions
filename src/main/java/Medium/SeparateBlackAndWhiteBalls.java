package Medium;

public class SeparateBlackAndWhiteBalls {

//    public long minimumSteps(String s) {
//        char[] chars = s.toCharArray();
//
//        boolean isSwap = true;
//        int length = chars.length;
//        long countSteps = 0;
//        while (isSwap) {
//            isSwap = false;
//            for (int i = 0; i < length - 1; i++) {
//                if (chars[i] > chars[i + 1]) {
//                    swap(chars, i, i + 1);
//                    isSwap = true;
//                    countSteps++;
//                }
//            }
//            length--;
//        }
//        return countSteps;
//    }
//
//    private void swap(char[] chars, int i, int j) {
//        char tmp = chars[i];
//        chars[i] = chars[j];
//        chars[j] = tmp;
//    }

    public long minimumSteps(String s) {
        int left = 0;
        long count = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                count += (right - left);
                left++;
            }
        }

        return count;
    }
}
