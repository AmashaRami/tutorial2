import java.util.ArrayList;
import java.util.List;




public class SharedData 
{
	
	private List<Integer> list = new ArrayList<>();
	private boolean [] winArray;
	private boolean flag;
	private final int b;
	
	/**
	 * @param list  List that contains the numbers that the user entered
	 * @param b     The number that the user entered to check if there are group of numbers in list that the sum of them = b
	 */
	public SharedData(List<Integer> list, int b) {
		this.list = list;
		this.b = b;
	}

	/**
	 * @return return the places of the elements that  included in the solution
	 */
	public boolean[] getWinArray() 
	{
		return winArray;
	}

	/**
	 * @param winArray Set the winArray with one to the elements that we are taking in the solution
	 */
	public void setWinArray(boolean [] winArray) 
	{
		this.winArray = winArray;
	}

	/**
	 * @return list
	 */
	public List<Integer> getArray() 
	{
		return list;
	}

	/**
	 * @return the variable b 
	 */
	public int getB() 
	{
		return b;
	}

	/**
	 * @return the flag, which indicates if one of the threads has finished
	 */
	public boolean getFlag() 
	{
		return flag;
	}

	/**
	 * @param flag, this function sets  the flag
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
