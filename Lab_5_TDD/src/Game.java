import java.util.Vector;

public class Game {
	private Vector<Frame> frames;
	private int currentFrame;
	private int throwCounter;
	
	Game(){
		frames = new Vector<Frame>();
		for(int i = 0; i < 10; i++){
			frames.add(new Frame());
		}
		currentFrame = 0;
		throwCounter = 1;
	}
	
	public void bowlingThrow(int score){		
		if(throwCounter == 1){
			frames.get(currentFrame).setFirstThrow(score);
			
			throwCounter = 2;
		} else if(throwCounter == 2){
			frames.get(currentFrame).setSecondThrow(score);
			
			throwCounter = 1;
			currentFrame++;
		}
	}
	
	public int getSumOfSpecificFrame(int index){
		return frames.get(index).getSum();
	}
	
	public int getNrOfFrames(){
		return frames.size();
	}

	public int getSumOfGame(){
		int sumOfGame = 0;
		
		for(int i = 0; i < frames.size(); i++){
			sumOfGame+= frames.get(i).getSum();
		}
		
		return sumOfGame;
	}

}
