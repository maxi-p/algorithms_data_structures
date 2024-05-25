class Solution {
    public String res = "";
    public String foreignDictionary(String[] words) {
        if ( words.length == 0 ) return new String("");

        // method to store the "rules"
        HashMap<Character,List<Character>> adjList = new HashMap<>();

        // preprocessing
        for ( int i=0; i<words.length; i++ )
        {
            String a = words[i];
            for ( int j=0; j<a.length(); j++ )
            {
                if ( !adjList.containsKey(a.charAt(j)) )
                    adjList.put(a.charAt(j), new ArrayList<>());
            }
        }

        for ( int i=0; i<words.length-1; i++ )
        {
            String a = words[i];
            String b = words[i+1];

            int len = Math.min(a.length(),b.length());
            boolean equal = true;
            for ( int j=0; j<len; j++ )
            {
                if ( a.charAt(j) != b.charAt(j) )
                {
                    adjList.get(a.charAt(j)).add(b.charAt(j));
                    equal = false;
                    break;
                }
            }
            // invalid order edge case
            if ( equal && a.length() > b.length() )
            {
                return "";
            }
        }

        // true - processed, false - currently in path
        HashMap<Character,Boolean> visited = new HashMap<>();

        for ( Map.Entry<Character, List<Character>> mapElement : adjList.entrySet() )
        {
            // true - no cycle, false - cycle
            if ( !dfs(mapElement.getKey(), adjList, visited) )
            {
                return "";
            }
        }   

        // reversing a string manually
        String realRes = "";
        for ( int i=res.length()-1; i>=0; i-- )
        {
            realRes += res.charAt(i);
        }
        return realRes;
    }

    boolean dfs(Character cur, HashMap<Character, List<Character>> adjList, HashMap<Character, Boolean> visited)
    {
        // cycle check
        if ( visited.containsKey(cur) )
        {
            if ( visited.get(cur) == true )
                return true;
            else
                return false;
        }

        // adding to current path / "starting processing"
        visited.put(cur, false);
        if ( adjList.containsKey(cur) )
        {
            for ( Character depend : adjList.get(cur) )
            {
                if ( !dfs(depend, adjList, visited) )
                    return false;
            }
        }
        // finished processing
        visited.put(cur, true); 
        res += cur;
        return true;
    }
}
