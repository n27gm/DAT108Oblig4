package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

public class Deltagere {
	private List<Deltager> deltagere;

	public Deltagere() {
		this.deltagere = new ArrayList<>();
		deltagere.add(new Deltager("Anne", "Panne", "23456789", "passord", "kvinne"));
		deltagere.add(new Deltager("Arne", "Arnesen", "90123456", "passord", "mann"));
		deltagere.add(new Deltager("Lars-Petter", "Helland", "12345679", "passord", "mann"));
		deltagere.add(new Deltager("Per", "Persen", "12345678", "passord", "mann"));
		deltagere.add(new Deltager("Per", "Persen", "12345675", "passord", "mann"));
		deltagere.add(new Deltager("Per", "Viskelær", "34534534", "passord", "mann"));
		deltagere.add(new Deltager("Kari", "Nordmann", "98765432", "passord", "kvinne"));
		deltagere.add(new Deltager("Ola", "Nordmann", "10213243", "passord", "mann"));
		deltagere.add(new Deltager("June", "Volden", "47474747", "passord", "kvinne"));
		deltagere.add(new Deltager("Leah Monsen", "Hagen", "11111111", "passord", "kvinne"));
		deltagere.add(new Deltager("Naghm", "Alqaragei", "22223333", "passord", "kvinne"));
	}
	public List<Deltager> getDeltagere(){
		return deltagere;
	}

}
