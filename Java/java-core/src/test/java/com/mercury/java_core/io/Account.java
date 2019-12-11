package com.mercury.java_core.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Account implements Externalizable {
	//Enhancement of Serializable way, because of @Override, then will find type error
	
	String username = "admin";
	String password = "123456";
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(username);
		out.writeObject("abc" + password); 	
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		username = (String) in.readObject();
		password = (String) in.readObject();
		password = password.substring(3);
	}

}







