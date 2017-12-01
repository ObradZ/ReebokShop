/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Dell
 */
@WebServlet(name = "Products", urlPatterns = {"/Products"})
public class Products extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	try (PrintWriter out = response.getWriter()) {
	    try {
		String genderS = request.getParameter("gender");
		String catS = request.getParameter("category");
		int gender = Integer.parseInt(genderS);
		int cat = Integer.parseInt(catS);
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query q = session.createQuery("from Product as prod where prod.gender=:gender and prod.categoryId=:cat");
		q.setParameter("gender", gender);
		q.setParameter("cat", cat);
		List<Product> products = q.list();

		if (session.isOpen()) {
		    session.close();
		}
		if (products.isEmpty()) {
		    request.setAttribute("products", products);
		    request.setAttribute("h1", "There are no products for that category at the moment!");
		    request.getRequestDispatcher("products.jsp").forward(request, response);
		} else {
		    request.setAttribute("products", products);
		    request.getRequestDispatcher("products.jsp").forward(request, response);
		}
	    } catch (IOException ie) {
		System.out.println(ie.getMessage());
	    } catch (ServletException se) {
		System.out.println(se.getMessage());
	    } catch (HibernateException he) {
		System.out.println(he.getMessage());
	    }catch(NumberFormatException nfe){
//		WHO CAAAREEES :D
	    }
	}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
