package com.techelevator.model;

import java.util.List;

public interface PieceDAO {
	
	public List<Piece> getAllPieces();
	
	public Piece searchByCatalogueId(Double catalogueId);
	
	public List<Piece> searchByComposer(String composer);
	
	public List<Piece> searchByPublisher(String publisher);
	
	public List<Piece> searchByTitle(String title);
	
	public List<Piece> searchByEnsembleType(String ensembleType);
	
	public void saveNewPiece(Piece newPiece);
	
}