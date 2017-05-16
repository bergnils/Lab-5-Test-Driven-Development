import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void frameTest() throws Exception {
		//Create gameObject
		Game game = new Game();
		
		//throwing bowling balls
		game.bowlingThrow(4);
		game.bowlingThrow(5);
		
		//total value of the specific frame
		int frame = game.getSumOfSpecificFrame(0);
		
		//A single frame is not allowed to be greater or less than 10
		assertTrue(0 <= frame && frame <= 10);
		assertEquals(frame, 9);
	}
  
  @org.junit.Test
	public void frameScoreTest() throws Exception {
		//Create gameObject
		Game game = new Game();
		
		game.bowlingThrow(8);
		game.bowlingThrow(0);
		game.bowlingThrow(1);
		game.bowlingThrow(5);
		
		int firstFrame = game.getSumOfSpecificFrame(0);
		int secondFrame = game.getSumOfSpecificFrame(1);
		
		assertEquals(firstFrame, 8);
		assertEquals(secondFrame, 6);
	}
	
	@org.junit.Test
	public void testScoreOfGame(){
		Game game = new Game();
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		
		assertEquals(game.getSumOfGame(),70);
	}
	
	@org.junit.Test
	public void testStrike(){
		Game game = new Game();
		game.bowlingThrow(10);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		game.bowlingThrow(1); game.bowlingThrow(6);
		
		assertEquals(80,game.getSumOfGame());
	}

}
