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
import javax.swing.JTextField;

import Databases.CraftingRecipeDatabase;
import Databases.MaterialsDatabase;
import FileParsing.FileParser;
import MaterialLists.MaterialListFactory;
import MaterialLists.MaterialListIntf;
import RecipeClasses.*;

public class MainAppWindow {

	private JFrame frame;
	private DefaultListModel<String> matsModel;
	private DefaultListModel<String> recModel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	FileParser parse;
	CraftingRecipeDatabase recipe_database;
	MaterialsDatabase materials_database;

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
		
		materials_database = new MaterialsDatabase();
		recipe_database = new CraftingRecipeDatabase();
		
		MaterialListFactory mlf = new MaterialListFactory();
		MaterialListIntf mat_list_obj = mlf.grabMatData("Alch"); 
		parse = new FileParser(recipe_database, materials_database);
		parse.parseDirectory();
		
		matsModel = new DefaultListModel<String>();
		recModel = new DefaultListModel<String>();
		populateMatsModel();
		populateRecipeModel();
		
		
		String[] profStrings = {"Alchemy","Blacksmithing","Enchanting","Engineering","Inscription","Jewelcrafting","Leatherworking","Tailoring"};
		
		
		frame = new JFrame("WoW Profession Manager");
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox comboBox = new JComboBox(profStrings);
		comboBox.setBounds(26, 65, 204, 22);
		frame.getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		JList<String> list = new JList<String>(matsModel);
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		scrollPane.setViewportView(list);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setBounds(253, 66, 265, 174);
		frame.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane2 = new JScrollPane();
		JList<String> list2 = new JList<String>(recModel);
		list2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		scrollPane2.setViewportView(list2);
		scrollPane2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane2.setBounds(552, 66, 395, 174);
		frame.getContentPane().add(scrollPane2);
		
		JLabel lblMaterialsAndPrices = new JLabel("Materials and Prices");
		lblMaterialsAndPrices.setBounds(253, 46, 142, 16);
		frame.getContentPane().add(lblMaterialsAndPrices);
		
		JLabel lblSelectAProfession = new JLabel("Select a Profession");
		lblSelectAProfession.setBounds(26, 46, 134, 16);
		frame.getContentPane().add(lblSelectAProfession);
		
		JButton btnChangeMaterialData = new JButton("Change Material Data");
		btnChangeMaterialData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//open popup to change selected material data
				int selected_mat_idx = list.getSelectedIndex();
				System.out.println(selected_mat_idx);
				
			}
		});
		btnChangeMaterialData.setBounds(283, 305, 204, 25);
		frame.getContentPane().add(btnChangeMaterialData);
		
		textField = new JTextField();
		textField.setBounds(253, 270, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(402, 270, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(253, 253, 56, 16);
		frame.getContentPane().add(lblCost);
		
		JLabel lblSellPrice = new JLabel("Sell Price");
		lblSellPrice.setBounds(402, 253, 56, 16);
		frame.getContentPane().add(lblSellPrice);
		
		JLabel lblRecipes = new JLabel("Recipes");
		lblRecipes.setBounds(552, 46, 56, 16);
		frame.getContentPane().add(lblRecipes);
		
		textField_2 = new JTextField();
		textField_2.setBounds(614, 270, 116, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(768, 270, 116, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnChangeRecipeData = new JButton("Change Recipe Data");
		btnChangeRecipeData.setBounds(666, 305, 175, 25);
		frame.getContentPane().add(btnChangeRecipeData);
		
		JLabel lblCost_1 = new JLabel("Cost");
		lblCost_1.setBounds(614, 253, 56, 16);
		frame.getContentPane().add(lblCost_1);
		
		JLabel lblSellPrice_1 = new JLabel("Sell Price");
		lblSellPrice_1.setBounds(768, 253, 56, 16);
		frame.getContentPane().add(lblSellPrice_1);
		
		JButton btnTest = new JButton("TEST");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Remove this!
				recipe_database.displayRecipe(0);
			}
		});
		btnTest.setBounds(70, 439, 97, 25);
		frame.getContentPane().add(btnTest);
	}
	
	private void populateMatsModel(){
		
		String[] mats_arr = materials_database.packAllMaterials();
		
		matsModel.addElement("Material              " + "Cost        " + "Sell Price");
		for (int i = 0; i < mats_arr.length; i++){
			matsModel.addElement(mats_arr[i]);
		}
	}
	
	private void populateRecipeModel(){
		//matsModel.addElement("Material              " + "Cost        " + "Sell Price");
		String[] rec_arr = recipe_database.packAllRecipes();
		
		for (int i = 0; i < rec_arr.length; i++){
			recModel.addElement(rec_arr[i]);
		}
		
		
		
	}
}
