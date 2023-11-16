package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Aquisicao;


public class AquisicaoDAO {
	public void create(Aquisicao aquisicao) {

		String sql = "insert into Aquisicao (data_Aquisicao, nome, id_Evento, id_Aluno) values (?, ?, ?, ?)";

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
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public List<Aquisicao> read() {
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
				
				aquisicao.setdata_Aquisicao(rset.getInt("data_Aquisicao"));
				aquisicao.setnome(rset.getString("nome"));
				aquisicao.setid_Evento(rset.getString("id_Evento"));
				aquisicao.setid_Aluno(rset.getString("id_Aluno"));
				
				
				aquisicaos.add(aquisicao);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return aquisicaos;
	}
	
	public void update(Aquisicao aquisicao) {
		String sql = "UPDATE Aquisicao SET data_Aquisicao = ?, nome = ?, id_Evento = ?, id_Aluno = ?, WHERE id_Aluno = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
											
		try {  

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, aquisicao.getdata_Aquisicao());
			pstm.setString(2, aquisicao.getnome());
			pstm.setString(3, aquisicao.getid_Evento());
			pstm.setString(4, aquisicao.getid_Aluno());
			pstm.setInt(6, aquisicao.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public void delete(int id) {
		String sql = "DELETE FROM Aquisicao WHERE data_Aquisicao = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public Aquisicao readById(int id) {
		Aquisicao aquisicao = new Aquisicao();
		String sql = "select * from Aquisicao WHERE data_Aquisicao = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			aquisicao.setId(rset.getInt("id"));
			aquisicao.setdata_Aquisicao(rset.getInt("data_Aquisicao"));
			aquisicao.setnome(rset.getString("nome"));
			aquisicao.setid_Evento(rset.getString("id_Evento"));
			aquisicao.setid_Aluno(rset.getString("id_Aluno"));
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return aquisicao;
	}
}
