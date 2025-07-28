// 1. Brute Force (O(n × m))
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      for (int[] row : matrix) {
          for (int num : row) {
              if (num == target) return true;
          }
      }
      return false;
  }
}

// Solution 2
class Solution {
    public boolean searchMatrix(int[][] mat, int tar) {
        for(int i=0;i<mat.length;i++){
            if(mat[i][0]<=tar && mat[i][mat[i].length-1]>=tar){
                if(bs(mat[i],tar)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean bs(int[] mat,int tar){
        int l = 0,r = mat.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(mat[mid]==tar){
                return true;
            }else if(mat[mid] < tar){
                l=mid + 1;
            }else{
                r = mid -1;
            }
        }
        return false;
    }
}

// Solution 3
class Solution {
    public boolean searchMatrix(int[][] mat, int tar) {
        int n = mat.length,m = mat[0].length;
        int l = 0, r =n * m -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(mat[mid/m][mid%m] == tar){
                return true;
            }else if (mat[mid/m][mid%m] < tar){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return false;
    }
}

// Row-wise Binary Search (O(n × log m))
public boolean searchMatrix(int[][] matrix, int target) {
    for (int[] row : matrix) {
        int l = 0, r = row.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (row[mid] == target) return true;
            else if (row[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
    }
    return false;
}

// Java 8 Streams (For small matrices)
public boolean searchMatrix(int[][] matrix, int target) {
    return Arrays.stream(matrix)
        .anyMatch(row -> Arrays.binarySearch(row, target) >= 0);
}


