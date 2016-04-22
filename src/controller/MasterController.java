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
 * Servlet implementation class MasterController
 */
@WebServlet("/MasterController")
public class MasterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterController() {
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
		String act = request.getParameter("doThisToItem");
		ListItemDAO dao = new ListItemDAO();
		if (act.equals("add item")) {
			getServletContext().getRequestDispatcher("/addItems.html").forward(request, response);
		} else if (act.equals("delete item")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListItem toDelete = dao.getListOfAllItems().get(tempId);
			dao.deleteItem(toDelete);			
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);

		} else if (act.equals("edit item")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListItem toChange = dao.getListOfAllItems().get(tempId);
			
			request.setAttribute("store", toChange.getStore());
			request.setAttribute("item", toChange.getItem());
			
			getServletContext().getRequestDispatcher("/editItem.jsp").forward(request, response);
			
			
		}
	}

}
