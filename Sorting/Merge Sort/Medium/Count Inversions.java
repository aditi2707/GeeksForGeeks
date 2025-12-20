class Solution {
    
    private static int merge(int[] arr, int low, int mid, int high){
        
        int count = 0;
        
        List<Integer> temp = new ArrayList<>();
        int i = low, j = mid + 1;
        
        while(i <= mid && j <= high){
            
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else{
                count += mid - i + 1;
                temp.add(arr[j]);
                j++;
            }
        }
        
        while(i <= mid){
            temp.add(arr[i]);
            i++;
        }
        while(j <= high){
            temp.add(arr[j]);
            j++;
        }
        
        for(int k = low; k <= high; k++){
            arr[k] = temp.get(k - low);
        }
        
        return count;
    }
    
    private static int mergeSort(int[] arr, int low, int high){
        
        if(low >= high){
            return 0;
        }
        
        int mid = (low + high) / 2;
        
        int left = mergeSort(arr, low, mid);
        int right = mergeSort(arr, mid + 1, high);
        int count = left + right + merge(arr, low, mid, high);
        
        return count;
    }
    
    static int inversionCount(int arr[]) {
        // Code Here
        
        // Time Complexity : O(nlog n)
        
        // Space Complexity : O(n)
        
        
        return mergeSort(arr, 0, arr.length - 1);
    
    }
}
