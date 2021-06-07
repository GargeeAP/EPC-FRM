package com.mahindra.epcfrm.dto;

public class GetLeadNamesResponseDto {

	private String firstName;
	private String lastName;
	private Long faMobile;

	
	public GetLeadNamesResponseDto(String firstName, String lastName, Long faMobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.faMobile = faMobile;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getFaMobile() {
		return faMobile;
	}

	public void setFaMobile(long faMobile) {
		this.faMobile = faMobile;
	}

}
