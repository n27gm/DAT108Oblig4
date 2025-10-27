package no.hvl.dat108;

public class Validering {
	
	// Norske store bokstaver
	private static final String STORE_BOKSTAVER = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
	// Norske små bokstaver
	private static final String SMÅ_BOKSTAVER = "abcdefghijklmnopqrstuvwxyzæøå";
	
	public static boolean validerFornavn(String fornavn) {
		if (fornavn == null || fornavn.trim().isEmpty()) {
			return false;
		}
		
		String trimmet = fornavn.trim();
		int lengde = trimmet.length();
		
		// Sjekk lengde
		if (lengde < 2 || lengde > 20) {
			return false;
		}
		
		// Første tegn må være stor bokstav
		char førsteTegn = trimmet.charAt(0);
		if (STORE_BOKSTAVER.indexOf(førsteTegn) == -1) {
			return false;
		}
		
		// Sjekk resten av tegnene
		for (int i = 1; i < lengde; i++) {
			char c = trimmet.charAt(i);
			
			// Tillatte tegn: små bokstaver, store bokstaver (etter bindestrek/mellomrom), bindestrek, mellomrom
			if (SMÅ_BOKSTAVER.indexOf(c) != -1) {
				continue; // OK - liten bokstav
			} else if (c == '-' || c == ' ') {
				// Etter bindestrek eller mellomrom må det komme stor bokstav
				if (i + 1 < lengde) {
					char nesteTegn = trimmet.charAt(i + 1);
					if (STORE_BOKSTAVER.indexOf(nesteTegn) == -1) {
						return false;
					}
					i++; // Hopp over neste tegn (allerede sjekket)
				} else {
					return false; // Kan ikke slutte med bindestrek/mellomrom
				}
			} else if (STORE_BOKSTAVER.indexOf(c) != -1) {
				// Stor bokstav midt i ordet er kun OK etter bindestrek/mellomrom
				// Dette er allerede håndtert over
				continue;
			} else {
				return false; // Ugyldig tegn
			}
		}
		
		return true;
	}
	
	public static boolean validerEtternavn(String etternavn) {
		if (etternavn == null || etternavn.trim().isEmpty()) {
			return false;
		}
		
		String trimmet = etternavn.trim();
		int lengde = trimmet.length();
		
		// Sjekk lengde
		if (lengde < 2 || lengde > 20) {
			return false;
		}
		
		// Første tegn må være stor bokstav
		char førsteTegn = trimmet.charAt(0);
		if (STORE_BOKSTAVER.indexOf(førsteTegn) == -1) {
			return false;
		}
		
		// Sjekk resten av tegnene
		for (int i = 1; i < lengde; i++) {
			char c = trimmet.charAt(i);
			
			// Tillatte tegn: små bokstaver, store bokstaver (etter bindestrek), bindestrek
			// IKKE mellomrom!
			if (SMÅ_BOKSTAVER.indexOf(c) != -1) {
				continue; // OK - liten bokstav
			} else if (c == '-') {
				// Etter bindestrek må det komme stor bokstav
				if (i + 1 < lengde) {
					char nesteTegn = trimmet.charAt(i + 1);
					if (STORE_BOKSTAVER.indexOf(nesteTegn) == -1) {
						return false;
					}
					i++; // Hopp over neste tegn (allerede sjekket)
				} else {
					return false; // Kan ikke slutte med bindestrek
				}
			} else if (c == ' ') {
				return false; // Mellomrom ikke tillatt i etternavn
			} else if (STORE_BOKSTAVER.indexOf(c) != -1) {
				// Stor bokstav midt i ordet er kun OK etter bindestrek
				continue;
			} else {
				return false; // Ugyldig tegn
			}
		}
		
		return true;
	}
	
	public static boolean validerMobil(String mobil) {
		if (mobil == null || mobil.length() != 8) {
			return false;
		}
		
		// Sjekk at alle tegn er siffer
		for (int i = 0; i < 8; i++) {
			char c = mobil.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean validerPassord(String passord) {
		if (passord == null) {
			return false;
		}
		return passord.length() >= 8;
	}
	
	public static boolean validerPassordRepetert(String passord, String rpassord) {
		if (passord == null || rpassord == null) {
			return false;
		}
		return passord.equals(rpassord);
	}
	
	public static boolean validerKjonn(String kjonn) {
		return "mann".equals(kjonn) || "kvinne".equals(kjonn);
	}
	
	public static boolean validerAlt(String fornavn, String etternavn, String mobil, 
			String passord, String rpassord, String kjonn) {
		return validerFornavn(fornavn) 
				&& validerEtternavn(etternavn)
				&& validerMobil(mobil)
				&& validerPassord(passord)
				&& validerPassordRepetert(passord, rpassord)
				&& validerKjonn(kjonn);
	}
}