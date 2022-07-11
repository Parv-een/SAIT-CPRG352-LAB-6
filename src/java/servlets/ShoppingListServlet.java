/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author parve
 */
public class ShoppingListServlet extends HttpServlet {
    private ArrayList<String> sitems = new ArrayList<>();
    
          private final int PAGE_SIZE=10;
          private final String SHOPPING_ITEMS="ShoppingLists";
       

   
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        
        String username=request.getParameter("username");
        String   input=request.getParameter("action");
        String item = request.getParameter("item");
        String add=request.getParameter("Add");
        String del=request.getParameter("shoppingitems");
        String message="";

        
    
        if(input.equals("Add")){
           
            sitems.add(item);
            session.setAttribute("itemlist",sitems);
            
       
        }
        if(input.equals("Delete")){
          System.out.println(del);
            sitems.remove(del);
              session.setAttribute("itemlist",sitems);
        }
        
         if(input!=null && input.equals("logout")){
             session.invalidate();
             session=request.getSession();
         }
         else{
        
            if(username==null||username.equals("")){
            message="Please enter the username";
        }
        else{
            message="Hello, " + username;
            
        }
         }
              
          session.setAttribute("message",message);
          session.setAttribute("session",session);
        
      getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        return;
    }
         
}
