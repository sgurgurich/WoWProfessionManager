package Databases;

import java.util.ArrayList;

import RecipeClasses.MaterialClass;
import RecipeClasses.RecipeClass;

public class MaterialMapper {

	CraftingRecipeDatabase recipe_data;
	MaterialsDatabase material_data;

	public MaterialMapper(CraftingRecipeDatabase recipe_data, MaterialsDatabase material_data) {
		this.recipe_data   = recipe_data;                                                                        
		this.material_data = material_data;                                                                      
	}                                                                                                            

	public void mapMaterials(){                                                                                  


		ArrayList<ArrayList<MaterialClass>> mat_lists   = new ArrayList<ArrayList<MaterialClass>>();
		ArrayList<ArrayList<RecipeClass>> recipe_lists  = new ArrayList<ArrayList<RecipeClass>>();

		//Grab all materials                                                                                     
		mat_lists.add(material_data.getAlch_mats());    
		mat_lists.add(material_data.getBlacksmith_mats()); 
		mat_lists.add(material_data.getEnchant_mats()); 
		mat_lists.add(material_data.getEngineer_mats()); 
		mat_lists.add(material_data.getInscription_mats()); 
		mat_lists.add(material_data.getJewel_mats()); 
		mat_lists.add(material_data.getLeather_mats()); 
		mat_lists.add(material_data.getTailor_mats()); 

		//Grab all the current recipe lists
		recipe_lists.add(recipe_data.getAlch_recipes());
		recipe_lists.add(recipe_data.getBlacksmith_recipes());
		recipe_lists.add(recipe_data.getEnchant_recipes());
		recipe_lists.add(recipe_data.getEngineer_recipes());
		recipe_lists.add(recipe_data.getInscription_recipes()); 
		recipe_lists.add(recipe_data.getJewel_recipes());
		recipe_lists.add(recipe_data.getLeather_recipes());
		recipe_lists.add(recipe_data.getTailor_recipes());

		MaterialClass temp_mat =  null;

		for(int i = 0; i < recipe_lists.size(); i++) {
			for (int j = 0; j < recipe_lists.get(i).size(); j++) {
				if (recipe_lists.get(i).get(j).getMat1() != null) {
					temp_mat = lookUpMaterial(recipe_lists.get(i).get(j).getMat1().getName(), mat_lists.get(i));
					recipe_lists.get(i).get(j).setMat1(temp_mat);
				}
				if (recipe_lists.get(i).get(j).getMat2() != null) {
					temp_mat = lookUpMaterial(recipe_lists.get(i).get(j).getMat2().getName(), mat_lists.get(i));
					recipe_lists.get(i).get(j).setMat2(temp_mat);
				}
				if (recipe_lists.get(i).get(j).getMat3() != null) {
					temp_mat = lookUpMaterial(recipe_lists.get(i).get(j).getMat3().getName(), mat_lists.get(i));
					recipe_lists.get(i).get(j).setMat3(temp_mat);
				}
				if (recipe_lists.get(i).get(j).getMat4() != null) {
					temp_mat = lookUpMaterial(recipe_lists.get(i).get(j).getMat4().getName(), mat_lists.get(i));
					recipe_lists.get(i).get(j).setMat4(temp_mat);
				}
				if (recipe_lists.get(i).get(j).getMat5() != null) {
					temp_mat = lookUpMaterial(recipe_lists.get(i).get(j).getMat5().getName(), mat_lists.get(i));
					recipe_lists.get(i).get(j).setMat5(temp_mat);
				}
			}
		}
	}

	private MaterialClass lookUpMaterial(String mat_name, ArrayList<MaterialClass> mat_list) {
		MaterialClass temp_mat = null;

		for(int i = 0; i < mat_list.size(); i++) {
			if (mat_list.get(i).getName().equals(mat_name)) {
				temp_mat = mat_list.get(i);
			}
		}

		return temp_mat;
	}
}
