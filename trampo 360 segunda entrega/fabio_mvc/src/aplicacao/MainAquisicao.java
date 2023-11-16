package aplicacao;

import java.util.Scanner;

import dao.AquisicaoDAO;
import model.Aquisicao;


public class MainAquisicao {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		AquisicaoDAO aquisicaoDAO = new AquisicaoDAO();
		
		int opcao , id ; 
		
		String data_Aquisicao , nome , id_Evento, id_Aluno;
		
		
		do {
			
			System.out.println("\n============================== Aquisicao =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o data_Aquisicao:");
				data_Aquisicao = s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o id_Evento:");
				id_Evento = s.nextLine();
				System.out.println("Digite o id_Aluno:");
				id_Aluno = s.nextLine();
				
				
				
				
				
				
				aquisicaoDAO.create(new Aquisicao(data_Aquisicao, nome, id_Evento, id_Aluno));
				break;
			case 2:
				
				for (Aquisicao c : aquisicaoDAO.read()) {
					c.mostrar();
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o data_Aquisicao:");
				data_Aquisicao = s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o id_Evento:");
				id_Evento = s.nextLine();
				System.out.println("Digite o id_Aluno:");
				id_Aluno = s.nextLine();
				
				
				
				
				aquisicaoDAO.update(new Aquisicao(data_Aquisicao, nome, id_Evento, id_Aluno));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				aquisicaoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Aquisicao aquisicao1 = aquisicaoDAO.readById(id);
				
				aquisicao1.mostrar();
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}
}
