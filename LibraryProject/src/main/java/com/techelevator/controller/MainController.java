  
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
	
	@RequestMapping("/catalogueSearchResults")
	public String displayCatalogueSearch(@RequestParam(required = false) String request, @RequestParam(required = false) String searchTitle, @RequestParam(required = false) String searchComposer, ModelMap map) {
		List<Piece> piece = pieceDAO.searchPieces(searchTitle, searchComposer);
		map.put("allPieces", piece);
		map.addAttribute("request", request);
		return "fullCatalogue";
	}
	
	
	@RequestMapping("/pieceDetails")
	public String displayPieceDetails(@RequestParam Double catalogueId, ModelMap map) {
		Piece piece = pieceDAO.searchByCatalogueId(catalogueId);
		map.put("catalogueId", piece);
		return "pieceDetails";
	}
	
	@RequestMapping("/search")
	public String searchHome() {
		return "search";
	}


	@RequestMapping(path="/add", method=RequestMethod.GET)
	public String displayAddForm() {
		return "addForm";
	}
	
	@RequestMapping(path="/processAdd", method=RequestMethod.POST)
	public String processAdd(@RequestParam int catalogueId, 
			@RequestParam String composer, 
			@RequestParam String title, 
			@RequestParam String ensembleType, 
			@RequestParam String publisher, 
			ModelMap map, RedirectAttributes ra) {
		Piece newPiece = new Piece();
		newPiece.setCatalogueId((double) catalogueId);
		newPiece.setComposer(composer);
		newPiece.setTitle(title);
		newPiece.setEnsembleType(ensembleType);
		newPiece.setPublisher(publisher);
		pieceDAO.saveNewPiece(newPiece);
		ra.addFlashAttribute("pieceName", newPiece);
		return "redirect:/fullCatalogue";
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