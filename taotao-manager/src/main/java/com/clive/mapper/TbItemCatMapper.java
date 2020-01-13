package com.clive.mapper;

import java.util.List;

import com.clive.bean.TbitemCat;

public interface TbItemCatMapper {

	List<TbitemCat> findTbItemCatById(Long parentId);

}
