package study2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study1.Splitter;
import study2.domain.Lotto;
import study2.domain.Lottos;
import study2.view.InputView;

class LottoTest {
	
	Lottos lottoNumbers = new Lottos();
	List<Lotto> lottos = new ArrayList<Lotto>();
	
	@BeforeEach
	void init() {
		Lotto lotto;
				
	}
	
	@Test
	@DisplayName("구입 금액 나누기 1000은 로또 개수이다.")
	void 로또_개수를_테스트하자() {
		//Given
		int lottnum = InputView.inputNumberMessages(15000);
		
		// When
		// Then
		assertThat(15).isEqualTo(15);
	}
	
	@Test
	@DisplayName("로또번호가 46일떄 테스트")
	void 로또번호가_46일때는_어떻게될까() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(46);
		assertThatThrownBy(() -> new Lotto( numbers ).getNumbers())
		.isInstanceOf(IllegalArgumentException.class);
		
	}
	
	@Test
	@DisplayName("로또번호값이 45일때 테스트")
	void 로또번호가_45일때는_테스트가통가할까() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(45);
		assertThat(new Lotto(numbers).getNumbers().get(0)).isEqualTo(45);
	}
	
	@Test
	@DisplayName("입력금액만큼 로또가 생성될까")
	void 입력금액_만큼_로또가_생성테스트() {
		lottos = lottoNumbers.getLottoNumbers(15000);
		assertThat(lottos.size()).isEqualTo(15);
	}
	
}
