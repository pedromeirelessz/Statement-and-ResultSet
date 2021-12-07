package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		// Ir� executar um comando SQL
		Statement st = null;
		// ResultSet � representado por um objeto que recebe 
		// o resultado do statement em forma de tabela
		ResultSet rs = null;
		try {
			conn = DB.getConnection();

			// Para instanciar um statement, voc� vai chamar a variavel de conex�o que j�
			// est� instanciada, e chamar o .createStatement();
			st = conn.createStatement();

			// O metodo .executeQuery espera que voc� entre com uma String
			// E o resultado dessa consulta feita pelo .executeQuery, irei atribuir a
			// vari�vel rs que � um ResultSet
			rs = st.executeQuery("select * from department");
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}

		} catch (SQLException IO) {
			System.out.println(IO.getMessage());
		} finally {

			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
