import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
	
public class Gruppo {

	ArrayList<Socio> componenti;

	public Gruppo() {
		this.componenti = new ArrayList<Socio>();
	}

	public void aggiungiSocio(Socio socio) {
		componenti.add(socio);	
	}

	public void Salva() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DatabaseBasiDati",
							"postgres", "postgres");
			c.setAutoCommit(false);
			System.out.println("Connessione con database riuscita");

			stmt = c.createStatement();
			int i= 0;
			while (i<componenti.size()) {
				Socio s= componenti.get(i);
				String sql = "INSERT INTO gruppo "
				+ "VALUES("+s.toString()+");";
				stmt.executeUpdate(sql);
				System.out.println("siamo passati per qui");
				i++;
			}
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("Componenti della branca salvati");
	}
	
	public void eliminaSocio(String codiceSocio) {
		/*Socio s= componenti.get(0);
		int i= 0;
		while(s.getCodiceSocio() != codiceSocio && i<componenti.size()) {
			i++;
			s= componenti.get(i);
		}
		if(i<componenti.size()) {
			Connection c = null;
			Statement stmt = null;
			try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager
						.getConnection("jdbc:postgresql://localhost:5432/DatabaseBasiDati",
								"postgres", "postgres");
				c.setAutoCommit(false);
				System.out.println("Connessione con database riuscita");

				stmt = c.createStatement();
				String sql = "DELETE FROM gruppo "
						+ "WHERE codicesocio="+ s.getCodiceSocio()+");";
				stmt.executeUpdate(sql);

				stmt.close();
				c.commit();
				c.close();
			} catch (Exception e) {
				System.err.println( e.getClass().getName()+": "+ e.getMessage() );
				System.exit(0);
			}
			System.out.println("Componenti della branca salvati");
			componenti.remove(i);
		}
		else
			System.out.print("codice socio non trovato");
	}*/
		
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DatabaseBasiDati",
							"postgres", "postgres");
			c.setAutoCommit(false);
			System.out.println("Connessione con database riuscita");

			stmt = c.createStatement();
			String sql = "DELETE FROM gruppo "
					+ "WHERE codicesocio='"+ codiceSocio+"';";
			int i= stmt.executeUpdate(sql);
			if (i==1)
				System.out.println("socio eliminato");
			else
				System.out.println("socio non presente");

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
	}


}
