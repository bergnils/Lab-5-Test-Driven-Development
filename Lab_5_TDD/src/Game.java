import java.util.Vector;

public class Game {
	private Vector<Frame> frames;
	private int currentFrame;
	private int throwCounter;
	private int score;
	private boolean previousWasStrike;
	private boolean doubleStrike;
	private boolean previousWasSpare;
	private boolean bonusThrowAllowed;

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
		previousWasSpare = false;
		bonusThrowAllowed = false;
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
				if(previousWasSpare){
					this.score += score;
					previousWasSpare = false;
				}
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
			
			if(frames.get(currentFrame).getSum() == 10){
				previousWasSpare = true;
			}
			
			if(previousWasSpare && this.currentFrame == 9){
				bonusThrowAllowed = true;
			}
			currentFrame++;
		}
	}
	
	public void bonusThrow(int score) throws BowlingException{
		if(bonusThrowAllowed){
			this.score += score;
		} else{
			throw new BowlingException("Not allowed to perform bonus throw");
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
