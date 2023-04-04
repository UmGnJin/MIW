package Creatures;

public class Status {
	public String name;
	public int stack;
	public Status(String Name, int stacknum)
	{
		name = Name;
		stack = stacknum;
	}
	public Status GiveStatus()
	{
		Status stat = new Status(name, stack);
		return stat;
	}
}
