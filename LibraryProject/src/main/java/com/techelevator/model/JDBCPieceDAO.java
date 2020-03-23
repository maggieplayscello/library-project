package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCPieceDAO implements PieceDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCPieceDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private Piece mapRowToPiece(SqlRowSet row) {
		Piece piece = new Piece();
		piece.setCatalogueId(row.getDouble("call_num"));
		piece.setComposer(row.getString("composer"));
		piece.setTitle(row.getString("title"));
		piece.setEnsembleType(row.getString("ensemble"));
		piece.setPublisher(row.getString("publisher"));
		return piece;
	}
	
	@Override
	public List<Piece> getAllPieces() {
		List<Piece> allPieces = new ArrayList<>();
		String sql = "SELECT * FROM library ORDER BY composer";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
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
	public List<Piece> searchByComposer(String composer) {
		List<Piece> allPiecesByComposer = new ArrayList<>();
		String sql = "SELECT * FROM library WHERE composer LIKE ? ORDER BY title";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,  "%" + composer + "%");
		while (results.next()) {
			allPiecesByComposer.add(mapRowToPiece(results));
		}
		return allPiecesByComposer;	
	}

	@Override
	public List<Piece> searchByPublisher(String publisher) {
		List<Piece> allPiecesByPublisher = new ArrayList<>();
		String sql = "SELECT * FROM library WHERE publisher LIKE ? ORDER BY composer, title";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,  "%" + publisher + "%");
		while (results.next()) {
			allPiecesByPublisher.add(mapRowToPiece(results));
		}
		return allPiecesByPublisher;	
	}

	@Override
	public List<Piece> searchByTitle(String title) {
		List<Piece> allPiecesByTitle = new ArrayList<>();
		String sql = "SELECT * FROM library WHERE publisher LIKE ? ORDER BY composer, title";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,  "%" + title + "%");
		while (results.next()) {
			allPiecesByTitle.add(mapRowToPiece(results));
		}
		return allPiecesByTitle;	
	}

	@Override
	public List<Piece> searchByEnsembleType(String ensembleType) {
		List<Piece> allPiecesByEnsemble = new ArrayList<>();
		String sql = "SELECT * FROM library WHERE publisher LIKE ? ORDER BY composer, title";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,  "%" + ensembleType + "%");
		while (results.next()) {
			allPiecesByEnsemble.add(mapRowToPiece(results));
		}
		return allPiecesByEnsemble;	
	}

	@Override
	public void saveNewPiece(Piece newPiece) {
		String sql = "INSERT INTO library(call_num, composer, title, ensemble, publisher) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, newPiece.getCatalogueId(), newPiece.getComposer(), newPiece.getTitle(), newPiece.getEnsembleType(), newPiece.getPublisher());		
	}

}

