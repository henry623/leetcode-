package Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class daima1 {
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};


        Stack<Integer> stack = new Stack<>();
        HashSet<String> set = new HashSet<>(Arrays.asList("+","-","*","/"));
        for(String s: tokens){
            if(set.contains(s)){
                int nums1 = stack.pop();
                int nums2 = stack.pop();
                int result =0;
                if(s.equals("+")){
                    result = nums1 + nums2;
                }else if(s.equals("-")){
                    result = nums2 - nums1;
                }else if(s.equals("*")){
                    result = nums2 * nums1;
                }else if(s.equals("/")){
                    result = nums2 / nums1;
                }
                stack.push(result);

            }else{
                stack.push(Integer.parseInt(s));
            }

        }
        System.out.println(stack.pop());

    }
}
