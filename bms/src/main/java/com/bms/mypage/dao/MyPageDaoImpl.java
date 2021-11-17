package com.bms.mypage.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bms.member.dto.MemberDto;
import com.bms.order.dto.OrderDto;

@Repository
public class MyPageDaoImpl implements MyPageDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<OrderDto> selectMyOrderGoodsList(String memberId) throws DataAccessException{
		return sqlSession.selectList("mapper.mypage.selectMyOrderGoodsList" , memberId);
	}
	
	
	public List<OrderDto> selectMyOrderInfo(String orderId) throws DataAccessException{
		return sqlSession.selectList("mapper.mypage.selectMyOrderInfo" , orderId);
	}	

	
	public List<OrderDto> selectMyOrderHistoryList(Map<String,String> dateMap) throws DataAccessException{
		return sqlSession.selectList("mapper.mypage.selectMyOrderHistoryList" , dateMap);
	}
	
	
	public void updateMyInfo(Map<String,String> memberMap) throws DataAccessException{
		sqlSession.update("mapper.mypage.updateMyInfo" , memberMap);
	}
	
	
	public MemberDto selectMyDetailInfo(String memberId) throws DataAccessException{
		return sqlSession.selectOne("mapper.mypage.selectMyDetailInfo" , memberId);
	}

	
	public void updateMyOrderCancel(String orderId) throws DataAccessException{
		sqlSession.update("mapper.mypage.updateMyOrderCancel" , orderId);
	}

	@Override
	public List<OrderDto> getSearchMyOrders(Map<String, Object> getSearchMyOrderGoods) throws Exception {
		return sqlSession.selectList("mapper.mypage.getSearchMyOrders" , getSearchMyOrderGoods);
	}
}
