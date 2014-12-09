package main;

public class MortgageCalc {
	static double housingpayment;
	static double debtpayment;
	static double Monthly_rate;
	static double Present_Value;
	public static double DebtPayment(double grossincome, double monthlydebt){
		debtpayment = (((grossincome/12)*0.36)- monthlydebt);
		return debtpayment;
	}

	public static double HousingPayment(double grossincome){
		housingpayment = ((grossincome/12)*0.18);
		return housingpayment;	
	}

	public static double can_afford(double debtpayment, double housingpayment){
		if (debtpayment<housingpayment){
			return debtpayment;
		}
		else{
			return housingpayment;}
	}


	public static double present_value(double payment_used, double Term , double rate, double down_payment ){
		double Rate= rate/100;
		Monthly_rate = Math.pow(1+(Rate/12),Term*12);
		Present_Value= (payment_used)*(((1-(1/Monthly_rate))/(Rate/12))+down_payment);
		return Present_Value; 
	}
}


