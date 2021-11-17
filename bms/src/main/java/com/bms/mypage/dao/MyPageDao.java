package com.bms.mypage.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.bms.member.dto.MemberDto;
import com.bms.order.dto.OrderDto;

public interface MyPageDao {
	
	public List<OrderDto> selectMyOrderGoodsList(String memberId) throws DataAccessException;
	public List<OrderDto> selectMyOrderInfo(String orderId) throws DataAccessException;
	public List<OrderDto> selectMyOrderHistoryList(Map<String,String> dateMap) throws DataAccessException;
	public void updateMyInfo(Map<String,String> memberMap) throws DataAccessException;
	public MemberDto selectMyDetailInfo(String memberId) throws DataAccessException;
	public void updateMyOrderCancel(String orderId) throws DataAccessException;
	public List<OrderDto> getSearchMyOrders(Map<String, Object> getSearchMyOrderGoods) throws Exception;

}
