package Databases;

import java.util.ArrayList;

import RecipeClasses.*;

public class CraftingRecipeDatabase {
	
	private ArrayList<RecipeClass> alch_recipes;
	
	public CraftingRecipeDatabase(){
		alch_recipes = new ArrayList<RecipeClass>();
	}
	
	
	public void addRecipe(int prof_code, RecipeClass recipe){
		switch(prof_code){
		case 1111:
			alch_recipes.add(recipe);
			//System.out.println("Alchemy Recipe Added!");
			//recipe.printRecipe();
			break;
		default:
			break;
			
		}
	}
	
	public void displayRecipe(int index){
		alch_recipes.get(index).printRecipe();
	}
	
	
	
	public String[] packAllRecipes(){
		
		int total_count = alch_recipes.size(); //TODO: add all sizes
		
		String[] output_arr = new String[total_count];
		
		//TODO: repeat for all professions
		for (int i = 0; i < alch_recipes.size(); i++){
			output_arr[i] = alch_recipes.get(i).printRecipe();
		}
		
		return output_arr;
	}
	


}
