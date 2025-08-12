// Recursive Fast Power (Divide & Conquer)
class Solution {
    public double myPow(double x, int n) {
        long N = n; // avoid overflow for Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n / 2);
        return (n % 2 == 0) ? half * half : half * half * x;
    }
}

// Iterative Binary Exponentiation (Bitwise)
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1.0;
        while (N > 0) {
            if ((N & 1) == 1) result *= x;
            x *= x;
            N >>= 1;
        }
        return result;
    }
}

// Using Java’s BigInteger Bit Check
import java.math.BigInteger;

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1.0;
        BigInteger bits = BigInteger.valueOf(N);
        while (bits.signum() > 0) {
            if (bits.testBit(0)) ans *= x;
            x *= x;
            bits = bits.shiftRight(1);
        }
        return ans;
    }
}

// Recursive + Memoization (Cache intermediate powers)
import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Long, Double> memo = new HashMap<>();
    
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return helper(x, N);
    }

    private double helper(double x, long n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (memo.containsKey(n)) return memo.get(n);
        
        double half = helper(x, n / 2);
        double result = (n % 2 == 0) ? half * half : half * half * x;
        memo.put(n, result);
        return result;
    }
}

// Using Exponentiation via Math.exp & Math.log
class Solution {
    public double myPow(double x, int n) {
        return Math.exp(n * Math.log(x));
    }
}
