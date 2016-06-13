package model;

public class PhotoService {
	
	private int id_service;
	private int copies;
	private int id_photo_format;
	private int id_sealing;
	private int id_retouch;
	
	
	public int getId_service() {
		return id_service;
	}
	public void setId_service(int id_service) {
		this.id_service = id_service;
	}
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	public int getId_photo_format() {
		return id_photo_format;
	}
	public void setId_photo_format(int id_photo_format) {
		this.id_photo_format = id_photo_format;
	}
	public int getId_sealing() {
		return id_sealing;
	}
	public void setId_sealing(int id_sealing) {
		this.id_sealing = id_sealing;
	}
	public int getId_retouch() {
		return id_retouch;
	}
	public void setId_retouch(int id_retouch) {
		this.id_retouch = id_retouch;
	}
	
	@Override
	public String toString() {
		return "PhotoService [id_service=" + id_service + ", copies=" + copies + ", id_photo_format=" + id_photo_format
				+ ", id_sealing=" + id_sealing + ", id_retouch=" + id_retouch + "]";
	}
}
