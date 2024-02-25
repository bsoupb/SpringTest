package com.bsoupb.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsoupb.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {

	public List<Favorite> selectFavorite();
	
	public int insertFavorite(@Param("name") String name, @Param("url") String url);
	
	public int selectCountUrl(@Param("url") String url);
	
	public int deleteUrl(@Param("id") int id);
}
