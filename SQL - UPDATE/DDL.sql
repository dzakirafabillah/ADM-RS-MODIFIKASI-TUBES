-------------------------------------DAFTAR TABEL-------------------------------------
-- TABEL POLIKLINIK
-- TABEL DOKTER
-- TABEL PASIEN
-- TABEL RIWAYAT PENDAFTARAN
-- TABEL TINDAKAN
-- TABEL PEMBAYARAN
-- TABEL TINDAKAN_HISTORY
-- TABEL RESEP
-- TABEL OBAT
-- TABEL BAHAN
-- TABEL RESEP_OBAT
-- TABEL KANDUNGAN_OBAT

-------------------------------------DAFTAR VIEW-------------------------------------
--View Pasien Rawat Inap
--View Pasien Rawat Jalan
--View Daftar Pasien Rawat Inap Saat Ini

------------------------------------- TABEL -------------------------------------

-- TABEL POLIKLINIK
-- Menampung data poliklinik-poliklinik yang ada di Rumah Sakit 
-- ID di generate otomatis dengan sequence & trigger.

CREATE TABLE poliklinik (
    id_poliklinik               VARCHAR2(8) NOT NULL,
    nama_poliklinik             VARCHAR2(30) NOT NULL,
    jml_dokter                  NUMBER(3) NOT NULL,
    CONSTRAINT poliklinik_pk PRIMARY KEY ( id_poliklinik )
);


-- TABEL DOKTER
-- Menampung data dokter-dokter yang bekerja di Rumah Sakit/ Praktik di salah satu
-- poliklinik yang ada di Rumah Sakit 
-- ID di generate otomatis dengan sequence & trigger.
-- jika insert dengan prosedur, tgl mulai di set otomatis ketika data dokter dimasukan

CREATE TABLE dokter (
    id_dokter                 VARCHAR2(8) NOT NULL,
    nama_dokter               VARCHAR2(50) NOT NULL,
    no_izin_praktek           VARCHAR2(8) NOT NULL,
    tgl_mulai                 DATE NOT NULL,
    phone_number              VARCHAR2(13) NOT NULL,
    spesialisasi              VARCHAR2(35) NOT NULL,
    gaji                      NUMBER(8, 2) NOT NULL,
    poliklinik_id_poliklinik  VARCHAR2(8) ,
    alamat VARCHAR2(100),
    CONSTRAINT dokter_pk PRIMARY KEY ( id_dokter ),
    CONSTRAINT dokter__un UNIQUE ( no_izin_praktek, phone_number ),
       CONSTRAINT poliklinik_dokter2_fk FOREIGN KEY ( poliklinik_id_poliklinik )
        REFERENCES poliklinik ( id_poliklinik )
        ON DELETE SET NULL,
    CONSTRAINT gaji_dokter_min
        CHECK (gaji > 0)
);


-- TABEL PASIEN
-- Menampung data pasien yang terdaftar di Rumah Sakit
-- no_rekam_medis di generate otomatis dengan sequence & trigger.

CREATE TABLE pasien (
    no_rekam_medis    VARCHAR2(8) NOT NULL,
    nama_pasien       VARCHAR2(50) NOT NULL,
    gender            VARCHAR2(20) NOT NULL,
    tgl_lahir         DATE NOT NULL,
    alamat            VARCHAR2(100),
CONSTRAINT pasien_pk PRIMARY KEY ( no_rekam_medis ),
CONSTRAINT cek_valid_gender
    CHECK (gender = 'PEREMPUAN' OR gender = 'LAKI-LAKI')
);


-- TABEL RIWAYAT PENDAFTARAN
-- Menampung data Riwayat Pendaftaran pasien-pasien rumah sakit
-- Pasien mendaftarkan diri ke Poliklinik dan Dokter tertentu 
-- usia_pasien di isi otomatis karena trigger, berdasarkan tgl lahir pasien di tabel PASIEN.
-- jika insert dengan prosedur, tgl registrasi di set otomatis ketika data dokter dimasukan

