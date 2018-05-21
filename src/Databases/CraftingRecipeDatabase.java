package Databases;

import java.util.ArrayList;

import RecipeClasses.*;

public class CraftingRecipeDatabase {
	
	private ArrayList<RecipeClass> alch_recipes;
	private ArrayList<RecipeClass> blacksmith_recipes;
	private ArrayList<RecipeClass> enchant_recipes;
	private ArrayList<RecipeClass> engineer_recipes;
	private ArrayList<RecipeClass> inscription_recipes;
	private ArrayList<RecipeClass> jewel_recipes;
	private ArrayList<RecipeClass> leather_recipes;
	private ArrayList<RecipeClass> tailor_recipes;
	
	public CraftingRecipeDatabase(){
		alch_recipes        = new ArrayList<RecipeClass>();
		blacksmith_recipes  = new ArrayList<RecipeClass>();
		enchant_recipes     = new ArrayList<RecipeClass>();
		engineer_recipes    = new ArrayList<RecipeClass>();
		inscription_recipes = new ArrayList<RecipeClass>();
		jewel_recipes       = new ArrayList<RecipeClass>();
		leather_recipes     = new ArrayList<RecipeClass>();
		tailor_recipes      = new ArrayList<RecipeClass>();
	}
	
	
	public void addRecipe(int prof_code, RecipeClass recipe){
		switch(prof_code){
		case 1111:
			alch_recipes.add(recipe);
			break;
		case 1112:
			blacksmith_recipes.add(recipe);
			break;
		case 1113:
			enchant_recipes.add(recipe);
			break;
		case 1114:
			engineer_recipes.add(recipe);
			break;
		case 1115:
			inscription_recipes.add(recipe);
			break;
		case 1116:
			jewel_recipes.add(recipe);
			break;
		case 1117:
			leather_recipes.add(recipe);
			break;
		case 1118:
			tailor_recipes.add(recipe);
			break;
		default:
			break;
			
		}
	}
	
	public void displayRecipe(int index){
		alch_recipes.get(index).printRecipe();
	}
	
	public String[] breakDownRecipe(RecipeClass recipe) {
		String[] output = new String[11];
		
		output[0]  = recipe.getName();
		
		if (recipe.getMat1() != null) {
			output[1]  = Integer.toString(recipe.getQtMat1());
			output[2]  = recipe.getMat1().getName();
		}else {
			output[1]  = "";
			output[2]  = "";
		}
		
		if (recipe.getMat2() != null) {
			output[3]  = Integer.toString(recipe.getQtMat2());
			output[4]  = recipe.getMat2().getName();
		}else {
			output[3]  = "";
			output[4]  = "";
		}
		
		if (recipe.getMat3() != null) {
			output[5]  = Integer.toString(recipe.getQtMat3());
			output[6]  = recipe.getMat3().getName();
		}else {
			output[5]  = "";
			output[6]  = "";
		}
		
		if (recipe.getMat4() != null) {
			output[7]  = Integer.toString(recipe.getQtMat4());
			output[8]  = recipe.getMat4().getName();
		}else {
			output[7]  = "";
			output[8]  = "";
		}
		
		if (recipe.getMat5() != null) {
			output[9]  = Integer.toString(recipe.getQtMat5());
			output[10]  = recipe.getMat5().getName();
		}else {
			output[9]  = "";
			output[10]  = "";
		}
  	
		return output;
	}
	
	public RecipeClass lookUpRecipe(String selected_prof, int index){
		RecipeClass output = null;
		ArrayList<RecipeClass> temp_list = new ArrayList<RecipeClass>();
		switch(selected_prof) {
		case "Alchemy":
			temp_list = alch_recipes;
			break;
		case "Blacksmithing":
			temp_list = blacksmith_recipes;
			break;
		case "Enchanting":
			temp_list = enchant_recipes;
			break;
		case "Engineering":
			temp_list = engineer_recipes;
			break;
		case "Inscription":
			temp_list = inscription_recipes;
			break;
		case "Jewelcrafting":
			temp_list = jewel_recipes;
			break;
		case "Leatherworking":
			temp_list = leather_recipes;
			break;
		case "Tailoring":
			temp_list = tailor_recipes;
			break;
		default:
			break;
		}
		
		output = temp_list.get(index);
		
		return output;
	}
	
 	public String[][] packAllRecipes(String selected_prof){
		
		ArrayList<RecipeClass> temp_list = new ArrayList<RecipeClass>();
		
		switch(selected_prof) {
		case "Alchemy":
			temp_list = alch_recipes;
			break;
		case "Blacksmithing":
			temp_list = blacksmith_recipes;
			break;
		case "Enchanting":
			temp_list = enchant_recipes;
			break;
		case "Engineering":
			temp_list = engineer_recipes;
			break;
		case "Inscription":
			temp_list = inscription_recipes;
			break;
		case "Jewelcrafting":
			temp_list = jewel_recipes;
			break;
		case "Leatherworking":
			temp_list = leather_recipes;
			break;
		case "Tailoring":
			temp_list = tailor_recipes;
			break;
		default:
			break;
		}
		
		String[][] output_arr = new String[temp_list.size()][11];
		
		for (int i = 0; i < temp_list.size(); i++){
			output_arr[i] = breakDownRecipe(temp_list.get(i));
		}
		
		return output_arr;
	}


	public ArrayList<RecipeClass> getAlch_recipes() {
		return alch_recipes;
	}


	public void setAlch_recipes(ArrayList<RecipeClass> alch_recipes) {
		this.alch_recipes = alch_recipes;
	}


	public ArrayList<RecipeClass> getBlacksmith_recipes() {
		return blacksmith_recipes;
	}


	public void setBlacksmith_recipes(ArrayList<RecipeClass> blacksmith_recipes) {
		this.blacksmith_recipes = blacksmith_recipes;
	}


	public ArrayList<RecipeClass> getEnchant_recipes() {
		return enchant_recipes;
	}


	public void setEnchant_recipes(ArrayList<RecipeClass> enchant_recipes) {
		this.enchant_recipes = enchant_recipes;
	}


	public ArrayList<RecipeClass> getEngineer_recipes() {
		return engineer_recipes;
	}


	public void setEngineer_recipes(ArrayList<RecipeClass> engineer_recipes) {
		this.engineer_recipes = engineer_recipes;
	}


	public ArrayList<RecipeClass> getInscription_recipes() {
		return inscription_recipes;
	}


	public void setInscription_recipes(ArrayList<RecipeClass> inscription_recipes) {
		this.inscription_recipes = inscription_recipes;
	}


	public ArrayList<RecipeClass> getJewel_recipes() {
		return jewel_recipes;
	}


	public void setJewel_recipes(ArrayList<RecipeClass> jewel_recipes) {
		this.jewel_recipes = jewel_recipes;
	}


	public ArrayList<RecipeClass> getLeather_recipes() {
		return leather_recipes;
	}


	public void setLeather_recipes(ArrayList<RecipeClass> leather_recipes) {
		this.leather_recipes = leather_recipes;
	}


	public ArrayList<RecipeClass> getTailor_recipes() {
		return tailor_recipes;
	}


	public void setTailor_recipes(ArrayList<RecipeClass> tailor_recipes) {
		this.tailor_recipes = tailor_recipes;
	}
	


}
