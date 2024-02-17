import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
        HashMap<ArrayList<Integer>,String> hash = new HashMap<>();
        hash.put(new ArrayList<Integer>(Arrays.asList(1,5)),"asd");

        System.out.println(hash.get(new ArrayList<Integer>(Arrays.asList(1,3))));
        System.out.println(hash.get(new ArrayList<Integer>(Arrays.asList(1,2))));
        System.out.println(hash.get(new ArrayList<Integer>(Arrays.asList(1,1))));
        System.out.println(hash.get(new ArrayList<Integer>(Arrays.asList(2,5))));
        System.out.println(hash.get(new ArrayList<Integer>(Arrays.asList(1,5))));
	}
}
