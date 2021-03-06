-- INSERT DATA POLIKLINIK

INSERT ALL 
    INTO poliklinik(id_poliklinik, nama_poliklinik, jml_dokter)
    VALUES('PLKNK','POLI KEBIDANAN',0)
    INTO poliklinik(id_poliklinik, nama_poliklinik, jml_dokter)
    VALUES('PLKNK','POLI ANAK',0)
    INTO poliklinik(id_poliklinik, nama_poliklinik, jml_dokter)
    VALUES('PLKNK','POLI TUMBUH KEMBANG',0)
    INTO poliklinik(id_poliklinik, nama_poliklinik, jml_dokter)
    VALUES('PLKNK','POLI JANTUNG',0)
    INTO poliklinik(id_poliklinik, nama_poliklinik, jml_dokter)
    VALUES('PLKNK','POLI BEDAH UMUM',0)
    INTO poliklinik(id_poliklinik, nama_poliklinik, jml_dokter)
    VALUES('PLKNK','POLI BEDAH DIGESTIF',0)
    INTO poliklinik(id_poliklinik, nama_poliklinik, jml_dokter)
    VALUES('PLKNK','POLI BEDAH PLASTIK',0)
    INTO poliklinik(id_poliklinik, nama_poliklinik, jml_dokter)
    VALUES('PLKNK','POLI BEDAH ORTHOPEDI',0)
    INTO poliklinik(id_poliklinik, nama_poliklinik, jml_dokter)
    VALUES('PLKNK','POLI BEDAH SARAF',0)
    INTO poliklinik(id_poliklinik, nama_poliklinik, jml_dokter)
    VALUES('PLKNK','POLI PARU',0)
    SELECT * FROM dual;


--INSERT DATA DOKTER

