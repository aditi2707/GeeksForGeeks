class Solution {
    public int[] minAnd2ndMin(int arr[]) {
        // code here
        
        // Time Complexity : O(n)
        // Space Complexity : O(1)
        
        int min1 = -1, min2 = -1;
        
        for(Integer i: arr){
            if(min1 == -1 || i < min1){
                min2 = min1;
                min1 = i;
            }
            else if(i > min1 && (min2 == -1 || i < min2)){
                min2 = i;
            }
        }
        
        if(min2 == -1 || min1 == min2){
            return new int[]{-1};
        }
        
        return new int[]{min1, min2};
    }
}
