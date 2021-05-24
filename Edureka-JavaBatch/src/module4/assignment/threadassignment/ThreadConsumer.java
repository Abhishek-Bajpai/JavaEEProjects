package module4.assignment.threadassignment;

public class ThreadConsumer {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		TableGeneratorThreadFromThread myThreadAssignment=new TableGeneratorThreadFromThread();
		myThreadAssignment.start();
		try {
			myThreadAssignment.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i=1, j=1;i<=40;i++) {
			if(i%2 ==0) {
				System.out.println(j + " Even Number - " + i);
				j++;
			}
		}
		
		TableGeneratorThreadFromRunnable tableGeneratorThread=new TableGeneratorThreadFromRunnable(10);
		Thread threadToGenerateTable =new Thread(tableGeneratorThread);
		threadToGenerateTable.start();
		}

}
