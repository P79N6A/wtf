package cn.tc.ulife.platform.server.utils.model;


public class UploadBean {

	private String tableName;
	
	private String serviceTableName;

	private String cols;
	
	private String path;
	
	private String id;
	
	private String type;
	

	public String getServiceTableName() {
		return serviceTableName;
	}

	public void setServiceTableName(String serviceTableName) {
		this.serviceTableName = serviceTableName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getCols() {
		return cols;
	}

	public void setCols(String cols) {
		this.cols = cols;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
