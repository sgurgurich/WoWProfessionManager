package RecipeClasses;

public class RecipeClass {

	private String name;
	private MaterialClass mat1;
	private MaterialClass mat2;
	private MaterialClass mat3;
	private MaterialClass mat4;
	private MaterialClass mat5;
	private int qtMat1;
	private int qtMat2;
	private int qtMat3;
	private int qtMat4;
	private int qtMat5;
	
	
	private double sell;

	public RecipeClass(String name, 
			MaterialClass mat1,
			MaterialClass mat2,
			MaterialClass mat3,
			MaterialClass mat4,
			MaterialClass mat5,
			int qtMat1,
			int qtMat2,
			int qtMat3,
			int qtMat4,
			int qtMat5,
			double sell){
		
		this.name = name;
		this.mat1 = mat1;
		this.mat2 = mat2;
		this.mat3 = mat3;
		this.mat4 = mat4;
		this.mat5 = mat5;
		
		this.qtMat1 = qtMat1;
		this.qtMat2 = qtMat2;
		this.qtMat3 = qtMat3;
		this.qtMat4 = qtMat4;
		this.qtMat5 = qtMat5;
		
		this.sell = sell;

	}
	
	public String printRecipe(){
		
		String output = this.name + "   ";
		
		System.out.print(this.name + "   ");
		
		if (this.qtMat1 > 0){
			output = output + this.qtMat1 + "   " + this.mat1.getName() + "   ";
			System.out.print(this.qtMat1 + "   " + this.mat1.getName() + "   ");
		}
		
		if (this.qtMat2 > 0){
			output = output + this.qtMat2 + "   " + this.mat2.getName() + "   ";
			System.out.print(this.qtMat2 + "   " + this.mat2.getName() + "   ");
		}
		
		if (this.qtMat3 > 0){
			output = output + this.qtMat3 + "   " + this.mat3.getName() + "   ";
			System.out.print(this.qtMat3 + "   " + this.mat3.getName() + "   ");
		}
		
		if (this.qtMat4 > 0){
			output = output + this.qtMat4 + "   " + this.mat4.getName() + "   ";
			System.out.print(this.qtMat4 + "   " + this.mat4.getName() + "   ");
		}
		
		if (this.qtMat5 > 0){
			output = output + this.qtMat5 + "   " + this.mat5.getName() + "   ";
			System.out.print(this.qtMat5 + "   " + this.mat5.getName() + "   ");
		}
		
		System.out.println("");
		
		
		return output;
		
	}

	public int getQtMat1() {
		return qtMat1;
	}

	public void setQtMat1(int qtMat1) {
		this.qtMat1 = qtMat1;
	}

	public int getQtMat2() {
		return qtMat2;
	}

	public void setQtMat2(int qtMat2) {
		this.qtMat2 = qtMat2;
	}

	public int getQtMat3() {
		return qtMat3;
	}

	public void setQtMat3(int qtMat3) {
		this.qtMat3 = qtMat3;
	}

	public int getQtMat4() {
		return qtMat4;
	}

	public void setQtMat4(int qtMat4) {
		this.qtMat4 = qtMat4;
	}

	public int getQtMat5() {
		return qtMat5;
	}

	public void setQtMat5(int qtMat5) {
		this.qtMat5 = qtMat5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MaterialClass getMat1() {
		return mat1;
	}

	public void setMat1(MaterialClass mat1) {
		this.mat1 = mat1;
	}

	public MaterialClass getMat2() {
		return mat2;
	}

	public void setMat2(MaterialClass mat2) {
		this.mat2 = mat2;
	}

	public MaterialClass getMat3() {
		return mat3;
	}

	public void setMat3(MaterialClass mat3) {
		this.mat3 = mat3;
	}

	public MaterialClass getMat4() {
		return mat4;
	}

	public void setMat4(MaterialClass mat4) {
		this.mat4 = mat4;
	}

	public MaterialClass getMat5() {
		return mat5;
	}

	public void setMat5(MaterialClass mat5) {
		this.mat5 = mat5;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(int sell) {
		this.sell = sell;
	}

}
