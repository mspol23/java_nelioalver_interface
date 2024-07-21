package model.services;

public class USTaxService extends TaxService {

	@Override
	public Double tax (double basicPayment) {

		if(basicPayment <= 100.0) {
			return basicPayment * 0.5;
		}
		else {
			return basicPayment * 0.3;
		}
	}
}
