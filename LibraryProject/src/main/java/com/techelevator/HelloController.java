package com.techelevator;

import java.util.Map;

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
public class HelloController {
	
	@Autowired
	public PieceDAO pieceDAO;


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
		return "redirect:/confirmation";
	}
	
	@RequestMapping("/confirmation")
	public String confirmationPage() {
		return "confirmation";
	}
	

	
}
