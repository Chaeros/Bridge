package com.ssafy.bridge.bookmark.dto.response;

import java.math.BigDecimal;

public class BookMarkResponse {
	private int myAttractionId;
	private int contentId;
	private int contentTypeId;
	private String title;
	private String addr1;
	private String addr2;
	private String zipcode;
	private String tel;
	private String firstImage;
	private String firstImage2;
	private int readCount;
	private int sidoCode;
	private int gugunCode;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private String mlevel;
	private String description;
	private String memberId;
	
	public BookMarkResponse(int myAttractionId, int contentId, int contentTypeId, String title, String addr1,
			String addr2, String zipcode, String tel, String firstImage, String firstImage2, int readCount,
			int sidoCode, int gugunCode, BigDecimal latitude, BigDecimal longitude, String mlevel, String description,
			String memberId) {
		this.myAttractionId = myAttractionId;
		this.contentId = contentId;
		this.contentTypeId = contentTypeId;
		this.title = title;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
		this.tel = tel;
		this.firstImage = firstImage;
		this.firstImage2 = firstImage2;
		this.readCount = readCount;
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.mlevel = mlevel;
		this.description = description;
		this.memberId = memberId;
	}

	public int getMyAttractionId() {
		return myAttractionId;
	}

	public int getContentId() {
		return contentId;
	}

	public int getContentTypeId() {
		return contentTypeId;
	}

	public String getTitle() {
		return title;
	}

	public String getAddr1() {
		return addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getTel() {
		return tel;
	}

	public String getFirstImage() {
		return firstImage;
	}

	public String getFirstImage2() {
		return firstImage2;
	}

	public int getReadCount() {
		return readCount;
	}

	public int getSidoCode() {
		return sidoCode;
	}

	public int getGugunCode() {
		return gugunCode;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public String getMlevel() {
		return mlevel;
	}

	public String getDescription() {
		return description;
	}

	public String getMemberId() {
		return memberId;
	}

	@Override
	public String toString() {
		return "BookMarkResponse [myAttractionId=" + myAttractionId + ", contentId=" + contentId + ", contentTypeId="
				+ contentTypeId + ", title=" + title + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode
				+ ", tel=" + tel + ", firstImage=" + firstImage + ", firstImage2=" + firstImage2 + ", readCount="
				+ readCount + ", sidoCode=" + sidoCode + ", gugunCode=" + gugunCode + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", mlevel=" + mlevel + ", description=" + description + ", memberId="
				+ memberId + "]";
	}
	
}
