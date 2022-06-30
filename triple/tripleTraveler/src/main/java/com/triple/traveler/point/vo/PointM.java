package com.triple.traveler.point.vo;

public class PointM {
	private int pmId;
	private String userId;
	private int pmPoint;
	public int getPmId() {
		return pmId;
	}
	public void setPmId(int pmId) {
		this.pmId = pmId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPmPoint() {
		return pmPoint;
	}
	public void setPmPoint(int pmPoint) {
		this.pmPoint = pmPoint;
	}
	@Override
	public String toString() {
		return "PointM [pmId=" + pmId + ", userId=" + userId + ", pmPoint=" + pmPoint + "]";
	}
	
}
