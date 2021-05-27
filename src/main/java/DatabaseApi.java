import org.telegram.messageStructure.Result;

import java.sql.*;

public class DatabaseApi {
    private String url;
    private String user;
    private String pass;

    public DatabaseApi(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public boolean createUser(long user_id, String user_first_name, String user_last_name, String username) throws SQLException {
        String insertUser = "INSERT INTO user_data (user_id, user_first_name, user_last_name, username) VALUES (?, ?, ?, ?)";
        Connection db = DriverManager.getConnection(url, user, pass);
        PreparedStatement statement = db.prepareStatement(insertUser);
        statement.setLong(1, user_id);
        statement.setString(2, user_first_name);
        statement.setString(3, user_last_name);
        statement.setString(4, username);
        int result = statement.executeUpdate();
        db.close();
        return result == 1;
    }

    public boolean isUserExists(long user_id) throws SQLException {
        String selectQuery = "SELECT username FROM user_data WHERE user_id = ?";
        Connection db = DriverManager.getConnection(url, user, pass);
        PreparedStatement statement = db.prepareStatement(selectQuery);
        statement.setLong(1, user_id);
        ResultSet result = statement.executeQuery();
        db.close();
        return result.next();
    }

    public boolean saveMessage(long user_id, int unix_time, String text) throws SQLException {
        if (!isUserExists(user_id)) {
            return false;
        }
        String insertQuery = "INSERT INTO messages (user_id, message_unix_time, message_text) VALUES (?, ?, ?)";
        Connection db = DriverManager.getConnection(url, user, pass);
        PreparedStatement statement = db.prepareStatement(insertQuery);
        statement.setLong(1, user_id);
        statement.setInt(2, unix_time);
        statement.setString(3, text);
        int result = statement.executeUpdate();
        db.close();
        return true;
    }
}
