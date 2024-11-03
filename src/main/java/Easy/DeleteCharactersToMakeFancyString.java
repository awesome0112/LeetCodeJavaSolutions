package Easy;

public class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        char currentChar = s.charAt(0);
        int appearance = 1;
        StringBuilder res = new StringBuilder();
        res.append(currentChar);
        for(int i = 1; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(currentChar == tmp) {
                appearance++;
            } else {
                currentChar = tmp;
                appearance = 1;
            }

            if(appearance != 3) {
                res.append(tmp);
            } else {
                appearance--;
            }
        }

        return res.toString();
    }
}
