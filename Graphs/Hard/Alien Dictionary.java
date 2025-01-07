class Solution {
    public String findOrder(String[] dict, int k) {
        // Write your code here
        
        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[k];
        String ans = "";
        
        for(int i = 0; i < k; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 1; i < dict.length; i++){
            String a = dict[i - 1];
            String b = dict[i];
            int p = 0, q = 0;
            
            while(p < a.length() && q < b.length()){
                if(a.charAt(p) != b.charAt(q)){
                    list.get(a.charAt(p) - 'a').add(b.charAt(q) - 'a');
                    inDegree[b.charAt(q) - 'a']++;
                    break;
                }
                p++;
                q++;
            }
        }
        
        for(int i = 0; i < k; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            
            int poll = queue.poll();
            ans += (char)(97 + poll);
            
            for(Integer i: list.get(poll)){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        
        if(ans.length() == k){
            return ans;
        }
        
        return "";
    }
}
