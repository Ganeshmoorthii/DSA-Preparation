// 1. Concatenation Trick (Most Common)
class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}

// 2. Manual Rotation Using StringBuilder
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            char ch = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);
            if (sb.toString().equals(goal)) return true;
        }

        return false;
    }
}

// 3. Check All Rotations Using Substring
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (rotated.equals(goal)) return true;
        }

        return false;
    }
}

// 4. Using Queue for Character Rotation 
import java.util.*;

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        Queue<Character> q1 = new LinkedList<>();
        Queue<Character> q2 = new LinkedList<>();

        for (char c : s.toCharArray()) q1.offer(c);
        for (char c : goal.toCharArray()) q2.offer(c);

        for (int i = 0; i < s.length(); i++) {
            if (q1.equals(q2)) return true;

            char ch = q1.poll();
            q1.offer(ch);
        }

        return false;
    }
}

// 5. Using indexOf() and startsWith()
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String combined = s + s;
        int index = combined.indexOf(goal);
        return index != -1;
    }
}
