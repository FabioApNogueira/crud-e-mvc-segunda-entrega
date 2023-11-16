package aplicacao;

import java.util.Scanner;

import dao.EventoDAO;
import model.Evento;


public class MainEvento {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		EventoDAO eventoDAO = new EventoDAO();
		
		int opcao , id ; 
		
		String nome , data_Evento;
		
		
		do {
			
			System.out.println("\n============================== Evento =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o data_Evento:");
				data_Evento = s.nextLine();
				
				
				
				
				
				
				EventoDAO.create(new Evento(nome, data_Evento));
				break;
			case 2:
				
				for (Evento c : eventoDAO.read()) {
					c.mostrar();
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o data_Evento:");
				data_Evento = s.nextLine();
				
				
				
				EventoDAO.update(new Evento(nome, data_Evento));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				EventoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Evento evento = eventoDAO.readById(id);
				
				evento.mostrar();
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}
}
