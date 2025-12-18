class Solution {
    int maxLength(int arr[]) {
        // code here
        
        // Time Complexity : O(n)
        
        // Space Complexity : O(n)
        
        
        int prefix = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            
            prefix += arr[i];
            
            if(!map.containsKey(prefix)){
                map.put(prefix, i);
            }
            else{
                max = Math.max(max, i - map.get(prefix));
            }
            if(prefix == 0){
                max = Math.max(max, i + 1);
            }
        }
        
        return max;
        
        
        
        
        
        
        
        
        // // Time Complexity : O(n * 2)
        
        // // Space Complexity : O(n * 2)
        
        
        // int[] prefix = new int[arr.length];
        // prefix[0] = arr[0];
        // int max = 0;
        // Map<Integer, Integer> map = new HashMap<>();
        
        // for(int i = 1; i < arr.length; i++){
        //     prefix[i] = prefix[i - 1] + arr[i];
        // }
        
        // for(int i = 0; i < prefix.length; i++){
        //     if(!map.containsKey(prefix[i])){
        //         map.put(prefix[i], i);
        //     }
        //     else{
        //         max = Math.max(max, i - map.get(prefix[i]));
        //     }
        //     if(prefix[i] == 0){
        //         max = Math.max(max, i + 1);
        //     }
        // }
        
        // return max;
    }
}
