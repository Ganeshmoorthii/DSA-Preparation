class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = first_occcur(nums,target);
        int last = last_occcur(nums,target);
        return new int[]{first, last};
    }
    private int first_occcur(int[] nums, int x){
        int low = 0, high = nums.length - 1;
        int first = -1;
        while(low <= high){
            int mid = low + (high - low) /2;
            if(nums[mid]==x){
                first = mid;
                high = mid -1;
            }
            else if (nums[mid] < x){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return first;
    }
    private int last_occcur(int[] nums, int x){
        int low = 0, high = nums.length - 1;
        int last = -1;
        while(low <= high){
            int mid = low + (high - low) /2;
            if(nums[mid]==x){
                last = mid;
                low = mid + 1;
            }
            else if (nums[mid] < x){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return last;
    }
}
