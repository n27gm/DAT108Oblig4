package no.hvl.dat108;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PaameldingController {
	
	@Autowired
	private Deltagere deltagere;
	
	@GetMapping("/paamelding")
	public String visPaameldingsskjema(
			@RequestParam(required = false) String feilmelding,
			Model model) {
		if (feilmelding != null) {
			model.addAttribute("feilmelding", feilmelding);
		}
		return "paamelding";
	}
	
	@PostMapping("/paamelding")
	public String behandlePaamelding(
			@RequestParam String fornavn,
			@RequestParam String etternavn,
			@RequestParam String mobil,
			@RequestParam String passord,
			@RequestParam String rpassord,
			@RequestParam(required = false) String kjonn,
			RedirectAttributes redirectAttributes) {
		
		// Valider alle felt
		if (!Validering.validerAlt(fornavn, etternavn, mobil, passord, rpassord, kjonn)) {
			return "redirect:/paamelding?feilmelding=Påmeldingsdetaljer er ugyldige";
		}
		
		// Sjekk om mobil allerede er registrert
		if (deltagere.finnesMobil(mobil)) {
			return "redirect:/paamelding?feilmelding=Deltager med dette mobilnummeret er allerede påmeldt";
		}
		
		// Legg til ny deltager
		Deltager nyDeltager = new Deltager(
				fornavn.trim(), 
				etternavn.trim(), 
				mobil, 
				passord, 
				kjonn);
		deltagere.leggTilDeltager(nyDeltager);
		
		// Redirect til bekreftelsesside med deltagerinfo
		redirectAttributes.addFlashAttribute("deltager", nyDeltager);
		return "redirect:/paameldt";
	}
	
	@GetMapping("/paameldt")
	public String visPaameldt() {
		return "paameldt";
	}
}