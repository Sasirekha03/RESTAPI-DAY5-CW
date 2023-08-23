package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;



@RestController
public class ApiController {
	
	@Autowired
	BookService bs;
	
	@PostMapping("/")
	public boolean add(@RequestBody Book b)
	{
		 bs.saveinfo(b);
		return true;
	}
	@PostMapping("addnstud")
	public boolean addndetails(@RequestBody List<Book> b)
	{
		bs.savedetails(b);
		return true;
	}
	
	@GetMapping("/")
	public List<Book> show()
	{
		return bs.showinfo();
	}
	@GetMapping("showbyid/{id}")
	public Optional<Book> showid(@PathVariable int id)
	{
		return bs.showbyid(id);
	}
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody Book b )
	{
		return bs.updateinfobyid(id, b);
	}
	@DeleteMapping("delid/{id}")
	public boolean deleteinfo(@PathVariable int id)
	{
		bs.deletepvid(id);
		return true ;
	}


}
