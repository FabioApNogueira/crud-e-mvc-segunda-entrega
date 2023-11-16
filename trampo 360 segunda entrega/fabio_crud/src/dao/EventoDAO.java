package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Aluno;

public class EventoDAO {
	
	//CREATE
	public void create (Evento evento) {
		String sql = "insert into evento (nome, id_Evento, data_Evento,) values (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, evento.getnome());
			pstm.setString(2, evento.getid_Evento());
			pstm.setString(3, evento.getdata_Evento());
		
			
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
		public List <Evento> read(){
			List<Evento> eventos = new ArrayList<Evento>();
			String sql = "select * from evento";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Evento evento = new Evento();
				evento.setnome (rset.getInt("nome"));
				evento.setid_Evento (rset.getString("id_Evento"));
				evento.setdata_Evento (rset.getString("data_Evento"));
				
				
				eventos.add(evento);
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
		
		return eventos;
	}
	
	//UPDATE
	public void update (Evento evento) {
		String sql = "UPDATE evento SET nome = ?,  id_Evento = ?, data_Evento = ?, WHERE id_Aluno = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, evento.getnome());
			pstm.setString(2, evento.getid_Evento());
			pstm.setString(3, evento.getdata_Evento());
			
			pstm.setInt(4, evento.getId());
			
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
	public void delete (int id_Evento) {
	String sql = "DELETE FROM aluno WHERE id_Evento = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionMySQL.createConnectionMySQL();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, id_Evento);
		
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
	public Evento readById (int id_Evento) {
		Evento evento = new Evento();
		String sql = "select * from aluno WHERE id_Evento= ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_Evento);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			
			evento.setnome(rset.getInt("nome"));
			evento.setid_Evento(rset.getString("id_Evento"));
			evento.setdata_Evento(rset.getString("data_Evento"));
			
		
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
		return evento;
		}
	}

