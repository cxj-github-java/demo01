package com.clive.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clive.bean.TbItem;

public interface TbItemMapper {
	//查询数据库tbitem表里，根据商品编号查询商品信息
	TbItem findTbItemById(Long tbItemId);
	//查询所有商品信息
	List<TbItem> findTbItemByPage(@Param("index") Integer index,@Param("pageSize") Integer pageSize);
	//查询商品表的总合条数
	Integer findAllCount();
	//根据商品id删除商品信息，如果返回数据>0,删除成功，
	//int deleteItemById(@Param("ids") List<Long> ids);
	int updateItemById(@Param("ids") List<Long> ids,@Param("type") Integer type);
	//搜索关键字
	List<TbItem> searchTbItem(@Param("title") String title,@Param("price") Long price,@Param("sellPoint") String sellPoint,@Param("i") Integer i,@Param("limit") Integer limit);
	Integer searchCount();
}
