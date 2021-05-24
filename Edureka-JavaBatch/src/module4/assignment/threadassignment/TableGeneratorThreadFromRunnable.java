package module4.assignment.threadassignment;

public class TableGeneratorThreadFromRunnable implements Runnable {

	private int num;
	TableGeneratorThreadFromRunnable(int x){
		this.num = x;
	}
	@Override
		public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println( num + " * " + i + " = " + (num*i));
		}
	}
	
	
}
