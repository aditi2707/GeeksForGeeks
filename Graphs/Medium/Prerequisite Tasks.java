class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        int[] inDegree = new int[N];
        int count = 0;
        
        for(int i = 0; i < N; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < P; i++){
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
            inDegree[prerequisites[i][1]]++;
        }
        
        for(int i = 0; i < N; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            
            int poll = queue.poll();
            count++;
            
            for(Integer i: list.get(poll)){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        
        return count == N;
    }
    
}
