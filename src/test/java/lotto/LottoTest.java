package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 1등 결과를 반환하는 기능")
    @Test
    void calculateAnswerFirst() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        GameResult gameResult = answer.play(lotto);
        assertThat(gameResult.isFirst()).isTrue();
    }

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 2등 결과를 반환하는 기능")
    @Test
    void calculateAnswerSecond() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        GameResult gameResult = answer.play(lotto);
        assertThat(gameResult.isSecond()).isTrue();
    }

}
