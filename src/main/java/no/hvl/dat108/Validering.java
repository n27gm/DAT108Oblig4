package no.hvl.dat108;

import java.util.regex.Pattern;

public class Validering {
	
	// Fornavn: 2-20 tegn, første tegn stor bokstav, kan inneholde bokstaver, bindestrek og mellomrom
	private static final Pattern FORNAVN_PATTERN = 
			Pattern.compile("^[A-ZÆØÅ][a-zæøå]+([-\\s][A-ZÆØÅ][a-zæøå]+)*$");
	
	// Etternavn: 2-20 tegn, første tegn stor bokstav, kan inneholde bokstaver og bindestrek (IKKE mellomrom)
	private static final Pattern ETTERNAVN_PATTERN = 
			Pattern.compile("^[A-ZÆØÅ][a-zæøå]+(-[A-ZÆØÅ][a-zæøå]+)*$");
	
	// Mobil: eksakt 8 siffer
	private static final Pattern MOBIL_PATTERN = 
			Pattern.compile("^\\d{8}$");
	
	public static boolean validerFornavn(String fornavn) {
		if (fornavn == null || fornavn.trim().isEmpty()) {
			return false;
		}
		String trimmet = fornavn.trim();
		return trimmet.length() >= 2 && trimmet.length() <= 20 
				&& FORNAVN_PATTERN.matcher(trimmet).matches();
	}
	
	public static boolean validerEtternavn(String etternavn) {
		if (etternavn == null || etternavn.trim().isEmpty()) {
			return false;
		}
		String trimmet = etternavn.trim();
		return trimmet.length() >= 2 && trimmet.length() <= 20 
				&& ETTERNAVN_PATTERN.matcher(trimmet).matches();
	}
	
	public static boolean validerMobil(String mobil) {
		if (mobil == null) {
			return false;
		}
		return MOBIL_PATTERN.matcher(mobil).matches();
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