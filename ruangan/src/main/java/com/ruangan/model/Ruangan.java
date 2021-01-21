package com.ruangan.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "t_ruangan")
	public class Ruangan {
		@Id
		private int id_ruangan;
		private String nama_ruangan;
		private String keperluan;
		private String tanggalBooking;
		
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
		public String getTanggalBooking() {
			return tanggalBooking;
		}
		public void setTanggalBooking(String tanggalBooking) {
			this.tanggalBooking = tanggalBooking;
		}

		
		
	}

