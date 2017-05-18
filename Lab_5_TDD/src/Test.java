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
	public void gameTest() throws Exception {
		//Create gameObject
		Game game = new Game();
		
		//throw 20 bowling balls
		for(int i = 0; i < 20; i++) {
			game.bowlingThrow((int)Math.random()*10);
		}
		
		//does the game consist of 10 frames?
		assertEquals(game.getNrOfFrames(), 10);	
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
	
	@org.junit.Test
	public void testTwoStrikesInARow(){
		Game game = new Game();
		game.bowlingThrow(10);
		game.bowlingThrow(10);
		game.bowlingThrow(7); game.bowlingThrow(2);
		game.bowlingThrow(3); game.bowlingThrow(6);
		game.bowlingThrow(4); game.bowlingThrow(4);
		game.bowlingThrow(5); game.bowlingThrow(3);
		game.bowlingThrow(3); game.bowlingThrow(3);
		game.bowlingThrow(4); game.bowlingThrow(5);
		game.bowlingThrow(8); game.bowlingThrow(1);
		game.bowlingThrow(2); game.bowlingThrow(6);
		
		assertEquals(112,game.getSumOfGame());
	}
	
	@org.junit.Test
	public void testStrikeAsLastFrame(){
		Game game = new Game();
		
		game.bowlingThrow(1); game.bowlingThrow(5);
		game.bowlingThrow(3); game.bowlingThrow(6);
		game.bowlingThrow(7); game.bowlingThrow(2);
		game.bowlingThrow(3); game.bowlingThrow(6);
		game.bowlingThrow(4); game.bowlingThrow(4);
		game.bowlingThrow(5); game.bowlingThrow(3);
		game.bowlingThrow(3); game.bowlingThrow(3);
		game.bowlingThrow(4); game.bowlingThrow(5);
		game.bowlingThrow(8); game.bowlingThrow(1);
		game.bowlingThrow(10);
		try {
			game.bonusThrow(7); game.bonusThrow(2);
		} catch (BowlingException e) {
			
		}
		
		assertEquals(92,game.getSumOfGame());
	}
	
	@org.junit.Test
	public void testTwoSparesInARow(){
		Game game = new Game();
		game.bowlingThrow(8); game.bowlingThrow(2);
		game.bowlingThrow(5); game.bowlingThrow(5);
		game.bowlingThrow(7); game.bowlingThrow(2);
		game.bowlingThrow(3); game.bowlingThrow(6);
		game.bowlingThrow(4); game.bowlingThrow(4);
		game.bowlingThrow(5); game.bowlingThrow(3);
		game.bowlingThrow(3); game.bowlingThrow(3);
		game.bowlingThrow(4); game.bowlingThrow(5);
		game.bowlingThrow(8); game.bowlingThrow(1);
		game.bowlingThrow(2); game.bowlingThrow(6);
		
		assertEquals(98,game.getSumOfGame());
	}
	
	@org.junit.Test
	public void spareTest(){
		Game game = new Game();
		game.bowlingThrow(1); game.bowlingThrow(9);
		game.bowlingThrow(3); game.bowlingThrow(6);
		game.bowlingThrow(7); game.bowlingThrow(2);
		game.bowlingThrow(3); game.bowlingThrow(6);
		game.bowlingThrow(4); game.bowlingThrow(4);
		game.bowlingThrow(5); game.bowlingThrow(3);
		game.bowlingThrow(3); game.bowlingThrow(3);
		game.bowlingThrow(4); game.bowlingThrow(5);
		game.bowlingThrow(8); game.bowlingThrow(1);
		game.bowlingThrow(2); game.bowlingThrow(6);
		
		assertEquals(88,game.getSumOfGame());
	}
	
	@org.junit.Test
	public void testSpareFollowedByStrike(){
		Game game = new Game();
		game.bowlingThrow(10);
		game.bowlingThrow(4); game.bowlingThrow(6);
		game.bowlingThrow(7); game.bowlingThrow(2);
		game.bowlingThrow(3); game.bowlingThrow(6);
		game.bowlingThrow(4); game.bowlingThrow(4);
		game.bowlingThrow(5); game.bowlingThrow(3);
		game.bowlingThrow(3); game.bowlingThrow(3);
		game.bowlingThrow(4); game.bowlingThrow(5);
		game.bowlingThrow(8); game.bowlingThrow(1);
		game.bowlingThrow(2); game.bowlingThrow(6);
		
		assertEquals(103,game.getSumOfGame());
	}
	
	@org.junit.Test
	public void testSpareAsLastFrame(){
		Game game = new Game();
		game.bowlingThrow(1); game.bowlingThrow(5);
		game.bowlingThrow(3); game.bowlingThrow(6);
		game.bowlingThrow(7); game.bowlingThrow(2);
		game.bowlingThrow(3); game.bowlingThrow(6);
		game.bowlingThrow(4); game.bowlingThrow(4);
		game.bowlingThrow(5); game.bowlingThrow(3);
		game.bowlingThrow(3); game.bowlingThrow(3);
		game.bowlingThrow(4); game.bowlingThrow(5);
		game.bowlingThrow(8); game.bowlingThrow(1);
		game.bowlingThrow(2); game.bowlingThrow(8);
		try {
			game.bonusThrow(7);
		} catch (BowlingException e) {
			
		}
		
		assertEquals(90,game.getSumOfGame());
	}
	
	@org.junit.Test
	public void testBonusThrowIsAStrike(){
		Game game = new Game();
		game.bowlingThrow(1); game.bowlingThrow(5);
		game.bowlingThrow(3); game.bowlingThrow(6);
		game.bowlingThrow(7); game.bowlingThrow(2);
		game.bowlingThrow(3); game.bowlingThrow(6);
		game.bowlingThrow(4); game.bowlingThrow(4);
		game.bowlingThrow(5); game.bowlingThrow(3);
		game.bowlingThrow(3); game.bowlingThrow(3);
		game.bowlingThrow(4); game.bowlingThrow(5);
		game.bowlingThrow(8); game.bowlingThrow(1);
		game.bowlingThrow(2); game.bowlingThrow(8);
		try {
			game.bonusThrow(10);
			//attempt to throw twice more
			game.bonusThrow(5); game.bonusThrow(3);
		} catch (BowlingException e) {
			
		}
		
		assertEquals(93,game.getSumOfGame());
	}
	
	@org.junit.Test
	public void testPerfectGame(){
		Game game = new Game();
		game.bowlingThrow(10);
		game.bowlingThrow(10);
		game.bowlingThrow(10);
		game.bowlingThrow(10);
		game.bowlingThrow(10);
		game.bowlingThrow(10);
		game.bowlingThrow(10);
		game.bowlingThrow(10);
		game.bowlingThrow(10);
		game.bowlingThrow(10);
		try {
			game.bonusThrow(10);
			game.bonusThrow(10);
			//attempt to throw twice more
			game.bonusThrow(5); 
			game.bonusThrow(3);
		} catch (BowlingException e) {
			
		}
		
		assertEquals(300,game.getSumOfGame());
	}
	
	@org.junit.Test
	public void attemptIllegalBonusThrow(){
		Game game = new Game();
		game.bowlingThrow(1); game.bowlingThrow(5);
		game.bowlingThrow(3); game.bowlingThrow(6);
		game.bowlingThrow(7); game.bowlingThrow(2);
		game.bowlingThrow(3); game.bowlingThrow(6);
		game.bowlingThrow(4); game.bowlingThrow(4);
		game.bowlingThrow(5); game.bowlingThrow(3);
		game.bowlingThrow(3); game.bowlingThrow(3);
		game.bowlingThrow(4); game.bowlingThrow(5);
		game.bowlingThrow(8); game.bowlingThrow(1);
		game.bowlingThrow(2); game.bowlingThrow(7);
		try {
			game.bonusThrow(7);
		} catch (BowlingException e) {
			
		}
		
		assertEquals(82,game.getSumOfGame());
	}
}