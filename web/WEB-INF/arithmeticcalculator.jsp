<%-- 
    Document   : arithmeticcalculator
    Created on : 24-Sep-2020, 2:06:44 PM
    Author     : 809968
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        
        <form method="post" action="arithmetic">
            First: <input type="text" name="First" ><br>
            Second: <input type="text" name="Second" ><br>
            <input type="submit" value="+" name="button">
            <input type="submit" value="-" name="button">
            <input type="submit" value="*" name="button">
            <input type="submit" value="/" name="button">
        </form>
            <div>
                
                ${message}
                    
            </div>
            <a href="age">Age Calculator</a>    
    </body>
</html>
