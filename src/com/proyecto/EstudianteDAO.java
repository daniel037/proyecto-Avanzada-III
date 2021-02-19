package com.proyecto;

import java.sql.*;
import java.util.ArrayList;


public class EstudianteDAO {

	// - - - - - - - - - - - - - - - - - - - - - -
	// Atributos
	// - - - - - - - - - - - - - - - - - - - - - -
	/**
	 * La fechada a la Base de datos
	 */
	private FachadaDB fachada;


	// - - - - - - - - - - - - - - - - - - - - - -
	// Métodos
	// - - - - - - - - - - - - - - - - - - - - - -
	/**
	 * El constructor de la clase PersonaDAO
	 */
	public EstudianteDAO()
	{
		fachada = new FachadaDB();
	}

	/** 
	 * Consulta las personas.
	 * <br><b>post:</b> Se ha consultado y retornado las personas
	 * @return Lista de las personas.
	 * @throws SQLException. Lanza una excepción si no se ejecuta la sentencia sql.
	 * @throws ClassNotFoundException. Lanza una excepción, si no se conecta a la Base de datos.
	 */
	public ArrayList consultar()throws ClassNotFoundException, SQLException 
	{
		ArrayList estudiantes = new ArrayList();
		String sqlConsultar = "SELECT ide, nombre FROM estudiante ORDER BY ide";
		Connection miConexion = fachada.conectar();
		if(miConexion != null)
		{
			Statement instruccion = miConexion.createStatement();
			ResultSet tabla = instruccion.executeQuery(sqlConsultar);
			while(tabla.next())
			{
					
				Estudiante estudiante = new Estudiante(tabla.getString("ide"), tabla.getString("nombre"));
				estudiantes.add(estudiante);
			}
				fachada.desconectar(miConexion);
		}
		
		return estudiantes;
	}
}

