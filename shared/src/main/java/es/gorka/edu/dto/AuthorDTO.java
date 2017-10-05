package es.gorka.edu.dto;

import java.sql.Date;
import java.util.List;

public class AuthorDTO implements IEntityDTO {

	private Long id;
	private String name;
	private Date DateOfBirth;
	private List<BookDTO> books;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public List<BookDTO> getBooks() {
		return books;
	}
	
	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
}
