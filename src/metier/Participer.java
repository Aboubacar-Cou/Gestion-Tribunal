package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Participer {
	private String idpartie;
	private String numaf;
	private String rolepartie;
	public Participer() {
		// TODO Auto-generated constructor stub
	}
	
	public String getIdpartie() {
		return idpartie;
	}

	public void setIdpartie(String idpartie) {
		this.idpartie = idpartie;
	}

	public String getNumaf() {
		return numaf;
	}

	public void setNumaf(String numaf) {
		this.numaf = numaf;
	}

	public String getRolepartie() {
		return rolepartie;
	}

	public void setRolepartie(String rolepartie) {
		this.rolepartie = rolepartie;
	}

	public void Enregistrer(Participer part) {
	    Connection cnx = null;
	    BDConnection bd = new BDConnection();
	    cnx = bd.seconnecter();
	    String sql = "insert into participer values(?,?,?)";
	    PreparedStatement pst = null;
	    try {
	        pst = cnx.prepareStatement(sql); // correctif : prepareStatement, pas prepareCall
	        pst.setString(1, part.getIdpartie());
	        pst.setString(2, part.getNumaf());
	        pst.setString(3, part.getRolepartie());
	        pst.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try { if (pst != null) pst.close(); if (cnx != null) cnx.close(); } catch (SQLException e) { e.printStackTrace(); }
	    }
	}
	public List<Participer> getparticiper(){
		Connection cnx = null;
		BDConnection bd = new BDConnection();
		cnx = bd.seconnecter();
		List<Participer> lpart = new ArrayList<Participer>();
		String sql="select* from participer";
		Statement st =null;
		ResultSet rs = null;
		try {
			st = cnx.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			Participer part= new Participer();
			part.setIdpartie(rs.getString(1));
			part.setNumaf(rs.getString(2));
			part.setRolepartie(rs.getString(3));
			lpart.add(part);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lpart;
	}
	public Participer getparticiperbycode(String idpartie, String numaf) {
	    Connection cnx = null;
	    BDConnection bd = new BDConnection();
	    cnx = bd.seconnecter();
	    Participer part = new Participer();
	    String sql = "select * from participer where idpartie=? and numaf=?";
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	    try {
	        pst = cnx.prepareStatement(sql);
	        pst.setString(1, idpartie);
	        pst.setString(2, numaf);
	        rs = pst.executeQuery();
	        if (rs.next()) {
	            part.setIdpartie(rs.getString(1));
	            part.setNumaf(rs.getString(2));
	            part.setRolepartie(rs.getString(3));
	        }
	        rs.close(); pst.close(); cnx.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return part;
	}

	public void majparticiper(String idpartie, String ancienNumaf, Participer part) {
	    Connection cnx = null;
	    BDConnection bd = new BDConnection();
	    cnx = bd.seconnecter();
	    // seul rolepartie est modifiable ; numaf/idpartie font partie de la clé
	    String sql = "update participer set rolepartie=? where idpartie=? and numaf=?";
	    PreparedStatement pst = null;
	    try {
	        pst = cnx.prepareStatement(sql);
	        pst.setString(1, part.getRolepartie());
	        pst.setString(2, idpartie);
	        pst.setString(3, ancienNumaf);
	        int i = pst.executeUpdate();
	        System.out.println(i != 0 ? "Mise a jour effectuee" : "Mise a jour echouee !");
	        pst.close(); cnx.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public void suppparticiper(String idpartie) {
		Connection cnx = null;
		BDConnection bd = new BDConnection();
		cnx = bd.seconnecter();
		String sql = "delete from participer where idpartie=?";
		PreparedStatement pst = null;
		try {
			pst = cnx.prepareStatement(sql);
			pst.setString(1, idpartie);
			pst.executeUpdate();
			
			pst.close(); 
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
/*
 * +------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| idpartie   | varchar(50) | NO   | PRI |         |       |
| numaf      | varchar(50) | NO   | PRI |         |       |
| rolepartie | varchar(50) | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
 */