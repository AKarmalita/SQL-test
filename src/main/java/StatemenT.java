import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StatemenT {
    private Statement statement;

    public StatemenT() throws SQLException {
        makeStatemenT();
    }

    public Statement makeStatemenT() throws SQLException {
        Connectt c = null;

        c = new Connectt();
        Connection conn = c.makeConnection();
        statement = conn.createStatement();
        return statement;
    }

    public void selectUsersById(String Id){
        String s="SELECT * FROM sys.user where id=\""+Id+"\"";
        try {
            ResultSet resultSet=statement.executeQuery(s);
            resultSet.next();
            System.out.println(resultSet.getString("username"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getListUsersByEmail(String email) throws SQLException {
        String s = "SELECT * FROM sys.user where email=\"" + email + "\"";

        ResultSet resultSet;
        List<User> users=new ArrayList<>();
        resultSet=statement.executeQuery(s);

        while (resultSet.next()){
            System.out.println(resultSet.getString("username")+" "+ resultSet.getString("email"));
        }
        return users;
    }

    public void UpdatePassword(String password,String id){
        String s="UPDATE `sys`.`user` SET `password` = \""+password+"\" WHERE (`id` = \""+id+"\")";
        try {
            statement.execute(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

