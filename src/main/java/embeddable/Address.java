package embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String street;
	private String state;
	private String  country;
	private String zipCode;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + "]";
	}
	
	
}
