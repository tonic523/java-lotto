package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.domain.LottoRanking;

public class Lotto {

    public static final int PRICE = 1000;

    private static final int SIZE = 6;
    private static final int SUB_LIST_FROM_INDEX = 0;

    private static final List<Number> LOTTO_NUMBERS = new ArrayList<>();

    private static final String TEXT_DELIMITER = ", ";

    private final Set<Number> numbers;

    static {
        for (int i = Number.MIN_VALUE; i <= Number.MAX_VALUE; i++) {
            Number number = new Number(String.valueOf(i));
            LOTTO_NUMBERS.add(number);
        }
    }

    public Lotto() {
        Collections.shuffle(LOTTO_NUMBERS);
        this.numbers = new HashSet<>(LOTTO_NUMBERS.subList(SUB_LIST_FROM_INDEX, SIZE));
    }

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream().map(Number::new).collect(Collectors.toSet());
    }

    public static Lotto of(String text) {
        String[] splitText = text.split(TEXT_DELIMITER);
        return new Lotto(toNumberList(splitText));
    }

    private static List<Integer> toNumberList(String[] splitText) {
        try {
            return Arrays.stream(splitText)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    private static void validateNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("6개의 숫자가 필요합니다.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        int noDuplicateCount = (int)numbers.stream().distinct().count();

        if (noDuplicateCount != SIZE) {
            throw new IllegalArgumentException("중복은 허용하지 않습니다.");
        }
    }

    public LottoRanking getWinningPrice(Lotto lotto, Number bonusNumber) {
        int count = 0;
        boolean containsBonus = false;
        for (Number number : lotto.getNumbers()) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        if (count == 5 && numbers.contains(bonusNumber)) {
            containsBonus = true;
        }

        return LottoRanking.of(count, containsBonus);
    }

    public Set<Number> getNumbers() {
        return numbers;
    }
}
