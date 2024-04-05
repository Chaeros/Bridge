package com.ssafy.bridge.bookmark.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
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
	@Override
	public boolean searchBookMark(int contentId) throws SQLException {
		return bookMarkDao.isInBookMark(contentId);
	}
	
	@Override
	public int removeByContentIdBookMark(int contentId) throws SQLException {
		return bookMarkDao.deleteByContentIdBookMark(contentId);
	}
	
	public static int parent[];
	
	@Override
	public List<BookMarkResponse> optimalRouteBookMarkList(String memberId) throws SQLException {
		List<BookMarkResponse> bookMarkResponses = bookMarkDao.selectBookMarkList(memberId);
		
		class Node{
			int start;
			int end;
			double distance;
			public Node(int start, int end, double distance) {
				this.start = start;
				this.end = end;
				this.distance = distance;
			}
			public int getStart() {
				return start;
			}
			public int getEnd() {
				return end;
			}
			public double getDistance() {
				return distance;
			}
		}
		
		List<Node> nodes = new ArrayList<>();
		
		int listSize = bookMarkResponses.size();
		parent = new int[listSize];
		List<List<Node>> list = new ArrayList<>();
		for ( int i = 0 ; i < listSize ; ++i ) {
			list.add(new ArrayList());
			parent[i] = i;
		}
		
		for ( int i = 0 ; i < listSize ; ++i ) {
			for ( int j = 0 ; j < listSize ; ++j ) {
				if ( i != j ) {
					BookMarkResponse position1 = bookMarkResponses.get(i);
					BookMarkResponse position2 = bookMarkResponses.get(j);
					list.get(i).add(new Node(i,j,calculateDistance(position1.getLatitude(), position1.getLongitude(), position2.getLatitude(), position2.getLongitude())));
				}
			}
		}
		return null;
	}
	
    public static double calculateDistance(BigDecimal lat1, BigDecimal lon1, BigDecimal lat2, BigDecimal lon2) {
        double lat1Rad = Math.toRadians(lat1.doubleValue());
        double lon1Rad = Math.toRadians(lon1.doubleValue());
        double lat2Rad = Math.toRadians(lat2.doubleValue());
        double lon2Rad = Math.toRadians(lon2.doubleValue());

        final double R = 6371.0;

        double dlon = lon2Rad - lon1Rad;
        double dlat = lat2Rad - lat1Rad;

        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
    
    
}
