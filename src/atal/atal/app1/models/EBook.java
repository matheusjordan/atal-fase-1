package atal.app1.models;

public class EBook {
	private String title;
	private String author;
	private Integer publishDate;
	private Integer id;
	
	public EBook(Integer id, String title, String author, Integer publishDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishDate = publishDate;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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
