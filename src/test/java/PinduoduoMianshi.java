public class PinduoduoMianshi {
    public static void main(String[] args) {
        System.out.println(new PinduoduoMianshi().new Solution().removeKdigits("1432219", 3));
    }
    public class Solution {
        public String removeKdigits(String num, int k) {
            if (k >= num.length()) return "0"; // 特殊情况处理

            char[] stack = new char[num.length()];
            int top = 0; // 栈顶指针

            for (char c : num.toCharArray()) {
                // 当还有删除次数且栈不为空且当前字符小于栈顶字符时，弹出栈顶
                while (k > 0 && top > 0 && c < stack[top - 1]) {
                    top--;
                    k--;
                }
                stack[top++] = c; // 当前字符入栈
            }

            // 处理剩余未删除的 k（当数字单调递增时）
            top -= k;
            if (top <= 0) return "0"; // 全删完

//            // 去除前导零
//            int start = 0;
//            while (start < top && stack[start] == '0') start++;
//            if (start == top) return "0"; // 全零情况

            //return new String(stack, start, top - start);
            return new String(stack,0,top-k);
        }
    }
}
