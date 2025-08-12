 
class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        // 1. Skip leading spaces
        while (i < n && s.charAt(i) == ' ') i++;

        // 2. Handle sign
        boolean positive = true;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            positive = s.charAt(i) != '-';
            i++;
        }

        // 3. Parse digits
        int res = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4. Check for overflow
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            i++;
        }

        return positive ? res : -res;
    }
}

// Recursive Parsing with Accumulator
public class AtoiRecursive {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        boolean neg = s.charAt(0) == '-';
        if (neg || s.charAt(0) == '+') s = s.substring(1);
        return helper(s, 0, neg ? -1 : 1, 0);
    }

    private int helper(String s, int idx, int sign, long result) {
        if (idx >= s.length() || !Character.isDigit(s.charAt(idx)))
            return (int) result;
        result = result * 10 + sign * (s.charAt(idx) - '0');
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return helper(s, idx + 1, sign, result);
    }
}

// Using Java Streams & Functional Reduce
import java.util.stream.IntStream;

public class AtoiStreams {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;

        int sign = 1, idx = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            sign = str.charAt(0) == '-' ? -1 : 1;
            idx++;
        }

        String digits = str.substring(idx).replaceAll("[^0-9].*$", "");
        if (digits.isEmpty()) return 0;

        long result = IntStream.range(0, digits.length())
                .mapToLong(i -> digits.charAt(i) - '0')
                .reduce(0L, (acc, d) -> acc * 10 + d);

        result *= sign;
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) result;
    }
}

// Using Scanner for Token Parsing
import java.util.*;

public class AtoiScanner {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        Scanner sc = new Scanner(s);
        if (!sc.hasNextInt()) return 0;
        int num;
        try {
            num = sc.nextInt();
        } catch (Exception e) {
            return s.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return num;
    }
}

// BigInteger-Based Clamping
import java.math.BigInteger;

public class AtoiBigInteger {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1, idx = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = s.charAt(0) == '-' ? -1 : 1;
            idx++;
        }

        String numStr = "";
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            numStr += s.charAt(idx++);
        }
        if (numStr.isEmpty()) return 0;

        BigInteger big = new BigInteger(numStr).multiply(BigInteger.valueOf(sign));
        if (big.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) return Integer.MAX_VALUE;
        if (big.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) return Integer.MIN_VALUE;
        return big.intValue();
    }
}

//
