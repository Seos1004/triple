package com.triple.traveler.point.dto.res;

public class PointRes {

	private String pmId;
	private String userId;
	private String updateDate;
	private String pmPoint;
	private String createDate;
	public String getPmId() {
		return pmId;
	}
	public void setPmId(String pmId) {
		this.pmId = pmId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getPmPoint() {
		return pmPoint;
	}
	public void setPmPoint(String pmPoint) {
		this.pmPoint = pmPoint;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "PointRes [pmId=" + pmId + ", userId=" + userId + ", updateDate=" + updateDate + ", pmPoint=" + pmPoint
				+ ", createDate=" + createDate + "]";
	}
}
