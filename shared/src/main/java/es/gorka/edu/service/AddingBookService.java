package es.gorka.edu.service;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import es.gorka.edu.model.Book;

@Service
public class AddingBookService {

	private static final Logger logger = LogManager.getLogger(AddingBookService.class.getName());

	public boolean insert(Book book) {
		logger.debug("simulando insercion de un Libro");
		return true;
	}

	public List<Book> searchAll(Book book) {
		List<Book> listBook = new ArrayList<Book>();
		
		return listBook;
	}

}