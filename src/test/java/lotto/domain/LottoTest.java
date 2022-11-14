package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static lotto.dto.LottoResponseDtos.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("한개의 로또를 오름차순으로 정렬하는 기능")
    @CsvSource(value = {"0,4", "1,7", "2,9", "3,10", "4,12", "5,14"})
    @ParameterizedTest
     void sortLottoNumber(int index, int answer) {
        List<Integer> numbers = new ArrayList<>(List.of(7, 4, 9, 10, 14, 12));
        Lotto lotto = new Lotto(numbers);

        LottoResponseDto responseDto = lotto.toResponseDto();
        List<Integer> sortNumbers = responseDto.getLottoNumber();

        assertThat(sortNumbers.get(index)).isEqualTo(answer);
    }

    @DisplayName("두개의 로또에서 겹치는 숫자 찾기")
    @Test
    void countContainsNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertThat(lotto.countContainsNumber(otherLotto)).isEqualTo(3);
    }

    @DisplayName("한개의 로또에서 주어진 숫자를 포함하고 있는지 여부")
    @Test
    void isContains() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isContains(1)).isTrue();
        assertThat(lotto.isContains(7)).isFalse();
    }
}
