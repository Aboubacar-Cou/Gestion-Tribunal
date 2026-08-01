package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Affaire {
	private String numaf;
	// CORRECTION 1 : On passe en java.util.Date pour correspondre au Servlet
	private java.util.Date datedebut;
	private String nature;
	private String typeaf;
	private String idmag;
	
	public Affaire() {}

	public String getNumaf() { return numaf; }
	public void setNumaf(String numaf) { this.numaf = numaf; }

	public java.util.Date getDatedebut() { return datedebut; }
	public void setDatedebut(java.util.Date datedebut) { this.datedebut = datedebut; }

	public String getNature() { return nature; }
	public void setNature(String nature) { this.nature = nature; }

	public String getTypeaf() { return typeaf; }
	public void setTypeaf(String typeaf) { this.typeaf = typeaf; }

	public String getIdmag() { return idmag; }
	public void setIdmag(String idmag) { this.idmag = idmag; }

	public void Enregistrer(Affaire aff) {
		Connection cnx = null;
		BDConnection bd = new BDConnection();
		cnx = bd.seconnecter();
		String sql = "insert into affaire values(?,?,?,?,?)";
		PreparedStatement pst = null;
		try {
			// CORRECTION 2 : Utiliser prepareStatement au lieu de prepareCall (réservé aux procédures stockées)
			pst = cnx.prepareStatement(sql);
			pst.setString(1, aff.getNumaf());
			
			// CORRECTION 3 : Conversion sécurisée et gestion des dates nulles
			if (aff.getDatedebut() != null) {
				pst.setDate(2, new java.sql.Date(aff.getDatedebut().getTime()));
			} else {
				pst.setNull(2, java.sql.Types.DATE);
			}
			
			pst.setString(3, aff.getNature());
			pst.setString(4, aff.getTypeaf());
			pst.setString(5, aff.getIdmag());
			pst.executeUpdate();
			
			pst.close(); cnx.close(); // Penser à fermer les ressources
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Affaire> getaffaire(){
		Connection cnx = null;
		BDConnection bd = new BDConnection();
		cnx = bd.seconnecter();
		List<Affaire> laff = new ArrayList<Affaire>();
		String sql = "select * from affaire";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = cnx.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Affaire aff = new Affaire();
				aff.setNumaf(rs.getString(1));
				// Récupère la date SQL et la stocke naturellement dans le java.util.Date
				aff.setDatedebut(rs.getDate(2));
				aff.setNature(rs.getString(3));
				aff.setTypeaf(rs.getString(4));
				aff.setIdmag(rs.getString(5));
				laff.add(aff);	
			}
			rs.close(); st.close(); cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return laff;
	}

	public Affaire getaffairebycode(String numaf) {
    	Connection cnx = null;
    	BDConnection bd = new BDConnection();
    	cnx = bd.seconnecter();
    	Affaire aff = new Affaire(); // Initialisé à null si non trouvé
    	String sql = "select * from affaire where numaf=?";
    	PreparedStatement pst = null;
    	ResultSet rs = null;
    	try {
			pst = cnx.prepareStatement(sql);
			pst.setString(1, numaf);
			rs = pst.executeQuery();
			if(rs.next()) { // Utiliser un "if" au lieu de "while" car la clé primaire est unique
				aff = new Affaire();
				aff.setNumaf(rs.getString(1));
				aff.setDatedebut(rs.getDate(2));
				aff.setNature(rs.getString(3));
				aff.setTypeaf(rs.getString(4));
				aff.setIdmag(rs.getString(5));
			}
			rs.close(); pst.close(); cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return aff;
    }

	public void majaffaire(String numaf, Affaire aff){
	    Connection cnx = new BDConnection().seconnecter();
	    String sql = "update affaire set datedebut=?, nature=?, typeaf=?, idmag=? where numaf=?";
	    try {
	        PreparedStatement pst = cnx.prepareStatement(sql);

	        if (aff.getDatedebut() != null) {
	            pst.setDate(1, new java.sql.Date(aff.getDatedebut().getTime()));
	        } else {
	            pst.setNull(1, java.sql.Types.DATE);
	        }
	        pst.setString(2, aff.getNature());
	        pst.setString(3, aff.getTypeaf());
	        pst.setString(4, aff.getIdmag());
	        pst.setString(5, numaf); // utiliser le paramètre

	        int i = pst.executeUpdate();
	        if (i != 0) System.out.println("Mise à jour effectuée");
	        else System.out.println("Mise à jour échouée !");
	        pst.close(); cnx.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public void suppaffaire(String numaf) {
		Connection cnx = null;
		BDConnection bd = new BDConnection();
		cnx = bd.seconnecter();
		String sql = "delete from affaire where numaf=?";
		PreparedStatement pst = null;
		try {
			pst = cnx.prepareStatement(sql);
			pst.setString(1, numaf);
			pst.executeUpdate();
			
			pst.close(); 
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
