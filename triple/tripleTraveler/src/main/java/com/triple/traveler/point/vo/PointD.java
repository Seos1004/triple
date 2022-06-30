package com.triple.traveler.point.vo;

public class PointD {
	private int pdId;
	private int pmId;
	private String userId;
	private int pdPoint;
	private String pdSystemType;
	private String pdPointType;
	private String reviewId;
	private String placeId;
	public int getPdId() {
		return pdId;
	}
	public void setPdId(int pdId) {
		this.pdId = pdId;
	}
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
	public int getPdPoint() {
		return pdPoint;
	}
	public void setPdPoint(int pdPoint) {
		this.pdPoint = pdPoint;
	}
	public String getPdSystemType() {
		return pdSystemType;
	}
	public void setPdSystemType(String pdSystemType) {
		this.pdSystemType = pdSystemType;
	}
	public String getPdPointType() {
		return pdPointType;
	}
	public void setPdPointType(String pdPointType) {
		this.pdPointType = pdPointType;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	@Override
	public String toString() {
		return "PointD [pdId=" + pdId + ", pmId=" + pmId + ", userId=" + userId + ", pdPoint=" + pdPoint
				+ ", pdSystemType=" + pdSystemType + ", pdPointType=" + pdPointType + ", reviewId=" + reviewId
				+ ", placeId=" + placeId + "]";
	}
	
}
