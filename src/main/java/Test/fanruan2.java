package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class fanruan2 {
    public static void main(String[] args) {
        System.out.println(new Solution().Solve(2, 2, new int[]{9, 1, 6, 4}));

    }

    static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param N int整型
         * @param K int整型
         * @param R int整型一维数组 每个参赛者的评分
         * @return int整型
         */
        public int Solve (int N, int K, int[] R) {
            // write code here
            int n = R.length;
            Integer[] sortedR = new Integer[n];
            for(int i =0;i<n;i++){
                sortedR[i] = R[i];
            }
            Arrays.sort(sortedR,Collections.reverseOrder());
            List<Integer> winners = new ArrayList<>(Arrays.asList(sortedR));
            int totalCloseMatches = 0;
            for(int i =0;i<N;i++){
                int size = winners.size() /2;
                List<Integer> next = new ArrayList<>(winners.subList(size,2*size));
                List<Integer> very = new ArrayList<>(winners.subList(0,size));
                Collections.sort(next);
                Collections.sort(very);

                int count = 0;
                int idx_very = 0;
                int idx_next = 0;

                while(idx_very <very.size() && idx_next<next.size()){
                    long diff = (long)very.get(idx_very) -(long)next.get(idx_next);
                    if(diff <=K){
                        count++;
                        idx_next++;
                        idx_very++;
                    }
                }
                totalCloseMatches +=count;
                winners =very;
            }


            return totalCloseMatches;
        }
    }
}
