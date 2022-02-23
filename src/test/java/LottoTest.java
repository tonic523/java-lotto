import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Nested
    @DisplayName("로또는")
    class NewLotto {

        @Nested
        @DisplayName("크기가 6이 아닌 숫자 리스트를 주면")
        class Context_with_not_six_length_list {

            @Test
            @DisplayName("예외를 발생시킨다.")
            void it_throw_exception() {
                assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("6개의 숫자가 필요합니다.");

                assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("6개의 숫자가 필요합니다.");
            }
        }

        @Nested
        @DisplayName("숫자 리스트가 중복이 있으면")
        class Context_with_duplicate {

            @Test
            @DisplayName("예외를 발생시킨다.")
            void it_throw_exception() {
                assertThatThrownBy(() -> new Lotto(List.of(1, 1, 3, 4, 5, 6)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복은 허용하지 않습니다.");
            }
        }
    }
    
    @Nested
    @DisplayName("어떤 번호가 포함되었는지 판단하는 메소드는")
    class Contains {

        @Nested
        @DisplayName("포함되는 번호가 주어지면")
        class Context_with_contains_number {

            @Test
            @DisplayName("true를 반환한다.")
            void it_returns_true() {
                Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                assertThat(lotto.contains(new Number("1"))).isTrue();
            }
        }

        @Nested
        @DisplayName("포함되지 않는 번호가 주어지면")
        class Context_with_not_contains_number {

            @Test
            @DisplayName("false를 반환한다.")
            void it_returns_true() {
                Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                assertThat(lotto.contains(new Number("7"))).isFalse();
            }
        }
    }
}
