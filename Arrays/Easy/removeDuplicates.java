// 1. Using HashSet (Unsorted Array – Best for Interviews)
public int[] removeDuplicates(int[] arr) {
    Set<Integer> set = new LinkedHashSet<>(); // preserves order
    for (int num : arr) {
        set.add(num);
    }
    int[] result = new int[set.size()];
    int i = 0;
    for (int num : set) {
        result[i++] = num;
    }
    return result;
}

// 2. In-place Removal for Sorted Array (like Leetcode #26)
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
}

// 3. Using Java 8+ Streams (for unique result)
public int[] removeDuplicates(int[] arr) {
    return Arrays.stream(arr)
                 .distinct()
                 .toArray();
}

// 4. Brute-force (Avoid – For Learning)
public int[] removeDuplicates(int[] arr) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
        if (!list.contains(arr[i])) {
            list.add(arr[i]);
        }
    }
    int[] result = new int[list.size()];
    for (int i = 0; i < result.length; i++) {
        result[i] = list.get(i);
    }
    return result;
}
