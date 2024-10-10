package net.acmicpc.numTEST;

import java.util.*;

public class num {

    static class Item {
        int weight;
        int value;
        
        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // 아이템 리스트
        List<Item> items = new ArrayList<>();
        items.add(new Item(1000, 60));
        items.add(new Item(2000, 100));
        items.add(new Item(3000, 120));

        int maxWeight = 3000; // 배낭의 최대 무게

        // 좌표 압축을 위한 배열
        Set<Integer> weights = new HashSet<>();
        for (Item item : items) {
            weights.add(item.weight);
        }

        // 압축된 무게 값으로 변환하기 위해 무게를 오름차순 정렬하고 압축된 값을 매핑
        List<Integer> sortedWeights = new ArrayList<>(weights);
        Collections.sort(sortedWeights);
        Map<Integer, Integer> compressed = new HashMap<>();
        for (int i = 0; i < sortedWeights.size(); i++) {
            compressed.put(sortedWeights.get(i), i + 1);  // 1부터 시작하는 압축 좌표
        }

        // 압축된 크기의 DP 배열 선언 (배낭의 무게는 압축된 값으로 계산)
        int[] dp = new int[compressed.size() + 1];

        // DP로 배낭 문제 해결 (좌표 압축 적용)
        for (Item item : items) {
            int compressedWeight = compressed.get(item.weight);
            for (int i = compressed.size(); i >= compressedWeight; i--) {
                dp[i] = Math.max(dp[i], dp[i - compressedWeight] + item.value);
            }
        }

        // 최적의 가치 출력
        System.out.println("최대 가치: " + dp[compressed.size()]);
    }
}