package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private static final int INIT_COUNT = 0;
    private static final int ADD_NUMBER = 1;
    private static final double ROUND_OFF_NUMBER = 1e3;

    private final Map<LottoRankings, Integer> result;

    public Result() {
        result = new HashMap<>();
        for (LottoRankings value : LottoRankings.values()) {
            result.put(value, INIT_COUNT);
        }
    }

    public int getCount(LottoRankings key) {
        return result.get(key);
    }

    public void add(LottoRankings key) {
        result.put(key, result.get(key) + ADD_NUMBER);
    }

    public double getRateOfProfit(Money money) {
        long total = 0L;
        for (Map.Entry<LottoRankings, Integer> entry : result.entrySet()) {
            total += (long)entry.getKey().getPrice() * entry.getValue();
        }

        return Math.round((double)total / money.getValue() * ROUND_OFF_NUMBER) / ROUND_OFF_NUMBER;
    }
}
