import cn.leetcode.Test49;

import java.util.concurrent.*;

public class Test49T {
    public static void main(String[] args) throws InterruptedException {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Test49 test49 = new Test49();
        
        // 使用线程池来模拟多线程环境
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        StringBuilder sharedStringBuilder = new StringBuilder();
        
        // 创建多个任务，每个任务尝试使用同一个 StringBuilder 实例
        for (String str : strs) {
            executorService.submit(() -> {
                int[] counts = new int[26];
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    counts[str.charAt(i) - 'a']++;
                }
                for (int i = 0; i < 26; i++) {
                    if (counts[i] != 0) {
                        sharedStringBuilder.append((char) ('a' + i));
                        sharedStringBuilder.append(counts[i]);
                    }
                }
                String key = sharedStringBuilder.toString();
                System.out.println("Generated key: " + key);
                sharedStringBuilder.setLength(0); // 清空 StringBuilder 以便下次使用
            });
        }
        
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
