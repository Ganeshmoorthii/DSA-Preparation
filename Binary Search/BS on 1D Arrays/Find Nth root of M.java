class Solution
{
    public int NthRoot(int n, int m)
    {
        int low = 1,high = m;
        while(low <= high){
            int mid = low + (high - low)/2;
            long val = helper(mid,n,m);
            if(val == m){
                return mid;
            }else if(val>m){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    private long helper(int val , int n, int m){
        long res = 1;
        for(int i=1;i<=n;i++){
            if(res>m){
                return res;
            }
            res *= val;
        }
        return res;
    }
}
