package com.techelevator.model;

import java.util.List;

public interface PieceDAO {
	
	public List<Piece> getAllPieces();
	
	public List<Piece> searchPieces(String searchTitle, String searchComposer);
	
	public void saveNewPiece(Piece newPiece);

	Piece searchByCatalogueId(int catalogueId);

	List<Piece> searchByGenre(String genre);

	
}