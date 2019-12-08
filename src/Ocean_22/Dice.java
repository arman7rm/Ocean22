package Ocean_22;
import java.util.Random;

public class Dice {
	
	public int roll() {
		Random random = new Random();
		int number = random.nextInt(7);
		if (number==0){
			number=1;
		}
		return number;
	}

}
