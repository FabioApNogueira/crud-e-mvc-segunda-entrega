package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Aluno;

public class AquisicaoDAO {
	
	//CREATE
	public void create (Aquisicao aquisicao) {
		String sql = "insert into aquisicao (data_Aquisicao, nome, id_Evento, id_Aluno) values (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, aquisicao.getdata_Aquisicao());
			pstm.setString(2, aquisicao.getnome());
			pstm.setString(3, aquisicao.getid_Evento());
			pstm.setString(4, aquisicao.getid_Aluno());
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			 try {
				
				 if (pstm !=null) {
					 pstm.close();
				
				 }
				 if (conn !=null) {
					 conn.close();
				 }
				 
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
	}
		
	}

	//READ
		public List <Aquisicao> read(){
			List<Aquisicao> aquisicaos = new ArrayList<Aquisicao>();
			String sql = "select * from aquisicao";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Aquisicao aquisicao = new Aquisicao();
				aquisicao.setdata_Aquisicao (rset.getInt("data_Aquisicao"));
				aquisicao.setnome (rset.getString("nome"));
				aquisicao.setid_Evento (rset.getString("id_Evento"));
				aquisicao.setnome (rset.getString("nome"));
				aquisicao.setid_Aluno (rset.getString("id_Aluno"));
				
				aquisicaos.add(aquisicao);
			}
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		 try {
			
			 if (pstm !=null) {
				 pstm.close();
			
			 }
			 if (conn !=null) {
				 conn.close();
			 }
			 
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
}
		
		return aquisicaos;
	}
	
	//UPDATE
	public void update (Aquisicao aquisicao) {
		String sql = "UPDATE aquisicao SET data_Aquisicao = ?,  nome = ?, id_Evento = ?, id_Aluno = ? WHERE id_Aquisicao = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, aquisicao.getdata_Aquisicao());
			pstm.setString(2, aquisicao.getnome());
			pstm.setString(3, aquisicao.getid_Evento());
			pstm.setString(4, aquisicao.getid_Aluno());
			
			pstm.setInt(5, aquisicao.getId());
			
			pstm.execute();
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		 try {
			
			 if (pstm !=null) {
				 pstm.close();
			
			 }
			 if (conn !=null) {
				 conn.close();
			 }
			 
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
}
	} 
	
	//DELETE
	public void delete (int id_Aquisicao) {
	String sql = "DELETE FROM aquisicao WHERE id_Aquisicao = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionMySQL.createConnectionMySQL();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, id_Aquisicao);
		
		pstm.execute();
	
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		 try {
			
			 if (pstm !=null) {
				 pstm.close();
			
			 }
			 if (conn !=null) {
				 conn.close();
			 }
			 
			 }catch (Exception e) {
				 e.printStackTrace();
			 
}
	}
	}
	//readById
	public Aquisicao readById (int id_Aquisicao) {
		Aquisicao aquisicao = new Aquisicao();
		String sql = "select * from aquisicao WHERE id_Aquisicao= ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_Aquisicao);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			aquisicao.setdata_Aquisicao (rset.getInt("data_Aquisicao"));
			aquisicao.setnome (rset.getString("nome"));
			aquisicao.setid_Evento (rset.getString("id_Evento"));
			aquisicao.setnome (rset.getString("nome"));
			aquisicao.setid_Aluno (rset.getString("id_Aluno"));
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				 if (pstm !=null) {
					 pstm.close();
				
				 }
				 if (conn !=null) {
					 conn.close();
				 }
				 
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
	    }
		return aquisicao;
		}
	}

