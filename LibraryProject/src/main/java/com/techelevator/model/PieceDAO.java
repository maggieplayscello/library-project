package com.techelevator.model;

import java.util.List;

public interface PieceDAO {
	
	public List<Piece> getAllPieces();
	
	public List<Piece> searchPieces(String searchTitle, String searchComposer);

	public Piece searchByCatalogueId(Double catalogueId);
	
	public List<Piece> searchByPublisher(String publisher);
	
	public List<Piece> searchByEnsembleType(String ensembleType);
	
	public void saveNewPiece(Piece newPiece);

	
}