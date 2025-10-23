package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class shopee2 {

    public int[] searchDupK(int[] arr, int k) {
        // write code here
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int num :arr){
            countMap.put(num,countMap.getOrDefault(num,0) +1);

        }
        List<Integer> validList = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: countMap.entrySet()){
            if(entry.getValue() >=k){
                validList.add(entry.getKey());
            }
        }

        Collections.sort(validList);
        int[] result = new int[validList.size()];
        for(int i =0;i<validList.size();i++){
            result[i] = validList.get(i);
        }

        return result;

    }
}

