<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.sql.*" %>
<%
    /*conexion sera nuestra conexion a la bd*/
    Connection conexion=null;
 
    String mensaje="";
 
    /*parametros para la conexion*/
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/aforo";
    String usuario = "root";
    String clave = "";
    /*procedimiento de la conexion*/
    try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url,usuario,clave);
 
        /*guardando la conexion en la session*/
        session.setAttribute("conexion",conexion);
    } catch (Exception ex){
        mensaje=ex.toString();
    }
 
    mensaje="conectado";
    if(conexion.isClosed()){
        mensaje="desconectado";
    }
%>


<html>
    <head>
        <title>EJERCICIO 03 CONEXION BD CON JSP</title>
    </head>
    <body>
        <form action="desconectar.jsp" method="post">
            <input name="estado" type="text" value="Estado: <%=mensaje%>"/>
            <input type="submit" value="Desconectar"/>
        </form>
    </body>
</html>