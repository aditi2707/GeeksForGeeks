class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        
        // Time Complexity : O(n * 2)
        
        // Space Complexity : O(n)
        
        
        int[] nums = new int[arr.length + 1];
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(Integer i: arr){
            nums[i] += 1;
            if(nums[i] == 2){
                ans.add(i);
            }
        }
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == 0){
                ans.add(i);
            }
        }
        
        return ans;
        
        
        
        
        
        
        // // Time Complexity : O(n * 2)
        
        // // Space Complexity : O(n)
        
        
        // Set<Integer> set = new HashSet<>();
        // ArrayList<Integer> ans = new ArrayList<>();
        
        
        // for(Integer i: arr){
        //     if(!set.contains(i)){
        //         set.add(i);
        //     }
        //     else{
        //         ans.add(i);
        //     }
        // }
        
        // for(int i = 1; i <= arr.length; i++){
        //     if(!set.contains(i)){
        //         ans.add(i);
        //     }
        // }
        
        // return ans;
        
        
        
        
        
        
        // // Time Complexity : O(n)
        
        // // Space Complexity : O(n)
        
        
        // Set<Integer> set = new HashSet<>();
        // ArrayList<Integer> ans = new ArrayList<>();
        // long sum = 0;
        
        // for(Integer i: arr){
        //     if(!set.contains(i)){
        //         set.add(i);
        //         sum += (long)i;
        //     }
        //     else{
        //         ans.add(i);
        //     }
        // }
        
        // long total = (long)((arr.length * (arr.length + 1)) / 2);
        
        // ans.add((int)(total - sum));
        
        // return ans;
        
    }
}
