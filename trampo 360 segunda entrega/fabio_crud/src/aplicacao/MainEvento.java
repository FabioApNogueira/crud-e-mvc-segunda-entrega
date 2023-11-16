package aplicacao;

import java.util.Scanner;

import dao.EventoDAO;
import model.Evento;

public class MainEvento {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		EventoDAO eventoDAO = new EventoDAO();
		
		int opcao , id ; 
		String nome;
		String data_Evento; 
		String id_Evento;
		
		
		do {
			
			System.out.println("\n============================== RESERVAS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a Data:");
				data_Evento = s.nextLine();
				System.out.println("Digite o Evento:");
				id_Evento = s.nextLine();
				System.out.println("Digite a Nome:");
				nome = s.nextLine();
				
				
				
				
				
				
			eventoDAO.create(new Evento(id_Evento, data_Evento, nome));
				break;
			case 2:
				
				for (Evento e : eventoDAO.read()) {
					e.mostrar();
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data:");
				data_Evento = s.nextLine();
				System.out.println("Digite o valor:");
				id_Evento = s.nextLine();
				
				
				
				
				
				eventoDAO.update(new Evento(id, id_Evento, data_Evento, nome));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				eventoDAO.delete(id);
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
