package FileParsing;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

import Databases.CraftingRecipeDatabase;
import Databases.DatabasePopulator;
import Databases.MaterialsDatabase;
import RecipeClasses.MaterialClass;

public class FileParser {

	private int current_prof; // 0=Alchemy
	private int data_type;    // 0=Recipe, 1=PriceData

	private ArrayList<String> alch_recipe_names;
	private ArrayList<String> alch_recipe_mats;

	private DatabasePopulator db_pop;
	CraftingRecipeDatabase recipe_data;
	MaterialsDatabase material_data;


	public FileParser(CraftingRecipeDatabase recipe_data, MaterialsDatabase material_data){
		current_prof = 0;
		this.recipe_data = recipe_data;
		db_pop = new DatabasePopulator(recipe_data, material_data);
		
	}


	public void parseDirectory(){

		File dir = new File("datafiles");


		File[] directoryListing = dir.listFiles();
		System.out.println(directoryListing);
		if (directoryListing != null) {
			for (File child : directoryListing) {
				// Do something with child
				System.out.print(child.getName());
				parseFile(child.getPath());
			}
		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
			System.out.println("here");
		}

	}

	public void parseFile(String file_name){

		File file = new File(file_name);
		System.out.println(file_name);
		try{

			Scanner inputStream = new Scanner(file);
			// hasNext() loops line-by-line
			while(inputStream.hasNext()){
				//read single line, put in string
				String data = inputStream.nextLine();
				//	System.out.println(data);
				parseLine(data);
			}
			// after loop, close scanner
			inputStream.close();


		}catch (FileNotFoundException e){

			e.printStackTrace();
		}
	}

	private void parseLine(String line){	

		int temp = 0;
		
		try{
			temp = Integer.parseInt(line.substring(0,4));
		}
		catch (NumberFormatException e){
			temp = 9999;
		}
		
		System.out.println(temp);
		switch (temp){
		case 1111:
			current_prof = 1111;
			break;
		case 1112:
			current_prof = 1112;
			break;
		case 1113:
			current_prof = 1113;
			break;
		case 1114:
			current_prof = 1114;
			break;
		case 1115:
			current_prof = 1115;
			break;
		case 1116:
			current_prof = 1116;
			break;
		case 1117:
			current_prof = 1117;
			break;
		case 1118:
			current_prof = 1118;
			break;
		case 0000:
			data_type = 0;
			break;
		case 1101:
			data_type = 1;
			break;
		default:
			if (data_type == 0){
				breakDownNonIdLine(line);
			}
			else{
				breakDownMatLine(line);
			}
			break;
		}

	}

	private void breakDownNonIdLine(String line){
		ArrayList<String> temp_list = new ArrayList<String>(Arrays.asList(line.split(",")));
		String name;
		int temp_qt1;
		int temp_qt2;
		int temp_qt3;
		int temp_qt4;
		int temp_qt5;
		MaterialClass temp_mat1;
		MaterialClass temp_mat2;
		MaterialClass temp_mat3;
		MaterialClass temp_mat4;
		MaterialClass temp_mat5;
		
		
		switch(temp_list.size()){
		case 3:
			name = temp_list.get(0);
			temp_qt1 = Integer.parseInt(temp_list.get(1));
			temp_mat1 = new MaterialClass(temp_list.get(2), 0, 0);
			db_pop.addRecipe(current_prof, name, temp_qt1, temp_mat1);
			break;

		case 5:
			name = temp_list.get(0);
			temp_qt1 = Integer.parseInt(temp_list.get(1));
			temp_qt2 = Integer.parseInt(temp_list.get(3));
			temp_mat1 = new MaterialClass(temp_list.get(2), 0, 0);
			temp_mat2 = new MaterialClass(temp_list.get(4), 0, 0);
			db_pop.addRecipe(current_prof, name, temp_qt1, temp_mat1, temp_qt2, temp_mat2);
			break;

		case 7:
			name = temp_list.get(0);
			temp_qt1 = Integer.parseInt(temp_list.get(1));
			temp_qt2 = Integer.parseInt(temp_list.get(3));
			temp_qt3 = Integer.parseInt(temp_list.get(5));
			temp_mat1 = new MaterialClass(temp_list.get(2), 0, 0);
			temp_mat2 = new MaterialClass(temp_list.get(4), 0, 0);
			temp_mat3 = new MaterialClass(temp_list.get(6), 0, 0);
			db_pop.addRecipe(current_prof, name, temp_qt1, temp_mat1, temp_qt2, temp_mat2, temp_qt3, temp_mat3);
			break;

		case 9:
			name = temp_list.get(0);
			temp_qt1 = Integer.parseInt(temp_list.get(1));
			temp_qt2 = Integer.parseInt(temp_list.get(3));
			temp_qt3 = Integer.parseInt(temp_list.get(5));
			temp_qt4 = Integer.parseInt(temp_list.get(7));
			temp_mat1 = new MaterialClass(temp_list.get(2), 0, 0);
			temp_mat2 = new MaterialClass(temp_list.get(4), 0, 0);
			temp_mat3 = new MaterialClass(temp_list.get(6), 0, 0);
			temp_mat4 = new MaterialClass(temp_list.get(8), 0, 0);
			db_pop.addRecipe(current_prof, name, temp_qt1, temp_mat1, temp_qt2, temp_mat2, temp_qt3, temp_mat3, temp_qt4, temp_mat4);
			break;

		case 11:
			name = temp_list.get(0);
			temp_qt1 = Integer.parseInt(temp_list.get(1));
			temp_qt2 = Integer.parseInt(temp_list.get(3));
			temp_qt3 = Integer.parseInt(temp_list.get(5));
			temp_qt4 = Integer.parseInt(temp_list.get(7));
			temp_qt5 = Integer.parseInt(temp_list.get(9));
			temp_mat1 = new MaterialClass(temp_list.get(2), 0, 0);
			temp_mat2 = new MaterialClass(temp_list.get(4), 0, 0);
			temp_mat3 = new MaterialClass(temp_list.get(6), 0, 0);
			temp_mat4 = new MaterialClass(temp_list.get(8), 0, 0);
			temp_mat5 = new MaterialClass(temp_list.get(10), 0, 0);
			db_pop.addRecipe(current_prof, name, temp_qt1, temp_mat1, temp_qt2, temp_mat2, temp_qt3, temp_mat3, temp_qt4, temp_mat4, temp_qt5, temp_mat5);
			break;

		default:
			break;
		}

	}

	private void breakDownMatLine(String line){
		ArrayList<String> temp_list = new ArrayList<String>(Arrays.asList(line.split(",")));
		System.out.println("Here");
		String name = temp_list.get(0);
		int cost = Integer.parseInt(temp_list.get(1));
		int sell = Integer.parseInt(temp_list.get(2));
		
		db_pop.addMaterial(current_prof, name, cost, sell);
		
	}
}
