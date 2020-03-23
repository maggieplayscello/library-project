package com.techelevator.model;

public class Piece {
	
	private Double catalogueId;
	private String composer;
	private String title;
	private String ensembleType;
	private String publisher;

	
	public Piece() {
	}
		
	public Piece(int catalogueId, String composer, String title, String ensembleType, String publisher) {
		super();
		this.catalogueId = (double) catalogueId;
		this.composer = composer;
		this.title = title;
		this.ensembleType = ensembleType;
		this.publisher = publisher;
	}
	

	public Double getCatalogueId() {
		return catalogueId;
	}
	public void setCatalogueId(Double catalogueId) {
		this.catalogueId = catalogueId;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEnsembleType() {
		return ensembleType;
	}
	public void setEnsembleType(String ensembleType) {
		this.ensembleType = ensembleType;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Piece [catalogueId=" + catalogueId + ", composer=" + composer + ", title=" + title + ", ensembleType="
				+ ensembleType + ", publisher=" + publisher + "]";
	}
		
}
