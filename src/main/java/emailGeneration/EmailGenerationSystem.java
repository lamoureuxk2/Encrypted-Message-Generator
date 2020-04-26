package emailGeneration;

import customer.*;

public class EmailGenerationSystem {

	public final String BUSINESS_HEADER = "Dear customer,\n\n";
	public final String VIP_HEADER = "Dear esteemed customer,\n\n";
	public final String FREQUENT_HEADER = "Dear special customer,\n\n";
	public final String NEW_HEADER = "Dear new customer,\n\n";
	public final String RETURNING_HEADER = "Dear returning customer,\n\n";
	public final String BUSINESS_FOOTER = "Best wishes,\n";
	public final String VIP_FOOTER = "Best regards,\n";
	public final String FREQUENT_FOOTER = "We are glad to serve you,\n";
	public final String NEW_FOOTER = "We hope to serve you soon,\n";
	public final String RETURNING_FOOTER = "Thank you for your business,\n";
	
	public String generateEmail(Customer c, String body, String name) {
		if( c.getType().equals("Business")) return this.genBusinessEmail(body, name);
		else if( c.getType().equals("New")) return this.genNewCustomerEmail(body, name);
		else if( c.getType().equals("Frequent")) return this.genFrequentEmail(body, name);
		else if( c.getType().equals("Returning")) return this.genReturningEmail(body, name);
		else if( c.getType().equals("VIP")) return this.genVipEmail(body, name);
		else return this.genBusinessEmail(body, name);
	} 
	
	public String genBusinessEmail(String body, String name) {
		return BUSINESS_HEADER + body + "\n\n" + BUSINESS_FOOTER + name;
	}
	public String genReturningEmail(String body, String name) {
		return RETURNING_HEADER + body + "\n\n" + RETURNING_FOOTER + name;
	}
	public String genVipEmail(String body, String name) {
		return VIP_HEADER + body + "\n\n" + VIP_FOOTER + name;
	}
	public String genNewCustomerEmail(String body, String name) {
		return NEW_HEADER + body + "\n\n" + NEW_FOOTER + name;
	}
	public String genFrequentEmail(String body, String name) {
		return FREQUENT_HEADER + body + "\n\n" + FREQUENT_FOOTER + name;
	}
	

}
