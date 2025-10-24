package no.hvl.dat108;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeltagerlisteController {
	
	@Autowired
	private Deltagere deltagere;
	
	@GetMapping("/deltagerliste")
	public String visDeltagerliste(Model model) {
		model.addAttribute("deltagerliste", deltagere.getDeltagere());
		return "deltagerliste";
	}
}