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


@WebServlet(urlPatterns = {"/aluno", "/aluno-save", "/aluno-delete", "/aluno-edit", "/aluno-update"})
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	AlunoDAO cdao = new AlunoDAO();

    public AlunoController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String route = request.getServletPath();
        switch (route) {
        case "/aluno":
            read(request,response);
            break;
        case "/aluno-save":
            save(request,response);
            break;
        case "/aluno-delete":
            delete(request,response);
            break;
       case "/aluno-edit":
			edit(request, response);
			break;
		case "/aluno-update":
			update(request, response);
			break;
        default:

            break;
        }

    }
 
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       
        
		
		Aluno.Aluno aluno = null;
		aluno.setid_Aluno(request.getParameter("id_Aluno"));
		aluno.setCPF(request.getParameter("CPF"));
		aluno.setemail(request.getParameter("email"));
		aluno.setnome(request.getParameter("nome"));
		aluno.setsenha(request.getParameter("senha"));
        
        if(request.getParameter("id")!=null){
        	aluno.setId(Integer.parseInt(request.getParameter("id")));
            cdao.update(aluno);

        }else {
            cdao.create(aluno);
        }
        response.sendRedirect("aluno");
    }
    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Aluno>aluno = cdao.read();
        request.setAttribute("aluno", aluno);
        RequestDispatcher rd=request.getRequestDispatcher("./cadastro.jsp");
        rd.forward(request, response);
        }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        cdao.delete(id);
        response.sendRedirect("aluno");
    }


	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Aluno aluno = cdao.readById(id);
		
		request.setAttribute("aluno", aluno);

		RequestDispatcher rd = request.getRequestDispatcher("./cadastro.jsp");
		rd.forward(request, response);
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Aluno aluno = null;
		aluno.setId(Integer.parseInt(request.getParameter("id")));
		aluno.setid_Aluno(request.getParameter("id_Aluno"));
		aluno.setCPF(request.getParameter("CPF"));
		aluno.setemail(request.getParameter("email"));
		aluno.setnome(request.getParameter("nome"));
		aluno.setsenha(request.getParameter("senha"));
        
		
		cdao.update(aluno);
		response.sendRedirect("aluno");
	}
	
	}