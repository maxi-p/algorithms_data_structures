import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class anagram_sentences{

    public static void main(String args[]){
        System.out.println("Hello world!");
        List<String> sentences = Arrays.asList("add dad that", "hey dude", "welcome to ucf");
        List<String> words = Arrays.asList("add", "dad", "to", "in", "ot");
        
        System.out.println(sentences);
        System.out.println(words);
        // anagram checker
        // if(isAnagram("dad", "add"))
        //     System.out.println("yes");



        
        
        System.out.println(findSentences(words, sentences));

    }

    public static List<Integer> findSentences(List<String> words, List<String> sentences){
        List<Integer> res = new ArrayList<>();

        HashMap<String,Integer> hash = getAnagramCount(words);
        // hashmap checker
        System.out.println(hash);

        for(String cur: sentences){
            // System.out.println("adding");
            res.add(1);
            List<String> wordsInSentence = getWordsFromSentences(cur);

            for(String wordInSentence : wordsInSentence){

                if(hash.containsKey(wordInSentence)){
                    int count = hash.get(wordInSentence);
                    if(count != 1)
                        res.set(res.size()-1, res.get(res.size()-1)*count);
                }
                // System.out.println(res);
            }
            // System.out.println(wordsInSentence);
        }
        return res;
    }

    public static List<String> getWordsFromSentences(String sentence){
        List<String> res = new ArrayList<>();
        res = Arrays.asList(sentence.split("[^\\w']+"));
        return res;
    }

    public static HashMap<String, Integer> getAnagramCount(List<String> words){
        HashMap<String,Integer> hash = new HashMap<>();
        int [] visited = new int[words.size()];
        for(int i=0;i<words.size();i++){
            List<String> curList = new ArrayList<>();
            int count = 1;
            if(visited[i] == 0){
                visited[i] = 1; 
                curList.add(words.get(i));
                for(int j=i+1;j<words.size();j++){
                    if(visited[j] == 0 && isAnagram(words.get(i), words.get(j))){
                        visited[j] = 1;
                        curList.add(words.get(j));
                        count++;
                    }
                }
            }
            for(String str : curList){
                hash.put(str,count);
            }
            
        }

        return hash;
    }

    public static boolean isAnagram(String one, String two){
        if(one.length() != two.length())
            return false;
        
        if(one.equals(two))
            return false;

        HashMap<Character,Integer> hash1 = new HashMap<>();
        HashMap<Character,Integer> hash2 = new HashMap<>();

        for(int i=0;i<one.length();i++){
            if(hash1.containsKey(one.charAt(i))){
                hash1.put(one.charAt(i),hash1.get(one.charAt(i))+1);
            }
            else{
                hash1.put(one.charAt(i),1);
            }
        }
        for(int i=0;i<two.length();i++){
            if(hash2.containsKey(two.charAt(i))){
                hash2.put(two.charAt(i),hash2.get(two.charAt(i))+1);
            }
            else{
                hash2.put(two.charAt(i),1);
            }
        }

        for(Map.Entry<Character,Integer> cur : hash1.entrySet()){
            if(cur.getValue() != hash2.get(cur.getKey()))
                return false;
        }   

        return true;        
    }

}