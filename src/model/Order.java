package model;

public class Order {

	private int id;
	private int idStatus;
	private String creationTime;
	private String lastEditTime;
	private String addedInfo;
	private int idPayment;
	private int idShippment;
	private int idDepartment;
	
	public Order(){
		
	}
	
	public Order(int idStatus, String addedInfo, int idPayment, int idShippment, int idDepartment) {
		
		this.idStatus = idStatus;
		this.addedInfo = addedInfo;
		this.idPayment = idPayment;
		this.idShippment = idShippment;
		this.idDepartment = idDepartment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public String getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(String lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	public String getAddedInfo() {
		return addedInfo;
	}
	public void setAddedInfo(String addedInfo) {
		this.addedInfo = addedInfo;
	}
	public int getIdPayment() {
		return idPayment;
	}
	
	/**
	 * 1 - przelew
	 * 2 - gotowka
	 * @param idPayment
	 */
	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}
	public int getIdShippment() {
		return idShippment;
	}
	
	/**
	 * 
	 * 1 - Kurier
	 * 2 - list polecony
	 * 3 - list eko 
	 * @param idShippment
	 */
	public void setIdShippment(int idShippment) {
		this.idShippment = idShippment;
	}
	public int getIdDepartment() {
		return idDepartment;
	}
	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}
	
	

}
