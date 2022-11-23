package ControllerAL;
import ViewLayer.View;
import java.util.ArrayList;

import DataBaseLayer.DB;

public class Controller 
{
	DB db = new DB();
	
	public ArrayList<String> returnMeaning(String word)
	{
		return db.loadMeaning(word);
	}
	
}