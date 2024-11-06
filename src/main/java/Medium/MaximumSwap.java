package Medium;

public class MaximumSwap {
    static boolean swap(char ch[], int i, int j) {
        if (i == j || ch[i] == ch[j]) return false;
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return true;
    }

    // selection sort
    public int maximumSwap(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        int maxIndex = 0;
        char max = ch[0];
        for (int i = 0; i < ch.length - 1; i++) {
            max = ch[i];
            maxIndex = i;
            for (int j = i; j < ch.length; j++) {
                // >= not >
                if (ch[j] >= max) {
                    max = ch[j];
                    maxIndex = j;
                }
            }
            if (swap(ch, i, maxIndex)) return Integer.parseInt(String.valueOf(ch));
        }
        return num;
    }
}
