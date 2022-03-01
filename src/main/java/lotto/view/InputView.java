package lotto.view;

import java.util.Scanner;

import lotto.domain.lotto.LottoFactory;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.(1000원 ~ 20억원)");
        return scanner.nextLine();
    }

    public static String inputLastWeekWinningNumbers() {
        System.out.printf("%n지난 주 당첨 번호를 입력해 주세요.(\"%s\"를 기준으로 6개 입력해주세요.)%n", LottoFactory.TEXT_DELIMITER);
        return scanner.nextLine();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}
