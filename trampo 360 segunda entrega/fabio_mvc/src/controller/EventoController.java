package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDAO;
import model.Aluno;


@WebServlet(urlPatterns = {"/evento", "/evento-save", "/evento-delete", "/evento-edit", "/evento-update"})
public class EventoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	EventoDAO cdao = new EventoDAO();

    public EventoController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String route = request.getServletPath();
        switch (route) {
        case "/evento":
            read(request,response);
            break;
        case "/evento-save":
            save(request,response);
            break;
        case "/evento-delete":
            delete(request,response);
            break;
       case "/evento-edit":
			edit(request, response);
			break;
		case "/evento-update":
			update(request, response);
			break;
        default:

            break;
        }

    }
 
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       
        
		
    	Evento.Evento evento = null;
    	evento.setnome(request.getParameter("nome"));
    	evento.setdata_Evento(request.getParameter("data_Evento"));
    	
        
        if(request.getParameter("id")!=null){
        	evento.setId(Integer.parseInt(request.getParameter("id")));
            cdao.update(evento);

        }else {
            cdao.create(evento);
        }
        response.sendRedirect("evento");
    }
    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Evento>evento = cdao.read();
        request.setAttribute("evento", evento);
        RequestDispatcher rd=request.getRequestDispatcher("./cadastro.jsp");
        rd.forward(request, response);
        }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        cdao.delete(id);
        response.sendRedirect("evento");
    }


	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Evento evento = cdao.readById(id);
		
		request.setAttribute("evento", evento);

		RequestDispatcher rd = request.getRequestDispatcher("./cadastro.jsp");
		rd.forward(request, response);
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Evento.Evento evento = null;
    	evento.setnome(request.getParameter("nome"));
    	evento.setdata_Evento(request.getParameter("data_Evento"));
        
		
		cdao.update(evento);
		response.sendRedirect("evento");
	}
	
	}