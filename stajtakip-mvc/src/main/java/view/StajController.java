package view;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import security.SessionClientData;
import dao.BaseDAO;

@RestController
public class StajController  {

	@Autowired
	private BaseDAO baseDAO;
	
	@Autowired
	private SessionClientData scd;

		
	@RequestMapping(value="/staj/takip")
	public Map<String,Object> stajTakipTest() throws IOException {
		Map<String,Object> m = new HashMap();
		m.put("Selam","Geyik");
		return m;
	}

	@RequestMapping(value="/staj/listNodes.ajax")
	public Map<String,Object> listNodes() throws IOException {
		Map<String,Object> m = new HashMap();
		List l = baseDAO.getJdbcTemplate().queryForList("select ID as \"nodeId\" , PARENT_ID as \"parentId\", ID as \"id\", TEXT as \"text\", "
					+ "CLS as \"cls\", LEAF as  \"leaf\", COMPONENT_NAME as \"componentName\" from nodes");
		m.put("list",l);
		return m;
	}
	
	
}