CREATE TABLE riwayat_pendaftaran (
    no_registrasi             VARCHAR2(8) NOT NULL,
    symptom                   VARCHAR2(200) NOT NULL,
    diagnosa                  VARCHAR2(50) ,
    tipe_rawat                VARCHAR2(15) NOT NULL,
    tgl_registrasi            DATE NOT NULL,
    usia_pasien       NUMBER(3) NOT NULL,
    pasien_no_rekam_medis     VARCHAR2(8) NOT NULL,
    poliklinik_id_poliklinik  VARCHAR2(8) ,
    dokter_id_dokter VARCHAR2(8) ,
    CONSTRAINT riwayat_pendaftaran_pk PRIMARY KEY ( no_registrasi ),
    CONSTRAINT riwayat_pendaftaran_pasien_fk FOREIGN KEY ( pasien_no_rekam_medis )
        REFERENCES pasien ( no_rekam_medis )
        ON DELETE SET NULL,
    CONSTRAINT rp_poliklinik_fk FOREIGN KEY ( poliklinik_id_poliklinik )
        REFERENCES poliklinik ( id_poliklinik )
        ON DELETE SET NULL,
    CONSTRAINT rp_dokter_fk FOREIGN KEY ( dokter_id_dokter )
        REFERENCES dokter ( id_dokter )
        ON DELETE SET NULL,
    CONSTRAINT cek_valid_tipe_rawat
        CHECK (tipe_rawat = 'INAP' OR tipe_rawat = 'JALAN')
);

-- TABEL ANTRIAN
-- Nomor antrian dibuat per poliklinik per dokter
-- Data akan dihapus setiap harinya
CREATE TABLE antrian(
    no_antri                  INTEGER NOT NULL,
    tgl_registrasi            DATE NOT NULL,
    no_registrasi             VARCHAR2(8) NOT NULL,
    poliklinik_id_poliklinik  VARCHAR2(8),
    dokter_id_dokter VARCHAR2(8),
    CONSTRAINT antrian_pk PRIMARY KEY (no_registrasi),
    CONSTRAINT antrian_noreg_fk FOREIGN KEY ( no_registrasi )
        REFERENCES riwayat_pendaftaran ( no_registrasi )
        ON DELETE SET NULL,
    CONSTRAINT antri_poliklinik_fk FOREIGN KEY ( poliklinik_id_poliklinik )
        REFERENCES poliklinik ( id_poliklinik )
        ON DELETE SET NULL,
    CONSTRAINT antri_dokter_fk FOREIGN KEY ( dokter_id_dokter )
        REFERENCES dokter ( id_dokter )
        ON DELETE SET NULL
);

-- TABEL TINDAKAN
-- Menampung data tindakan-tindakan yang dapat dilakukan terhadap pasien.
-- Data pada tabel menjadi patokan harga untuk tiap tindakan
-- ID di generate otomatis dengan sequence & trigger.

CREATE TABLE tindakan (
    id_tindakan                        VARCHAR2(8) NOT NULL,
    nama_tindakan                      VARCHAR2(50) NOT NULL,
    deskripsi                          VARCHAR2(100) ,
    tarif                              NUMBER(10, 2) NOT NULL,
    CONSTRAINT tindakan_pk PRIMARY KEY ( id_tindakan ),
    CONSTRAINT min_tarif
        CHECK (tarif > 0)
);


-- TABEL PEMBAYARAN
-- Menampung data pembayaran hasil dari proses pendaftaran
-- ID di generate otomatis dengan sequence & trigger.

