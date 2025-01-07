class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        
        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[n];
        int ind = 0;
        
        List<List<Integer>> list = new ArrayList<>();
        int[] inDegree = new int[n];
        
        
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            list.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }
        
        for(int i = 0; i < m; i++){
            inDegree[prerequisites.get(i).get(0)]++;
        }
        
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            
            int poll = queue.poll();
            ans[ind] = poll;
            ind++;
            
            for(Integer i: list.get(poll)){
                inDegree[i]--;
                
                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        
        if(ind < n){
            return new int[0];
        }
        
        return ans;
    }
}
