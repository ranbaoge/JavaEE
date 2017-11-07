package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Book;
import com.entity.Category;

public interface BookMapper {
    
	/**
	 * 保存书籍种类
	 * @param book
	 * @return
	 */
	int saveBook(Book book);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int deleteById(int id);
	
	/**
	 * 分页模糊查询
	 * @param map
	 * map:page,pageSize,name,author,birthday
	 * @return
	 */
	List<Book> queryByPage(Map<String, Object> map);
	
	/**
	 * 对模糊查询的总记录数进行统计
	 * @param map
	 * @return
	 */
	int count(Map<String, Object> map);
	
	List<Category> queryAll();
}