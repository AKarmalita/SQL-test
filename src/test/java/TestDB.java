import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class TestDB {
    static StatemenT dbDriver;
    @BeforeClass
    public static void start(){
        dbDriver = SQLInstans.getInstance();
    }

    @Test
    public void test1(){
        dbDriver.selectUsersById("65431");
    }

    @Test
    public void test2() throws SQLException {
        dbDriver.getListUsersByEmail("rrr@ggg.com");
        }

    @Test
    public void test3(){
        dbDriver.UpdatePassword("n121212","1252");
    }


    }
