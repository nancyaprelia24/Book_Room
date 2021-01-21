package com.ruangan.client.model;
import java.util.Date;

public class Ruangan {
		private int id_ruangan;
		private String nama_ruangan;
		private String keperluan;
		private String tanggal_booking;
		public int getId_ruangan() {
			return id_ruangan;
		}
		public void setId_ruangan(int id_ruangan) {
			this.id_ruangan = id_ruangan;
		}
		public String getNama_ruangan() {
			return nama_ruangan;
		}
		public void setNama_ruangan(String nama_ruangan) {
			this.nama_ruangan = nama_ruangan;
		}
		public String getKeperluan() {
			return keperluan;
		}
		public void setKeperluan(String keperluan) {
			this.keperluan = keperluan;
		}
		public String getTanggal_booking() {
			return tanggal_booking;
		}
		public void setTanggal_booking(String tanggal_booking) {
			this.tanggal_booking = tanggal_booking;
		}
		

		
	}

