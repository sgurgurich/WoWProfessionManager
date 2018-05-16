package Databases;

import java.util.ArrayList;

import RecipeClasses.MaterialClass;

public class MaterialsDatabase {
	private ArrayList<MaterialClass> alch_mats;
	
	public MaterialsDatabase(){
		alch_mats = new ArrayList<MaterialClass>();
	}
	

	public void addMaterial(int prof_code, MaterialClass material){
		
		System.out.println(prof_code);
		switch(prof_code){
		case 1111:
			alch_mats.add(material);
			//System.out.println("Alchemy Recipe Added!");
			//recipe.printRecipe();
			break;
		default:
			break;
			
		}
	}
	
	public String[] packAllMaterials(){
		
		int total_count = alch_mats.size(); //TODO: add all sizes
		
		String[] output_arr = new String[total_count];
		
		//TODO: repeat for all professions
		for (int i = 0; i < alch_mats.size(); i++){
			output_arr[i] = alch_mats.get(i).printMaterial();
		}
		
		
		
		return output_arr;
	}
	
	
	
}
