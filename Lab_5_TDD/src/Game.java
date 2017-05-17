import java.util.Vector;

public class Game {
	private Vector<Frame> frames;
	private int currentFrame;
	private int throwCounter;
	private int score;
	boolean previousWasStrike;
	boolean doubleStrike;

	Game(){
		frames = new Vector<Frame>();
		for(int i = 0; i < 10; i++){
			frames.add(new Frame());
		}
		currentFrame = 0;
		throwCounter = 1;
		score = 0;
		previousWasStrike = false;
		doubleStrike = false;
	}

	public void bowlingThrow(int score){
		if(throwCounter == 1){
			if(score == 10){
				if(previousWasStrike){
					this.score += 10;
					doubleStrike = true;
				}
				frames.get(currentFrame).setFirstThrow(score);
				this.score += score;
				previousWasStrike = true;
				currentFrame++;
			} else{
				frames.get(currentFrame).setFirstThrow(score);
				this.score += score;

				if(doubleStrike){
					this.score += score;
					doubleStrike = false;
				}
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

	public int getSumOfGame(){
		return score;
	}

}
