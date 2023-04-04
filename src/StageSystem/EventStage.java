package StageSystem;

import java.util.ArrayList;
import java.util.Scanner;

import Events.Event;

public class EventStage extends Stage{
	public Event event;
	public void Use()
	{
		event.Use();
		
		if (event.end == true)
		{
			NextStage();
		}
		
	}
	
	
}
