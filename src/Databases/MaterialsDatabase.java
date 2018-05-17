package Databases;

import java.util.ArrayList;

import RecipeClasses.MaterialClass;
import RecipeClasses.RecipeClass;

public class MaterialsDatabase {
	private ArrayList<MaterialClass> alch_mats;         
	private ArrayList<MaterialClass> blacksmith_mats;     
	private ArrayList<MaterialClass> enchant_mats;    
	private ArrayList<MaterialClass> engineer_mats;   
	private ArrayList<MaterialClass> inscription_mats;       
	private ArrayList<MaterialClass> jewel_mats;     
	private ArrayList<MaterialClass> leather_mats;      
	private ArrayList<MaterialClass> tailor_mats; 
	                                                  
	public MaterialsDatabase(){
		alch_mats        = new ArrayList<MaterialClass>();
		blacksmith_mats  = new ArrayList<MaterialClass>();
		enchant_mats     = new ArrayList<MaterialClass>();
		engineer_mats    = new ArrayList<MaterialClass>();
		inscription_mats = new ArrayList<MaterialClass>();
		jewel_mats       = new ArrayList<MaterialClass>();
		leather_mats     = new ArrayList<MaterialClass>();
		tailor_mats      = new ArrayList<MaterialClass>();
	}
	

	public void addMaterial(int prof_code, MaterialClass material){
		
		System.out.println(prof_code);
		switch(prof_code){
		case 1111:
			alch_mats.add(material);
			break;
		case 1112:
			blacksmith_mats.add(material);
			break;
		case 1113:
			enchant_mats.add(material);
			break;
		case 1114:
			engineer_mats.add(material);
			break;
		case 1115:
			inscription_mats.add(material);
			break;
		case 1116:
			jewel_mats.add(material);
			break;
		case 1117:
			leather_mats.add(material);
			break;
		case 1118:
			tailor_mats.add(material);
			break;
		default:
			break;
			
		}
	}
	
	public String[] breakDownMaterial(MaterialClass mat) {
		String[] output = new String[4];
		
		output[0] = mat.getName();
		output[1] = Double.toString(mat.getCost());
		output[2] = Double.toString(mat.getSell());
		output[3] = ""; //TODO: CHANGE THIS
		
		
		return output;
	}
	
	public String[][] packAllMaterials(String selected_prof){

		ArrayList<MaterialClass> temp_list = new ArrayList<MaterialClass>();
		
		switch(selected_prof) {
		case "Alchemy":
			temp_list = alch_mats;
			break;
		case "Blacksmithing":
			temp_list = blacksmith_mats;
			break;
		case "Enchanting":
			temp_list = enchant_mats;
			break;
		case "Engineering":
			temp_list = engineer_mats;
			break;
		case "Inscription":
			temp_list = inscription_mats;
			break;
		case "Jewelcrafting":
			temp_list = jewel_mats;
			break;
		case "Leatherworking":
			temp_list = leather_mats;
			break;
		case "Tailoring":
			temp_list = tailor_mats;
			break;
		default:
			break;
		}
		
		String[][] output_arr = new String[temp_list.size()][4];
		
		for (int i = 0; i < temp_list.size(); i++){
			output_arr[i] = breakDownMaterial(temp_list.get(i));
		}
		
		return output_arr;
	}


	public ArrayList<MaterialClass> getAlch_mats() {
		return alch_mats;
	}


	public void setAlch_mats(ArrayList<MaterialClass> alch_mats) {
		this.alch_mats = alch_mats;
	}


	public ArrayList<MaterialClass> getBlacksmith_mats() {
		return blacksmith_mats;
	}


	public void setBlacksmith_mats(ArrayList<MaterialClass> blacksmith_mats) {
		this.blacksmith_mats = blacksmith_mats;
	}


	public ArrayList<MaterialClass> getEnchant_mats() {
		return enchant_mats;
	}


	public void setEnchant_mats(ArrayList<MaterialClass> enchant_mats) {
		this.enchant_mats = enchant_mats;
	}


	public ArrayList<MaterialClass> getEngineer_mats() {
		return engineer_mats;
	}


	public void setEngineer_mats(ArrayList<MaterialClass> engineer_mats) {
		this.engineer_mats = engineer_mats;
	}


	public ArrayList<MaterialClass> getInscription_mats() {
		return inscription_mats;
	}


	public void setInscription_mats(ArrayList<MaterialClass> inscription_mats) {
		this.inscription_mats = inscription_mats;
	}


	public ArrayList<MaterialClass> getJewel_mats() {
		return jewel_mats;
	}


	public void setJewel_mats(ArrayList<MaterialClass> jewel_mats) {
		this.jewel_mats = jewel_mats;
	}


	public ArrayList<MaterialClass> getLeather_mats() {
		return leather_mats;
	}


	public void setLeather_mats(ArrayList<MaterialClass> leather_mats) {
		this.leather_mats = leather_mats;
	}


	public ArrayList<MaterialClass> getTailor_mats() {
		return tailor_mats;
	}


	public void setTailor_mats(ArrayList<MaterialClass> tailor_mats) {
		this.tailor_mats = tailor_mats;
	}
	
	
	
}