CREATE TABLE pembayaran (
    id_pembayaran                       VARCHAR2(8) NOT NULL,
    total_pembayaran                    NUMBER(10, 2) NOT NULL, 
    rp_no_registrasi                    VARCHAR2(8) NOT NULL,
    status_pembayaran                   VARCHAR2(13) NOT NULL,

    CONSTRAINT pembayaran_pk PRIMARY KEY ( id_pembayaran,rp_no_registrasi ),
    CONSTRAINT pembayaran_rp_fk FOREIGN KEY ( rp_no_registrasi )
        REFERENCES riwayat_pendaftaran ( no_registrasi),
    CONSTRAINT cek_valid_status_bayar
        CHECK (status_pembayaran = 'SUDAH DIBAYAR' OR status_pembayaran = 'BELUM DIBAYAR')
);


-- TABEL TINDAKAN_HISTORY
-- Tabel relasi antara TINDAKAN dan RIWAYAT_PENDAFTARAN yang bersifat many to many
-- total tarif akan di isi otomatis karena trigger.

CREATE TABLE tindakan_history 
   (no_registrasi VARCHAR2(8) NOT NULL, 
	id_tindakan VARCHAR2(8) NOT NULL, 
	jumlah NUMBER NOT NULL, 
    total_tarif  NUMBER(15,2) NOT NULL,
    CONSTRAINT tindakan_history_pk PRIMARY KEY ( id_tindakan, no_registrasi),
    CONSTRAINT th_rp_fk FOREIGN KEY ( no_registrasi )
        REFERENCES riwayat_pendaftaran ( no_registrasi),
    CONSTRAINT th_tdk_fk FOREIGN KEY ( id_tindakan )
        REFERENCES tindakan ( id_tindakan)
   );


-- TABEL RESEP
-- Menampung data resepyang dibuat oleh dokter untuk pasien.
-- ID di generate otomatis dengan sequence & trigger.
-- jika insert dengan prosedur, tgl resep di set otomatis ketika data dokter dimasukan

CREATE TABLE resep
    (id_resep  VARCHAR2(8) NOT NULL,
    no_registrasi  VARCHAR2(8) NOT NULL,
    tgl_resep DATE NOT NULL,
    status_tebus VARCHAR2(15) NOT NULL,
    keterangan VARCHAR2(100),
    CONSTRAINT resep_pk PRIMARY KEY (id_resep, no_registrasi),
    CONSTRAINT resep_rp_fk FOREIGN KEY ( no_registrasi )
        REFERENCES riwayat_pendaftaran ( no_registrasi),
    CONSTRAINT cek_valid_status_tebus
        CHECK (status_tebus = 'SUDAH DITEBUS' OR status_tebus = 'BELUM DITEBUS')
    );


-- TABEL OBAT
-- Menampug data obat yang ada di apotek rumah sakit.
-- ID di generate otomatis dengan sequence & trigger.

CREATE TABLE obat
    (id_obat            VARCHAR2(8) NOT NULL,
     kode_obat          VARCHAR2(50) NOT NULL,
     nama_obat          VARCHAR2(50) NOT NULL,
     stock_fisik        INTEGER NOT NULL,
     stock_available    INTEGER NOT NULL,
     id_jenis_obat      VARCHAR2(30) NOT NULL,
     harga              NUMBER (10,2) NOT NULL,
     CONSTRAINT obat_pk PRIMARY KEY ( id_obat),
     CONSTRAINT cek_stock_fisik
        CHECK (stock_fisik >= 0) 
    );


-- TABEL BAHAN
-- Menampung data bahan - bahan obat
-- ID di generate otomatis dengan sequence & trigger.

CREATE TABLE INGREDIENT
    (id_bahan       VARCHAR2(8) NOT NULL,
     nama_bahan     VARCHAR2(50) NOT NULL,
     CONSTRAINT bahan_pk PRIMARY KEY ( id_bahan)
    );



-- TABEL RESEP_OBAT
-- Menampung data terkait isi resep.
-- Relasi antara RESEP dan OBAT yang bersifat many to many
-- total harga akan di isi otomatis karena trigger. Prkalian antara jumlah dan harga obat pada tabel OBAT.

