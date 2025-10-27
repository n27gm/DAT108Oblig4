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
	public String visPaameldingsskjema(Model model) {
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
		
		// Valider hvert felt og samle feilmeldinger
		boolean harFeil = false;
		
		// Valider fornavn
		if (!Validering.validerFornavn(fornavn)) {
			redirectAttributes.addFlashAttribute("fornavnFeil", 
				"Fornavn må være 2-20 tegn, starte med stor bokstav (A-Å), og kan inneholde bokstaver, bindestrek og mellomrom");
			harFeil = true;
		}
		
		// Valider etternavn
		if (!Validering.validerEtternavn(etternavn)) {
			redirectAttributes.addFlashAttribute("etternavnFeil", 
				"Etternavn må være 2-20 tegn, starte med stor bokstav (A-Å), og kan inneholde bokstaver og bindestrek (ikke mellomrom)");
			harFeil = true;
		}
		
		// Valider mobil
		if (!Validering.validerMobil(mobil)) {
			redirectAttributes.addFlashAttribute("mobilFeil", 
				"Mobilnummer må være eksakt 8 siffer");
			harFeil = true;
		} else if (deltagere.finnesMobil(mobil)) {
			redirectAttributes.addFlashAttribute("mobilFeil", 
				"Deltager med dette mobilnummeret er allerede påmeldt");
			harFeil = true;
		}
		
		// Valider passord
		if (!Validering.validerPassord(passord)) {
			redirectAttributes.addFlashAttribute("passordFeil", 
				"Passord må være minst 8 tegn langt");
			harFeil = true;
		}
		
		// Valider repetert passord
		if (!Validering.validerPassordRepetert(passord, rpassord)) {
			redirectAttributes.addFlashAttribute("rpassordFeil", 
				"Passordene må være like");
			harFeil = true;
		}
		
		// Valider kjønn
		if (!Validering.validerKjonn(kjonn)) {
			redirectAttributes.addFlashAttribute("kjonnFeil", 
				"Du må velge kjønn");
			harFeil = true;
		}
		
		// Hvis det er feil, send tilbake til skjemaet med feilmeldinger og tidligere input
		if (harFeil) {
			redirectAttributes.addFlashAttribute("fornavn", fornavn);
			redirectAttributes.addFlashAttribute("etternavn", etternavn);
			redirectAttributes.addFlashAttribute("mobil", mobil);
			redirectAttributes.addFlashAttribute("kjonn", kjonn);
			return "redirect:/paamelding";
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