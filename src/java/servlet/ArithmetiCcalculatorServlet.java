/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmetiCcalculatorServlet extends HttpServlet {
 public double result;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             request.setAttribute("message", "Result: ---");
             getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        
          String first = request.getParameter("First");
          String second = request.getParameter("Second");         
//          String resultSet = request.getParameter("resultset");       
          
        request.setAttribute("First", first);
        request.setAttribute("Second", second);
        
        
        if (first == null || first.equals("") || second == null || second.equals("")) {
            request.setAttribute("message", "Result: invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
        if(!isStringInt(first) || !isStringInt(second)){
              request.setAttribute("message", "Result: invalid");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response); 
        return;
          }
        
        double numFirst = Double.parseDouble(first);
        double numSecond = Double.parseDouble(second);
         
        String buttonClicked = request.getParameter("button");
            if(null == buttonClicked){
                  request.setAttribute("message", "Result: invalid");
                   getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response); 
                    return;
            }
              
            if("+".equals(buttonClicked)){
                result = numFirst + numSecond;
                 request.setAttribute("message", "Result: " + formatDouble(result));
                 getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);  
            }
              // do stuff for condion A
            if("-".equals(buttonClicked)){
                 result = numFirst - numSecond;
                  request.setAttribute("message", "Result: " + formatDouble(result));
                 getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);  
            }
              // do stuff for condion B
            if("*".equals(buttonClicked)){
                 result = numFirst * numSecond;
                  request.setAttribute("message", "Result: " + formatDouble(result));
                 getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);  
            }
            
             if("/".equals(buttonClicked)){
                 
                 if(numFirst != 0){
                     result = numFirst / numSecond;
                      request.setAttribute("message", "Result: " + formatDouble(result));
                 getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);  
                 }
                 else{
                  request.setAttribute("message", "Result: invalid");
                   getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response); 
                    return;
                 }
            }

        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);  
         
    }


    	  public boolean isStringInt(String validate)
		{
		    try
		    {
		        Double.parseDouble(validate);
		        return true;
		    } catch (NumberFormatException ex)
		    {
		        return false;
		    }
		}
          
          public String formatDouble(double s) {
		DecimalFormat fmt = new DecimalFormat("##0.00");
		return fmt.format(s);
          }
}
