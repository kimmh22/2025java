package com.study.spring.bbs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBbsDao {

	public List<BbsDto> listDao();
	public int countDAO();                          
	public BbsDto viewDAO(String id);                    
	public int writeDAO(String writer, String title, String content); 
	public int deleteDAO(String id);
}
