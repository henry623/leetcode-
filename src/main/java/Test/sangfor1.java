package Test;

import java.util.*;

public class sangfor1 {
    static class Process{
        int score;
        int time;
        Process(int score, int time){
            this.score = score;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Process> map = new HashMap<>();
        for(int i =0;i<n;i++){
            int pid = in.nextInt();
            int score = in.nextInt();
            int time = in.nextInt();
            map.put(pid, new Process(score, time));
        }

        int m = in.nextInt();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int i = 0; i < m; i++){
            int parentPid = in.nextInt();
            int childPid = in.nextInt();
            map2.computeIfAbsent(parentPid, k -> new ArrayList<>()).add(childPid);
        }
        int T = in.nextInt();
        int S = in.nextInt();
        
        List<List<Integer>> chains = new ArrayList<>();
        for(int pid : map.keySet()){
            dfs(pid,new ArrayList<>(), map, map2, chains);
        }
        List<List<Integer>> badChains= new ArrayList<>();
        List<Integer> totalRiskScores = new ArrayList<>();
        for (List<Integer> chain : chains){
            if(chain.isEmpty()) continue;
            int totalScore = 0;
            int minTime = Integer.MAX_VALUE;
            int maxTime = Integer.MIN_VALUE;
            for(int pid:chain){
                Process process = map.get(pid);
                totalScore += process.score;
                minTime = Math.min(minTime, process.time);
                maxTime = Math.max(maxTime, process.time);
            }

            int TimeDiff = maxTime - minTime;
            if(TimeDiff <= T && totalScore >= S){
                badChains.add(chain);
                totalRiskScores.add(totalScore);
            }


        }
        if (badChains.isEmpty()){
            System.out.println("NULL");
        }else{
            for (int i = 0; i < badChains.size(); i++) {
                List<Integer> chain = badChains.get(i);
                int totalScore = totalRiskScores.get(i);
                for(int pid: chain){
                    System.out.print(pid + " ");
                }
                System.out.println(totalScore);
            }
        }
    }

    private static void dfs(int pid, ArrayList<Integer> cur, Map<Integer, Process> map, Map<Integer, List<Integer>> map2, List<List<Integer>> chains) {
        cur.add(pid);
        chains.add(new ArrayList<>(cur));
        if(map2.containsKey(pid)){
            for(int childPid : map2.get(pid)){
                dfs(childPid, cur, map, map2, chains);
            }
        }
        cur.remove(cur.size()-1);
    }
}
