/**
 * 
 */
package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookMapper;
import com.entity.Book;
import com.entity.Category;
import com.service.BookService;

/**
 * @author huangdaye
 *
 */
@Service("bookService")
public class BookServiceImpl implements BookService{

	/* (non-Javadoc)
	 * @see com.service.BookService#saveBook(com.entity.Book)
	 */
	
	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public int saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookMapper.saveBook(book);
	}

	/* (non-Javadoc)
	 * @see com.service.BookService#deleteById(int)
	 */
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return bookMapper.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.service.BookService#queryByPage(java.util.Map)
	 */
	@Override
	public List<Book> queryByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Integer page=(Integer) map.get("page");
		Integer pageSize=(Integer) map.get("pageSize");
		
		Integer from=(page-1)*pageSize;
		
		map.put("from", from);
		
		return bookMapper.queryByPage(map);
	}

	/* (non-Javadoc)
	 * @see com.service.BookService#count(java.util.Map)
	 */
	@Override
	public int count(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bookMapper.count(map);
	}

	/* (non-Javadoc)
	 * @see com.service.BookService#queryAll()
	 */
	@Override
	public List<Category> queryAll() {
		// TODO Auto-generated method stub
		return bookMapper.queryAll();
	}

}
