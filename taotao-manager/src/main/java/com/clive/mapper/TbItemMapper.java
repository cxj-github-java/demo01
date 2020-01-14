package com.clive.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clive.bean.TbItem;
import com.clive.bean.TbitemCat;

public interface TbItemMapper {
	//查询数据库tbitem表里，根据商品编号查询商品信息
	TbItem findTbItemById(Long tbItemId);
	//查询所有商品信息
	List<TbItem> findTbItemByPage(@Param("index") Integer index,@Param("pageSize") Integer pageSize);
	//查询商品表的总合条数
	Integer findAllCount();
	//根据商品id删除商品信息，如果返回数据>0,删除成功，
	//int deleteItemById(@Param("ids") List<Long> ids);
	int updateItemById(@Param("ids") List<Long> ids,@Param("type") Integer type,@Param("date") Date date);
	//搜索关键字
	List<TbItem> searchTbItem(@Param("title") String title,@Param("price") Long price,@Param("cId") Long cId,@Param("page") Integer page,@Param("limit") Integer limit);
	Integer searchCount(@Param("title")String title,@Param("price")Long price, @Param("cId")Long cId);
	//统计商品分类id
	List<TbItem> showEchartsByCId();
	//根据分类id查询商品表中分类的商品数量
	int findTbItemByCIdCount(@Param("cId")Long cId);
	
}
