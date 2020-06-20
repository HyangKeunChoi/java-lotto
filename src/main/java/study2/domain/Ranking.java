package study2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Ranking {

	public enum Rank {
		SIXMATCH(6, 2_000_000_000), FIVEMATCH(5, 15_000_000), FOURMATCH(4, 50_000), THREEMATCH(3, 5_000), MISS(0, 0);

		int countOfMatch;
		int winningMoney;

		private Rank(int countOfMatch, int winningMoney) {
			this.countOfMatch = countOfMatch;
			this.winningMoney = winningMoney;
		}

		public int getCountOfMatch() {
			return countOfMatch;
		}

		public int getWinningMoney() {
			return winningMoney;
		}

	}
		
	public static List<Integer> winNumSplit(String inputWinNumber) {
		if (inputWinNumber.equals("") || inputWinNumber == null) {
			throw new IllegalArgumentException("공백이나 null은 안됩니다.");
		}

		return 	Arrays.asList(inputWinNumber.replace(" ", "")
				.split(","))				
				.stream()
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toList());				
	}

	public Map<Rank, Integer> matchNumber(List<Lotto> lottos, List<Integer> winningLotto) {
		Map<Rank, Integer> rankRepository = new HashMap<>();

		lottos.forEach(lotto -> {
			Rank rank = lotto.getRankWithWinningLotto(winningLotto);
			
			// 피드백 적용완료하였습니다.
			rankRepository.put(rank, rankRepository
					.getOrDefault(rank, 0) +1);			
		});
		
		return rankRepository;
	}

	public static Rank getRanking(int matchedNumber) {
		return Arrays.stream(Rank.values())
				.filter(rank -> rank.getCountOfMatch()== matchedNumber)
				.findFirst()
				.orElse(Rank.MISS);
	}	
}