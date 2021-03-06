package com.bms.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.cart.dto.CartDto;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertCart(CartDto cdto) throws Exception {
		sqlSession.insert("mapper.cart.insertCart" ,cdto);
	}

	@Override
	public List<CartDto> getAllCart() throws Exception {
		return sqlSession.selectList("mapper.cart.getAllCart");
	}

	@Override
	public void deleteCart(String[] data) throws Exception {
		for (int i = 0; i < data.length; i++) {
			sqlSession.delete("mapper.cart.deleteCart" , data[i]);
		}
	}

	@Override
	public CartDto getOneCart(String[] data) throws Exception {
		return sqlSession.selectOne("mapper.cart.getOneCart" , data);
	}

}
