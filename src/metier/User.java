package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String iduser;
    private String nomuser;
    private String prenomuser;
    private String motdepasse;

    

    public String getIduser() {
		return iduser;
	}



	public void setIduser(String iduser) {
		this.iduser = iduser;
	}



	public String getNomuser() {
		return nomuser;
	}



	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}



	public String getPrenomuser() {
		return prenomuser;
	}



	public void setPrenomuser(String prenomuser) {
		this.prenomuser = prenomuser;
	}



	public String getMotdepasse() {
		return motdepasse;
	}



	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}



	public User seConnecter(String nomuser,String prenomuser, String motdepasse) {
        Connection cnx = null;
        BDConnection bd = new BDConnection();
        cnx = bd.seconnecter();
        User us = null;
        String sql = "select * from user where nomuser=? and prenomuser=? and motdepasse=?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1, nomuser);
            pst.setString(2, prenomuser);
            pst.setString(3, motdepasse);
            rs = pst.executeQuery();
            if (rs.next()) {
                us = new User();
                us.setIduser(rs.getString(1));
                us.setNomuser(rs.getString(2));
                us.setPrenomuser(rs.getString(3));
                us.setMotdepasse(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return us; // null si identifiants incorrects
    }
}