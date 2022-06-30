package com.triple.traveler.review.vo;

public class Review {
	private String reviewId;	
	private String reviewContent;
	private String userId;
	private String attachedPhotoIds;
	private String placeId;
	private String reviewDeleteYn;
	private String updateData;
	private String createDate;
	private String deleteData;
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAttachedPhotoIds() {
		return attachedPhotoIds;
	}
	public void setAttachedPhotoIds(String attachedPhotoIds) {
		this.attachedPhotoIds = attachedPhotoIds;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getReviewDeleteYn() {
		return reviewDeleteYn;
	}
	public void setReviewDeleteYn(String reviewDeleteYn) {
		this.reviewDeleteYn = reviewDeleteYn;
	}
	public String getUpdateData() {
		return updateData;
	}
	public void setUpdateData(String updateData) {
		this.updateData = updateData;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getDeleteData() {
		return deleteData;
	}
	public void setDeleteData(String deleteData) {
		this.deleteData = deleteData;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", reviewContent=" + reviewContent + ", userId=" + userId
				+ ", attachedPhotoIds=" + attachedPhotoIds + ", placeId=" + placeId + ", reviewDeleteYn="
				+ reviewDeleteYn + ", updateData=" + updateData + ", createDate=" + createDate + ", deleteData="
				+ deleteData + "]";
	}
}
