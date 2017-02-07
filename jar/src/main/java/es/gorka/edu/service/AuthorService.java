package es.gorka.edu.service;

import java.sql.Date;

import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.stereotype.Service;

import es.gorka.edu.dto.UserDTO;
import es.gorka.edu.model.Author;
import es.gorka.edu.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@SpringBean
	AuthorRepository repository;
	
	public boolean insertNewAuthor(Author author) {
		repository.insertNewAuthor(author);
		return true;
	}

}