package Test;

import java.util.*;

public class didi5 {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        int k = in.nextInt();

//        for(int n =l;n<=r;n++){
//            int count =0;
//            for(int base= a;base<=b;base++){
//                List<Integer> digits = toBase(n,base);
//                if(isWave(digits)){
//                    count++;
//                    if (count==k||count + (b-base) <k){
//                        break;
//                    }
//                }else{
//                    if (count + (b-base) <k){
//                        break;
//                    }
//                }
//            }
//            if(count==k){
//                System.out.println(n);
//            }
//        }

        List<Integer> result = findKWaveNumbers(a,b,l,r,k);
        System.out.println(result.size());

    }

    private static List<Integer> findKWaveNumbers(int a, int b, int l, int r, int k) {
        List<Integer> result = new ArrayList<>();
        for(int n =l;n<=r;n++){
            int waveCount =0;
            for(int base= a;base<=b;base++){
                if(isWaveNumberInBase(n,base)){
                    waveCount++;
                    if(waveCount>=k){
                        break;
                    }
                }

            }
            if(waveCount==k){
                result.add(n);
            }
        }
        return result;

    }

    private static boolean isWaveNumberInBase(int n, int base) {
        if (n==0) return false;
        String representation = convertToBase(n,base);
        if(representation.length() ==1){
            return true;
        }
        return isAlternatingTwoChars( representation);
    }

    private static boolean isAlternatingTwoChars(String representation) {
        if(representation.length() < 2){
            return true;
        }
        Set<Character> charSet = new HashSet<>();
        for(char c: representation.toCharArray()){
            charSet.add(c);
            if(charSet.size()>2){
                return false;
            }
        }
        if(charSet.size()!=2){
            return false;
        }
        for(int i=1;i<representation.length();i++){
            if(representation.charAt(i) != representation.charAt(i-1)){
                return false;
            }
        }
        return true;
    }

    private static String convertToBase(int n, int base) {
        if(n==0) return "0";
        StringBuilder sb = new StringBuilder();

        while(n>0){
            int digit = n%base;
            if(digit<10){
                sb.append(digit);
            }else{
                sb.append((char)('A'+digit-10));
            }
            n/=base;
        }
        return sb.reverse().toString();
    }

    public static List<Integer> toBase(int n,int base){
        List<Integer> digits = new ArrayList<>();
        if(n==0){
            digits.add(0);
            return digits;
        }
        while(n>0){
            digits.add(n%base);
            n = n/base;
        }
        Collections.reverse(digits);
        return digits;
    }
    public static boolean isWave(List<Integer> digits){
        int len = digits.size();
        if(len==1) return true;
        int d1 = digits.get(0);
        int d2 = digits.get(1);
        if(d1==d2){
            return false;
        }
        for(int i=0;i<len;i++){
            if(i%2==0){
                if(digits.get(i)!=d1){
                    return false;
                }
            }else{
                if(digits.get(i)!=d2){
                    return false;
                }
            }
        }
        return true;
    }
}
