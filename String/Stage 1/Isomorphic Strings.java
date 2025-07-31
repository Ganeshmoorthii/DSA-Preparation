// 1. Using Two HashMaps (Bi-directional check)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);

            if (map1.containsKey(c1) && map1.get(c1) != c2) return false;
            if (map2.containsKey(c2) && map2.get(c2) != c1) return false;

            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;
    }
}

// 2. Using Arrays for ASCII character mapping
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;

            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }

        return true;
    }
}

// 3. Transform Strings to Pattern Strings 
class Solution {
    public boolean isIsomorphic(String s, String t) {
        return encode(s).equals(encode(t));
    }

    private String encode(String str) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int code = 0;

        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, code++);
            }
            sb.append(map.get(c)).append(" ");
        }

        return sb.toString();
    }
}

// 4. Using Java Streams for Pattern
import java.util.*;
import java.util.stream.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        return toPattern(s).equals(toPattern(t));
    }

    private List<Integer> toPattern(String str) {
        Map<Character, Integer> map = new HashMap<>();
        AtomicInteger index = new AtomicInteger(0);
        return str.chars()
                  .mapToObj(c -> (char) c)
                  .map(c -> map.computeIfAbsent(c, k -> index.getAndIncrement()))
                  .collect(Collectors.toList());
    }
}

// 5. Two Arrays (Cleaner ASCII Solution)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sMap = new int[128];
        int[] tMap = new int[128];

        for (int i = 0; i < s.length(); i++) {
            if (sMap[s.charAt(i)] != tMap[t.charAt(i)]) return false;

            sMap[s.charAt(i)] = i + 1;
            tMap[t.charAt(i)] = i + 1;
        }

        return true;
    }
}


// 
