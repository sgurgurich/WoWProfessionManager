package MaterialLists;

public class MaterialListFactory {
	
	public MaterialListFactory(){
		
	}
	
	public MaterialListIntf grabMatData(String profession){
		MaterialListIntf output_list = new AlchemyMaterialList();
		
		switch(profession){
		case "Alchemy":
			output_list = new AlchemyMaterialList();
			break;
		case "Blacksmithing":
			break;
		case "Enchanting":
			break;
		case "Engineering":
			break;
		case "Inscription":
			break;
		case "Jewelcrafting":
			break;
		case "Leatherworking":
			break;
		case "Tailoring":
			break;
		default:
			break;
		}
		
		return output_list;
	}

}
