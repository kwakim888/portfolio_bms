package com.bms.goods.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bms.goods.dto.ImageFileDto;

@Repository
public class GoodsDaoImpl implements GoodsDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Map<String,Object>> selectGoodsList(String goodsStatus) throws DataAccessException {
	   return sqlSession.selectList("mapper.goods.selectGoodsList" , goodsStatus);	
	}
	
	@Override
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException {
	   return sqlSession.selectList("mapper.goods.selectKeywordSearch" , keyword);
	}
	
	@Override
	public List<Map<String,Object>> selectGoodsBySearchWord(String searchWord) throws DataAccessException{
		 return sqlSession.selectList("mapper.goods.selectGoodsBySearchWord" , searchWord);
	}
	
	@Override
	public Map<String,Object> selectGoodsDetail(String goodsId) throws DataAccessException{
		return sqlSession.selectOne("mapper.goods.selectGoodsDetail" , goodsId);
	}
	
	@Override
	public List<ImageFileDto> selectGoodsDetailImage(String goodsId) throws DataAccessException{
		return sqlSession.selectList("mapper.goods.selectGoodsDetailImage" , goodsId);
	}
	
}
