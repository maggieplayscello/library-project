package com.techelevator.model;

public class Piece {
	
	private int catalogueId;
	private String composerLastName;
	private String composerFirstName;
	private String title;
	private String genre;
	private String publisher;
	private String soloInstrument;
	
	public Piece() {
	}
		
	public Piece(int catalogueId, String composerLastName, String composerFirstName, String title, String genre, String publisher, String soloInstrument) {
		super();
		this.catalogueId = catalogueId;
		this.composerLastName = composerLastName;
		this.composerFirstName = composerFirstName;
		this.title = title;
		this.genre = genre;
		this.publisher = publisher;
		this.soloInstrument = soloInstrument;
	}
	

	public int getCatalogueId() {
		return catalogueId;
	}
	public void setCatalogueId(int catalogueId) {
		this.catalogueId = catalogueId;
	}
	public String getComposerLastName() {
		return composerLastName;
	}
	public void setComposerLastName(String composerLastName) {
		this.composerLastName = composerLastName;
	}
	public String getComposerFirstName() {
		return composerFirstName;
	}
	public void setComposerFirstName(String composerFirstName) {
		this.composerFirstName = composerFirstName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getSoloInstrument() {
		return soloInstrument;
	}
	public void setSoloInstrument(String soloInstrument) {
		this.soloInstrument = soloInstrument;
	}

	@Override
	public String toString() {
		return "Piece [catalogueId=" + catalogueId + ", composer=" + composerFirstName + " " + composerLastName + ", title=" + title + ", genre="
				+ genre + ", publisher=" + publisher + ", soloInstrument=" + soloInstrument + "]";
	}
		
}