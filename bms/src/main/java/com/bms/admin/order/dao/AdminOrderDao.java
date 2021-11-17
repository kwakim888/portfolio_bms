package com.bms.admin.order.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.bms.member.dto.MemberDto;
import com.bms.order.dto.OrderDto;

public interface AdminOrderDao {
	
	public List<OrderDto> selectNewOrderList(Map<String,Object> condMap) throws DataAccessException;
	public void updateDeliveryState(Map<String, String> deliveryMap) throws DataAccessException;
	public Map<String,Object> selectOrderDetail(int orderId) throws DataAccessException;
	public MemberDto selectOrderer(String memberId) throws DataAccessException;
	
}
