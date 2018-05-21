import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Databases.CraftingRecipeDatabase;
import Databases.MaterialMapper;
import Databases.MaterialsDatabase;
import RecipeClasses.*;
import FileParsing.FileParser;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MainAppWindow {

	private JFrame frame;
	private DefaultTableModel matsModel;
	private DefaultTableModel recModel;
	FileParser parse;
	CraftingRecipeDatabase recipe_database;
	MaterialsDatabase materials_database;
	MaterialMapper material_mapper;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String[][] mats_data;
	String[][] rec_data;
    String[] mat_columns;
	String[] rec_columns;
	int entered_quantity;
	double estimated_cost;
	double est_profit;
	double est_profit_per;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAppWindow window = new MainAppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		entered_quantity = 0;
		estimated_cost   = 0.0;
		est_profit       = 0.0;
		est_profit_per   = 0.0;
		
		//Create a list of all crafting professions
		String[] profStrings = {"Alchemy","Blacksmithing","Enchanting","Engineering","Inscription","Jewelcrafting","Leatherworking","Tailoring"};
		String initial_profession = "Alchemy";
        mat_columns = new String[] {"Material", "Cost", "Sell Price", "Profit"};
        rec_columns = new String[] {"Recipe", " ", "Mat 1", " ", "Mat 2", " ", "Mat 3", " ", "Mat 4", " ", "Mat 5",};
		
		
		//Create the databases
		materials_database = new MaterialsDatabase();
		recipe_database = new CraftingRecipeDatabase();
		material_mapper = new MaterialMapper(recipe_database, materials_database);

		//Parse the data files to populate the databases
		parse = new FileParser(recipe_database, materials_database);
		parse.parseDirectory();
		
		//Map all Material objects to their place in the recipes
		material_mapper.mapMaterials();
		
		//Populate the display list models from the databases
		populateMatsModel(initial_profession);
		populateRecipeModel(initial_profession);
		
		
		frame = new JFrame("WoW Profession Manager");
		frame.setBounds(100, 100, 1280, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		JTable table = new JTable(matsModel);
		table.setColumnSelectionAllowed(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table); 
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setBounds(254, 29, 704, 207);
		frame.getContentPane().add(scrollPane);
		
		
		JScrollPane scrollPane2 = new JScrollPane();
		JTable table2 = new JTable(recModel);
		table2.setColumnSelectionAllowed(false);
		table2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table2.getColumnModel().getColumn(0).setPreferredWidth(500);
		table2.getColumnModel().getColumn(1).setPreferredWidth(75);
		table2.getColumnModel().getColumn(2).setPreferredWidth(300);
		table2.getColumnModel().getColumn(3).setPreferredWidth(75);
		table2.getColumnModel().getColumn(4).setPreferredWidth(300);
		table2.getColumnModel().getColumn(5).setPreferredWidth(75);
		table2.getColumnModel().getColumn(6).setPreferredWidth(300);
		table2.getColumnModel().getColumn(7).setPreferredWidth(75);
		table2.getColumnModel().getColumn(8).setPreferredWidth(300);
		table2.getColumnModel().getColumn(9).setPreferredWidth(75);
		table2.getColumnModel().getColumn(10).setPreferredWidth(300);
		scrollPane2.setViewportView(table2); 
		scrollPane2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane2.setBounds(254, 272, 989, 197);
		frame.getContentPane().add(scrollPane2);
		
		JComboBox comboBox = new JComboBox(profStrings);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTableModels();
				populateMatsModel(comboBox.getSelectedItem().toString());
				populateRecipeModel(comboBox.getSelectedItem().toString());
				table.setModel(matsModel);
				table2.setModel(recModel);
			}
		});
		comboBox.setBounds(26, 29, 204, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblMaterialsAndPrices = new JLabel("Materials and Prices");
		lblMaterialsAndPrices.setBounds(253, 11, 142, 16);
		frame.getContentPane().add(lblMaterialsAndPrices);
		
		JLabel lblSelectAProfession = new JLabel("Select a Profession");
		lblSelectAProfession.setBounds(26, 11, 134, 16);
		frame.getContentPane().add(lblSelectAProfession);
		
		JLabel lblRecipes = new JLabel("Recipes");
		lblRecipes.setBounds(254, 256, 56, 16);
		frame.getContentPane().add(lblRecipes);
		
		JButton btnTest = new JButton("TEST");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Remove this!
				recipe_database.displayRecipe(0);
			}
		});
		btnTest.setBounds(146, 432, 97, 25);
		frame.getContentPane().add(btnTest);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 247, 932, 10);
		frame.getContentPane().add(separator);
		
		textField_1 = new JTextField(Double.toString(estimated_cost));
		textField_1.setBounds(122, 299, 108, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField(Integer.toString(entered_quantity));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entered_quantity = Integer.parseInt(textField.getText());
				
				
				textField_1.setText(Double.toString(estimated_cost));
			}
		});
		textField.setBounds(26, 299, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField(Double.toString(est_profit_per));
		textField_2.setBounds(122, 370, 108, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField(Double.toString(est_profit));
		textField_3.setBounds(123, 401, 107, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAmountCreated = new JLabel("Quantity");
		lblAmountCreated.setBounds(26, 283, 113, 14);
		frame.getContentPane().add(lblAmountCreated);
		
		JLabel lblEstimatedCost = new JLabel("Estimated Cost");
		lblEstimatedCost.setBounds(122, 283, 87, 14);
		frame.getContentPane().add(lblEstimatedCost);
		
		JButton btnCalculateProfit = new JButton("Calculate Profit");
		btnCalculateProfit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					entered_quantity = Integer.parseInt(textField.getText());
					double profit_earned = 1.0;
					RecipeClass temp_rec = recipe_database.lookUpRecipe(comboBox.getSelectedItem().toString(), table2.getSelectedRow());
					
					
					est_profit_per =(calculateSales(temp_rec) - calculateCost(temp_rec));
					est_profit = entered_quantity * est_profit_per;
					
					textField_2.setText(Double.toString(est_profit_per));
					textField_3.setText(Double.toString(est_profit));
					
					System.out.println(temp_rec.getName());
					System.out.println(entered_quantity);
					System.out.println(calculateCost(temp_rec));
					System.out.println(calculateSales(temp_rec));
					
					
					
				}
				catch (NumberFormatException nfe) {
					//pass
				}
				catch (IndexOutOfBoundsException ioobe){
					//pass
				}
			}
		});
		btnCalculateProfit.setBounds(26, 330, 204, 23);
		frame.getContentPane().add(btnCalculateProfit);
		

		
		JLabel lblEstProfitunit = new JLabel("Est. Profit/Unit");
		lblEstProfitunit.setBounds(26, 373, 86, 14);
		frame.getContentPane().add(lblEstProfitunit);
		
		JLabel lblEstTotalProfit = new JLabel("Est. Total Profit");
		lblEstTotalProfit.setBounds(26, 404, 86, 14);
		frame.getContentPane().add(lblEstTotalProfit);
		
		JLabel lblSGurgurich = new JLabel("S. Gurgurich");
		lblSGurgurich.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblSGurgurich.setBounds(1214, 467, 86, 14);
		frame.getContentPane().add(lblSGurgurich);
	}
	
	private void populateMatsModel(String prof){
		mats_data = materials_database.packAllMaterials(prof);	
		matsModel = new DefaultTableModel(mats_data, mat_columns);
	}
	
	private void populateRecipeModel(String prof){
		
		rec_data = recipe_database.packAllRecipes(prof);
		recModel = new DefaultTableModel(rec_data, rec_columns);
	}
	
	private void resetTableModels(){
		matsModel.setRowCount(0);
		recModel.setRowCount(0);
	}
	
	private double calculateSales(RecipeClass recipe) {
		double out = 0.0;
		
		out = recipe.getSell();
		
		return out;
	}
	
	private double calculateCost(RecipeClass recipe) {
		
		double out = 0.0;
		
		try{
			out = out + (recipe.getQtMat1() * (recipe.getMat1().getCost()));
		}catch(NullPointerException npe){
			// pass
		}
		
		try{
			out = out + (recipe.getQtMat2() * (recipe.getMat2().getCost()));
		}catch(NullPointerException npe){
			// pass
		}
		
		try{
			out = out + (recipe.getQtMat3() * (recipe.getMat3().getCost()));
		}catch(NullPointerException npe){
			// pass
		}
		
		try{
			out = out + (recipe.getQtMat4() * (recipe.getMat4().getCost()));
		}catch(NullPointerException npe){
			// pass
		}
		
		try{
			out = out + (recipe.getQtMat5() * (recipe.getMat5().getCost()));
		}catch(NullPointerException npe){
			// pass
		}
		
		estimated_cost = out;
		return out;
		
	}
	
	
}
