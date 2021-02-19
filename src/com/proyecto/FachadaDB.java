package com.proyecto;

import java.sql.*;

public class FachadaDB {
	//verificar cadena 
	// - - - - - - - - - - - - - - - - - - - - - -
	// Constantes
	// - - - - - - - - - - - - - - - - - - - - - -
    /**
     * Driver de conexi�n a la base de datos
     */
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
    /**
     * La cadena de conexi�n a la base de datos que incluye la zona horaria
     */
	public static final String URL = "jdbc:mysql://localhost:3306/aforo?serverTimezone=UTC";
	
    /**
     * Nombre del usuario con el que se conecta a la base de datos
     */
	public static final String USUARIO = "root";
	
    /**
     * Clave de acceso a la base de datos
     */
	public static final String PASSWORD = "123456";

	// - - - - - - - - - - - - - - - - - - - - - -
	// Atributos
	// - - - - - - - - - - - - - - - - - - - - - -
    /**
     * La cadena de conexi�n a la base de datos que incluye la zona horaria
     */
	private String url;
	
    /**
     * Nombre del usuario con el que se conecta a la base de datos
     */
	private String usuario;
	
    /**
     * Clave de acceso a la base de datos
     */
	private String password;
	
    /**
     * Objeto que mantiene la conexi�n a la base de datos
     */
	private Connection conexion;

	// - - - - - - - - - - - - - - - - - - - - - -
	// M�todos
	// - - - - - - - - - - - - - - - - - - - - - -
	/**
	 * El constructor de la clase FachadaBD
	 */
	public FachadaDB()
	{
		url = URL;
		usuario = USUARIO;
		password = PASSWORD;
		conexion = null;
	}
	
	/**
	 * Crea un objetivo de tipo conexi�n con la base de datos
	 * @return retorna el objetivo de tipo conexi�n
	 * @throws SQLException. Lanza una excepci�n si no se ejecuta la sentencia sql.
	 * @throws ClassNotFoundException. Lanza una excepci�n, si no se conecta a la Base de datos.
	 */
	public Connection conectar() throws SQLException, ClassNotFoundException 
	{
		Class.forName(DRIVER);
		conexion = DriverManager.getConnection(url,usuario,password);
		return conexion;
	}
	
	/**
	 * Cierra una conexi�n a la base de datos.
	 * @param laConexion, El objeto de tipo conexi�n laConexion!=null
	 * @throws SQLException. Lanza una excepci�n si no se ejecuta la sentencia sql.
	 */
	public void desconectar(Connection laConexion) throws SQLException
	{
		laConexion.close();
	}
}