INSERT ALL
	INTO DOKTER (ID_DOKTER, NAMA_DOKTER, NO_IZIN_PRAKTEK, PHONE_NUMBER, SPESIALISASI, GAJI, POLIKLINIK_ID_POLIKLINIK, TGL_MULAI)
	VALUES ('DKTR','dr. Ida, Sp. OG', '07071650', '089789996541', 'Obstetri Ginekologi', 6000000, 'PLKNK001', SYSDATE)
	INTO DOKTER (ID_DOKTER, NAMA_DOKTER, NO_IZIN_PRAKTEK, PHONE_NUMBER, SPESIALISASI, GAJI, POLIKLINIK_ID_POLIKLINIK, TGL_MULAI)
	VALUES ('DKTR', 'dr.  Ayu, M. Biomed., Sp. A', '11090633', '087807895697', 'Anak', 9000000, 'PLKNK002', SYSDATE)
	INTO DOKTER (ID_DOKTER, NAMA_DOKTER, NO_IZIN_PRAKTEK, PHONE_NUMBER, SPESIALISASI, GAJI, POLIKLINIK_ID_POLIKLINIK, TGL_MULAI)
	VALUES ('DKTR', 'dr. Rian , M.Sc., Sp.  A., MARS', '03122001', '085721032001', 'Anak', 100000000, 'PLKNK003', SYSDATE)
	INTO DOKTER (ID_DOKTER, NAMA_DOKTER, NO_IZIN_PRAKTEK, PHONE_NUMBER, SPESIALISASI, GAJI, POLIKLINIK_ID_POLIKLINIK, TGL_MULAI)
	VALUES ('DKTR', 'dr. I Gusti, Sp. JP', '03122407', '085895678333', 'Jantung', 9500000, 'PLKNK004', SYSDATE)
    INTO DOKTER (ID_DOKTER, NAMA_DOKTER, NO_IZIN_PRAKTEK, PHONE_NUMBER, SPESIALISASI, GAJI, POLIKLINIK_ID_POLIKLINIK, TGL_MULAI)
	VALUES ('DKTR', 'dr. D. P. Oka, Sp. B', '06190007', '085908762541', 'Anestesiologi', 6500000, 'PLKNK005', SYSDATE)
    INTO DOKTER (ID_DOKTER, NAMA_DOKTER, NO_IZIN_PRAKTEK, PHONE_NUMBER, SPESIALISASI, GAJI, POLIKLINIK_ID_POLIKLINIK, TGL_MULAI)
	VALUES ('DKTR', 'dr. Made, Sp. BKBD', '10092367', '089872098175', 'Bedah Pencernaan', 900000, 'PLKNK006', SYSDATE)
    INTO DOKTER (ID_DOKTER, NAMA_DOKTER, NO_IZIN_PRAKTEK, PHONE_NUMBER, SPESIALISASI, GAJI, POLIKLINIK_ID_POLIKLINIK, TGL_MULAI)
	VALUES ('DKTR', 'dr. Trisna, Sp. BP-RE PhD', '08068734', '082183990487', 'Bedah Plastik', 8500000, 'PLKNK007', SYSDATE)
    INTO DOKTER (ID_DOKTER, NAMA_DOKTER, NO_IZIN_PRAKTEK, PHONE_NUMBER, SPESIALISASI, GAJI, POLIKLINIK_ID_POLIKLINIK, TGL_MULAI)
	VALUES ('DKTR', 'dr. Budi, M. Biomed., Sp. OT', '09081111', '089091728457', 'Bedah Orthopedi', 8700000, 'PLKNK008', SYSDATE)
    INTO DOKTER (ID_DOKTER, NAMA_DOKTER, NO_IZIN_PRAKTEK, PHONE_NUMBER, SPESIALISASI, GAJI, POLIKLINIK_ID_POLIKLINIK, TGL_MULAI)
	VALUES ('DKTR', 'dr. David Sp. BS', '0413003', '085720999876', 'Bedah Saraf', 12000000, 'PLKNK009', SYSDATE)
    INTO DOKTER (ID_DOKTER, NAMA_DOKTER, NO_IZIN_PRAKTEK, PHONE_NUMBER, SPESIALISASI, GAJI, POLIKLINIK_ID_POLIKLINIK, TGL_MULAI)
	VALUES ('DKTR', 'dr.Amelia, Sp. P', '09080154', '082198278994', 'Paru', 7800000, 'PLKNK010', SYSDATE)
    INTO DOKTER (ID_DOKTER, NAMA_DOKTER, NO_IZIN_PRAKTEK, PHONE_NUMBER, SPESIALISASI, GAJI, POLIKLINIK_ID_POLIKLINIK, TGL_MULAI)
	VALUES ('DKTR','dr. Irene, Sp. OG', '07081250', '089789673412', 'Obstetri Ginekologi', 6000000, 'PLKNK001', SYSDATE)
	INTO DOKTER (ID_DOKTER, NAMA_DOKTER, NO_IZIN_PRAKTEK, PHONE_NUMBER, SPESIALISASI, GAJI, POLIKLINIK_ID_POLIKLINIK, TGL_MULAI)
	VALUES ('DKTR', 'dr.  Jamal, M. Biomed., Sp. A', '10090633', '0878023661197', 'Anak', 9000000, 'PLKNK002', SYSDATE)
	INTO DOKTER (ID_DOKTER, NAMA_DOKTER, NO_IZIN_PRAKTEK, PHONE_NUMBER, SPESIALISASI, GAJI, POLIKLINIK_ID_POLIKLINIK, TGL_MULAI)
	VALUES ('DKTR', 'dr. Diana , M.Sc., Sp.  A., MARS', '03150019', '085723981029', 'Anak', 100000000, 'PLKNK003', SYSDATE)
	SELECT * FROM dual;


-- INSERT DATA PASIEN

INSERT ALL
	INTO PASIEN ( NO_REKAM_MEDIS, NAMA_PASIEN,  GENDER, TGL_LAHIR)
	VALUES ('P','UJANG', 'LAKI-LAKI', '18-Jan-2000')
	INTO PASIEN (  NO_REKAM_MEDIS, NAMA_PASIEN, GENDER, TGL_LAHIR)
	VALUES ('P', 'ZAHRA', 'PEREMPUAN', '14-Jan-1998')
	INTO PASIEN ( NO_REKAM_MEDIS, NAMA_PASIEN,  GENDER, TGL_LAHIR)
	VALUES ('P','ASEP',  'LAKI-LAKI', '22-Jan-1999')
	INTO PASIEN ( NO_REKAM_MEDIS, NAMA_PASIEN, GENDER, TGL_LAHIR)
	VALUES ('P','CICI', 'PEREMPUAN', '22-Jan-1995')
    INTO PASIEN ( NO_REKAM_MEDIS, NAMA_PASIEN, GENDER, TGL_LAHIR)
	VALUES ('P','JULAHA', 'PEREMPUAN', '21-Jun-1995')
	SELECT * FROM dual;


