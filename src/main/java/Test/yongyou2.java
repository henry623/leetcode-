package Test;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class yongyou2 {
    static class Vehicle{
        int id;
        int arrival;
        int charging;

        public Vehicle(int id,int arrival,int charging){
            this.id = id;
            this.arrival = arrival;
            this.charging = charging;
        }

    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        for(int i=0;i<n;i++){
            int arrival = in.nextInt();
            int charging = in.nextInt();
            vehicles.add(new Vehicle(i,arrival,charging));
        }

        Collections.sort(vehicles,(a,b) -> {
            if(a.arrival!=b.arrival){
                return a.arrival-b.arrival;
            }else{
                 return a.id-b.id;
            }
        });

        int[] availableTime = new int[k];
        int[][] result = new int[n][3];
        for(Vehicle v:vehicles){
            int id= v.id;
            int arrival =v.arrival;
            int charging = v.charging;

            int chargerId = -1;
            for(int i=0 ;i<k;i++){
                if(availableTime[i] <=arrival){
                    chargerId = i;
                    break;
                }
            }
            if(chargerId ==-1){
                int minAvailable = Integer.MAX_VALUE;
                for(int i=0;i<k;i++){
                    if(availableTime[i] <minAvailable){
                        minAvailable = availableTime[i];
                        chargerId = i;
                    }
                }
            }

            int start = Math.max(arrival,availableTime[chargerId]);
            int end = start+charging;
            availableTime[chargerId] = end;
            result[id][0] = start;
            result[id][1] = end;
            result[id][2] = chargerId+1;
            
        }
        for(int i=0;i<n;i++){
            System.out.println(i +" " + result[i][0] +" " + result[i][1]+ " " + result[i][2]);
        }
    }
}

