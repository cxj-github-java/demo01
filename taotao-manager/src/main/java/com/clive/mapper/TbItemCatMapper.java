package com.clive.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clive.bean.TbitemCat;

public interface TbItemCatMapper {
	//根据parentid查询商品分类信息
	List<TbitemCat> findTbItemCatById(Long parentId);
	//根据商品分类id查询商品分类信息
	TbitemCat getTbItemCatById(@Param("id")Long id);

}
