package es.gorka.edu.model;

import java.util.Date;

public class Book implements IEntity<Long> {

	private Long id;
	private String title;
	private String ISBN;
	private String author;
	private Integer yearEdition;
	private Date creationDate;

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((yearEdition == null) ? 0 : yearEdition.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (yearEdition == null) {
			if (other.yearEdition != null)
				return false;
		} else if (!yearEdition.equals(other.yearEdition))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + ISBN + ", yearEdition=" + yearEdition
				+ ", creationDate=" + creationDate + "]";
	}

}
