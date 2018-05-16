package RecipeClasses;

public class MaterialClass {
	
	private String name;
	private int cost;
	private int sell;

	public MaterialClass(String name, int cost, int sell){
		this.name = name;
		this.cost = cost;
		this.sell = sell;
		
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getSell() {
		return sell;
	}

	public void setSell(int sell) {
		this.sell = sell;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String printMaterial(){
		String output = this.name + "     " + this.cost + "       " + this.sell;
		System.out.println(output);
		return output;
	}
}
