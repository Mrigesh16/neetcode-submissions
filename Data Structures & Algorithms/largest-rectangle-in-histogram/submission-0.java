class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] rightMin = new int [n];
        int[] leftMin = new int [n];
        leftMin[0] = -1;
        rightMin[n-1] = n;
        for(int i = 1; i<n; i++){
            int previous = i-1;
            while (previous >= 0 && heights[previous] >= heights[i]) {
                previous = leftMin[previous];
            }
            leftMin[i] = previous;
        }
        for(int i = n-2; i >=0; i--){
            int previous = i+1;
            while(previous <n && heights[previous] >= heights[i]){
                previous = rightMin[previous];
            }
            rightMin[i] = previous;
        }

        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            maxArea = Math.max(maxArea, heights[i] * (rightMin[i]-leftMin[i]-1));
        }

        return maxArea;
    }
}
