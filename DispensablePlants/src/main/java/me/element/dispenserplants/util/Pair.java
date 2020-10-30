package me.element.dispenserplants.util;

public class Pair<T1, T2> {

	private T1 T1;
	private T2 T2;
	
	public Pair(T1 val1, T2 val2)
	{
		this.T1 = val1;
		this.T2 = val2;
	}
	
	public T1 getFirst()
	{
		return T1;
	}
	
	public T2 getSecond()
	{
		return T2;
	}
}
