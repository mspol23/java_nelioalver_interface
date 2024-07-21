package model.services;

public class BrazilTaxService {
	
	public double tax (double basicPayment) {
		if(basicPayment <= 100.0) {
			return basicPayment * 0.2;
		}
		else {
			return basicPayment * 0.15;
		}
	}
}
