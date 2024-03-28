package com.ssafy.bridge.bookmark.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.attraction.info.dao.AttractionInfoDao;
import com.ssafy.bridge.attraction.info.dao.AttractionInfoDaoImpl;
import com.ssafy.bridge.attraction.info.dto.response.AttractionInfoResponse;
import com.ssafy.bridge.bookmark.dao.BookMarkDao;
import com.ssafy.bridge.bookmark.dao.BookMarkDaoImpl;
import com.ssafy.bridge.bookmark.dto.request.BookMarkAddRequest;
import com.ssafy.bridge.bookmark.dto.response.BookMarkResponse;

public class BookMarkServiceImpl implements BookMarkService {
	private static BookMarkService bookMarkService;
	private BookMarkDao bookMarkDao;
	private AttractionInfoDao attractionInfoDao;
	private BookMarkServiceImpl() {
		attractionInfoDao = AttractionInfoDaoImpl.getInstance();
		bookMarkDao = BookMarkDaoImpl.getInstance();
	}
	public static BookMarkService getInstance() {
		if ( bookMarkService == null ) {	
			bookMarkService = new BookMarkServiceImpl();
		}
		return bookMarkService;
	}
	@Override
	public int addBookMark(int contentId, String memberId) throws SQLException {
		return bookMarkDao.insertBookMark(
				transferAttractionInfoToBookMarkRequest(
						attractionInfoDao.selectAttractionInfo(contentId), memberId)
				);
	}
	@Override
	public int removeBookMark(int attractionId) throws SQLException {
		return bookMarkDao.deleteBookMark(attractionId);
	}
	
	public BookMarkAddRequest transferAttractionInfoToBookMarkRequest(AttractionInfoResponse attractionInfoResponse, String memberId) {
		return new BookMarkAddRequest(
				attractionInfoResponse.getContentId(), 
				attractionInfoResponse.getContentTypeId(), 
				attractionInfoResponse.getTitle(),
				attractionInfoResponse.getAddr1(),
				attractionInfoResponse.getAddr2(),
				attractionInfoResponse.getZipcode(),
				attractionInfoResponse.getTel(),
				attractionInfoResponse.getFirstImage(),
				attractionInfoResponse.getFirstImage2(),
				attractionInfoResponse.getReadCount(),
				attractionInfoResponse.getSidoCode(),
				attractionInfoResponse.getGugunCode(),
				attractionInfoResponse.getLatitude(),
				attractionInfoResponse.getLongitude(),
				attractionInfoResponse.getMlevel(),
				attractionInfoResponse.getDescription(),
				memberId
				);
	}
	@Override
	public List<BookMarkResponse> displayBookMarkList(String memberId) throws SQLException {
		return bookMarkDao.selectBookMarkList(memberId);
	}
}
