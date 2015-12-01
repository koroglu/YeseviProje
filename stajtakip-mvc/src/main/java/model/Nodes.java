package model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Nodes {
	@JsonIgnore
	public List<Nodes> lstNodes = new ArrayList();
	private String id;
	private String cls;
	private Boolean leaf;
	private String text;
	
	public void buildNodes() {
		Nodes node = new Nodes("1","file",true,"Ana Menu");
		lstNodes.add(node);
		node = new Nodes("2","file",true,"Ana Menu");
		lstNodes.add(node);
		node = new Nodes("3","file",true,"Ana Menu");
		lstNodes.add(node);
		node = new Nodes("4","file",true,"Ana Menu");
		
	}
	@JsonIgnore
	public List<Nodes> getNodes()  {
		return this.lstNodes;
	}
	public Nodes(String id, String cls, Boolean leaf, String text) {
		super();
		this.id = id;
		this.cls = cls;
		this.leaf = leaf;
		this.text = text;
	}
	
	
	
	
	public Nodes() {
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public Boolean getLeaf() {
		return leaf;
	}
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	
	
}
