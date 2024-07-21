package model.services;

<<<<<<< HEAD
public class BrazilTaxService extends TaxService {
=======
public class BrazilTaxService implements TaxService {
>>>>>>> 92baee0 (Solução com interface. Indicada.)
	
	@Override
	public Double tax (double basicPayment) {
		if(basicPayment <= 100.0) {
			return basicPayment * 0.2;
		}
		else {
			return basicPayment * 0.15;
		}
	}
}
