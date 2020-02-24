public class Dog {
	//What are some attributes for a dog?
	private  String name;
	private int age;
	private String gender;
	private double weight;
	private String breed;
	private String color;
	private boolean isAsleep = false; 
	// why is it private? so no other class can access it
	//and cant get attriubtes without help from this program

	//constructor to create a dog
	// This creates a new instance of a dog
	//public so any program can create a dog
	public Dog(String pName, int pAge, String pGender, double pWeight, String pBreed, String pColor){
		this.name = pName;
		this.age = pAge;
		this.gender = pGender;
		this.weight = pWeight;
		this.breed = pBreed;
		this.color = pColor;

	}
	public String toString() {
		return this.name +  this.color + this.breed +  this.age +this.age;
	}
	public String getName(){
		return this.name;
	}
	public String setName(String newName){
		return this.name = newName;

	}
	public void sleep() {
	this.isAsleep = !this.isAsleep;

	}
	public String isAsleep(){
		if(this.isAsleep){
			return "Dog is asleep";

		} else {
			return "dog is awake";
		}
	}
	public static String randomBreed(){
		String[] breeds = {
			"Daschund",
			"Retriever",
			"Labrador",
			"Cocker Spaniel",
			"Beagle"
		};
		int randNum = (int)Math.floor(Math.random()* breeds.length);
		return breeds[randNum];
	}

	public static void main(String[] args){
		Dog d1 = new Dog("Tinker", 1, "female", 12.2, "shiba","Chocolate & tan");
		System.out.println("Got to here");
		System.out.println(d1.toString());
		Dog d2 = new Dog("Spot",5, "male", 45, "labrador","black");
		System.out.println("Dog d2: "+ d2.toString());
		System.out.println();
		System.out.println("Dogs d1 name: " + d1.name);

	}

}	