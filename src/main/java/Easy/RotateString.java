package Easy;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        for(int i = 0; i < s.length(); i++) {
            s = move(s);
            if(s.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    private String move(String s) {
        char firstChar = s.charAt(0);
        return s.substring(1) + firstChar;
    }
}
