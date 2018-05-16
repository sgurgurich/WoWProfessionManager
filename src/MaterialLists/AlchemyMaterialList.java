package MaterialLists;

public class AlchemyMaterialList implements MaterialListIntf{

	final int NUM_OF_MATS = 10;
	String[] mat_list;
	String[] price_list;
	String[] sale_price_list;
	String[] final_list;
	
	
	public AlchemyMaterialList(){
		mat_list        = new String[NUM_OF_MATS];
		price_list      = new String[NUM_OF_MATS];
		sale_price_list = new String[NUM_OF_MATS];
		final_list = new String[NUM_OF_MATS];
		
		populateMatList();
		populatePriceList();
		populateSalePriceList();
		createFullStrings();
	}
	
	
	@Override
	public String[] getFinalList() {

		return final_list;
	}
	
	private void populateMatList(){
		mat_list[0] = "Temp Mat 0";
		mat_list[1] = "Temp Mat 1";
		mat_list[2] = "Temp Mat 2";
		mat_list[3] = "Temp Mat 3";
		mat_list[4] = "Temp Mat 4";
		mat_list[5] = "Temp Mat 5";
		mat_list[6] = "Temp Mat 6";
		mat_list[7] = "Temp Mat 7";
		mat_list[8] = "Temp Mat 8";
		mat_list[9] = "Temp Mat 9";
	}
	private void populatePriceList(){
		price_list[0] = "1,000";
		price_list[1] = "2,000";
		price_list[2] = "3,000";
		price_list[3] = "4,000";
		price_list[4] = "5,000";
		price_list[5] = "6,000";
		price_list[6] = "7,000";
		price_list[7] = "8,000";
		price_list[8] = "9,000";
		price_list[9] = "10,000";
	}
	
	private void populateSalePriceList(){
		sale_price_list[0] = "1,000";
		sale_price_list[1] = "2,000";
		sale_price_list[2] = "3,000";
		sale_price_list[3] = "4,000";
		sale_price_list[4] = "5,000";
		sale_price_list[5] = "6,000";
		sale_price_list[6] = "7,000";
		sale_price_list[7] = "8,000";
		sale_price_list[8] = "9,000";
		sale_price_list[9] = "10,000";
	}
	
	private void createFullStrings(){
		for (int i = 0; i < NUM_OF_MATS; i++){
			final_list[i] = mat_list[i] + "        " + price_list[i]  + "        " + sale_price_list[i];
		}
	}

}
