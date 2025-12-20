class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        
        // Time Complexity : O(n)
        
        // Space Complexity : O(n)
        
        
        int xor = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i = 0; i < arr.length; i++){
            
            xor ^= arr[i];
            if(map.containsKey(k ^ xor)){
                count += map.get(k ^ xor);
            }
            
            if(!map.containsKey(xor)){
                map.put(xor, 1);
            }
            else{
                map.put(xor, map.get(xor) + 1);
            }
        }
        
        return count;
        
        
        
        
        
        
        
        // // Time Complexity : O(n * 2)
        
        // // Space Complexity : O(n * 2)
        
        
        // int[] xor = new int[arr.length];
        // xor[0] = arr[0];
        // int count = 0;
        // Map<Integer, Integer> map = new HashMap<>();
        // map.put(0, 1);
        
        // for(int i = 1; i < arr.length; i++){
        //     xor[i] = xor[i - 1] ^ arr[i];
        // }
        
        // for(int i = 0; i < xor.length; i++){
        //     if(map.containsKey(k ^ xor[i])){
        //         count += map.get(k ^ xor[i]);
        //     }
            
        //     if(!map.containsKey(xor[i])){
        //         map.put(xor[i], 1);
        //     }
        //     else{
        //         map.put(xor[i], map.get(xor[i]) + 1);
        //     }
        // }
        
        // return count;
    }
}
