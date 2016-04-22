package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;
import model.ListItemDAO;

/**
 * Servlet implementation class changeItemServlet
 */
@WebServlet("/changeItemServlet")
public class changeItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String oldStore = request.getParameter("oldStore");
		String newStore = request.getParameter("newStore");
		String oldItem = request.getParameter("oldItem");
		String newItem = request.getParameter("newItem");
		
		ListItem oldListItem = new ListItem(oldStore, oldItem);
		ListItem newListItem = new ListItem(newStore, newItem);
		
		ListItemDAO dao = new ListItemDAO();
		dao.updateItem(oldListItem, newListItem);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
