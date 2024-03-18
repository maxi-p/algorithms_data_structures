import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class radio_waves{
    public static void main(String[] args){
        // System.out.println("hello grafs!");
        
        // Test 1
        System.out.println(calculateMax(4, Arrays.asList(1,2,3),Arrays.asList(2,3,4),Arrays.asList(1,3,2,1)));

        // Test 2
        System.out.println(calculateMax(4, Arrays.asList(1,1,1),Arrays.asList(2,3,4),Arrays.asList(1,1,1,1)));

        // Test 3
        System.out.println(calculateMax(4, Arrays.asList(1,2,3),Arrays.asList(2,3,4),Arrays.asList(1,3,1,3)));

        // Test 4
        System.out.println(calculateMax(9, Arrays.asList(1,1,2,3,4,4,5,6,6,7,8),Arrays.asList(2,3,4,4,5,6,7,7,9,8,9),Arrays.asList(1,1,1,1,1,1,1,1,1)));
    }

    public static int calculateMax(int networkNodes, List<Integer> networkFrom, List<Integer> networkTo, List<Integer> frequency){        
        // preprocessing
        List<List<Integer>> adjList = new ArrayList<>();
        // 0 index (unused)
        adjList.add(new ArrayList<>());
        for(int i=1; i<= networkNodes;i++){
            ArrayList<Integer> cur = new ArrayList<>();
            adjList.add(cur);
            
            for(int j=0;j<networkFrom.size();j++){
                if(networkFrom.get(j) == i){
                    cur.add(networkTo.get(j));
                }
                if(networkTo.get(j) == i){
                    cur.add(networkFrom.get(j));
                }
            }
        }

        int [] visited = new int[networkNodes+1];
        int level[] = new int[networkNodes+1];
        
        int max = 0;
        for(int i=1; i <= networkNodes; i++){
            Arrays.fill(visited,0);
            Arrays.fill(level,0);
            ArrayList<Integer> queue = new ArrayList<>();
            queue.add(i);
            visited[i] = 1;
            level[i] = 0;
            
            while(queue.size() !=0){
                int cur = queue.get(0);queue.remove(0);
                int curLvl = level[cur];
                for(Integer con : adjList.get(cur)){
                    if(Math.abs(frequency.get(cur-1) - frequency.get(con-1))<=1 && visited[con] == 0){
                        queue.add(con);
                        visited[con] = 1;
                        level[con] = curLvl + 1;
                        max = Math.max(max,level[con]); 
                    }
                }
            }
                       

            

        }
        return max;
    }
}