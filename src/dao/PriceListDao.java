package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.PriceList;
import util.DbUtil;

public class PriceListDao {

	private Connection connection;

	public PriceListDao() {
		connection = DbUtil.getConnection();
	}

	public PriceList getPriceList() {

		System.out.println("PriceListDao: getPriceList...");

		PriceList list = new PriceList();

		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT price FROM payment");

			while (rs.next()) {
				list.setPaymentPrzelew(rs.getInt(1));
				rs.next();
				list.setPaymentGotowka(rs.getInt(1));
			}

			rs = statement.executeQuery("SELECT price FROM photo_format");
			while (rs.next()) {
				list.setPhotoFormat9x13(rs.getInt(1));
				rs.next();
				list.setPhotoFormat10x15(rs.getInt(1));
				rs.next();
				list.setPhotoFormat13x18(rs.getInt(1));
			}

			rs = statement.executeQuery("SELECT price FROM retouch");
			while (rs.next()) {
				list.setRetouchNone(rs.getInt(1));
				rs.next();
				list.setRetouchEyes(rs.getInt(1));
				rs.next();
				list.setRetouchMontage(rs.getInt(1));
			}

			rs = statement.executeQuery("SELECT price FROM sealing");
			while (rs.next()) {
				list.setSealingNone(rs.getInt(1));
				rs.next();
				list.setSealingFull(rs.getInt(1));
			}

			rs = statement.executeQuery("SELECT price FROM shipment");
			while (rs.next()) {
				list.setShipmentKurier(rs.getInt(1));
				rs.next();
				list.setShipmentPolecony(rs.getInt(1));
				rs.next();
				list.setShipmentEko(rs.getInt(1));
			}

		} catch (SQLException e) {
			System.out.println("Error - download PriceList");
			e.printStackTrace();
			return null;
		}
		return list;

	}

	public boolean savePriceList(PriceList list) {

		/*
		 * UPDATE `photo_format` SET `price` = '33' WHERE `photo_format`.`id_photo_format` = 1
		 * UPDATE `payment` SET `price` = '33' WHERE `payment`.`id_payment` = 1
		 * UPDATE `shipment` SET `price` = '141' WHERE `shipment`.`id_shipment` = 1
		 * UPDATE `retouch` SET `price` = '222' WHERE `retouch`.`id_retouch` = 2
		 * UPDATE `sealing` SET `price` = '1' WHERE `sealing`.`id_sealing` = 1
		 */
		
		Statement statement;
		try {
			statement = connection.createStatement();
			
			String sql;
			
			sql = "UPDATE `photo_format` SET `price` = '" + list.getPhotoFormat9x13() + "' WHERE `photo_format`.`id_photo_format` = 1";
			statement.executeUpdate(sql);
			sql = "UPDATE `photo_format` SET `price` = '" + list.getPhotoFormat10x15() + "' WHERE `photo_format`.`id_photo_format` = 2";
			statement.executeUpdate(sql);
			sql = "UPDATE `photo_format` SET `price` = '" + list.getPhotoFormat13x18() + "' WHERE `photo_format`.`id_photo_format` = 3";
			statement.executeUpdate(sql);
			
			sql = "UPDATE `payment` SET `price` = '" + list.getPaymentPrzelew() + "' WHERE `payment`.`id_payment` = 1";
			statement.executeUpdate(sql);
			sql = "UPDATE `payment` SET `price` = '" + list.getPaymentGotowka() + "' WHERE `payment`.`id_payment` = 2";
			statement.executeUpdate(sql);
			
			sql = "UPDATE `retouch` SET `price` = '" + list.getRetouchNone() + "' WHERE `retouch`.`id_retouch` = 1";
			statement.executeUpdate(sql);
			sql = "UPDATE `retouch` SET `price` = '" + list.getRetouchEyes() + "' WHERE `retouch`.`id_retouch` = 2";
			statement.executeUpdate(sql);
			sql = "UPDATE `retouch` SET `price` = '" + list.getRetouchMontage() + "' WHERE `retouch`.`id_retouch` = 3";
			statement.executeUpdate(sql);
			
			//sealing
			sql = "UPDATE `sealing` SET `price` = '" + list.getSealingNone() + "' WHERE `sealing`.`id_sealing` = 1";
			statement.executeUpdate(sql);
			sql = "UPDATE `sealing` SET `price` = '" + list.getSealingFull() + "' WHERE `sealing`.`id_sealing` = 2";
			statement.executeUpdate(sql);
			
			//shipment
			
			sql = "UPDATE `shipment` SET `price` = '" + list.getShipmentKurier() + "' WHERE `shipment`.`id_shipment` = 1";
			statement.executeUpdate(sql);
			sql = "UPDATE `shipment` SET `price` = '" + list.getShipmentPolecony() + "' WHERE `shipment`.`id_shipment` = 2";
			statement.executeUpdate(sql);
			sql = "UPDATE `shipment` SET `price` = '" + list.getShipmentEko() + "' WHERE `shipment`.`id_shipment` = 3";
			statement.executeUpdate(sql);
			
			
			
		} catch (SQLException e) {
			System.out.println("Error - upload PriceList");
			e.printStackTrace();
			return false;
		}
	     

		
		return true;

	}

}
