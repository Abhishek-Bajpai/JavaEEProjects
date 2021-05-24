package module4.assignment.interfaceassignment;

public class MyQueueClass implements MyQueueInterface{

	int valueArray[] = new int[5];
	int front = 0;
	int rear = 0;
	
	@Override
	public void insert(int value) {
		valueArray[rear++] = value;		 
		
	}

	@Override
	public int delete() {
		
		return valueArray[front++];
		 
	}
	
	public void display()
	{
		for (int i = front; i < rear; ++i)
			System.out.println(valueArray[i]);
		
	}
	
}
