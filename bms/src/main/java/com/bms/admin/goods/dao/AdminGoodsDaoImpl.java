package com.bms.admin.goods.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bms.goods.dto.GoodsDto;
import com.bms.goods.dto.ImageFileDto;

@Repository
public class AdminGoodsDaoImpl  implements AdminGoodsDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertNewGoods(Map<String,Object> newGoodsMap) throws DataAccessException {
		sqlSession.insert("mapper.admin.goods.insertNewGoods" , newGoodsMap);
		
	}
	
	@Override
	public int selectMaxGoodsId() throws DataAccessException {
		return sqlSession.selectOne("mapper.admin.goods.selectMaxGoodsId");
	}
	
	@Override
	public void insertGoodsImageFile(List<ImageFileDto> fileList)  throws DataAccessException {
		for (ImageFileDto imageFileDto : fileList) {
			sqlSession.insert("mapper.admin.goods.insertGoodsImageFile" , imageFileDto);
		}
	}
		
	@Override
	public List<GoodsDto> selectNewGoodsList(Map<String,Object> condMap) throws DataAccessException {
		return sqlSession.selectList("mapper.admin.goods.selectNewGoodsList" , condMap);
	}
	
	@Override
	public Map<String,Object> selectGoodsDetail(int goodsId) throws DataAccessException{
		return sqlSession.selectOne("mapper.admin.goods.selectGoodsDetail" , goodsId);
	}
	
	@Override
	public List<ImageFileDto> selectGoodsImageFileList(int goodsId) throws DataAccessException {
		return sqlSession.selectList("mapper.admin.goods.selectGoodsImageFileList" , goodsId);
	}
	
	@Override
	public void updateGoodsInfo(Map<String,String> goodsMap) throws DataAccessException{
		sqlSession.update("mapper.admin.goods.updateGoodsInfo" , goodsMap);
	}
	
	@Override
	public void deleteGoodsImage(int imageId) throws DataAccessException{
		sqlSession.delete("mapper.admin.goods.deleteGoodsImage" , imageId);
	}
	
//	@Override
//	public void deleteGoodsImage(List fileList) throws DataAccessException{
//		int image_id;
//		for (int i=0; i<fileList.size();i++){
//			ImageFileDto bean=(ImageFileDto) fileList.get(i);
//			image_id=bean.getImage_id();
//			sqlSession.delete("mapper.admin.goods.deleteGoodsImage",image_id);	
//		}
//	}


	@Override
	public void updateGoodsImage(List<ImageFileDto> imageFileList) throws DataAccessException {
		
		for (int i=0; i<imageFileList.size(); i++){
			ImageFileDto imageFileDTO = imageFileList.get(i);
			sqlSession.update("mapper.admin.goods.updateGoodsImage" , imageFileDTO);	
		}
		
	}

	@Override
	public void removeGoodsInfo(int goodsId) throws Exception {
		sqlSession.delete("mapper.admin.goods.removeGoodsInfo" , goodsId);
	}

	@Override
	public void removeGoodsImageInfo(int goodsId) throws Exception {
		sqlSession.delete("mapper.admin.goods.removeGoodsImageInfo" , goodsId);
	}

	

}
