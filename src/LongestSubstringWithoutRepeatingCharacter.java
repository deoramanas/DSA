import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        // String s="pwwkew";
        //  String s="abcabcbb";
        // String s="     ";
        // String s="bbbbb";
       // String s = "dvdf";
        //    s=s.trim();
        //String s="asjrgapa";
        //String s="au";

        String s="abcaabcdba";
       // solutionTLE(s);
      //  solutionSet(s);
        solutionMap(s);
    }

    private static void solutionMap(String s) {
        HashMap<Character,Integer> hmap=new HashMap<>();
        int right=0,left=0;
        int n= s.length();
        int len=0;
        while(right <n){
            if(hmap.containsKey(s.charAt(right))){
                left=Math.max(hmap.get(s.charAt(right))+1,left);
            }
            hmap.put(s.charAt(right),right);
            len= Math.max(len, right-left+1);
            right++;
        }

        System.out.println(len);
    }

    private static void solutionSet(String s) {

        Set<Character> set=new HashSet();

        int i=0,j=0,longest=0;
        int n=s.length();
        while(i<n && j<n){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i++));
            }else{
                set.add(s.charAt(j++));
                longest=Math.max(longest, j-i);
            }
        }

        System.out.println(longest);
    }

    private static void solutionTLE(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();

        int max = 0;
        for (int j = 0; j < len; j++) {
            for (int i = j ; i < len; i++) {
                if (stack.contains(s.charAt(i))) {
                    if (stack.size() > max) {
                        max = stack.size();
                    }
                    stack.removeAllElements();
                }
                stack.push(s.charAt(i));
            }
            if(!stack.isEmpty() && stack.size()>max)
            {
                max=stack.size();
            }
            stack.removeAllElements();
        }

        if(!stack.isEmpty() && stack.size()>max)
        {
            max=stack.size();
        }
        System.out.println(max);
    }
}
