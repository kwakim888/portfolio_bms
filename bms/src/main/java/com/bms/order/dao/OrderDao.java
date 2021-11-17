package com.bms.order.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.bms.order.dto.OrderDto;

public interface OrderDao {
	
	public List<Map<String, Object>> listMyOrderGoods(OrderDto ordtDto) throws DataAccessException;
	public void insertNewOrder(OrderDto ordtDto) throws DataAccessException;
	public OrderDto findMyOrder(String orderId) throws DataAccessException;

}
