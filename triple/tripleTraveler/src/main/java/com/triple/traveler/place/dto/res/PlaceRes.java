package com.triple.traveler.place.dto.res;

public class PlaceRes {

	private String placeId;
	private String placeName;
	
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	@Override
	public String toString() {
		return "Place [placeId=" + placeId + ", placeName=" + placeName + "]";
	}
}