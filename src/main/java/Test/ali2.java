package Test;

import java.util.*;

public class ali2 {
    public static void main(String[] args) {
        String[] words = {"story","fleet", "bar", "foo"};
        ali2  test = new ali2();
        System.out.println(test.indexPairs("thestoryofleetcodefoobarandme",words));

    }

    public int[][] indexPairs (String text, String[] words) {
        // write code here
        Set<String> wordset = new HashSet<>(Arrays.asList(words));
        Set<Integer> lengthset = new HashSet<>();
        for(String word : words){
            lengthset.add(word.length());
        }

        List<int[]> result = new ArrayList<>();
        int n = text.length();
        for(int i = 0;i <n;i++){
            for(int len :lengthset){
                int j = i + len - 1;
                if(j +1 >n) continue;

                String sub = text.substring(i,j + 1);
                if(wordset.contains(sub)){
                    result.add(new int[]{i,j});
                }
            }
        }

        int[][] ans = new int[result.size()][2];
        for(int k =0;k<result.size();k++){
            ans[k] = result.get(k);
        }
        return ans;
    }
}
