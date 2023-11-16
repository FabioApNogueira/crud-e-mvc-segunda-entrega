package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Aluno;


public class AlunoDAO {
	public void create(Aluno aluno) {

		String sql = "insert into Aluno (id_Aluno, CPF, email, nome, senha) values (?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, aluno.getid_Aluno());
			pstm.setString(2, aluno.getCPF());
			pstm.setString(3, aluno.getemail());
			pstm.setString(4, aluno.getnome());
			pstm.setString(5, aluno.getsenha());

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
	
	public List<Aluno> read() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		String sql = "select * from aluno";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Aluno aluno = new Aluno();
				
				aluno.setid_Aluno(rset.getInt("id_Aluno"));
				aluno.setCPF(rset.getString("CPF"));
				aluno.setemail(rset.getString("email"));
				aluno.setnome(rset.getString("nome"));
				aluno.setsenha(rset.getString("senha"));
				

				alunos.add(aluno);
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

		return alunos;
	}
	
	public void update(Aluno aluno) {
		String sql = "UPDATE Aluno SET id_Aluno = ?, CPF = ?, email = ?, nome = ?, senha = ? WHERE id_Aluno = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
											
		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, aluno.getid_Aluno());
			pstm.setString(2, aluno.getCPF());
			pstm.setString(3, aluno.getemail());
			pstm.setString(4, aluno.getnome());
			pstm.setString(5, aluno.getsenha());
			pstm.setInt(6, aluno.getId());

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
		String sql = "DELETE FROM Aluno WHERE id_Aluno = ?";

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
	
	public Aluno readById(int id) {
		Aluno aluno = new Aluno();
		String sql = "select * from Aluno WHERE id_Aluno = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			aluno.setId(rset.getInt("id_Aluno"));
			aluno.setid_Aluno(rset.getInt("id_Aluno"));
			aluno.setCPF(rset.getString("CPF"));
			aluno.setemail(rset.getString("email"));
			aluno.setnome(rset.getString("nome"));
			aluno.setsenha(rset.getString("senha"));
			

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
		return aluno;
	}
}
