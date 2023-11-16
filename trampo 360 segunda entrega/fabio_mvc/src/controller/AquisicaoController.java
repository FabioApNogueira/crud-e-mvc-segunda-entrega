package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AquisicaoDAO;
import model.Aquisicao;


@WebServlet(urlPatterns = {"/aquisicao", "/aquisicao-save", "/aquisicao-delete", "/aquisicao-edit", "/aquisicao-update"})
public class AquisicaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	AquisicaoDAO cdao = new AquisicaoDAO();

    public AquisicaoController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String route = request.getServletPath();
        switch (route) {
        case "/aquisicao":
            read(request,response);
            break;
        case "/aquisicao-save":
            save(request,response);
            break;
        case "/aquisicao-delete":
            delete(request,response);
            break;
       case "/aquisicao-edit":
			edit(request, response);
			break;
		case "/aquisicao-update":
			update(request, response);
			break;
        default:

            break;
        }

    }
 
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       
        
		
		Aquisicao.Aquisicao aquisicao = null;
		aquisicao.setdata_Aquisicao(request.getParameter("data_Aquisicao"));
		aquisicao.setnome(request.getParameter("nome"));
		aquisicao.setid_Evento(request.getParameter("id_Evento"));
		aquisicao.setid_Aluno(request.getParameter("id_Aluno"));
		
        
        if(request.getParameter("id")!=null){
        	aquisicao.setId(Integer.parseInt(request.getParameter("id")));
            cdao.update(aquisicao);

        }else {
            cdao.create(aquisicao);
        }
        response.sendRedirect("aquisicao");
    }
    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Aquisicao>aquisicao = cdao.read();
        request.setAttribute("aquisicao", aquisicao);
        RequestDispatcher rd=request.getRequestDispatcher("./cadastro.jsp");
        rd.forward(request, response);
        }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        cdao.delete(id);
        response.sendRedirect("aquisicao");
    }


	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Aquisicao aquisicao = cdao.readById(id);
		
		request.setAttribute("aquisicao", aquisicao);

		RequestDispatcher rd = request.getRequestDispatcher("./cadastro.jsp");
		rd.forward(request, response);
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Aquisicao aquisicao = null;
		aluno.setId(Integer.parseInt(request.getParameter("id")));
		aquisicao.setdata_Aquisicao(request.getParameter("data_Aquisicao"));
		aquisicao.setnome(request.getParameter("nome"));
		aquisicao.setid_Evento(request.getParameter("id_Evento"));
		aquisicao.setid_Aluno(request.getParameter("id_Aluno"));
        
		
		cdao.update(aquisicao);
		response.sendRedirect("aquisicao");
	}
	
	}