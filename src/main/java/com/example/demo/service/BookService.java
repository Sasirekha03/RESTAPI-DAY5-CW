package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo br;
	
	public Book saveinfo(Book b)
	{
		return br.save(b);
	}
	public List<Book> showinfo()
	{
		return br.findAll();
	}
	public List<Book> savedetails(List<Book> b)
	{
		return (List<Book>)br.saveAll(b);
	}
	
	public Optional<Book> showbyid(int id)
	{
		return br.findById(id);
	}
	public String updateinfobyid(int id,Book b)
	{
		br.saveAndFlush(b);
		if(br.existsById(id))
		{
			return "Updated";
		}
		else
		{
			return "Enter valid id";
		}
	}
	public void deletepvid(int id)
	{
		br.deleteById(id);
	}
	

}
