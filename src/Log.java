import java.sql.*;

public class Log {
    Connection db = null;
    public Log(String databaseName) {
        try {
            Class.forName("org.sqlite.JDBC");
            db = DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
            db.setAutoCommit(false);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    public void insert(String tableName, String data) throws SQLException {
        var sqlStatement = db.createStatement();
        String InsertQuery = "INSERT INTO " + tableName + " VALUES (" + data + ");";
        sqlStatement.executeUpdate(InsertQuery);
        sqlStatement.close();
        db.commit();
    }
    public void selectTable(String tableName) throws SQLException {
        var sqlStatement = db.createStatement();
        sqlStatement.executeUpdate("SELECT * FROM " + tableName + ";");
        sqlStatement.close();
        db.commit();
    }
}
