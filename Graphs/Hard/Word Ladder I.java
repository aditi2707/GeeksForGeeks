class Solution
{
    class Pair{
        
        String s;
        int n;
        
        Pair(String s, int n){
            this.s = s;
            this.n = n;
        }
    }
    
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startWord, 1));
        
        Set<String> set = new HashSet<>();
        for(String s: wordList){
            set.add(s);
        }
        
        set.remove(startWord);
        
        while(!queue.isEmpty()){
            Pair poll = queue.poll();
            String str = poll.s;
            int len = poll.n;
            
            if(str.equals(targetWord)){
                return len;
            }
            
            for(int i = 0; i < str.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    String temp = str.substring(0, i) + c + str.substring(i + 1);
                    if(set.contains(temp)){
                        queue.add(new Pair(temp, len + 1));
                        set.remove(temp);
                    }
                }
            }
        }
        
        return 0;
    }
}
