/**
 * @author JeongInn
 */
public class Game {
	private int  rolls[] = new int[21];
	private int currentRoll = 0;
	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}
	public int score() {
		int score = 0;
		int rollIndex = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isStrike(rollIndex)) {
				score += 10 + strikeBonus(rollIndex);
				rollIndex += 1;
			} else if (isSpare(rollIndex)) {
				score += 10 + spareBonus(rollIndex);
				rollIndex += 2;
			} else {
				score += scoreInFrame(rollIndex);
				rollIndex += 2;
			}
		}
		return score;
	}
	private int strikeBonus(int rollIndex) {
		return rolls[rollIndex + 1] + rolls[rollIndex + 2];
	}
	private boolean isStrike(int rollIndex) {
		return rolls[rollIndex] == 10;
	}
	
	public int spareBonus(int rollIndex) {
		return rolls[rollIndex + 2];
	}
	private boolean isSpare(int rollIndex) {
		return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
	}
	
	public int scoreInFrame(int rollIndex) {
		return rolls[rollIndex] + rolls[rollIndex + 1];
	}
}
