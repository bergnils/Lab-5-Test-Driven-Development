import java.util.Vector;

public class Game {
	private Vector<Frame> frames;
	private int currentFrame;
	private int throwCounter;
	private int score;
	boolean previousWasStrike;

	Game(){
		frames = new Vector<Frame>();
		for(int i = 0; i < 10; i++){
			frames.add(new Frame());
		}
		currentFrame = 0;
		throwCounter = 1;
		score = 0;
		previousWasStrike = false;
	}

	public void bowlingThrow(int score){
		if(throwCounter == 1){
			if(score == 10){
				frames.get(currentFrame).setFirstThrow(score);
				this.score += score;
				previousWasStrike = true;
				currentFrame++;
			} else{
				frames.get(currentFrame).setFirstThrow(score);
				this.score += score;
				throwCounter = 2;
			}
		} else if(throwCounter == 2){
			frames.get(currentFrame).setSecondThrow(score);

			throwCounter = 1;
			this.score += score;
			
			if(previousWasStrike){
				this.score += frames.get(currentFrame).getSum();
				previousWasStrike = false;
			}
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
		return score;
	}

}
