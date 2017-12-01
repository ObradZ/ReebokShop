/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.HibernateUtil;
import model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Dell
 */
@WebServlet(name = "DataEntry", urlPatterns = {"/DataEntry"})
@MultipartConfig
public class DataEntry extends HttpServlet {

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
	try {
//	    Getting parameters from admin.jsp
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    String name = request.getParameter("name");
	    String categorySt = request.getParameter("category");
	    String genderSt = request.getParameter("gender");
	    String priceSt = request.getParameter("price");
	    String stackSt = request.getParameter("stack");
	    Part picture = request.getPart("image");

	    String pictureName = System.currentTimeMillis() + picture.getSubmittedFileName();

//	    String to INT or DOUBLE!
	    int category = Integer.parseInt(categorySt);
	    int gender = Integer.parseInt(genderSt);
	    double price = Double.parseDouble(priceSt);
	    short stack = Short.parseShort(stackSt);

//	    InputStream for picture
	    InputStream is = picture.getInputStream();
	    String folderName = "ProductImages";
//	    Lets make dir if it doesn't exist!	
	    File file = new File(request.getServletContext().getRealPath("/") + folderName);
	    if (!file.exists()) {
		file.mkdirs();
	    }
//	    Okey lets write that picture down!(saving picture)
	    FileOutputStream fos = new FileOutputStream(file.getAbsolutePath()+"/"+pictureName);
	    int b;
	    while((b=is.read())!=-1){
		fos.write(b);
	    }
	    fos.flush();
	    fos.close();
	    is.close();
	    
//	    Finnaly saving product in database
	Product product = new Product();
	product.setCategoryId(category);
	product.setGender(gender);
	product.setImage(pictureName);
	product.setName(name);
	product.setPrice(price);
	product.setStack(stack);
	session.save(product);
//	    closing session
	    if (session.isOpen()) {
		session.close();
	    }
//	    redirect to admin.jsp with right message
	    request.setAttribute("rez", "Successfuly updated!");
	    request.getRequestDispatcher("admin.jsp").forward(request, response);
	} catch (NumberFormatException nfe) {
	    request.setAttribute("rez", "NumberFormatException fail");
	    request.getRequestDispatcher("admin.jsp").forward(request, response);
	} catch (IOException ex) {
	    request.setAttribute("rez", "IOException");
	    request.getRequestDispatcher("admin.jsp").forward(request, response);
	} catch (ServletException se) {
	   request.setAttribute("rez", "ServletException");
	    request.getRequestDispatcher("admin.jsp").forward(request, response);
	} catch (HibernateException hbmE) {
	    request.setAttribute("rez", "HBM FAIL");
	    request.getRequestDispatcher("admin.jsp").forward(request, response);
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
