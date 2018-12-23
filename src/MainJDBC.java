/**
 * JDBC usage examples
 */
public class MainJDBC {

	public static void main(String[] args) {
		JDBCExample jdbcExample;

		TCPServer server = new TCPServer(6788);
		// creating the example object
		jdbcExample = new JDBCExample(server);

		// connecting
		if (!jdbcExample.openConnection())
			return;

		// demo executeQuery
		 jdbcExample.read10SongFromDB();

		// demo executeUpdate
		// jdbcExample.demoExecuteUpdate();

		// demo transactions
		// jdbcExample.demoTransactions();

		// demo without prepared statement
		// jdbcExample.demoWithoutPreparedStatement();

		// demo with prepared statement
		// jdbcExample.demoWithPreparedStatement();

		// demo batch prepared statement
		// jdbcExample.demoBatchPreparedStatement();

		// demo batch prepared statement (single transaction)
		// jdbcExample.demoBatchPreparedStatementTransaction();

		// demo get back the generated id
		// jdbcExample.demoGetGeneratedID();

		// close the connection
		jdbcExample.closeConnection();

		System.out.println("Done :)");
	}

}
