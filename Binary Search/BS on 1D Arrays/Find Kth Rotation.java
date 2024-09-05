class Solution {
    public int findKRotation(List<Integer> arr) {
        int low = 0;
        int high = arr.size() - 1;
        int m = arr.get(0);
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr.get(low)<=arr.get(mid)){
                m = Math.min(m,arr.get(low));
                low = mid + 1;
            }else{
                m = Math.min(m,arr.get(mid));
                high = mid - 1;
            }
        }
        return arr.indexOf(m);
    }
}
