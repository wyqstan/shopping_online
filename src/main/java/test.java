import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
public class test {
    public static void main(String[] args) throws SQLException {

//1.创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
//2.获取连接对象
        Connection conn = ds.getConnection();
//3.打印
        System.out.println(conn);
    }
}
