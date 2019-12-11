
public class Burger {
	int breads;
	int patties;
	boolean hasLettuce;
	
	
	// non-argument constructor
	Burger(){
		
	}
	
	// constructor with arguments
	Burger(int breads, int patties, boolean hasLettuce){
		this.breads = breads;
		this.patties = patties;
		this.hasLettuce = hasLettuce;
	}
	
	@Override
	// over write the toString method, we can directly print the object that what we want
	public String toString(){
		return "Breads: " + breads
				+ " Patties: " + patties
				+ " Lettuce: " + hasLettuce;
	}
	
	
}





