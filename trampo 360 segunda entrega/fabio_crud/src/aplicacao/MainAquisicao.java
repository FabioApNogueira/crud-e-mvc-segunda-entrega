package aplicacao;

import java.util.Scanner;

import dao.AlunoDAO;
import dao.AquisicaoDAO;
import dao.EventoDAO;
import model.Aluno;
import model.Aquisicao;
import model.Evento;

public class MainAquisicao {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		AquisicaoDAO AquisicaoDAO = new AquisicaoDAO();
		EventoDAO eventoDAO = new EventoDAO();
		AlunoDAO alunoDAO = new AlunoDAO();

		int opcao, id, id_Aluno, id_Evento;
		String data;
		String nome;

		do {

			System.out.println("\n============================== COMPRAS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Digite o ID do Aluno:");
				id_Aluno = s.nextInt();
				s.nextLine();
				System.out.println("Digite o ID do Evento:");
				id_Evento = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data:");
				data = s.nextLine();
				System.out.println("Digite o valor:");
				nome = s.nextLine();

				Aluno aluno = alunoDAO.readById(id_Aluno);
				Evento evento = eventoDAO.readById(id_Evento);

				AquisicaoDAO.create(new Aquisicao(data, nome, aluno, id_Evento,));
				break;
			case 2:

				for (Aquisicao a : AquisicaoDAO.read()) {
					a.mostrar();
				}

				break;
			case 3:

				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o ID do Aluno:");
				id_Aluno = s.nextInt();
				s.nextLine();
				System.out.println("Digite o ID do Evento:");
				id_Evento = s.nextInt();
				s.nextLine();
				System.out.println("Digite a Data:");
				data = s.nextLine();
				System.out.println("Digite o Nome:");
				nome = s.nextLine();

				Aluno aluno1 = alunoDAO.readById(id_Aluno);
				Evento evento1 = eventoDAO.readById(id_Evento);

				AquisicaoDAO.update(new Aquisicao(id, data, nome, aluno1, evento1));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				AquisicaoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Aquisicao aquisicao = AquisicaoDAO.readById(id);

				aquisicao.mostrar();
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}
}
