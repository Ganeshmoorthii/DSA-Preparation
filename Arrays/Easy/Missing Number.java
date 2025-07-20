// 1. Sorting + Scan
public int missingNumber(int[] nums) {
    Arrays.sort(nums);                 // O(n log n)
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i) return i;
    }
    return nums.length; // If all 0..n-1 present
}

// 2. HashSet Lookup
public int missingNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int x : nums) set.add(x);
    for (int i = 0; i <= nums.length; i++) {
        if (!set.contains(i)) return i;
    }
    return -1;
}

// 3. Boolean Presence Array
public int missingNumber(int[] nums) {
    int n = nums.length;
    boolean[] seen = new boolean[n + 1];
    for (int x : nums) seen[x] = true;
    for (int i = 0; i <= n; i++) if (!seen[i]) return i;
    return -1;
}

// 4. Math Summation Formula
public int missingNumber(int[] nums) {
    long n = nums.length;
    long expected = n * (n + 1) / 2;
    long actual = 0;
    for (int x : nums) actual += x;
    return (int)(expected - actual);
}

//  5. XOR Trick (Bitwise) – Most Popular Optimal
public int missingNumber(int[] nums) {
    int xor = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        xor ^= i ^ nums[i];
    }
    xor ^= n; // Include the last index (n)
    return xor;
}

// 6. Cyclic (Index) Placement (Variant of Cyclic Sort)
public int missingNumber(int[] nums) {
    int n = nums.length;
    int i = 0;
    while (i < n) {
        int correct = nums[i];
        if (correct < n && nums[i] != nums[correct]) {
            int temp = nums[i];
            nums[i] = nums[correct];
            nums[correct] = temp;
        } else {
            i++;
        }
    }
    for (i = 0; i < n; i++) {
        if (nums[i] != i) return i;
    }
    return n;
}

// 7. Difference Accumulation (Running Offset)
public int missingNumber(int[] nums) {
    int missing = nums.length; // Start with n
    for (int i = 0; i < nums.length; i++) {
        missing += i - nums[i];
    }
    return missing;
}

// 8. Streams (Java 8+)
public int missingNumber(int[] nums) {
    int n = nums.length;
    long expected = (long)n * (n + 1) / 2;
    long actual = Arrays.stream(nums).asLongStream().sum();
    return (int)(expected - actual);
}

// 9. BitSet / Boolean Vector (Large Range Variation)
public int missingNumber(int[] nums) {
    int n = nums.length;
    BitSet bs = new BitSet(n + 1);
    for (int x : nums) bs.set(x);
    return bs.nextClearBit(0); // First bit not set
}

// 10. Functional XOR (Streams)
public int missingNumber(int[] nums) {
    int n = nums.length;
    int xor = n;
    for (int i = 0; i < n; i++) {
        xor ^= i ^ nums[i];
    }
    return xor;
}
