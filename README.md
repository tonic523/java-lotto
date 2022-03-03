# java-lotto

로또 미션 저장소

## 어떤 프로그램인가요?

가상으로 사용자가 로또를 구매하고 지난주 당첨 번호를 직접 입력하여 당첨이 얼마나 되는지 수익률이 몇인지 알 수 있는
프로그램입니다.
- java로만 구현된 애플리케이션(jdk11버전)
- 터미널에서 사용자가 구입금액, 지난주 당첨 번호를 입력하고 터미널에서 결과를 확인할 수 있다.
- 로또는 1 ~ 45 중 랜덤으로 6개의 번호를 가진 로또를 발급한다.
- 로또는 1장당 1000원이다.
- 당첨기준은 실제 로또와 같다.

> 추가 구현
- 로또를 수동으로 구매하는 기능

## 스토리보드
```text
구입금액을 입력해 주세요.(1000원~20억원)
14000

수동으로 구매할 로또 수를 입력해 주세요.
3

수동으로 구매할 번호를 입력해 주세요.(", "를 기준으로 6개 입력해주세요.)
8, 21, 23, 41, 42, 43
3, 5, 11, 16, 32, 38
7, 11, 16, 35, 36, 44

수동으로 3장, 자동으로 11개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.(", "를 기준으로 6개 입력해주세요.)
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

## 구현할 기능 목록

> 구입 금액 입력

- [x] 구입 금액은 20억 이하여야 한다.(1000 ~ 20억)
- [x] 1000으로 나누어 떨어져야 한다.
- [x] 숫자여야 한다.

> 수동으로 구매할 로또 수 입력

- [x] 음수가 아닌 정수여야 한다.
- [x] 구입 금액으로 구매가능한 수여야 한다.

> 수동 로또 번호 입력, 지난 주 당첨 번호 입력

- [x] `, ` 로 입력값을 분리한다.
- [x] 분리한 배열의 크기는 6이어야 한다.
- [x] 각 문자열은 숫자여야 한다.
- [x] 각 숫자는 1~45여야 한다. (로또 번호의 조건)
- [x] 각 숫자는 중복을 허용하지 않는다. (로또 조건)

> 보너스 볼 입력

- [x] 지난주 당첨번호와 중복되면 안된다.
- [x] 숫자는 1~45여야 한다.
- [x] 숫자여야 한다.

> Object Graph

- [x] 로또 묶음(Lottos)
    - [x] 로또를 추가할 수 있다.
    - [x] 당첨 번호가 주어지면 순위 결과를 반환한다.
    - [x] 당첨 번호가 입력되면 각각의 로또 당첨 여부 확인
    - [x] 구매한 가격의 총합을 알려준다.
- [x] 당첨 번호(LottoWinningNumber)
  - [x] 로또의 당첨 번호와 보너스 번호를 가진다.
  - [x] 보너스 번호는 당첨 번호에 없는 번호여야 한다.
  - [x] 로또가 주어지면 당첨 순위를 알려준다.
- [x] 로또(Lotto)
    - [x] 6개의 로또번호를 가진다.
    - [x] 중복된 로또번호가 있으면 안된다.
    - [x] 특정 숫자가 포함하는지 확인한다.
- [x] 로또 팩토리(LottoFactory)
  - [x] 랜덤한 중복되지 않은 6개의 번호를 가진 로또 생성
  - [x] 문자열이 주어지면 `, `로 구분한 6개의 번호로 로또 생성
- [x] 로또번호(Number)
    - [x] 1~45의 숫자를 가진다.
- [x] 로또번호 팩토리(Number)
  - [x] 문자열 타입의 숫자가 주어지면 로또번호 생성
- [x] 구입 금액(Money)
    - [x] 1000원 단위의 숫자를 가진다.
    - [x] 1000 ~ 20억 사이여야 한다.
    - [x] 입력한 수 만큼 로또를 살 수 있는지 확인하고 돈을 차감한다.
    - [x] 남은 돈으로 살 수 있는 로또 개수를 반환한다.
- [x] 개수(Count)
  - [x] 0 이상의 값을 가진다.
  - [x] 개수끼리 빼기 연산을 할 수 있다.
- [x] 당첨 순위 (LottoRanking)
    - [x] 1등 ~ 5등의 금액을 가진다.
    - [x] 당첨 로또와 로또가 주어지면 순위를 알려준다.
- [x] 결과(Result)
    - [x] 당첨 결과를 당첨 순위, 개수로 저장한다.
    - [x] 수익률을 계산한다.

## 페어 프로그래밍 컨벤션

- 10분 간격으로 역할을 바꾼다.
- BDD 테스트 코드 작성 패턴으로 작성한다.
- 테스트만 통과할 수 있을 정도로 TDD를 구현한다.
- 커밋 단위를 README 기준으로 한다.
