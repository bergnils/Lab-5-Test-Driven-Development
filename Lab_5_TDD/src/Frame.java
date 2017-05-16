
public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	Frame(){
		firstThrow = 0;
		secondThrow = 0;
	}
	
	public int getSum(){
		return (firstThrow + secondThrow);
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public void setFirstThrow(int firstThrow) {
		this.firstThrow = firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	public void setSecondThrow(int secondThrow) {
		this.secondThrow = secondThrow;
	}
}
