import java.util.Date;
import java.text.SimpleDateFormat; 

import fond.io.InputWindow;

public class GestoreGruppo {
	
	public static Socio iscriviSocio() throws Exception {
		InputWindow in= new InputWindow();
		String nome = in.readString("Inserire nome");
		String cognome = in.readString("Inserire cognome");
		String codiceSocio = in.readString("Inserire codice socio");
		String codiceFiscale = in.readString("Inserire codice fiscale");
		String cittaNascita = in.readString("Inserire città di nascita");
		Date dataNascita = new SimpleDateFormat("dd/MM/yyyy").parse(in.readString("Inserire data di nascita (gg/MM/aaaa)"));
		String indirizzo = in.readString("Inserire indirizzo");
		String email = in.readString("Inserire email");
		String branca = in.readString("Inserire branca");
		char sesso = in.readChar("Inserire sesso (m/f)");
		
		Socio s= new Socio(codiceSocio, nome, cognome, sesso, codiceFiscale, cittaNascita,
				dataNascita, indirizzo, email, branca);
		return s;
	};
	

	public static void main(String[] args) throws Exception {
	
		Gruppo g= new Gruppo();
		/*InputWindow in= new InputWindow();
		while(in.readChar("aggiungi un altro socio? /n (digita s per continuare)") == 's')
			g.aggiungiSocio(iscriviSocio());	
		g.Salva();*/
		InputWindow in= new InputWindow();
		String nome = in.readString("Inserire nome");
		String cognome = in.readString("Inserire cognome");
		int codiceSocio = in.readInt("Inserire codice socio");
		String codiceFiscale = in.readString("Inserire codice fiscale");
		String cittaNascita = in.readString("Inserire città di nascita");
		Date dataNascita = new SimpleDateFormat("dd/MM/yyyy").parse(in.readString("Inserire data di nascita (gg/MM/aaaa)"));
		String indirizzo = in.readString("Inserire indirizzo");
		String email = in.readString("Inserire email");
		String branca = in.readString("Inserire branca");
		char sesso = in.readChar("Inserire sesso (m/f)");
		Socio s= new Socio(Integer.toString(codiceSocio), nome, cognome, sesso, codiceFiscale, cittaNascita,
				dataNascita, indirizzo, email, branca);
		g.aggiungiSocio(s);
		for (int i=0; i<20; i++) {
			
			s=new Socio(Integer.toString(codiceSocio+ i+1), nome+i, cognome+i, sesso, codiceFiscale+i, cittaNascita+i,
					dataNascita, indirizzo+1, email+i, branca);
			g.aggiungiSocio(s);		
			System.out.println("siamo passati per qui2");
		};
		g.Salva();
		
		g.eliminaSocio("1");

	}

}
