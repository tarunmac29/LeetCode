class Solution {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;
        while(low <= high){
            int min = Math.min(height[low], height[high]);

            int area = min * (high - low);

            maxArea = Math.max(area, maxArea);

            if(height[low] < height[high]){
                low++;
            }else{
                high--;
            }
        }
        return maxArea;
    }
}