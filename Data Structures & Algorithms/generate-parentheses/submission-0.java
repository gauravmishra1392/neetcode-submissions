class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> solution = new ArrayList();
        int open = 0;
        int closed = 0;
        int length = 0;
        dfs(n,solution,open,closed,"");
        return solution;
    }

    void dfs(int n , List solution, int open, int closed,
    String val){

        if(open == n && closed == n){
            solution.add(val);
            return;
        }
        if(closed > open ){
            return;
        }
        if(open<n){
        dfs(n,solution,open+1,closed,val+"(");
        }
        if(closed<open){
        dfs(n,solution,open,closed+1,val+")");
        }
    }
}
