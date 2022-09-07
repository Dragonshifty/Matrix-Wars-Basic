import java.util.Random;
import javax.swing.JOptionPane;
public class Battler {
	public static int[][] matrix = new int[4][4];		
	public static int[][] compMatrix = new int[4][4];
		
	public void setBattler(){
		
		Random random = new Random();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = random.nextInt(10);				
			}
		}
		
		for (int i = 0; i < compMatrix.length; i++) {
			for (int j = 0; j < compMatrix[i].length; j++) {
				compMatrix[i][j] = random.nextInt(10);				
			}
		}				
	}
	
	public void getMatrix() {
		System.out.println("Your Matrix:");
		
		int count = 0;
		
		while (count < 4) {		
		for (int i : matrix[count]) {
			System.out.print(i + " ");
		}
		System.out.println();
		count++;
		}
	}
	
	public void getComputerMatrix() {
		System.out.println("Computer's Matrix:");
		
		int count = 0;
		while (count < 4) {
		
		for (int i : compMatrix[count]) {
			System.out.print(i + " ");
		}
		System.out.println();
		count++;
		}
	}
	
	public static void main(String[] args) {
		int shots = 0;
		int hits = 0;
		int score = 0;
		boolean running = true;				
		
		Battler battler = new Battler();
		
		battler.setBattler();
		
//		battler.getMatrix();
//		System.out.println();
		
		System.out.println("Welcome to Matrix-Wars. Lowest total score wins.");
		System.out.println("Enter coordinates 1 to 4, starting from top left.");
		System.out.println("Your matrix is hidden - score higher to get a hit.");
		System.out.println("Both matrix coordinates added to together (a miss incurs 10pt penalty).");
		System.out.println("Good luck!");
		System.out.println();
		
		battler.getComputerMatrix();
		System.out.println();
		
		while (running) {
			
			try {
				String coordOne = JOptionPane.showInputDialog(null, "Enter Y Coord: ", "Battle Matrix", 3);
				String coordTwo = JOptionPane.showInputDialog(null, "Enter X coord:", "Battle Matrix", 3);
								
				if (coordOne == null || coordTwo.toLowerCase() == null) {
					System.out.println("Exiting");
					running = false;
				}
				
				int realCoordOne = Integer.parseInt(coordOne) -1;
				int realCoordTwo = Integer.parseInt(coordTwo) -1;
								
			
				if (matrix[realCoordOne][realCoordTwo] > compMatrix[realCoordOne][realCoordTwo]) {
					hits++;
					JOptionPane.showMessageDialog(null, "Hit! Hits: " + hits);
					
					score += matrix[realCoordOne][realCoordTwo] + compMatrix[realCoordOne][realCoordTwo];
					
					compMatrix[realCoordOne][realCoordTwo] = 9;
					
					battler.getComputerMatrix();
					if (hits == 3) {
						JOptionPane.showMessageDialog(null, "You win!");
						running = false;
					}
						
				} else if (matrix[realCoordOne][realCoordTwo] <= compMatrix[realCoordOne][realCoordTwo]) {
					shots++;
					JOptionPane.showMessageDialog(null, "Miss! Shots fired: " + shots);
					
					score += matrix[realCoordOne][realCoordTwo] + compMatrix[realCoordOne][realCoordTwo];
					score += 10;
					
					battler.getComputerMatrix();
					
					if (shots == 3) {
						JOptionPane.showMessageDialog(null, "You Lose!");
						running = false;
					}
				} 
			} catch (Exception e) {
				System.out.println("Invalid Input");
			} finally {
				System.out.println();
				System.out.println("Your score is " + score);
				System.out.println("Hits = " + hits + " | Missed = " + shots);
				System.out.println();
			}
		}
	}							
}

