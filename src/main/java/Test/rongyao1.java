package Test;

import java.util.*;

public class rongyao1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        input = input.replace("[","").replace("]","").replace(" ","");
        String[] arr = input.split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        List<String> validTimes = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, used, validTimes, new ArrayList<>());

        if (validTimes.isEmpty()){
            System.out.println("invalid");
        }else{
            Collections.sort(validTimes,Collections.reverseOrder());
        }

        System.out.println(validTimes.get(0));
    }

    private static void backtrack(int[] nums, boolean[] used, List<String> validTimes, List<Integer> list) {
        if(list.size() ==6){
            int hour = list.get(0)*10 + list.get(1);
            int minute = list.get(2)*10 + list.get(3);
            int second = list.get(4)*10 + list.get(5);
            if(hour>=0 && hour<24 && minute>=0 && minute<60 && second>=0 && second<60){
                String time = String.format("%02d:%02d:%02d", hour, minute, second);
                validTimes.add(time);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])){
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums, used, validTimes, list);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}
