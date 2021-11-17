package com.bms.order.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bms.order.dto.OrderDto;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Map<String, Object>> listMyOrderGoods(OrderDto orderDto) throws DataAccessException{
		return sqlSession.selectList("mapper.order.selectMyOrderList" , orderDto);
	}
	
	public void insertNewOrder(OrderDto orderDto) throws DataAccessException{
		System.out.println(orderDto);
		sqlSession.insert("mapper.order.insertNewOrder" , orderDto);
	}	
	
	public OrderDto findMyOrder(String orderId) throws DataAccessException{
		return sqlSession.selectOne("mapper.order.selectMyOrder" , orderId);
	}
	
}

