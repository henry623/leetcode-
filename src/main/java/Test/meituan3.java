package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class meituan3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            long[] A = new long[n];
            long[] B = new long[n];
            for(int i=0;i<n;i++){
                A[i] = in.nextLong();
            }
            for(int i=0;i<n;i++){
                B[i] = in.nextLong();
            }
            List<List<Long>> pathA= new ArrayList<>();
            for(long num:A){
                pathA.add(getTransformPath(num));
            }
            List<List<Long>> pathB= new ArrayList<>();
            for(long num:A){
                pathB.add(getTransformPath(num));
            }
            int[] indexA = new int[n];
            Arrays.fill(indexA,0);
            Map<Long,Integer> freqA = new HashMap<>();
            Map<Long,List<Integer>> elementA = new HashMap<>();
            for(int i=0;i<n;i++){
                long v= pathA.get(i).get(0);
                freqA.put(v,freqA.getOrDefault(v,0)+1);
                elementA.computeIfAbsent(v,k -> new ArrayList<>()).add(i);
            }

            int[] indexB = new int[n];
            Arrays.fill(indexB,0);
            Map<Long,Integer> freqB = new HashMap<>();
            Map<Long,List<Integer>> elementB = new HashMap<>();
            for(int i=0;i<n;i++){
                long v= pathA.get(i).get(0);
                freqB.put(v,freqB.getOrDefault(v,0)+1);
                elementB.computeIfAbsent(v,k -> new ArrayList<>()).add(i);
            }

            Set<Long> all = new TreeSet<>(Collections.reverseOrder());
            all.addAll(freqA.keySet());
            all.addAll(freqB.keySet());
            long totalSteps = 0;
            for (Long num:all){
                int diff = freqA.getOrDefault(num,0) - freqB.getOrDefault(num,0);
                if (diff ==0) continue;

                if(diff >0){
                    List<Integer> list = elementA.getOrDefault(num,Collections.emptyList());
                    int count = 0;
                    Iterator<Integer> iter = list.iterator();
                    while(iter.hasNext() && count <diff){
                        int idx = iter.next();
                        if (indexA[idx] +1 >= pathA.get(idx).size()){
                            continue;
                        }
                        long oldV = pathA.get(idx).get(indexA[idx]);
                        long newV = pathA.get(idx).get(indexA[idx]+1);
                        freqA.put(oldV,freqA.get(oldV)-1);
                        if (freqA.get(oldV) ==0){
                            freqA.remove(oldV);
                        }
                        freqA.put(newV,freqA.getOrDefault(newV,0)+1);
                        elementA.get(oldV).remove(Integer.valueOf(idx));
                        if (elementA.get(oldV).isEmpty()){
                            elementA.remove(oldV);
                        }
                        elementA.computeIfAbsent(newV,k -> new ArrayList<>()).add(idx);
                        indexA[idx] ++;
                        totalSteps++;
                        count++;
                        iter.remove();
                    }
                }else {
                    List<Integer> list = elementB.getOrDefault(num,Collections.emptyList());
                    int count = 0;
                    Iterator<Integer> iter = list.iterator();
                    while(iter.hasNext() && count <-diff){
                        int idx = iter.next();
                        if (indexB[idx] +1 >= pathB.get(idx).size()){
                            continue;
                        }
                        long oldV = pathB.get(idx).get(indexB[idx]);
                        long newV = pathB.get(idx).get(indexB[idx]+1);
                        freqB.put(oldV,freqB.get(oldV)-1);
                        if (freqB.get(oldV) ==0){
                            freqB.remove(oldV);
                        }
                        freqB.put(newV,freqB.getOrDefault(newV,0)+1);
                        elementB.get(oldV).remove(Integer.valueOf(idx));
                        if (elementB.get(oldV).isEmpty()){
                            elementB.remove(oldV);
                        }
                        elementB.computeIfAbsent(newV,k -> new ArrayList<>()).add(idx);
                        indexB[idx] ++;
                        totalSteps++;
                        count++;
                        iter.remove();

                    }
                }
            }
            System.out.println(totalSteps);
        }
    }
    public static List<Long> getTransformPath(long x){
        List<Long> path = new ArrayList<>();
        while(true){
            path.add(x);
            long next = Long.bitCount(x);
            if(next ==x)break;
            x= next;
        }
        return path;
    }
}
