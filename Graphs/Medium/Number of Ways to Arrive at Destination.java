class Pair{
    private long key;
    private int value;
    
    public Pair(long key, int value){
        this.key = key;
        this.value = value;
    }
    
    public long getKey(){
        return key;
    }
    public int getValue(){
        return value;
    }
}


class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        
        // Time Complexity : O(V + E + Elog V)
        // The last while loop is a typical Dijkstra's algorithm.
        
        // Space Complexity : O(V + 2 * E + V + V + E)
        // An additional array ways will be used to store the # of shortest ways.
        
        
        List<List<int[]>> adjList = new ArrayList<>();
        long[] distance = new long[n];
        int[] ways = new int[n];
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a.getKey(), b.getKey()));
        
        Arrays.fill(distance, Long.MAX_VALUE);
        
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(List<Integer> l: roads){
            adjList.get(l.get(0)).add(new int[]{l.get(1), l.get(2)});
            adjList.get(l.get(1)).add(new int[]{l.get(0), l.get(2)});
        }
        
        distance[0] = 0;
        minHeap.add(new Pair((long)0, 0));
        ways[0] = 1;
        
        while(!minHeap.isEmpty()){
            Pair poll = minHeap.poll();
            long d = poll.getKey();
            int node = poll.getValue();
            
            for(int[] i: adjList.get(node)){
                int v = i[0];
                int e = i[1];
                if(d + (long)e < distance[v]){
                    distance[v] = d + (long)e;
                    ways[v] = ways[node];
                    minHeap.add(new Pair(distance[v], v));
                }
                else if(d + (long)e == distance[v]){
                    ways[v] = (ways[v] + ways[node]) % 1000000007;
                }
            }
        }
        
        return ways[n - 1] % 1000000007;
    }
}
