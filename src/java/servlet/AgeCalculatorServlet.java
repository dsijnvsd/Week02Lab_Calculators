
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AgeCalculatorServlet extends HttpServlet {
    public int finalAge;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
          String ages = request.getParameter("age");
          
          
                 
        request.setAttribute("age", ages);
        
        
        if (ages == null || ages.equals("")) {
            request.setAttribute("message", "Please enter value.");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
        }
        if(!isStringInt(ages)){
              request.setAttribute("message", "Please enter a number");
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response); 
        return;
          }
         finalAge = Integer.parseInt(ages) ;
              finalAge += 1;
              if(finalAge>151 || finalAge<1){
                  request.setAttribute("message", "Please enter a number between 0-150");
                   getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);  
       return;
              }
        request.setAttribute("message", "Your age next birthday will be " + finalAge);
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);  
         
    }


    	  public boolean isStringInt(String validate)
		{
		    try
		    {
		        Integer.parseInt(validate);
		        return true;
		    } catch (NumberFormatException ex)
		    {
		        return false;
		    }
		}
}
