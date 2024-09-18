package atal.app1.models;

public class EBook {
	private String title;
	private String author;
	private Integer publishDate;
	
	public EBook(String title, String author, Integer publishDate) {
		super();
		this.title = title;
		this.author = author;
		this.publishDate = publishDate;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Integer getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(Integer publishDate) {
		this.publishDate = publishDate;
	}
}
