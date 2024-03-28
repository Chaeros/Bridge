package com.ssafy.bridge.attraction.info.dto.request;

public class AttractionInfoListRequest {
	private int sidoCode;
	private int gugunCode;
	private int contentTypeId;
	private String title;
	
	public AttractionInfoListRequest(int sidoCode, int gugunCode, int contentTypeId, String title) {
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.contentTypeId = contentTypeId;
		this.title = title;
	}

	public int getSidoCode() {
		return sidoCode;
	}

	public int getGugunCode() {
		return gugunCode;
	}

	public int getContentTypeId() {
		return contentTypeId;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "AttractionInfoListRequest [sidoCode=" + sidoCode + ", gugunCode=" + gugunCode + ", contentTypeId="
				+ contentTypeId + ", title=" + title + "]";
	}
	
}
