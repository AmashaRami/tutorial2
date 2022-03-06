import java.util.List;



public class ThreadCheckArray implements Runnable 
{
	private boolean flag1;
	private boolean [] winArray;
	SharedData sd;
	int[] array;
	List<Integer> list;
	int b;
	
	public ThreadCheckArray(SharedData sd) 
	{
		this.sd = sd;	
		synchronized (sd) 
		{
			list = sd.getArray();
			b = sd.getB();
		}		
		
		winArray = new boolean[list.size()];
	}
	
	void rec(int n, int b)
	{
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		if (n == 1)
		{
			if(b == 0 || b == list.get(n-1))
			{
				flag1 = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}			
			}
			if (b == list.get(n-1))
				winArray[n-1] = true;
			return;
		}
		
		rec(n-1, b - list.get(n-1));
		if (flag1)
			winArray[n-1] = true;
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		rec(n-1, b);
	}

	public void run() {
		if (list.size() != 1)
			if (Thread.currentThread().getName().equals("thread1"))
				rec(list.size()-1, b - list.get(list.size()-1));
			else 
				rec(list.size()-1, b);
		if (list.size() == 1)
			if (b == list.get(0) && !flag1)
			{
				winArray[0] = true;
				flag1 = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}
			}
		if (flag1)
		{
			if (Thread.currentThread().getName().equals("thread1"))
				winArray[list.size() - 1] = true;
			synchronized (sd) 
			{
				sd.setWinArray(winArray);
			}	
		}
	}
}
