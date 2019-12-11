package com.mercury.java_core.generics;

import java.util.List;
public class Room<T>{
			// T is generics
	T something;
	
	public static void main(String[] args) {
		// create a Room which can have Chair only
		Room<Chair> roomWithChair = new Room<>();
		roomWithChair.something = new Chair();
		
		Room<Desk> roomWithDesk = new Room<>();
		roomWithDesk.something = new Desk();
		
		// Chair is sub type of Object
		// But Room<Chair> is not a sub type of Room<Object>
		// wildcard: ?
		print(roomWithChair);
		print(roomWithDesk);
		
		Room<GamingChair> roomWithGamingChair = new Room<>();
		
		// upper bounded wildcard
		printRoomWithChairs(roomWithChair);
		printRoomWithChairs(roomWithGamingChair);
		
		// lower bounded wildcard
		Room<Object> roomWithObject = new Room<>();
		Room<Furniture> roomWithFurniture = new Room<>();
		printRoomOtherThanGamingChair(roomWithObject);
		printRoomOtherThanGamingChair(roomWithFurniture);
		printRoomOtherThanGamingChair(roomWithChair);
//		printRoomOtherThanGamingChair(roomWithGamingChair);
		
	}
	
	// print a room 
	public static void print(Room<?> room){
		
	}
	
	// print a room which has Chair or GamingChair
	public static void printRoomWithChairs(Room<? extends Chair> room){
		Chair something = room.something;
	}
	
	// print a Room which has Chair, Furniture, Object(other than GamingChair)
	public static void printRoomOtherThanGamingChair(Room<? super Chair> room){
		Object something = room.something;
	}		
	
}




