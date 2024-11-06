package Medium;
public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {
    public int minChanges(String s) {
        int count = 0;
        int app = 1;
        char current = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(current == tmp) {
                app++;
            } else {
                if(app % 2 != 0) {
                    count++;
                    app++;
                } else {
                    current = tmp;
                    app = 1;
                }
            }
        }
        return count;
    }
}
