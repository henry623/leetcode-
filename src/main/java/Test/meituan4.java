package Test;

import java.util.Arrays;
import java.util.Scanner;

public class meituan4 {
    static  class Fenwick{
        int[] tree;
        int size;

        public Fenwick(int n){
            size = n;
            tree = new int[n+1];
        }

        public void update(int index, int delta){
            index ++;
            while(index <= size){
                tree[index] += delta;
                index += index & -index;
            }
        }

        public int query(int index){
            int sum =0;
            index ++;
            while (index > 0){
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }

        public int query(int left, int right){
            if (left > right) return 0;
            return query(right) - query(left-1);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i =0; i<n ;i++){
            a[i] = in.nextInt();
        }

        if(n==0){
            System.out.println(0);
            return;
        }
        int[] b = a.clone();
        Arrays.sort(b);
        int m = 1;
        for(int i =1;i<n;i++){
            if(b[i]!=b[i-1]) b[m++] = b[i];
        }
        b = Arrays.copyOf(b,m);
        int[] index = new int[n];
        for(int i =0;i<n;i++){
            index[i] = Arrays.binarySearch(b,a[i]);
        }
        Fenwick tree = new Fenwick(m);
        for (int i = 0; i < n; i++) {
            tree.update(index[i],1);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            tree.update(index[i],-1);
            for(int j =0;j<i;j++){
                if(a[i]>a[j]){
                    int l = index[j]+1;
                    int r = index[i]-1;
                    if (l<=r){
                        ans += tree.query(l,r);
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
