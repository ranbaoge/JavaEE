/**
 * 
 */
package com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.entity.Book;
import com.entity.Category;
import com.service.BookService;

/**
 * @author huangdaye
 *
 */
@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	@RequestMapping("save.do")
	public String save(Book book,Model model,HttpServletRequest request) {
		int rs = bookService.saveBook(book);
		System.out.println("-------------------------------->"+rs);
		return query(1, null, null, null,request, model);
	}
	
	
	@RequestMapping("delete/{id}.do")
	public String delete(@PathVariable int id,Model model,HttpServletRequest request) {
		int rs = bookService.deleteById(id);
		System.out.println("-------------------------------->"+rs);
		return query(1, null, null, null,request, model);
	}
	
	@RequestMapping("query/{page}.do")
	public String query(@PathVariable(required=true) int page,
			            String name,
			            String author,
			            @DateTimeFormat(pattern="yyyy-MM-dd") Date publishDate,
			            HttpServletRequest request,
			            Model model) {
		
		//获取服务器的ip和端口号
		String ipAddr = request.getLocalAddr();
		int port = request.getLocalPort();
		System.out.println(ipAddr+"\t"+port);
		
		
		//计算模糊的总记录数
		Map<String, Object> map=new HashMap<>();
		map.put("name", name);
		map.put("author", author);
		map.put("publishDate", publishDate);
		int count = bookService.count(map);
		
		//定义页面容量pageSize
		int pageSize=8;
		
		//计算页数
		int lastPage=count%pageSize==0?count/pageSize:count/pageSize+1;
		
		//准备分页参数
		map.put("page", page);
		map.put("pageSize", pageSize);
		
		//进行分页查询
		List<Book> books = bookService.queryByPage(map);
		
		
		//封装当前页数据
		model.addAttribute("page", page);
		//封装尾页
		model.addAttribute("lastPage", lastPage);
		//封装数据
		model.addAttribute("books", books);
		//封装模糊查询参数
		model.addAttribute("name", name);
		model.addAttribute("author", author);
		
		DateFormat format=null;
		String strDate=null;
		if(publishDate!=null) {
			format= new SimpleDateFormat("yyyy-MM-dd");
			strDate= format.format(publishDate);
		}
		
		model.addAttribute("publishDate", strDate);
		
		
		return "show";
	}
	
	/**
	 * 通过ajax来加载书籍数据
	 * @return
	 */
	@RequestMapping("queryAll.do")
	@ResponseBody
	public String queryAll() {
		
		List<Category> categorys = bookService.queryAll();
		
		String json=JSON.toJSONString(categorys,true);
		System.out.println(json);
		
		return json;
	}
	
}
