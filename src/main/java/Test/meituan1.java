package Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class meituan1 {
    // ai题


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String s = in.readLine();

            int[] upper = new int[26];
            int[] lower = new int[26];
            for (char c : s.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    upper[c - 'A']++;
                } else if (c >= 'a' && c <= 'z') {
                    lower[c - 'a']++;
                }
            }

            int[] form = new int[26];
            for (int i = 0; i < 26; i++) {
                int cost_upper = lower[i] + (upper[i] > 0 ? 0 : 1);
                int cost_lower = upper[i] + (lower[i] > 0 ? 0 : 1);
                if (cost_upper <= cost_lower) {
                    form[i] = 0;
                } else {
                    form[i] = 1;
                }
            }

            StringBuilder reserved = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    int idx = c - 'A';
                    if (form[idx] == 0) {
                        reserved.append(c);
                    }
                } else if (c >= 'a' && c <= 'z') {
                    int idx = c - 'a';
                    if (form[idx] == 1) {
                        reserved.append(c);
                    }
                }
            }

            List<Character> insertions = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (form[i] == 0) {
                    if (upper[i] == 0) {
                        insertions.add((char) ('A' + i));
                    }
                } else {
                    if (lower[i] == 0) {
                        insertions.add((char) ('a' + i));
                    }
                }
            }
            Collections.sort(insertions);

            char[] resArr = new char[reserved.length() + insertions.size()];
            int i = 0, j = 0, k = 0;
            while (i < insertions.size() && j < reserved.length()) {
                char c1 = insertions.get(i);
                char c2 = reserved.charAt(j);
                if (c1 <= c2) {
                    resArr[k++] = c1;
                    i++;
                } else {
                    resArr[k++] = c2;
                    j++;
                }
            }
            while (i < insertions.size()) {
                resArr[k++] = insertions.get(i++);
            }
            while (j < reserved.length()) {
                resArr[k++] = reserved.charAt(j++);
            }

            out.write(new String(resArr));
            out.newLine();
        }
        out.flush();
    }
}


