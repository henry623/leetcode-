import java.util.Arrays;

public class Test1T {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(strs);
        System.out.println(Arrays.toString(strs));

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = -1;
        for (int j = i; j < 9; j++) {
          if(nums[j] >=1){
              i++;
          }
        }
        System.out.println(i);

    }
}
