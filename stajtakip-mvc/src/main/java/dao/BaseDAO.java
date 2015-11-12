package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	private void init() {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

	
	
}
