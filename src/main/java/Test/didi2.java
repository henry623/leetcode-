package Test;
import java.util.*;

public class didi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0){
            int n = in.nextInt();
            long m = in.nextLong();
            long[] a = new long[n];
            long sum = 0;
            for(int i = 0;i<n;i++){
                a[i] = in.nextLong();
                sum += a[i];
            }
            Arrays.sort(a);
            long avg = sum/n;
            long r = sum % n;
            long K = 0;
            for(int i = 0;i<n;i++){
                if(i<n-r){
                    if(a[i]<avg){
                        K+=(avg - a[i]);
                    }
                }else{
                    if (a[i]<avg+1){
                        K+=(avg+1 - a[i]);
                    }
                }
            }
            if(K<=m){
                if(r==0){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                }
            }else{
                long[] prefix = new long[n+1];
                for (int i = 0; i < n; i++) {
                    prefix[i+1] = prefix[i] + a[i];
                }
                long[] suffix = new long[n+1];
                suffix[n] = 0;
                for (int i = n-1; i >=0; i--) {
                    suffix[i] = suffix[i+1] + a[i];
                }
                long lowL = a[0];
                long highL = avg;
                long L0 = a[0];
                while(lowL<=highL){
                    long mid = (lowL+highL)/2;
                    int p = compare(a,mid);
                    long need = (long) p*mid - prefix[p];
                    if(need<=m){
                        L0 = mid;
                        lowL = mid+1;
                    }else{
                        highL = mid-1;
                    }
                }
                long lowU =0;
                long highU = a[n-1];
                long U0 = a[n-1];
                while(lowU<=highU){
                    long mid = (lowU+highU)/2;
                    int q = compare2(a,mid);
                    long need;
                    if(q==-1){
                        need = suffix[0] - n*mid;
                    }else if(q ==n-1){
                        need =0;
                    }else{
                        need = suffix[q+1] - (n-q-1)*mid;
                    }
                    if(need <=m){
                        U0 = mid;
                        highU = mid-1;
                    }else{
                        lowU = mid+1;
                    }

                }
                System.out.println(U0 - L0);
            }
        }
    }

    private static int compare(long[] a, long mid) {
        int low = 0,high = a.length;
        while(low<high){
            int midtemp = (low+high)/2;
            if(a[midtemp]<mid){
                low = midtemp+1;
            }else{
                high = midtemp;
            }
        }
        return low;
    }

    private static int compare2(long[] a, long mid) {
        int low = -1,high = a.length -1;
        while(low<high){
            int midtemp = (low+high +1)/2;
            if(a[midtemp]>mid){
                high = midtemp-1;
            }else{
                low = midtemp;
            }
        }
        return low;
    }
}
