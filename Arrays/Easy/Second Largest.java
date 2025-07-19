// 1. Sorting Approach
public int secondLargest(int[] arr) {
    Arrays.sort(arr);
    int max = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) {
        if (arr[i] != max) {
            return arr[i];
        }
    }
    return -1; // No second largest exists
}

// 2. Two Pass Approach
public int secondLargest(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int num : arr) {
        if (num > max) {
            max = num;
        }
    }

    int second = Integer.MIN_VALUE;
    for (int num : arr) {
        if (num > second && num < max) {
            second = num;
        }
    }

    return second == Integer.MIN_VALUE ? -1 : second;
}

// 3. Optimal Single Pass Approach
class Solution {
    public int print2largest(int[] arr) {
        int largest = arr[0], slargest = -1;
        
        // Loop through the array starting from the first element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                // Update second largest before updating largest
                slargest = largest;
                largest = arr[i];
            } else if (arr[i] > slargest && arr[i] != largest) {
                // Update second largest if the current element is not the largest
                slargest = arr[i];
            }
        }
        return slargest;
    }
}

// 4. Using TreeSet (Only for Unique Elements)
public int secondLargest(int[] arr) {
    TreeSet<Integer> set = new TreeSet<>();
    for (int num : arr) set.add(num);
    
    if (set.size() < 2) return -1;
    
    set.remove(set.last());
    return set.last();
}

// 5. Streams Approach (Java 8+)
public int secondLargest(int[] arr) {
    return Arrays.stream(arr)
        .distinct()
        .boxed()
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst()
        .orElse(-1);
}

