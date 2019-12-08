package Ocean_22;

import java.util.Scanner;

public class Game {
	
	static int largest(int arr[]) //Find Maximum value of an array
    { 
        int i; 
          
        // Initialize maximum element 
        int max = arr[0]; 
       
        // Traverse array elements from second and 
        // compare every element with current max   
        for (i = 1; i < arr.length; i++) 
            if (arr[i] > max) 
                max = arr[i]; 
       
        return max; 
    } 

	public static int ocean_22(int balance) { //game function 
		Dice first = new Dice();//Creates Dice variable
		int rollCount =0;
		int[] allBalances = new int[10000];//creates array of balances history

		while(balance>0) {//while user has money
			boolean money = true;
			while (money) { 
				int roll1 = first.roll();
				int roll2 = first.roll();
				if (roll1+roll2==7) {
					balance = balance +4;
					allBalances[rollCount]=balance;
					rollCount++;
				}
				else {
					balance = balance-1;
					if (balance<0) {
						money = false;
					}
					allBalances[rollCount] = balance;
					rollCount++;
				}
			}
		}
		int max = largest(allBalances);

		System.out.println("Your maximum balance was " + max); 
		
		for (int i=0; i<allBalances.length; i++) {
			int num = 0;
			if (num>0) {
				System.out.println(" or ");

			}
			if (allBalances[i]==max) {
				if (i==0) {
					System.out.println("You should have stopped playing on your first roll");
					break;
				}
				System.out.println("You should have stopped playing on your " + i + "th roll");
				num++;
			}
			
		}

		System.out.println("You have rolled " + rollCount + " times.");
		
		
	return rollCount;
}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How much money do you have to play? :");
	
		int bet = in.nextInt();
		in.close();
		ocean_22(bet);

	}
	
}
