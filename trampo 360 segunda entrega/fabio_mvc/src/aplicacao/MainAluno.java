package aplicacao;

import java.util.Scanner;

import dao.AlunoDAO;
import model.Aluno;


public class MainAluno {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		AlunoDAO alunoDAO = new AlunoDAO();
		
		int opcao , id ; 
		
		String id_Aluno , CPF , email, nome, senha;
		
		
		do {
			
			System.out.println("\n============================== Alunos =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o id_Aluno:");
				id_Aluno = s.nextLine();
				System.out.println("Digite o CPF:");
				CPF = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o senha:");
				senha = s.nextLine();
				
				
				
				
				
				alunoDAO.create(new Aluno(id_Aluno, CPF, email, nome, senha));
				break;
			case 2:
				
				for (Aluno c : alunoDAO.read()) {
					c.mostrar();
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id_Aluno:");
				id_Aluno = s.nextLine();
				System.out.println("Digite o CPF:");
				CPF = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o senha:");
				senha = s.nextLine();
				
				
				alunoDAO.update(new Aluno(id, id_Aluno, CPF, email, nome, senha));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				alunoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Aluno aluno = alunoDAO.readById(id);
				
				aluno.mostrar();
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}
}
