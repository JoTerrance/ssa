package es.gorka.edu.dto;

import java.util.Date;

public class BookDTO implements IEntityDTO {

	private String title;
	private String ISBN;
	private String author;
	private Integer yearEdition;
	private Date creationDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getYearEdition() {
		return yearEdition;
	}

	public void setYearEdition(Integer yearEdition) {
		this.yearEdition = yearEdition;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
