package edu.ciit.iot.serial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Subject {
	private List<SerialComListener> clientList = new ArrayList<>();
	
	public void resgisterObsever(SerialComListener listener) {
		clientList.add(listener);
		
		
	}
	
	public void unresgisterObsever(SerialComListener listener) {
		if((clientList != null) && (clientList.contains(listener))) {
			clientList.remove(listener);
		}
	}
	
	public void notifyObseverUpdate(Message message) {
		for(SerialComListener listener:clientList) {
			listener.update(message);
		}
		System.out.println(message);
	}

}
