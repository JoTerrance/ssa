package es.gorka.edu.service;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import es.gorka.edu.model.Author;

@Service
public class AddingAuthorService {

	private static final Logger logger = LogManager.getLogger(AddingAuthorService.class.getName());

	public boolean insert(Author author) {
		logger.debug("simulando insercion de un Autor");
		return true;
	}

	public List<Author> searchAll(Author author) {
		List<Author> listAuthor = new ArrayList<Author>();
		
		return listAuthor;
	}

}