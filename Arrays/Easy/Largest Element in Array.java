// 1. Naive Approach (Sorting)
public int findLargest(int[] arr) {
    Arrays.sort(arr);
    return arr[arr.length - 1]; // Last element will be the largest
}

// 2. Iterative (Best and Most Used)
class Solution {
    public static int largest(int[] arr) {
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(max < arr[i]) max = arr[i];
        }
        return max;
    }
}

// 3. Using Collections (for object arrays like Integer[])
public int findLargest(Integer[] arr) {
    return Collections.max(Arrays.asList(arr));
}

// 4. Using Streams (Java 8+)
public int findLargest(int[] arr) {
    return Arrays.stream(arr).max().getAsInt();
}

// Recursive Approach
public int findLargestRecursive(int[] arr, int n) {
    if (n == 1) return arr[0];
    return Math.max(arr[n - 1], findLargestRecursive(arr, n - 1));
}
