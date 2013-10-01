package base.dbunit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DbUnitManagerFactory {

	DataSource dataSource;
	
	@Autowired
	public DbUnitManagerFactory(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public DbUnitManager getDbUnitManager() {
		return new DbUnitManagerHSQLDBServer(dataSource);
	}
	
}
