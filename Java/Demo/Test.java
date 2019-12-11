
class Test{

	public static void main(String[] args){
		System.out.println("Hello world !");

		try {
			int sum=0;
			for(String s : args) {
				System.out.println(s);
				sum += Integer.valueOf(s);
				// or: sum += Integer.parseInt(s);
			}
			System.out.println("Sum of all parameters is : " + sum);
		} catch (NumberFormatException e) {
			System.out.println("Your input parameters are not all numeric values!");
		}
		
	}

}