-- INSERT DATA TINDAKAN

INSERT ALL
    INTO tindakan(id_tindakan, nama_tindakan, deskripsi, tarif)
    VALUES ('T','Rawat Inap','Biaya untuk satu hari',100000)
    INTO tindakan(id_tindakan, nama_tindakan, deskripsi, tarif)
    VALUES ('T','Konnsultasi','Pemeriksaan fisik oleh dokter',170000)
    INTO tindakan(id_tindakan, nama_tindakan, deskripsi, tarif)
    VALUES ('T','USG','USG Bagian Perut', 523000 )
    INTO tindakan(id_tindakan, nama_tindakan, deskripsi, tarif)
    VALUES ('T','Cek darah','Tes darah untuk memeriksa kesehatan',385000)
    INTO tindakan(id_tindakan, nama_tindakan, deskripsi, tarif)
    VALUES ('T','Apendektomi laproskopi','Prosedur pembedahan dengan metode operasi terbuka',9000000)
    INTO tindakan(id_tindakan, nama_tindakan, deskripsi, tarif)
    VALUES ('T','Bedah Mata AL','Bedah Mata Anastesi Lokal',11000000)
    INTO tindakan(id_tindakan, nama_tindakan, deskripsi, tarif)
    VALUES ('T','Bedah THT LF','Bedah THT Laring Faring',9000000)
    INTO tindakan(id_tindakan, nama_tindakan, deskripsi, tarif)
    VALUES ('T','Ultrasonografi',' ',750000)
    SELECT * FROM dual;



--INSERT DATA RIWAYAT PENDAFTARAN
INSERT 
    INTO RIWAYAT_PENDAFTARAN(NO_REGISTRASI, SYMPTOM, DIAGNOSA, TIPE_RAWAT, TGL_REGISTRASI, PASIEN_NO_REKAM_MEDIS, POLIKLINIK_ID_POLIKLINIK, DOKTER_ID_DOKTER, USIA_PASIEN)
    VALUES( 'R', 'nyeri dada, Sesak napas', 'Kardiomiopati (gangguan otot jantung)', 'INAP', '20-May-2021', 'P0000001' ,'PLKNK004','DKTR0013', 0);
INSERT 
    INTO RIWAYAT_PENDAFTARAN(NO_REGISTRASI, SYMPTOM, DIAGNOSA, TIPE_RAWAT, TGL_REGISTRASI, PASIEN_NO_REKAM_MEDIS, POLIKLINIK_ID_POLIKLINIK , DOKTER_ID_DOKTER, USIA_PASIEN)
    VALUES('R',  'nyeri dada yang bertambah parah ketika batuk', 'Paru paru basah', 'JALAN', '20-May-2021', 'P0000004' ,'PLKNK010','DKTR0019', 0);
INSERT 
    INTO RIWAYAT_PENDAFTARAN(NO_REGISTRASI,  SYMPTOM, DIAGNOSA, TIPE_RAWAT, TGL_REGISTRASI, PASIEN_NO_REKAM_MEDIS, POLIKLINIK_ID_POLIKLINIK , DOKTER_ID_DOKTER, USIA_PASIEN)
    VALUES('R',  'demam dan menggigil, sesak napas, dan nyeri dada saat menarik napas', 'Endokarditis', 'INAP', '20-May-2021', 'P0000002' ,'PLKNK004', 'DKTR0013', 0);
INSERT 
    INTO RIWAYAT_PENDAFTARAN(NO_REGISTRASI,  SYMPTOM, DIAGNOSA, TIPE_RAWAT, TGL_REGISTRASI, PASIEN_NO_REKAM_MEDIS, POLIKLINIK_ID_POLIKLINIK ,  DOKTER_ID_DOKTER, USIA_PASIEN)
    VALUES( 'R', 'kelumpuhan sementara pada otot-otot di wajah', 'Bell???s Palsy', 'JALAN', '20-May-2021', 'P0000039' ,'PLKNK003','DKTR0012', 0);
