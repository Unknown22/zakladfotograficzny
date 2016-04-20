package model;

import java.io.File;

public class Photo {

	private int idPhoto;
	private int idOrder;
	private String fileName;
	private int idService;
	private String fileType;
	private long fileSize;
	private File binaryFile;
	
	
	
	public Photo() {
	}
	
	
	public Photo(int idOrder, String fileName, int idService, String fileType, int fileSize, File binaryFile) {
		super();
		this.idOrder = idOrder;
		this.fileName = fileName;
		this.idService = idService;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.binaryFile = binaryFile;
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
	public File getBinaryFile() {
		return binaryFile;
	}
	public void setBinaryFile(File binaryFile) {
		this.binaryFile = binaryFile;
	}


	@Override
	public String toString() {
		return "Photo [idPhoto=" + idPhoto + ", idOrder=" + idOrder + ", fileName=" + fileName + ", idService="
				+ idService + ", fileType=" + fileType + ", fileSize=" + fileSize / 1024 + " KB, binaryFile=" + binaryFile + "]";
	}
	
	
	
	
}
