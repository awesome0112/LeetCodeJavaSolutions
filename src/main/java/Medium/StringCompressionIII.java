package Medium;

public class StringCompressionIII {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        char current = word.charAt(0);
        int appearence = 1;
        for (int i = 1; i < word.length(); i++) {
            char tmp = word.charAt(i);
            if (tmp == current) {
                appearence++;
                if (appearence == 9) {
                    comp.append(appearence).append(current);
                    appearence = 0;
                    current = '#';
                }
            } else {
                if (current != '#') {
                    comp.append(appearence).append(current);
                }
                current = tmp;
                appearence = 1;
            }
        }
        if (current != '#') comp.append(appearence).append(current);
        return comp.toString();
    }
}
