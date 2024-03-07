import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.util.function.Function;

public class SortWordsInArray {
    
    public static void main(String[] args) {
		System.out.print("Please, enter words separated by space: ");
		Scanner sc = new Scanner(System.in);
		List<String> words;
		
		// Reading 7 words in 1 line, splitting it by spaces, putting them in our list
		words = Arrays.asList(sc.nextLine().split(" "));
		Function<String,String> ignoreCase = (word) -> word.toLowerCase();
		Function<String,Integer> len = (word) -> -word.length();
		words.sort(Comparator.comparing(ignoreCase));
		words.sort(Comparator.comparing(len));
		for( String str : words){
		    System.out.print(str+" ");
		}
    }
}
