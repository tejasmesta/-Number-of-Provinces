class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i<= isConnected.length; i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i< isConnected.length; i++)
        {
            for(int j = 0; j<isConnected[0].length; j++)
            {            
                if(i != j && isConnected[i][j] == 1)
                {
                    addEdge(adj, i+1, j+1);
                }
            }
        }
        
        int v = isConnected.length;
        
        boolean vis[] = new boolean[v+1];
        
        int count = 0;
        
        
        
        for(int i = 0; i<=v; i++)
        {
            if(!vis[i])
            {
                dfs(i, adj, vis);
                count++;
            }
        }
        
        return count-1;
    }
    
    void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int dest)
    {
        adj.get(source).add(dest);
        adj.get(dest).add(source);
    }
    
    void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean vis[])
    {
        vis[v] = true;       
        
        
        for(Integer neighbor : adj.get(v))
        {
            if(!vis[neighbor])
            {
                dfs(neighbor, adj, vis);
            }
        }
    }
} 
