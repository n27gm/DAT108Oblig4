class DeltagerManager {
	// deklarer felt-variabler her
	#fornavn = document.getElementById("fornavn");
	#etternavn = document.getElementById("etternavn");
	#mobil = document.getElementById("mobil");
	#passord = document.getElementById("passord");
	#rpassord = document.getElementById("rpassord");
	#submit = document.getElementById("submit");
	#mann = document.getElementById("mann");
	#kvinne = document.getElementById("kvinne");
	#p;

	constructor(root) {
		this.#p = root.querySelector("p");

		console.log("oppretta")
		this.#addEvent.bind(this)();
	}


	#showHidden() {
		if (this.#p.classList.toString().includes("hidden")) {
			this.#p.classList.toggle("hidden");
		}
	}
	#erGyldig(input) {
		const type = input.value;
		return typeof type !== "undefined" && type !== "" && input.checkValidity();
	}
	#gyldigPassord() {
		console.log(this.#passord.value+"\n"+this.#rpassord.value)
		if (this.#passord.value === this.#rpassord.value) {
			return true;
		} else {
			return false;
		}
	}

	#kjonn() {
		console.log(this.#kvinne);
		if (this.#kvinne.checked) {
			console.log("kvinne er valt");
			return this.#kvinne;
		} else if (this.#mann.checked) {
			console.log("mann er valt");
			return this.#mann;
		}
		return null;
	}
	#gyldigSkjema() {
		const gyldig = this.#erGyldig;
		const show = this.#showHidden.bind(this);
		if (this.#kjonn.bind(this)() === null) {
			show();
		} else if (this.#gyldigPassord.bind(this)()) {
			show();
		}
		else if (!gyldig(this.#fornavn) || !gyldig(this.#etternavn) || !gyldig(this.#mobil)) {
			show();
		}
	}
	#addEvent() {
		console.log("Oppretter event");
		this.#submit.addEventListener("click", this.#gyldigSkjema.bind(this));
	}

}

const rootelement = document.getElementById("root");
new DeltagerManager(rootelement);
