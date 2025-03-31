class Solution {
    
    private boolean compareBoth(String s1, String s2){
            
        return (s1 + s2).compareTo(s2 + s1) > 0;
    }
    
    
    String findLargest(int[] arr) {
        // code here
        
        // Time Complexity : O(n + n logn + n).
        // Space Complexity : O(n + n)
        
        List<String> list = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        
        for(Integer i: arr){
            list.add(String.valueOf(i));
        }
        
        Collections.sort(list, (s1, s2) -> compareBoth(s1, s2)? -1 : 1);
        
        if(list.get(0).equals("0")){
            return "0";
        }
        
        for(String s: list){
            ans.append(s);
        }
        
        return ans.toString();
    }
}
