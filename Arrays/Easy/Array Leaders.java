class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        
        // Time Complexity : O(n * 2)
        
        // Space Complexity : O(n)
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        int max = arr[arr.length - 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length - 1]);
        
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] >= max){
                stack.push(arr[i]);
            }
            max = Math.max(max, arr[i]);
        }
        
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        
        return ans;
        
    }
}
