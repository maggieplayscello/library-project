package com.techelevator.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Piece;
import com.techelevator.model.PieceDAO;

@Controller
public class MainController {
		
	@Autowired 
	private PieceDAO pieceDAO;
	
	@RequestMapping("/home")
	public String displayHome(ModelMap map) {
		return "home";
	}
	
	@RequestMapping("/fullCatalogue")
	public String displayCatalogue(ModelMap map) {
		List<Piece> piece = pieceDAO.getAllPieces();
		map.put("allPieces", piece);
		return "fullCatalogue";
	}
	
	@RequestMapping("/details")
	public String displayPieceDetails(@RequestParam Double catalogueId, ModelMap map) {
		Piece piece = pieceDAO.searchByCatalogueId(catalogueId);
		map.put("catalogueId", piece);
		return "details";
	}
	
	@RequestMapping("/search")
	public String searchHome() {
		return "search";
	}
	
	@RequestMapping("/searchResult")
	public String searchCatalogue(@RequestParam(required=false) String composer, ModelMap map) {
		List<Piece> matchingPieces = pieceDAO.searchByComposer(composer);
		map.put("pieces", matchingPieces);
		return "searchResult";
	}
	
	@RequestMapping("/browse")
	public String browse() {
		return "browse";
	}
	
	@RequestMapping(path = "/browseSelection", method = RequestMethod.GET)
	public String browseView(@RequestParam String ensembleType, ModelMap map) {
		List <Piece> piecesByEnsemble = pieceDAO.searchByEnsembleType(ensembleType);
		map.put("pieceList", piecesByEnsemble);
		return "browseSelection";
	}
	
}
