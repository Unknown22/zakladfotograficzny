package model;

import java.io.File;
import java.io.InputStream;

public class Photo {

	private int idPhoto;
	private int idOrder;
	private String fileName;
	private int idService;
	private String fileType;
	private long fileSize;
	private InputStream inputStream;
	
	
	/**
	 * format zdjec
	 * 1 - 9x13
	 * 2 - 10x15
	 * 3 - 13x18
	 * 
	 */
	
	public Photo() {
	}
	
	
	public Photo(int idOrder, String fileName, int idService, String fileType, long fileSize, InputStream inputstream) {
		super();
		this.idOrder = idOrder;
		this.fileName = fileName;
		this.idService = idService;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.inputStream = inputstream;
	}
	public int getIdPhoto() {
		return idPhoto;
	}
	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getIdService() {
		return idService;
	}
	public void setIdService(int idService) {
		this.idService = idService;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public long getFileSize() {
		return fileSize;
	}
	
	
	public void setFileSize(long l) {
		this.fileSize = l;
	}


	@Override
	public String toString() {
		return "Photo [idPhoto=" + idPhoto + ", idOrder=" + idOrder + ", fileName=" + fileName + ", idService="
				+ idService + ", fileType=" + fileType + ", fileSize=" + fileSize / 1024 + " KB, inputStream=" + inputStream + "]";
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
	
	
}
