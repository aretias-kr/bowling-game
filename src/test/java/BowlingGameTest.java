import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
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
	
	@Ignore("Until we get design right")
	@Test
	public void should_return_16_when_one_spare_and_3_points() throws Exception {
		game.roll(5);
		game.roll(5);
		game.roll(3);
		
		rollMany(17, 0);
		assertEquals(16, game.score());
	}
	
	private void rollMany(int nRolls, int pins) {
		for (int i = 0; i < nRolls; i++) {
			game.roll(pins);
		}
	}
}
