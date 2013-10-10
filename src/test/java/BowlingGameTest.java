import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author JeongInn
 */
public class BowlingGameTest {
	private Game game;

	@Before
	public void setUp() {
		game = new Game();
	}
	
	@Test
	public void should_return_0_when_gutter_game() throws Exception {
		rollMany(20, 0);
		assertEquals(0, game.score());
	}
	
	@Test
	public void should_return_20_when_all_ones() throws Exception {
		rollMany(20, 1);
		assertEquals(20, game.score());
	}
	
	@Test
	public void should_return_16_when_one_spare_and_3_points() throws Exception {
		rollSpare();
		game.roll(3);
		
		rollMany(17, 0);
		assertEquals(16, game.score());
	}

	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}
	
	@Test
	public void should_return_24_when_one_strike_and_3_and_4_points() throws Exception {
		rollStrike();
		game.roll(3);
		game.roll(4);
		
		rollMany(16, 0);
		
		assertEquals(24, game.score());
	}
	
	@Test
	public void should_return_300_when_perfect_game() throws Exception {
		rollMany(12, 10);
		assertEquals(300, game.score());
	}

	@Test
	public void should_return_30_when_two_strikes() throws Exception {
		rollStrike();
		rollStrike();
		rollMany(16, 0);
		assertEquals(30, game.score());
	}
	
	private void rollStrike() {
		game.roll(10);
	}
	
	private void rollMany(int nRolls, int pins) {
		for (int i = 0; i < nRolls; i++) {
			game.roll(pins);
		}
	}
}
