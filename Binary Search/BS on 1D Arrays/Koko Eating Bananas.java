class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int mx = piles[0];
        for(int i=1;i<piles.length;i++){
            mx = Math.max(mx,piles[i]);
        }
        int low = 1,high = mx,ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high - low)/2;
            int totalhrs = helper(piles,mid);
            if(totalhrs <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private int helper(int[] arr, int h){
        int totalhrs = 0;
        for(int i=0;i<arr.length;i++){
            totalhrs += Math.ceil((double)arr[i]/(double)h);
        }
        return totalhrs;
    }
}
