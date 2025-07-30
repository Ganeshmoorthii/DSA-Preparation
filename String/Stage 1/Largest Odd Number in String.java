// Largest Odd Number in String
class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if ((c - '0') % 2 != 0) return num.substring(0, i + 1);
        }
        return "";
    }
}

// 2. Using Character.getNumericValue()
class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}

// 3. Using StringBuilder and reverse traversal
class Solution {
    public String largestOddNumber(String num) {
        StringBuilder sb = new StringBuilder(num);
        while (sb.length() > 0) {
            int lastDigit = sb.charAt(sb.length() - 1) - '0';
            if (lastDigit % 2 != 0) break;
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}

// 4. Using Regex (Less Efficient, But Interesting)
class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length(); i > 0; i--) {
            if (num.substring(0, i).matches(".*[13579]$")) {
                return num.substring(0, i);
            }
        }
        return "";
    }
}

// 5. Using Streams (Java 8+ Functional Style - Educational Purpose)
import java.util.stream.IntStream;

class Solution {
    public String largestOddNumber(String num) {
        return IntStream.iterate(num.length() - 1, i -> i >= 0, i -> i - 1)
            .filter(i -> (num.charAt(i) - '0') % 2 != 0)
            .mapToObj(i -> num.substring(0, i + 1))
            .findFirst()
            .orElse("");
    }
}
