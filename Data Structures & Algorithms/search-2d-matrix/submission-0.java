class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = getPotentialRow(matrix, target); 
        return rowIdx == -1 ? false : binarySearchOverRow(matrix, target, rowIdx);  
    }

    int getPotentialRow(int[][] matrix, int target){
        int endRow = matrix.length-1;
        int startRow = 0;
        while(startRow<= endRow){
            int mid = startRow + (endRow-startRow)/2;
            if(matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length-1]){
                return mid;
            }else if(matrix[mid][0] > target)
                endRow = mid-1;
            else
                startRow = mid+1;
        }
        return -1;
    }

    boolean binarySearchOverRow(int[][] matrix, int target, int rowIdx){
        int high = matrix[0].length-1;
        int low =0;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(matrix[rowIdx][mid] == target){
                return true;
            }else if(matrix[rowIdx][mid] > target){
                high = mid -1;
            }else
                low = mid +1;
        }
        return false;
    }
}
