class Solution {
    static char nonRepeatingChar(String s) {
        // code here
        
        // Time Complexity : O(n + n).
        // Space Complexity : O(n)
        
        int[] freq = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(freq[ch - 'a'] == 1){
                return ch;
            }
        }
        
        return '$';
    }
}
