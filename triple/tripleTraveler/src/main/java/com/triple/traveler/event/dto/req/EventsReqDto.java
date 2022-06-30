package com.triple.traveler.event.dto.req;

public class EventsReqDto {
	private String type;
	private String action;
	private String reviewId;
	private String content;
	private String[] attachedPhotoIds;
	private String userId;
	private String placeId;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String[] getAttachedPhotoIds() {
		return attachedPhotoIds;
	}
	public void setAttachedPhotoIds(String[] attachedPhotoIds) {
		this.attachedPhotoIds = attachedPhotoIds;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	@Override
	public String toString() {
		return "EventsReqDto [type=" + type + ", action=" + action + ", reviewId=" + reviewId + ", content=" + content
				+ ", attachedPhotoIds=" + attachedPhotoIds + ", userId=" + userId + ", placeId=" + placeId + "]";
	}
	
	
}
