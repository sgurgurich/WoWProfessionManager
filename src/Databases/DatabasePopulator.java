package Databases;

import RecipeClasses.MaterialClass;
import RecipeClasses.RecipeClass;

public class DatabasePopulator {
	
	private CraftingRecipeDatabase recipe_data;
	private MaterialsDatabase material_data;

	public DatabasePopulator(CraftingRecipeDatabase recipe_data, MaterialsDatabase material_data){
		this.recipe_data = recipe_data;
		this.material_data = material_data;
	}
	
	public void addRecipe(int prof_code, String rec_name, int qt1, MaterialClass mat1){
		RecipeClass temp_recipe = new RecipeClass(rec_name, mat1, null, null, null, null, qt1, 0, 0, 0, 0);
		recipe_data.addRecipe(prof_code, temp_recipe);
	}
	
	public void addRecipe(int prof_code, String rec_name, int qt1, MaterialClass mat1, int qt2, MaterialClass mat2){
		RecipeClass temp_recipe = new RecipeClass(rec_name, mat1, mat2, null, null, null, qt1, qt2, 0, 0, 0);
		recipe_data.addRecipe(prof_code, temp_recipe);
	}
	
	public void addRecipe(int prof_code, String rec_name, int qt1, MaterialClass mat1, int qt2, MaterialClass mat2,
			int qt3, MaterialClass mat3){
		RecipeClass temp_recipe = new RecipeClass(rec_name, mat1, mat2, mat3, null, null, qt1, qt2, qt3, 0, 0);
		recipe_data.addRecipe(prof_code, temp_recipe);
	}
	
	public void addRecipe(int prof_code, String rec_name, int qt1, MaterialClass mat1, int qt2, MaterialClass mat2,
			int qt3, MaterialClass mat3, int qt4, MaterialClass mat4){
		RecipeClass temp_recipe = new RecipeClass(rec_name, mat1, mat2, mat3, mat4, null, qt1, qt2, qt3, qt4, 0);
		recipe_data.addRecipe(prof_code, temp_recipe);
	}
	
	public void addRecipe(int prof_code, String rec_name, int qt1, MaterialClass mat1, int qt2, MaterialClass mat2,
			int qt3, MaterialClass mat3, int qt4, MaterialClass mat4, int qt5, MaterialClass mat5){
		RecipeClass temp_recipe = new RecipeClass(rec_name, mat1, mat2, mat3, mat4, mat5, qt1, qt2, qt3, qt4, qt5);
		recipe_data.addRecipe(prof_code, temp_recipe);
	}
	
	public void addMaterial(int prof_code, String mat_name, int cost, int sell){
		MaterialClass temp_mat = new MaterialClass(mat_name, cost, sell);
		material_data.addMaterial(prof_code, temp_mat);
	}
}
