class Solution {
    public int rowWithMax1s(int arr[][]) {
        int max_ones = 0;  // To store maximum count of 1s found so far
        int index = -1;    // To store index of row with maximum 1s
        
        for(int i = 0; i < arr.length; i++) {
            // Find the index of the first 1 in the row using binary search (lowerbound)
            int first_one_index = lowerbound(arr[i], arr[i].length, 1);
            
            // Calculate the count of 1s in the row
            int cnt_ones = arr[i].length - first_one_index;
            
            // Update if the current row has more 1s than the previous maximum
            if (cnt_ones > max_ones) {
                max_ones = cnt_ones;
                index = i;
            }
        }
        return index;
    }
    
    // Binary search to find the first occurrence of 1 in the row
    public static int lowerbound(int arr[], int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;  // Default to 'n' to handle the case when no 1 is found
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;  // Move left to find the first occurrence of 1
            } else {
                low = mid + 1;   // Move right if current element is less than 1
            }
        }
        return ans;
    }
}
