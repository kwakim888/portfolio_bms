
package com.bms.admin.goods.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.bms.goods.dto.GoodsDto;
import com.bms.goods.dto.ImageFileDto;

public interface AdminGoodsDao {
	
	public void insertNewGoods(Map<String,Object> newGoodsMap) throws DataAccessException;
	public int selectMaxGoodsId() throws DataAccessException;
	public List<GoodsDto>selectNewGoodsList(Map<String,Object> condMap) throws DataAccessException;
	public Map<String,Object> selectGoodsDetail(int goodsId) throws DataAccessException;
	public List<ImageFileDto> selectGoodsImageFileList(int goodsId) throws DataAccessException;
	public void insertGoodsImageFile(List<ImageFileDto> fileList)  throws DataAccessException;
	public void updateGoodsInfo(Map<String,String> goodsMap) throws DataAccessException;
	public void updateGoodsImage(List<ImageFileDto> imageFileList) throws DataAccessException;
	public void deleteGoodsImage(int image_id) throws DataAccessException;
	public void removeGoodsInfo(int goodsId) throws Exception;
	public void removeGoodsImageInfo(int goodsId) throws Exception;
	
	
}
