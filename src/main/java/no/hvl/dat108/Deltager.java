package no.hvl.dat108;

public class Deltager {
	private String mobil;
	private String passord;
	private String fornavn;
	private String etternavn;
	private String kjonn;

	public Deltager(String fornavn, String etternavn, String mobil, String passord, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = passord;
		this.kjonn = kjonn;
	}


}
