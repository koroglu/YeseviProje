package hello;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Composite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.BaseDAO;

@RestController
public class SoaController  {

	@Autowired
	private BaseDAO baseDAO;

	@RequestMapping("/soa")
	public Map<String, Object> hi(HttpServletResponse resp) throws IOException {
		Map m = new HashMap();
		List l = baseDAO.getJdbcTemplate().queryForList("select * from soa_domains");
		m.put("list", l);
		return m;
	}

	@RequestMapping("/jndi")
	public Map<String, Object> jndi(HttpServletResponse resp) throws Exception {

		Properties env = new Properties();
		env.put("Context.INITIAL_CONTEXT_FACTORY", "weblogic.jndi.WLInitialContextFactory");
		env.put("Context.PROVIDER_URL", "t3://mimoza:9001");
		env.put("java.naming.security.principal", "weblogic");
		env.put("java.naming.security.credentials", "Deme1212:.");
		env.put("java.naming.provider.url", "t3://mimoza:9001");

		env.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
		Context context = new InitialContext(env);

		try {
			DataSource ds = (DataSource) context.lookup("jdbc/SOADataSource");
			System.out.println(ds.getConnection().toString());
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/connect")
	public Map<String, Object> connect(HttpServletResponse resp) throws Exception {
		Map<String, Object> m = baseDAO.getJdbcTemplate().queryForMap("select * from soa_domains where soa_domain_name=:domainName", new Object[] { "telaura_prod_soa" });
		System.out.println(m.get("JDBC_URL"));

		Connection cn = DriverManager.getConnection((String) m.get("JDBC_URL"), (String) m.get("JDBC_USER"), (String) m.get("JDBC_PASS"));

		PreparedStatement pst = cn.prepareStatement("SELECT * FROM DBA_SCHEDULER_JOBS  order by last_start_date desc");
		ResultSet rst = pst.executeQuery();
		List l = new ArrayList();
		while (rst.next()) {
			l.add(rst.getString(2));
		}
		m.put("liste", l);
		return m;

	}

	@RequestMapping("/hi")
	public Map<String, Object> himy(HttpServletResponse resp) throws IOException {
		Map<String, Object> m = new HashMap();
		m.put("list", "liste olsun");
		m.put("adi", "umit");

		Composite comp = new Composite();
		comp.setCompositeName("bpelDenem");
		comp.setVersionNumber("1.0");

		m.put("comp", comp);

		return m;
	}

//	private final ErrorAttributes errorAttributes;
//
//	@Override
//	public String getErrorPath() {
//		return "/error";
//	}
//
//	@Autowired
//	public SoaController(ErrorAttributes errorAttributes) {
//		Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
//		this.errorAttributes = errorAttributes;
//	}

}
