package com.techelevator.model;


import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


@Component
public class JDBCPieceDAO implements PieceDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCPieceDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private Piece mapRowToPiece(SqlRowSet row) {
		Piece piece = new Piece();
		piece.setCatalogueId(row.getInt("call_num"));
		piece.setComposerLastName(row.getString("composer_last"));
		piece.setComposerFirstName(row.getString("composer_first"));
		piece.setTitle(row.getString("title"));
		piece.setGenre(row.getString("genre"));
		piece.setPublisher(row.getString("publisher"));
		piece.setSoloInstrument(row.getString("solo_instrument"));
		return piece;
	}
	
	@Override
	public List<Piece> getAllPieces() {
		List<Piece> allPieces = new ArrayList<>();
		String sql = "SELECT * FROM library ORDER BY composer_last";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			allPieces.add(mapRowToPiece(results));
		}
		return allPieces;
	}
	
	@Override
	public List<Piece> searchPieces(String searchTitle, String searchComposer) {
		List<Piece> allPieces = new ArrayList<>();		
		String sql = "SELECT * FROM library WHERE UPPER(title) LIKE ? AND UPPER(composer_last) LIKE ? ORDER BY composer_last";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + searchTitle.toUpperCase() + "%", searchComposer.toUpperCase() + "%");
		while (results.next()) {
			allPieces.add(mapRowToPiece(results));
		}
		return allPieces;
	}
	
	@Override
	public Piece searchByCatalogueId(Double catalogueId) {
		Piece pieceById = null;
		String sql = "SELECT * FROM library WHERE call_num = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, catalogueId);
		if (result.next()) {
			pieceById = mapRowToPiece(result);
		}
		return pieceById;
	}

	@Override
	public void saveNewPiece(Piece newPiece) {
		String sql = "INSERT INTO library(call_num, composer_last, composer_first, title, genre, publisher) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, newPiece.getCatalogueId(), newPiece.getComposerLastName(), newPiece.getComposerFirstName(), newPiece.getTitle(), newPiece.getGenre(), newPiece.getPublisher());		
	}


}