package study2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study2.domain.Lotto;
import study2.domain.LottoNumbers;
import study2.domain.Ranking;
import study2.domain.Ranking.Rank;

class RankTest {

	Ranking ranking;
	List<Integer> lottolist = Arrays.asList(25, 1, 2, 3, 7, 6);
	int count = 0;

	@BeforeEach
	void init() {
		ranking = new Ranking();
	}

	@Test
	@DisplayName("3개 일치하면 5000원입니다.")
	void 세개가_일치하는_경우() {

		String[] winNumber = { "1", "2", "3", "4", "5" };
		int[] nums = Arrays.stream(winNumber)
				.mapToInt(Integer::parseInt).toArray();

		// 테스트 코드에서도 indent를 1로 맞춰야 될까요?
		for (int i = 0; i < winNumber.length; i++) {
			if (lottolist.contains(nums[i])) {
				count++;
			}
		}

		assertThat(count).isEqualTo(Rank.THREEMATCH.getCountOfMatch());
	}

}
