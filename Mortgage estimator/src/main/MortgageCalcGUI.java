// Akuma Akuma-Ukpo

package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;

public class MortgageCalcGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MortgageCalcGUI window = new MortgageCalcGUI();
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
	public MortgageCalcGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 507, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblgrossincome = new JLabel("Gross Income");
		lblgrossincome.setBounds(10, 40, 111, 20);
		frame.getContentPane().add(lblgrossincome);
		
		JLabel lblMonthlyDebt = new JLabel("Monthly Debt");
		lblMonthlyDebt.setBounds(10, 83, 111, 14);
		frame.getContentPane().add(lblMonthlyDebt);
		
		JLabel lblinterestRate = new JLabel("Interest Rate");
		lblinterestRate.setBounds(10, 124, 111, 17);
		frame.getContentPane().add(lblinterestRate);
		
		JLabel lblTerm = new JLabel("Term");
		lblTerm.setBounds(10, 163, 97, 14);
		frame.getContentPane().add(lblTerm);
		
		JLabel lblDownPayment = new JLabel("Down Payment");
		lblDownPayment.setBounds(10, 200, 111, 14);
		frame.getContentPane().add(lblDownPayment);
		
		textField_4 = new JTextField();
		textField_4.setBounds(388, 61, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(131, 160, 40, 20);
		frame.getContentPane().add(comboBox);
		
		ArrayList<Integer> years = new ArrayList<Integer>();
		years.add(10);
		years.add(15);
		years.add(30);
		for(int i=0; i<years.size(); i++){
			comboBox.addItem(years.get(i));
		}
			comboBox.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	            	// getting the text from the textfields in a type of Strings
	            	Integer TERM = (Integer)comboBox.getSelectedItem();
	            	String GROSS_INCOME = textField.getText();
	            	String MONTHLY_DEBT= textField_1.getText();
	            	String INTEREST_RATE= textField_2.getText();
	            	String DOWN_PAYMENT= textField_3.getText();
	            	
	            	// convert string into integers 
	            	Double GROSS_income = Double.parseDouble(GROSS_INCOME);
	            	Double MONTHLY_debt = Double.parseDouble(MONTHLY_DEBT);
	            	Double INTEREST_rate= Double.parseDouble(INTEREST_RATE);
	            	Double DOWN_payment= Double.parseDouble(DOWN_PAYMENT);
	            	
	            	// get affordable value 
	            	double HOUSE_payment = MortgageCalc.HousingPayment(GROSS_income);
	            	double HOUSE_Debt_Payment = MortgageCalc.DebtPayment(GROSS_income, MONTHLY_debt);
	            	double CAN_afford = MortgageCalc.can_afford(HOUSE_Debt_Payment, HOUSE_payment);
	            	
	            	// round present_value(CAN_afford,TERM ,INTEREST_rate,DOWN_payment );
	            	DecimalFormat format = new DecimalFormat("#0.000");
	            	String PV = format.format(MORTGAGE);
	            	textField_4.setText(PV);
	            }	            
			});
	            	
			textField = new JTextField();
			textField.setBounds(131, 40, 86, 20);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			textField.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	            	// getting the text from the textfields 
	            	Integer TERM = (Integer)comboBox.getSelectedItem();
	            	String GROSS_INCOME = textField.getText();
	            	String MONTHLY_DEBT= textField_1.getText();
	            	String INTEREST_RATE= textField_2.getText();
	            	String DOWN_PAYMENT= textField_3.getText();
	            	
	            	// converting string into integers 
	            	Double GROSS_income = Double.parseDouble(GROSS_INCOME);
	            	Double MONTHLY_debt = Double.parseDouble(MONTHLY_DEBT);
	            	Double INTEREST_rate= Double.parseDouble(INTEREST_RATE);
	            	Double DOWN_payment= Double.parseDouble(DOWN_PAYMENT);
	            	
	            	// affordable value 
	            	double HOUSE_payment = MortgageCalc.HousingPayment(GROSS_income);
	            	double HOUSE_Debt_Payment = MortgageCalc.DebtPayment(GROSS_income, MONTHLY_debt);
	            	double CAN_afford = MortgageCalc.can_afford(HOUSE_Debt_Payment, HOUSE_payment);
	            	
	            	// rounding the present value 
	            	Double MORTAGE = MortgageCalc.present_value(CAN_afford,TERM ,INTEREST_rate,DOWN_payment );
	            	DecimalFormat format = new DecimalFormat("#0.000");
	            	String PV = format.format(MORTAGE);
	            	textField_4.setText("$"+PV);
	            }	            
			});
			
			
			textField_1 = new JTextField();
			textField_1.setBounds(131, 80, 86, 20);
			frame.getContentPane().add(textField_1);
			textField_1.setColumns(10);
			textField_1.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	            	// getting the text 
	            	Integer TERM = (Integer)comboBox.getSelectedItem();
	            	String GROSS_INCOME = textField.getText();
	            	String MONTHLY_DEBT= textField_1.getText();
	            	String INTEREST_RATE= textField_2.getText();
	            	String DOWN_PAYMENT= textField_3.getText();
	            	
	            	// converting string into integers 
	            	Double GROSS_income = Double.parseDouble(GROSS_INCOME);
	            	Double MONTHLY_debt = Double.parseDouble(MONTHLY_DEBT);
	            	Double INTEREST_rate= Double.parseDouble(INTEREST_RATE);
	            	Double DOWN_payment= Double.parseDouble(DOWN_PAYMENT);
	            	
	            	// getting affordable value 
	            	double HOUSE_payment = MortgageCalc.HousingPayment(GROSS_income);
	            	double HOUSE_Debt_Payment = MortgageCalc.DebtPayment(GROSS_income, MONTHLY_debt);
	            	double CAN_afford = MortgageCalc.can_afford(HOUSE_Debt_Payment, HOUSE_payment);
	            	
	            	// calculating and rounding the present value 
	            	Double MORTAGE = MortgageCalc.present_value(CAN_afford,TERM ,INTEREST_rate,DOWN_payment );
	            	DecimalFormat format = new DecimalFormat("#0.000");
	            	String PV = format.format(MORTAGE);
	            	textField_4.setText("$"+PV);
	            }	            
			});
			
			textField_2 = new JTextField();
			textField_2.setBounds(131, 121, 86, 20);
			frame.getContentPane().add(textField_2);
			textField_2.setColumns(10);
			textField_2.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	            	
	            	Integer TERM = (Integer)comboBox.getSelectedItem();
	            	String GROSS_INCOME = textField.getText();
	            	String MONTHLY_DEBT= textField_1.getText();
	            	String INTEREST_RATE= textField_2.getText();
	            	String DOWN_PAYMENT= textField_3.getText();
	            	
	            	
	            	Double GROSS_income = Double.parseDouble(GROSS_INCOME);
	            	Double MONTHLY_debt = Double.parseDouble(MONTHLY_DEBT);
	            	Double INTEREST_rate= Double.parseDouble(INTEREST_RATE);
	            	Double DOWN_payment= Double.parseDouble(DOWN_PAYMENT);
	            	
	            	// getting affordable value 
	            	double HOUSE_payment = MortgageCalc.HousingPayment(GROSS_income);
	            	double HOUSE_Debt_Payment = MortgageCalc.DebtPayment(GROSS_income, MONTHLY_debt);
	            	double CAN_afford = MortgageCalc.can_afford(HOUSE_Debt_Payment, HOUSE_payment);
	            	
	            
	            	Double MORTAGE = MortgageCalc.present_value(CAN_afford,TERM ,INTEREST_rate,DOWN_payment );
	            	DecimalFormat format = new DecimalFormat("#0.000");
	            	String PV = format.format(MORTAGE);
	            	textField_4.setText("$"+PV);
	            }	            
			});
			
			
			textField_3 = new JTextField();
			textField_3.setBounds(126, 197, 86, 20);
			frame.getContentPane().add(textField_3);
			textField_3.setColumns(10);
			
			textField_3.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	            
	            	Integer TERM = (Integer)comboBox.getSelectedItem();
	            	String GROSS_INCOME = textField.getText();
	            	String MONTHLY_DEBT= textField_1.getText();
	            	String INTEREST_RATE= textField_2.getText();
	            	String DOWN_PAYMENT= textField_3.getText();
	            	
	            	 
	            	Double GROSS_income = Double.parseDouble(GROSS_INCOME);
	            	Double MONTHLY_debt = Double.parseDouble(MONTHLY_DEBT);
	            	Double INTEREST_rate= Double.parseDouble(INTEREST_RATE);
	            	Double DOWN_payment= Double.parseDouble(DOWN_PAYMENT);
	            	
	            	
	            	double HOUSE_payment = MortgageCalc.HousingPayment(GROSS_income);
	            	double HOUSE_Debt_Payment = MortgageCalc.DebtPayment(GROSS_income, MONTHLY_debt);
	            	double CAN_afford = MortgageCalc.can_afford(HOUSE_Debt_Payment, HOUSE_payment);
	            	
	            	
	            	Double MORTAGE = MortgageCalc.present_value(CAN_afford,TERM ,INTEREST_rate,DOWN_payment );
	            	DecimalFormat format = new DecimalFormat("#0.000");
	            	String PV = format.format(MORTAGE);
	            	textField_4.setText("$"+PV);
	            }	            
			});
			
			
		
			
			
		
		JLabel lblAffordableAmount = new JLabel("Affordable Amount = ");
		lblAffordableAmount.setBounds(244, 64, 134, 14);
		frame.getContentPane().add(lblAffordableAmount);
		
		JLabel lblWhenChangingNumbers = new JLabel("Press Enter to re-calculate if fields have been modified ");
		lblWhenChangingNumbers.setBounds(67, 9, 368, 20);
		frame.getContentPane().add(lblWhenChangingNumbers);
		

		
	}
	}