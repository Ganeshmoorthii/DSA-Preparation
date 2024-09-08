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
