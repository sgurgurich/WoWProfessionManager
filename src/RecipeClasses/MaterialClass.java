package RecipeClasses;

public class MaterialClass {
	
	private String name;
	private double cost;
	private double sell;

	public MaterialClass(String name, double cost, double sell){
		this.name = name;
		this.cost = cost;
		this.sell = sell;
		
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(double sell) {
		this.sell = sell;
	} 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String printMaterial(){
		String output = this.name + "         " + this.cost + "            " + this.sell;
		System.out.println(output);
		return output;
	}
}