INSERT     
    INTO RIWAYAT_PENDAFTARAN(NO_REGISTRASI, SYMPTOM, DIAGNOSA, TIPE_RAWAT, TGL_REGISTRASI, PASIEN_NO_REKAM_MEDIS, POLIKLINIK_ID_POLIKLINIK , DOKTER_ID_DOKTER, USIA_PASIEN)
    VALUES('R',  'Luka Bakar tidak membaik', 'Kerusakan jaringan kulit', 'INAP', '10-May-2021', 'P0000005' ,'PLKNK007', 'DKTR0016', 0);


-- DATA RESEP
INSERT ALL
	INTO RESEP (ID_RESEP, NO_REGISTRASI,  TGL_RESEP, STATUS_TEBUS)
	VALUES ('MP','R0000003', SYSDATE, 'BELUM DITEBUS')
	INTO RESEP (ID_RESEP, NO_REGISTRASI,  TGL_RESEP, STATUS_TEBUS)
	VALUES ('MP', 'R0000031', SYSDATE, 'BELUM DITEBUS')
	INTO RESEP (ID_RESEP, NO_REGISTRASI,  TGL_RESEP, STATUS_TEBUS)
	VALUES ('MP','R0000032',  SYSDATE, 'BELUM DITEBUS')
	INTO RESEP (ID_RESEP, NO_REGISTRASI,  TGL_RESEP, STATUS_TEBUS)
	VALUES ('MP','R0000033', SYSDATE,'BELUM DITEBUS')
	SELECT * FROM dual;


-- DATA OBAT
INSERT ALL
	INTO OBAT (ID_OBAT, KODE_OBAT,  NAMA_OBAT, STOCK_FISIK, STOCK_AVAILABLE, ID_JENIS_OBAT, HARGA)
	VALUES ('O','SANMOL','OBAT BEBAS',100 ,100 , 'FLU_1',22000 )
    INTO OBAT (ID_OBAT, KODE_OBAT,  NAMA_OBAT, STOCK_FISIK, STOCK_AVAILABLE, ID_JENIS_OBAT, HARGA)
	VALUES ('O','CODEIN','OBAT RESEP',100 , 100, 'PAIN_KILLER_1', 50000 )
	INTO OBAT (ID_OBAT, KODE_OBAT,  NAMA_OBAT, STOCK_FISIK, STOCK_AVAILABLE, ID_JENIS_OBAT, HARGA)
	VALUES ('O','IBUPROFIN','OBAT RESEP', 100, 100, 'PAIN_KILLER_1', 75000)
	INTO OBAT (ID_OBAT, KODE_OBAT,  NAMA_OBAT, STOCK_FISIK, STOCK_AVAILABLE, ID_JENIS_OBAT, HARGA)
	VALUES ('O','PARACETAMOL','OBAT BEBAS', 100, 100, 'PAIN_KILLER_1', 62000)
	SELECT * FROM dual;


-- DATA RESEP OBAT
INSERT ALL
	INTO RESEP_OBAT (ID_RESEP, ID_OBAT, JUMLAH, UNIT)
	VALUES ('MP000006','O0000001',1, 'Strip')
    INTO RESEP_OBAT (ID_RESEP, ID_OBAT, JUMLAH, UNIT)
	VALUES ('MP000007','O0000001', 1, 'Strip')
	INTO RESEP_OBAT (ID_RESEP, ID_OBAT, JUMLAH, UNIT)
	VALUES ('MP000006','O0000002',2, 'Strip')
	INTO RESEP_OBAT (ID_RESEP, ID_OBAT, JUMLAH, UNIT)
	VALUES ('MP000008','O0000001',1, 'Strip')
	SELECT * FROM dual;


-- DATA TINDAKAN HISTORY
INSERT INTO TINDAKAN_HISTORY(id_tindakan, jumlah, total_tarif, no_registrasi)
VALUES ('T0000003', 3 , 0,'R0000031');