import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class radio_waves_diameter{
    public static List<List<Integer>> adjList;
    public static List<Integer> frequencies;

    public static void main(String arg[]){
        // System.out.println("hello trees");
        int networkNodes = 4;
        List<Integer> networkFrom = Arrays.asList(1,2,3);
        List<Integer> networkTo = Arrays.asList(2,3,4);
        List<Integer> frequency = Arrays.asList(1,1,1,1);
        System.out.println(findMaxDistance(networkNodes, networkFrom, networkTo, frequency));

        // Test 2
        System.out.println(findMaxDistance(
        8, 
        Arrays.asList(1,1,1,2,3,3,4), 
        Arrays.asList(2,3,4,5,6,7,8), 
        Arrays.asList(1,1,1,1,1,1,1,1)));

        // Test 3
        System.out.println(findMaxDistance(
        8, 
        Arrays.asList(1,1,1,2,3,3,4), 
        Arrays.asList(2,3,4,5,6,7,8), 
        Arrays.asList(1,1,1,3,1,1,1,1)));

        // Test 4
        System.out.println(findMaxDistance(
        8, 
        Arrays.asList(1,1,1,2,3,3,4), 
        Arrays.asList(2,3,4,5,6,7,8), 
        Arrays.asList(1,1,3,3,1,1,1,1)));

        // Test 5
        System.out.println(findMaxDistance(
        8, 
        Arrays.asList(1,1,1,2,3,3,4), 
        Arrays.asList(2,3,4,5,6,7,8), 
        Arrays.asList(1,1,2,3,1,3,3,1)));

        // Test 6
        System.out.println(findMaxDistance(
        8, 
        Arrays.asList(1,1,1,2,3,3,4), 
        Arrays.asList(2,3,4,5,6,7,8), 
        Arrays.asList(1,1,1,3,1,3,3,1)));

        // Test 7
        System.out.println(findMaxDistance(
        15, 
        Arrays.asList(1,1,2,3,3,4,5,6, 7, 8, 9,11,12,13), 
        Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,15,14), 
        Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)));

        // Test 8
        System.out.println(findMaxDistance(
        15, 
        Arrays.asList(1,1,2,3,3,4,5,6, 7, 8, 9,11,12,13), 
        Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,15,14), 
        Arrays.asList(1,1,1,1,3,1,1,1,1,1,1,1,1,1,1)));

        // Test 9
        System.out.println(findMaxDistance(
        15, 
        Arrays.asList(1,1,2,3,3,4,5,6, 7, 8, 9,11,12,13), 
        Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,15,14), 
        Arrays.asList(1,1,1,1,3,3,1,1,1,1,1,1,1,1,1)));

        // Test 10
        System.out.println(findMaxDistance(
        15, 
        Arrays.asList(1,1,2,3,3,4,5,6, 7, 8, 9,11,12,13), 
        Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,15,14), 
        Arrays.asList(1,1,3,1,1,1,1,1,1,1,1,1,1,1,1)));

        // Test 11
        System.out.println(findMaxDistance(
        15, 
        Arrays.asList(1,1,2,3,3,4,5,6, 7, 8, 9,11,12,13), 
        Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,15,14), 
        Arrays.asList(1,1,3,1,2,2,1,1,1,1,1,1,1,1,1)));
    }

    public static int findMaxDistance(int networkNodes, List<Integer> networkFrom, List<Integer> networkTo, List<Integer> frequency){
        adjList = new ArrayList<>();
        frequencies = new ArrayList<>();
    
        // 0 is unused
        adjList.add(new ArrayList<>());
        frequencies.add(-1);

        for(int i=1;i<=networkNodes;i++){
            adjList.add(new ArrayList<>());
            frequencies.add(frequency.get(i-1));
        }
        // System.out.println(frequencies);

        int root = networkFrom.get(0);
        int index = -1;
        for(Integer node : networkFrom){
            index++;
            adjList.get(node).add(networkTo.get(index));
        }

        // for(int i=0;i<=networkNodes;i++)
        //     System.out.println(adjList.get(i));

        MyInt res = new MyInt(0);

        getHeight(root,res);

        
        return res.get();
    }

    public static int getHeight(int root, MyInt res){
        int curMaxHeight = 0;

        for(Integer child: adjList.get(root)){
            int curHeight = getHeight(child,res);
            
            if(Math.abs(frequencies.get(root)-frequencies.get(child))>1)
                curHeight = 0;

            res.set(Math.max(res.get(), curMaxHeight + curHeight));
            curMaxHeight = Math.max(curMaxHeight, curHeight);
        }

        return curMaxHeight+1;
    }

    static class MyInt{
        private int val;

        public MyInt(int val){
            this.val = val;
        }

        public void set(int val){
            this.val =val;
        }
        public int get(){
            return val;
        } 
    }
}