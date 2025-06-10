import java.util.*;

public class mianShi {
    // select sum(score) from score where  c_id = '02'
    //
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 2, 3, 99, 333};
        System.out.println(nums);
        List<Integer> list = new ArrayList<>(Arrays.asList(nums));
        System.out.println(list);

        HashSet<Integer> set = new HashSet<>(list);
        List<Integer> list2 = new ArrayList<>(set);
        Collections.sort(list2);


        //list2.sort(Integer::compare);
        System.out.println(list2);

    }


}
