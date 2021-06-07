package com.mahindra.epcfrm.dto;

public class LeadFilterDto {

	private String userMobile;
	private String filterBy;
	private String sortByDate;
	private int limit;

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getFilterBy() {
		return filterBy;
	}

	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
	}

	public String getSortByDate() {
		return sortByDate;
	}

	public void setSortByDate(String sortByDate) {
		this.sortByDate = sortByDate;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
