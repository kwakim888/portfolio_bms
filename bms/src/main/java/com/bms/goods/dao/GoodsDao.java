package com.bms.goods.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.bms.goods.dto.ImageFileDto;

public interface GoodsDao {
	
	public List<Map<String,Object>> selectGoodsList(String sideMenu ) throws DataAccessException;
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException;
	public List<Map<String,Object>> selectGoodsBySearchWord(String searchWord) throws DataAccessException;
	public Map<String,Object> selectGoodsDetail(String goodsId) throws DataAccessException;
	public List<ImageFileDto> selectGoodsDetailImage(String goodsId) throws DataAccessException;

}
