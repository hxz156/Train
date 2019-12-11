package com.mercury.java_core.oop;
public class User implements Cloneable, Comparable<User> {
	// "implements Cloneable" is Marker that this class could be cloned
	// And you have to Override the clone() method
	
	private String name;
	private int age;
	private Key key;
	
	public User(){
		
	}
	
	public User(String name, int age) {
		super();	// called the superclass constructor
		if (age < 0){	// if age < 0, then this User will not be created
			throw new IllegalArgumentException("Age must "
					+ "be non-negative !");
		}
		this.name = name;
		this.age = age;
	}

	public User(String name, int age, Key key) {
		super();
		this.name = name;
		this.age = age;
		this.key = key;
	}
	
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

	// In source code Object.class, Clone() method
	// native method is Java written by C++ which is fast
	@Override
	public User clone() throws CloneNotSupportedException{
		User clonedUser = (User) super.clone();
		if(key != null){
			Key k = key.clone();
			clonedUser.setKey(k);
		}
		return clonedUser;	// This is deep copy
	}
//		// super.clone() invoke object.class
//		// to. Then (User) down-casting
//		return (User)super.clone();	// this is shallow copy
	
	
	// override, the parameters type must be the same
	// and in Object.class, the equals .... So Object
	@Override
	public boolean equals(Object other){
		// return true if name and age are the same 
		// current user's name and age
		
		// If the class is no what we want
		if(!(other instanceof User)){
			return false;
		}
		User otherUser = (User)other;
		return this.name.equals(otherUser.name) 
				&& this.age == (otherUser.age);
	}
	
	@Override
	public int hashCode(){
		return name.hashCode() + age;
	}

	@Override
	public int compareTo(User o) {
		return name.compareTo(o.name);
	}
}








