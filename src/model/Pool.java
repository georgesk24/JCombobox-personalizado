package model;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author SOFTWARE GALAXIA
 */
public class Pool {

    private final String DB="pruebas";
    private final String URL="jdbc:mysql://localhost/"+DB;
    private final String USER="root";
    private final String PASS="";    
    
    public DataSource initializeDataSource(){

        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);
        basicDataSource.setMaxActive(50);
        
        return basicDataSource;

    }    
    
    
    
}