CREATE TABLE RESEP_OBAT
    (id_resep       VARCHAR2(8) NOT NULL,
     id_obat        VARCHAR2(8) NOT NULL,
     jumlah         INTEGER NOT NULL,
     unit           VARCHAR2(10) NOT NULL,
     total_harga    NUMBER (10,2),
    CONSTRAINT resep_obat_pk PRIMARY KEY ( id_resep, id_obat),
    CONSTRAINT resep_ro_fk FOREIGN KEY ( id_resep )
        REFERENCES resep ( id_resep),
    CONSTRAINT obat_ro_fk FOREIGN KEY ( id_obat )
        REFERENCES obat ( id_obat),
     CONSTRAINT cek_jml_valid
        CHECK (jumlah >= 0)
    );



-- TABEL KANDUNGAN_OBAT
-- Menampung data terkait isi kompsisi obat.
-- Relasi antara INGREDIENT dan OBAT yang bersifat many to many

CREATE TABLE KANDUNGAN_OBAT
    (id_obat   VARCHAR2(8) NOT NULL,
     nama_obat VARCHAR2(50),
     id_bahan  VARCHAR2(8) NOT NULL,
     nama_bahan VARCHAR2(50) ,
     CONSTRAINT kandungan_obat_pk PRIMARY KEY ( id_obat, id_bahan),
     CONSTRAINT obat_ko_fk FOREIGN KEY ( id_obat )
        REFERENCES obat ( id_obat),
    CONSTRAINT bahan_ro_fk FOREIGN KEY ( id_bahan )
        REFERENCES ingredient ( id_bahan)
    );

------------------------------------- VIEW -------------------------------------

--View Pasien Rawat Inap
CREATE OR REPLACE FORCE VIEW KUNJUNGAN_PS_INAP ("NO_REKAM_MEDIS", "NAMA_PASIEN", "NO_REGISTRASI", "DIAGNOSA", "TOTAL_PEMBAYARAN") AS 
    SELECT a.no_rekam_medis, a.nama_pasien, b.no_registrasi, b.diagnosa, c.total_pembayaran
    FROM PASIEN a
    INNER JOIN RIWAYAT_PENDAFTARAN b
    ON a.no_rekam_medis = b.pasien_no_rekam_medis
    INNER JOIN PEMBAYARAN c
    ON b.no_registrasi = c.rp_no_registrasi 
    WHERE b.tipe_rawat = 'INAP';

--View Pasien Rawat Jalan
CREATE OR REPLACE FORCE VIEW KUNJUNGAN_PS_JALAN ("NO_REKAM_MEDIS", "NAMA_PASIEN", "NO_REGISTRASI", "DIAGNOSA", "TOTAL_PEMBAYARAN") AS 
    SELECT a.no_rekam_medis, a.nama_pasien, b.no_registrasi, b.diagnosa, c.total_pembayaran
    FROM PASIEN a
    INNER JOIN RIWAYAT_PENDAFTARAN b
    ON a.no_rekam_medis = b.pasien_no_rekam_medis
    INNER JOIN PEMBAYARAN c
    ON b.no_registrasi = c.rp_no_registrasi 
    WHERE b.tipe_rawat = 'JALAN';

--View Daftar Pasien Rawat Inap Saat Ini
CREATE OR REPLACE FORCE VIEW DAFTAR_INAP_SAAT_INI ("NO_REGISTRASI", "NO_REKAM_MEDIS", "NAMA_PASIEN",  "TGL_REGISTRSI") AS 
    SELECT b.no_registrasi, a.no_rekam_medis, a.nama_pasien,  b.tgl_registrasi
    FROM PASIEN a
    INNER JOIN RIWAYAT_PENDAFTARAN b
    ON a.no_rekam_medis = b.pasien_no_rekam_medis
    INNER JOIN PEMBAYARAN c
    ON b.no_registrasi = c.rp_no_registrasi 
    WHERE b.tipe_rawat = 'INAP'
    AND c.status_pembayaran = 'BELUM DIBAYAR';