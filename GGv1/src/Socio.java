import java.util.Date;

public class Socio {
	
	String nome, cognome, codiceSocio, codiceFiscale, 
	cittaNascita, indirizzo, email, branca;
	Date dataNascita;
	char sesso;
	
	public Socio(String codiceSocio, String nome, String cognome, char sesso, String codiceFiscale, String cittaNascita,
			Date dataNascita, String indirizzo, String email, String branca) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceSocio = codiceSocio;
		this.codiceFiscale = codiceFiscale;
		this.cittaNascita = cittaNascita;
		this.indirizzo = indirizzo;
		this.email = email;
		this.branca= branca;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
		this.branca= branca;
	}	
	
	public String getCodiceSocio() {
		return codiceSocio;
	}

	public String toString() {
		String s= "'"+ codiceSocio+ "', '"+ nome+ "', '"+ cognome+ "', '"+ sesso+ "', '"+ codiceFiscale+ "', '"
				+ cittaNascita+ "', '"+ dataNascita+ "', '"+ indirizzo + "', '"+ email+ "', '" + branca+  "'";
		return s;
	}

}
