package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class LottoController {

    private Money getBuyMoney() {
        String input;
        Money money;

        do {
            input = InputView.inputMoney();
            money = getValidMoney(input);
        } while (money == null);
        return money;
    }

    private Money getValidMoney(String input) {
        Money money = null;
        try {
            money = new Money(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return money;
    }
}
