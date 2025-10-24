package no.hvl.dat108;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class Deltagere {
	private List<Deltager> deltagere;

	public Deltagere() {
		this.deltagere = new ArrayList<>();
		deltagere.add(new Deltager("Anne", "Panne", "23456789", "passord", "kvinne"));
		deltagere.add(new Deltager("Arne", "Arnesen", "90123456", "passord", "mann"));
		deltagere.add(new Deltager("Lars-Petter", "Helland", "12345679", "passord", "mann"));
		deltagere.add(new Deltager("Per", "Persen", "12345678", "passord", "mann"));
		deltagere.add(new Deltager("Pål", "Hansen", "12345675", "passord", "mann"));
		deltagere.add(new Deltager("Per", "Viskelær", "34534534", "passord", "mann"));
		deltagere.add(new Deltager("Kari", "Nordmann", "98765432", "passord", "kvinne"));
		deltagere.add(new Deltager("Ola", "Nordmann", "10213243", "passord", "mann"));
		deltagere.add(new Deltager("June", "Volden", "47474747", "passord", "kvinne"));
		deltagere.add(new Deltager("Leah", "Monsen-Hagen", "11111111", "passord", "kvinne"));
		deltagere.add(new Deltager("Naghm", "Alqaragei", "22223333", "passord", "kvinne"));
	}
	
	public List<Deltager> getDeltagere(){
		return deltagere.stream()
				.sorted(Comparator.comparing(Deltager::getFornavn)
						.thenComparing(Deltager::getEtternavn))
				.collect(Collectors.toList());
	}
	
	public boolean finnesMobil(String mobil) {
		return deltagere.stream()
				.anyMatch(d -> d.getMobil().equals(mobil));
	}
	
	public void leggTilDeltager(Deltager deltager) {
		deltagere.add(deltager);
	}
}