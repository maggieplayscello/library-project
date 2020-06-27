  
package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Piece;
import com.techelevator.model.PieceDAO;

@Controller
public class MainController {
		
	@Autowired 
	private PieceDAO pieceDAO;
	
	@RequestMapping(path= {"/home"}, method=RequestMethod.GET)
	public String displayHome(ModelMap map) {
		return "home";
	}
	
	@RequestMapping("/fullCatalogue")
	public String displayCatalogue(ModelMap map) {
		List<Piece> piece = pieceDAO.getAllPieces();
		map.put("allPieces", piece);
		return "fullCatalogue";
	}
	
	@RequestMapping("/catalogueSearchResults")
	public String displayCatalogueSearch(ModelMap map, String searchTitle, String searchComposer) {
		List<Piece> piece = pieceDAO.searchPieces(searchTitle, searchComposer);
		map.put("allPieces", piece);
		return "fullCatalogue";
	}
	
	@RequestMapping("/searchByIdResults")
	public String displayCatalogueSearchById(@RequestParam int catalogueId, ModelMap map) {
		Piece piece = pieceDAO.searchByCatalogueId(catalogueId);
		map.put("catalogueId", piece);
		return "pieceDetails";
	}
	
	
	@RequestMapping("/pieceDetails")
	public String displayPieceDetails(@RequestParam int catalogueId, ModelMap map) {
		Piece piece = pieceDAO.searchByCatalogueId(catalogueId);
		map.put("catalogueId", piece);
		return "pieceDetails";
	}


	@RequestMapping(path="/add", method=RequestMethod.GET)
	public String displayAddForm() {
		return "addForm";
	}
	
	@RequestMapping(path="/processAdd", method=RequestMethod.POST)
	public String processAdd(@RequestParam int catalogueId, 
			@RequestParam String composerLastName, 
			@RequestParam String composerFirstName, 
			@RequestParam String title, 
			@RequestParam String genre, 
			@RequestParam String publisher, 
			ModelMap map, RedirectAttributes ra) {
		Piece newPiece = new Piece();
		newPiece.setCatalogueId(catalogueId);
		newPiece.setComposerLastName(composerLastName);
		newPiece.setComposerFirstName(composerFirstName);
		newPiece.setTitle(title);
		newPiece.setGenre(genre);
		newPiece.setPublisher(publisher);
		pieceDAO.saveNewPiece(newPiece);
		ra.addFlashAttribute("pieceName", newPiece);
		return "redirect:/fullCatalogue";
	}

	@RequestMapping("/browse")
	public String browse() {
		return "browse";
	}
	
	@RequestMapping("/browseSelection")
	public String browseSelection(ModelMap map, String genre) {
		List<Piece> piece = pieceDAO.searchByGenre(genre);
		map.put("allPieces", piece);
		return "browse";
	}
}