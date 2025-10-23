package Test;

import java.util.*;

public class rongyao3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            String input = in.nextLine();
            String[] cards = input.split(",");
            int[] points = new int[cards.length];
            for (int j = 0; j < cards.length; j++) {
                points[j] = convertToPoint(cards[j]);
            }
            int initialState = (1 << cards.length) - 1;
            Map<Integer, Boolean> memo = new HashMap<>();
            boolean ans = dfs(points, initialState, memo);
            System.out.println(ans ? "Y" : "N");
        }
    }

    private static int convertToPoint(String card) {
        String pointStr = card.substring(1);
        switch (card) {
            case "A":
                return 14;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            default:
                return Integer.parseInt(card);
        }
    }

    private static boolean dfs(int[] points, int state, Map<Integer, Boolean> memo) {
        if (memo.containsKey(state)) {
            return memo.get(state);
        }
        List<Integer> current = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            if (((state >> i) & 1) == 1) {
                current.add(points[i]);
            }
        }
        if(isStrictIncreasing(current)){
            memo.put(state, true);
            return false;
        }

        for (int i = 0; i < points.length; i++) {
            if (((state >> i) & 1) == 1) {
                int newState = state &~(1 << i);
                if (!dfs(points, newState, memo)) {
                    memo.put(state, true);
                    return true;
                }
            }
        }
        memo.put(state, false);
        return false;
    }

    private static boolean isStrictIncreasing(List<Integer> current) {
        if(current.isEmpty()){
            return false;
        }
        for (int i = 0; i < current.size() -1; i++) {
            if(current.get(i) >= current.get(i+1)){
                return false;
            }
        }
        Set<Integer> set = new HashSet<>(current);
        return set.size() == current.size();
    }
}
