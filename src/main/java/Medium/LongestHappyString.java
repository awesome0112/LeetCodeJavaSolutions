package Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestHappyString {

    final class Pair {
        private final Character character;
        private final Integer remaining;

        public Pair(Character character, Integer remaining) {
            this.character = character;
            this.remaining = remaining;
        }
    }

    private Pair getPairWithMostRemaining(Map<Character, Integer> map, Character exceptionChar) {
        int maxRemaining = 0;
        Integer result = null;
        Character character = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals(exceptionChar)) continue;
            int remaining = entry.getValue();
            if (remaining > maxRemaining) {
                maxRemaining = remaining;
                result = remaining;
                character = entry.getKey();
            }
        }
        return new Pair(character, result);
    }

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', a);
        map.put('b', b);
        map.put('c', c);

        Character currentChar = '#';

        while (true) {
            Pair pairWithMostRemaining;
            if (isValid(result, currentChar)) {
                pairWithMostRemaining = getPairWithMostRemaining(map, '#');
            } else {
                pairWithMostRemaining = getPairWithMostRemaining(map, currentChar);
            }
            Character character = pairWithMostRemaining.character;
            Integer remaining = pairWithMostRemaining.remaining;
            if (remaining == null) break;
            result.append(character);
            map.put(character, remaining - 1);
            currentChar = character;
        }

        return result.toString();
    }

    private static boolean isValid(StringBuilder stringBuilder, char character) {
        if (stringBuilder.length() < 2) return true;
        return !(stringBuilder.charAt(stringBuilder.length() - 1) == character
                && stringBuilder.charAt(stringBuilder.length() - 2) == character);
    }
}
