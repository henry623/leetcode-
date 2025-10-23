package Test;

import java.util.HashMap;
import java.util.Map;

public class shopee3 {
    class Solution {
        /**
         * Note: 类名、方法名、参数名已经指定，请勿修改
         *
         *
         *
         * @param a int整型 一维数组
         * @return int整型
         */
        public int MinimalSizeOfArray(int[] a) {
            // write code here
            if(a== null ||a.length == 0){
                return 0;
            }

            Map<Integer,Integer> freqMap = new HashMap<>();
            for(int num :a){
                freqMap.put(num,freqMap.getOrDefault(num,0) +1);
            }
            int oddCount = 0;
            for(int count:freqMap.values()){
                if(count %2 !=0){
                    oddCount++;
                }
            }
            if(oddCount ==0){
                return 0;
            }else{
                return oddCount % 2 ==1? 1:0;
            }
        }
    }
}


