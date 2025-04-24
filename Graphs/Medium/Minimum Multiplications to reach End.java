class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        
        // **IMPORTANT**
        // Do not terminate the loop when any value > end is found because it may
        // happen that after again multiplying by some value, the mod will be 
        // effective and it can give a lower value than end.
        

        // Time Complexity : O(100000 + 100000 * arr.length)
        // Filling the multi[] will take O(100000) time. The while loop can run
        // for a maximum of 100000 values and will run the array for each value.
        // Hence TC = O(100000 * arr.length). But in reality, the TC will be much
        // less than this value.
        
        // Space Complexity : O(100000 + 100000)
        // The queue and array can take a max of 100000 values.
        
        
        Queue<int[]> queue = new LinkedList<>();
        int[] multi = new int[100000];
        
        Arrays.fill(multi, Integer.MAX_VALUE);
        
        queue.add(new int[]{0, start});
        multi[start] = 0;
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int m = poll[0];
            int n = poll[1];
            
            if(n == end){
                return m;
            }
            
            for(Integer i: arr){
                if(m + 1 < multi[(n * i) % 100000]){
                    multi[(n * i) % 100000] = m + 1;
                    queue.add(new int[]{m + 1, (n * i) % 100000});
                }
            }
        }
        
        return -1;
        
    }
}
