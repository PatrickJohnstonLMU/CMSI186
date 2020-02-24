public class DogPack{
	//private instance data
	private int count;
	private  String name;
	private int age;
	private String gender;
	private double weight;
	private String breed;
	private String color;
	private Dog[] dp = null;



	//constructor
	public DogPack (int pCount,String pName, int pAge, String pGender, double pWeight, String pBreed, String pColor){
		this.dp = new Dog[pCount];
		for (int i = 0; i < pCount; i++){
			dp[i] = new Dog("Tinker", 1, "female", 12.2, "shiba","Chocolate & tan");
		}

	}
	public String toString(){
		String result = "";
		for (int i = 0; i < dp.length; i++){
			result += dp[i].toString();

		}
	}
}