package model;

public class PriceList {

	
	private int paymentPrzelew;
	private int paymentGotowka;
	
	private int photoFormat9x13;
	private int photoFormat10x15;
	private int photoFormat13x18;
	
	private int retouchNone;
	private int retouchEyes;
	private int retouchMontage;

	
	private int sealingNone;
	private int sealingFull;
	
	private int shipmentKurier;
	private int shipmentPolecony;
	private int shipmentEko;
	
	
	public void setDefault(){
		paymentPrzelew = 5;
		paymentGotowka = 5;
		
		photoFormat9x13 = 1;
		photoFormat10x15 = 3;
		photoFormat13x18 = 5;
		
		retouchNone = 0;
		retouchEyes = 2;
		retouchMontage = 35;
		
		sealingNone = 0;
		sealingFull = 5;
		
		shipmentKurier = 14;
		shipmentPolecony = 7;
		shipmentEko = 4;
	}
	
	public PriceList() {
	}
	
	

	public PriceList(int cenaAll) {
		super();
		this.paymentPrzelew = cenaAll;
		this.paymentGotowka = cenaAll;
		this.photoFormat9x13 = cenaAll;
		this.photoFormat10x15 = cenaAll;
		this.photoFormat13x18 = cenaAll;
		this.retouchNone = cenaAll;
		this.retouchEyes = cenaAll;
		this.retouchMontage = cenaAll;
		this.sealingNone = cenaAll;
		this.sealingFull = cenaAll;
		this.shipmentKurier = cenaAll;
		this.shipmentPolecony = cenaAll;
		this.shipmentEko = cenaAll;
	}

	public int getPaymentPrzelew() {
		return paymentPrzelew;
	}

	public void setPaymentPrzelew(int paymentPrzelew) {
		this.paymentPrzelew = paymentPrzelew;
	}

	public int getPaymentGotowka() {
		return paymentGotowka;
	}

	public void setPaymentGotowka(int paymentGotowka) {
		this.paymentGotowka = paymentGotowka;
	}

	public int getPhotoFormat9x13() {
		return photoFormat9x13;
	}

	public void setPhotoFormat9x13(int photoFormat9x13) {
		this.photoFormat9x13 = photoFormat9x13;
	}

	public int getPhotoFormat10x15() {
		return photoFormat10x15;
	}

	public void setPhotoFormat10x15(int photoFormat10x15) {
		this.photoFormat10x15 = photoFormat10x15;
	}

	public int getPhotoFormat13x18() {
		return photoFormat13x18;
	}

	public void setPhotoFormat13x18(int photoFormat13x18) {
		this.photoFormat13x18 = photoFormat13x18;
	}

	public int getRetouchNone() {
		return retouchNone;
	}

	public void setRetouchNone(int retouchNone) {
		this.retouchNone = retouchNone;
	}

	public int getRetouchEyes() {
		return retouchEyes;
	}

	public void setRetouchEyes(int retouchEyes) {
		this.retouchEyes = retouchEyes;
	}

	public int getRetouchMontage() {
		return retouchMontage;
	}

	public void setRetouchMontage(int retouchMontage) {
		this.retouchMontage = retouchMontage;
	}

	public int getSealingNone() {
		return sealingNone;
	}

	public void setSealingNone(int sealingNone) {
		this.sealingNone = sealingNone;
	}

	public int getShipmentKurier() {
		return shipmentKurier;
	}

	public void setShipmentKurier(int shipmentKurier) {
		this.shipmentKurier = shipmentKurier;
	}

	public int getShipmentPolecony() {
		return shipmentPolecony;
	}

	public void setShipmentPolecony(int shipmentPolecony) {
		this.shipmentPolecony = shipmentPolecony;
	}

	public int getShipmentEko() {
		return shipmentEko;
	}

	public void setShipmentEko(int shipmentEko) {
		this.shipmentEko = shipmentEko;
	}

	@Override
	public String toString() {
		return "PriceList [paymentPrzelew=" + paymentPrzelew + ", paymentGotowka=" + paymentGotowka
				+ ", photoFormat9x13=" + photoFormat9x13 + ", photoFormat10x15=" + photoFormat10x15
				+ ", photoFormat13x18=" + photoFormat13x18 + ", retouchNone=" + retouchNone + ", retouchEyes="
				+ retouchEyes + ", retouchMontage=" + retouchMontage + ", sealingNone=" + sealingNone + ", sealingFull="
				+ sealingFull + ", shipmentKurier=" + shipmentKurier + ", shipmentPolecony=" + shipmentPolecony
				+ ", shipmentEko=" + shipmentEko + "]";
	}

	public int getSealingFull() {
		return sealingFull;
	}

	public void setSealingFull(int sealingFull) {
		this.sealingFull = sealingFull;
	}
	
	

	
}

