class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<>(); 
        int len = s.length();

        for(int i=0; i<len; i++){
            Character cur = s.charAt(i);
            if(cur.equals('(') || cur.equals('{') || cur.equals('[')){
                stack.add(cur);
            }
            else {
                if(stack.size() == 0) 
                    return false;
                int latest = stack.size()-1;
                if(cur.equals(')')){
                    if(stack.get(latest).equals('(')){
                        stack.remove(latest);
                    }
                    else{
                        return false;
                    }
                }
                else if(cur.equals('}')){
                    if(stack.get(latest).equals('{')){
                        stack.remove(latest);
                    }
                    else{
                        return false;
                    }
                }
                else{
                    if(stack.get(latest).equals('[')){
                        stack.remove(latest);
                    }
                    else{
                        return false;
                    }
                }
            }
            // System.out.println(s.charAt(i));
        }

        return stack.size() == 0 ;
    }
}