------------------------------------- DAFTAR TRIGGER -------------------------------------
-- TRIGGER UNTUK GENERATE ID  
-- TRIGGER JUMLAH_DOKTER
-- TRIGGER PREVENT_DOKTER_DEL
-- TRIGGER VALID_DOKTER
-- TRIGGER usia_pasien
-- TRIGGER ADD_TINDAKAN_INAP
-- TRIGGER PREVENT_INS_INAP 
-- TRIGGER PREVENT_INSERT_PENDAFTARAN
-- TRIGGER Insert_Total_Pembayaran 
-- TRIGGER set_total_tarif_tindakan
-- TRIGGER set_total_harga_obat
-- TRIGGER upd_stock_avail_reduced
-- TRIGGER upd_stock_fisik_reduced
-- TRIGGER set_nama_obat_nama_bahan
-- TRIGGER clearYesterdayQueue
-- TRIGGER check_before_tebus_resep
 


------------------------------------- TRIGGER UNTUK GENERATE ID -------------------------------------

--------------- SEQUENCE --------------- 
CREATE SEQUENCE ID_RESEP_SEQ INCREMENT BY 1;
CREATE SEQUENCE ID_OBAT_SEQ INCREMENT BY 1;
CREATE SEQUENCE ID_BAHAN_SEQ INCREMENT BY 1;
CREATE SEQUENCE POLIKLINIK_SEQ INCREMENT BY 1;
CREATE SEQUENCE DOKTER_SEQ INCREMENT BY 1;
CREATE SEQUENCE NOREK_MEDIS_SEQ INCREMENT BY 1;
CREATE SEQUENCE NO_REGISTRASI_SEQ INCREMENT BY 1;
CREATE SEQUENCE TINDAKAN_SEQ INCREMENT BY 1;
CREATE SEQUENCE PEMBAYARAN_SEQ INCREMENT BY 1;

create or replace TRIGGER REGISTASI_NO
    BEFORE INSERT
    ON RIWAYAT_PENDAFTARAN
    REFERENCING NEW AS NEW OLD AS OLD
    FOR EACH ROW
BEGIN
    :NEW.no_registrasi := :NEW.no_registrasi || trim(to_char(NO_REGISTRASI_SEQ.nextval, '0000000'));
END REGISTASI_NO;

create or replace TRIGGER RESEP_ID
    BEFORE INSERT
    ON RESEP
    REFERENCING NEW AS NEW OLD AS OLD
    FOR EACH ROW
BEGIN
    :NEW.id_resep := :NEW.id_resep || trim(to_char(ID_RESEP_SEQ.nextval, '000000'));
END RESEP_ID;


create or replace TRIGGER OBAT_ID
    BEFORE INSERT
    ON OBAT
    REFERENCING NEW AS NEW OLD AS OLD
    FOR EACH ROW
BEGIN
    :NEW.id_obat := :NEW.id_obat || trim(to_char(ID_OBAT_SEQ.nextval, '0000000'));
END OBAT_ID;


create or replace TRIGGER BAHAN_ID
    BEFORE INSERT
    ON INGREDIENT
    REFERENCING NEW AS NEW OLD AS OLD
    FOR EACH ROW
BEGIN
    :NEW.id_bahan := :NEW.id_bahan || trim(to_char(ID_BAHAN_SEQ.nextval, '0000000'));
END BAHAN_ID;


create or replace TRIGGER Poli_ID
    BEFORE INSERT
    ON POLIKLINIK
    REFERENCING NEW AS NEW OLD AS OLD
    FOR EACH ROW
BEGIN
    :NEW.ID_POLIKLINIK := :NEW.ID_POLIKLINIK || trim(to_char(POLIKLINIK_SEQ.nextval, '000'));
END Poli_ID;


create or replace TRIGGER Dokter_ID
    BEFORE INSERT
    ON DOKTER
    REFERENCING NEW AS NEW OLD AS OLD
    FOR EACH ROW
BEGIN
    :NEW.ID_DOKTER := :NEW.ID_DOKTER || trim(to_char(DOKTER_SEQ.nextval, '0000'));
END Dokter_ID;


create or replace TRIGGER REK_MEDIS_ID
    BEFORE INSERT
    ON PASIEN
    REFERENCING NEW AS NEW OLD AS OLD
    FOR EACH ROW
BEGIN
    :NEW.no_rekam_medis := :NEW.no_rekam_medis || trim(to_char(DOKTER_SEQ.nextval, '0000000'));
END REK_MEDIS_ID;


create or replace TRIGGER REGISTASI_NO
    BEFORE INSERT
    ON RIWAYAT_PENDAFTARAN
    REFERENCING NEW AS NEW OLD AS OLD
    FOR EACH ROW
BEGIN
    :NEW.no_registrasi := :NEW.no_registrasi || trim(to_char(NO_REGISTRASI_SEQ.nextval, '0000000'));
END REGISTASI_NO;


create or replace TRIGGER TINDAKAN_ID
    BEFORE INSERT
    ON TINDAKAN
    REFERENCING NEW AS NEW OLD AS OLD
    FOR EACH ROW
BEGIN
    :NEW.id_tindakan:= :NEW.id_tindakan || trim(to_char(TINDAKAN_SEQ.nextval, '0000000'));
END TINDAKAN_ID;


create or replace TRIGGER PEMBAYARAN_ID
    BEFORE INSERT
    ON PEMBAYARAN
    REFERENCING NEW AS NEW OLD AS OLD
    FOR EACH ROW
BEGIN
    :NEW.id_pembayaran := :NEW.id_pembayaran || trim(to_char(PEMBAYARAN_SEQ.nextval, '0000000'));
END PEMBAYARAN_ID;



------------------------------------- TRIGGER  LAINNYA-------------------------------------

-- TERKAIT DOKTER & POLIKLINIK--

-- Goals : Ketika dokter baru diinsert, jumlah dokter bertambah 1
--         Ketika dokter di delete, jumlah dokter berkurang 1

create or replace TRIGGER jumlah_dokter 
    AFTER INSERT OR DELETE
    ON DOKTER
    REFERENCING OLD AS OLD NEW AS NEW
    FOR EACH ROW
    DECLARE jml number;
BEGIN
        IF INSERTING
            THEN UPDATE POLIKLINIK SET jml_dokter = (jml_dokter + 1) WHERE id_poliklinik = :NEW.poliklinik_id_poliklinik;
        ELSIF DELETING
            THEN UPDATE POLIKLINIK SET jml_dokter = (jml_dokter - 1) WHERE id_poliklinik = :OLD.poliklinik_id_poliklinik;
        END IF;
END;


-- Goals : Mencegah dokter di delete, ketika poliklinik tempat ia praktek hanya memiliki tinggal 1 dokter itu

create or replace TRIGGER PREVENT_DOKTER_DEL
    BEFORE DELETE ON DOKTER
    FOR EACH ROW
    DECLARE jml number;
BEGIN 
    SELECT jml_dokter INTO jml FROM POLIKLINIK WHERE id_poliklinik = :old.poliklinik_id_poliklinik;
        IF jml = 1
        THEN
            RAISE_APPLICATION_ERROR (-20000, 'Dokter Pada Poliklinik Minimal 1, Tunggu Ada Dokter Baru');
            ROLLBACK;   
        END IF;
END;


-- Goals : Ketika daftar, dipastika dokter yang dipilih, 
--         merupakan dokter yang praktek di poliklinik pasien tersebut daftar.

create or replace TRIGGER valid_dokter
    BEFORE INSERT OR UPDATE ON RIWAYAT_PENDAFTARAN
    FOR EACH ROW
    DECLARE i_id_pol varchar2(8);
            nama_pol varchar2(50);
    BEGIN 
            SELECT poliklinik_id_poliklinik INTO i_id_pol
            FROM DOKTER 
            WHERE id_dokter = :new.dokter_id_dokter;

            SELECT nama_poliklinik INTO nama_pol
            FROM poliklinik
            WHERE id_poliklinik = :new.poliklinik_id_poliklinik;

            IF i_id_pol != :new.poliklinik_id_poliklinik
            THEN
                RAISE_APPLICATION_ERROR (-20000, 'Dokter bukan dari poliklinik ' + nama_pol);
                ROLLBACK;
            END IF;
END;


-- TERKAIT PASIEN & RIWAYAT PENDAFTARAN--

-- Goals : Set usia pasien otomatis berdasarkan tanggal lahir di tabel PASIEN

create or replace TRIGGER usia_pasien
    BEFORE INSERT
    ON RIWAYAT_PENDAFTARAN
    REFERENCING NEW AS NEW OLD AS OLD
         FOR EACH ROW
         DECLARE 
            birthdate date;
            age number(3,0);
BEGIN
    SELECT tgl_lahir INTO birthdate FROM PASIEN WHERE no_rekam_medis =  :new.pasien_no_rekam_medis;
    SELECT TRUNC(TO_NUMBER(SYSDATE - TO_DATE(birthdate)) / 365.25) INTO AGE FROM DUAL;
    :new.usia_pasien := age;
END;

-- Goals : Pasien rawat inap harus membayar 100.000 sebagai biaya satu hari pertama 
-- menggunakan fasilitas rawat inap di rumah sakit

create or replace TRIGGER ADD_TINDAKAN_INAP 
AFTER INSERT OR UPDATE OF TIPE_RAWAT ON RIWAYAT_PENDAFTARAN
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
WHEN (NEW.TIPE_RAWAT = 'INAP')
BEGIN

INSERT INTO TINDAKAN_HISTORY(id_tindakan, jumlah, total_tarif, no_registrasi)
VALUES ('T0000002', 1 ,100000, :NEW.NO_REGISTRASI);

END;

-- Goals : Kamar Inap yg tersedia yaitu 100. Pasien tidak bisa di Rawat Inap jika kamar penuh.

create or replace TRIGGER PREVENT_INS_INAP
    BEFORE INSERT OR UPDATE OF TIPE_RAWAT ON RIWAYAT_PENDAFTARAN
    FOR EACH ROW
    DECLARE jml number;
    BEGIN 
            SELECT COUNT (*) INTO jml 
            FROM RIWAYAT_PENDAFTARAN b
            INNER JOIN PEMBAYARAN c
            ON b.no_registrasi = c.rp_no_registrasi 
            WHERE b.tipe_rawat = 'INAP'
                  AND c.status_pembayaran = 'BELUM DIBAYAR';

            IF jml >= 100
            THEN
                RAISE_APPLICATION_ERROR (-20000, 'Kamar pada rumah sakit penuh');
                ROLLBACK;
            END IF;
END;


-- Goals : Setiap DOkter 1 haridibatasi 30 Pendaftaran. 
-- Pendaftaran tidak bisa dilakukan jika telah mencapai limit.

create or replace TRIGGER PREVENT_INSERT_PENDAFTARAN
	BEFORE INSERT ON RIWAYAT_PENDAFTARAN
	FOR EACH ROW
	DECLARE jml number;
BEGIN
    SELECT count(*) INTO jml
    FROM RIWAYAT_PENDAFTARAN
    WHERE poliklinik_id_poliklinik = :new.poliklinik_id_poliklinik 
          AND
          dokter_id_dokter = :new.dokter_id_dokter
          AND
          tgl_registrasi = :new.tgl_registrasi;

    IF jml >= 30
    THEN
        RAISE_APPLICATION_ERROR (-20000, 'Pendaftaran ke dokter tersebut Mencapai Batas Maksimum, Silahkan mendaftar lagi besok');
        ROLLBACK;   
    END IF;

END;

-- Goals : set total_tarif tindakan secara otomatis.
-- Merupakan hasil perkalian jumlah tindakan yg diterima, dnegan harga tindakan pada tabel TINDAKAN

create or replace TRIGGER set_total_tarif_tindakan
    BEFORE INSERT OR UPDATE
    ON TINDAKAN_HISTORY
    REFERENCING NEW AS NEW OLD AS OLD
         FOR EACH ROW
         DECLARE 
            i_harga number(10,0);
            i_total number(10,0);
BEGIN
    SELECT tarif INTO i_harga FROM tindakan WHERE id_tindakan =  :new.id_tindakan ;
    i_total := i_harga * :new.jumlah;
    :new.total_tarif := i_total;
END;


-- Goals : total_tarif akan terus bertambah setiap pasien mendapatkan suatu tindakan.
-- Ketika ada tindakan pertama, otomatis ditambhkan biaya pendaftaran sebesar 25.000

create or replace TRIGGER Insert_Total_Pembayaran 
    AFTER INSERT OR UPDATE OF jumlah
    ON tindakan_history 
    REFERENCING NEW AS NEW OLD AS OLD
    FOR EACH ROW
    DECLARE p_count NUMBER;
            i_tarif number;
BEGIN
        SELECT count(*) INTO p_count
        FROM PEMBAYARAN
        WHERE rp_no_registrasi = :NEW.no_registrasi;
    IF(p_count = 0) THEN
        -- Ambil tarif 'Biaya Pendaftaran'
        SELECT tarif into i_tarif FROM tindakan where id_tindakan = 'T0000001';
       
       -- Biaya Pendaftaran (25000) otomatis ditambahkan.
        INSERT INTO PEMBAYARAN(ID_PEMBAYARAN,RP_NO_REGISTRASI,TOTAL_PEMBAYARAN, STATUS_PEMBAYARAN)
        VALUES('B', :NEW.no_registrasi,:NEW.total_tarif + i_tarif, 'BELUM DIBAYAR');
    ELSE
        IF INSERTING
        THEN
            UPDATE pembayaran bayar
            SET bayar.total_pembayaran = bayar.total_pembayaran + :NEW.total_tarif 
            WHERE :NEW.no_registrasi = bayar.rp_no_registrasi;
        ELSIF UPDATING
        THEN 
            UPDATE pembayaran bayar
            SET bayar.total_pembayaran = bayar.total_pembayaran + (:NEW.total_tarif - :OLD.total_tarif) 
            WHERE :NEW.no_registrasi = bayar.rp_no_registrasi;
        END IF;
    END IF;
END;


-- TERKAIT OBAT & RESEP

-- Goals : set total_harga obat secara otomatis.
-- Merupakan hasil perkalian jumlah obat yg diresepkan, dnegan harga obat pada tabel OBAT

create or replace TRIGGER set_total_harga_obat
    BEFORE INSERT OR UPDATE
    ON RESEP_OBAT
    REFERENCING NEW AS NEW OLD AS OLD
         FOR EACH ROW
         DECLARE 
            i_harga number(10,0);
            i_total number(10,0);
BEGIN
    SELECT harga INTO i_harga FROM obat WHERE id_obat =  :new.id_obat ;
    i_total := i_harga * :new.jumlah;
    :new.total_harga := i_total;
END;


-- Goals : stock available berkurang tiap ada dokter yang meresepkan obat tersebut

create or replace TRIGGER upd_stock_avail_reduced
    AFTER INSERT OR UPDATE ON RESEP_OBAT
    REFERENCING OLD AS OLD NEW AS NEW
    FOR EACH ROW
BEGIN
    IF INSERTING THEN
            UPDATE OBAT 
            SET stock_available = stock_available - :new.jumlah
            WHERE id_obat = :new.id_obat;
    ELSIF UPDATING THEN 
            UPDATE OBAT 
            SET stock_available = stock_available - (:new.jumlah - :old.jumlah)
            WHERE id_obat = :new.id_obat;
    END IF;
END;


--Goals: stock fisik akan berkurang tiap kali resep ditebus

create or replace TRIGGER upd_stock_fisik_reduced
    AFTER UPDATE OF STATUS_TEBUS ON RESEP
    REFERENCING OLD AS OLD NEW AS NEW
    FOR EACH ROW
    DECLARE CURSOR cur_list IS
                SELECT id_obat, jumlah
                FROM RESEP_OBAT
                WHERE id_resep = :NEW.id_resep ;
            curChoice cur_list%ROWTYPE;
BEGIN
    IF (:new.STATUS_TEBUS = 'SUDAH DITEBUS')
    THEN
        OPEN cur_list;
        LOOP
            FETCH cur_list INTO curChoice;
            EXIT WHEN cur_list%NOTFOUND;
            UPDATE OBAT 
            SET stock_fisik = stock_fisik - curChoice.jumlah
            WHERE id_obat = curChoice.id_obat;
        END LOOP;
        CLOSE cur_list;
    END IF;
END;

--Goals : nama obat dan nama bahan, akan di set otomatis berdasarkan nama di tabel OBAT dan BAHAN.

create or replace TRIGGER set_nama_obat_nama_bahan
    BEFORE INSERT
    ON KANDUNGAN_OBAT
    REFERENCING NEW AS NEW OLD AS OLD
    FOR EACH ROW
    DECLARE i_obat varchar2(50);
            i_bahan varchar2(50);
BEGIN
    SELECT nama_obat INTO i_obat FROM OBAT where id_obat = :new.id_obat;
    SELECT nama_bahan INTO i_bahan FROM INGREDIENT where id_bahan = :new.id_bahan;
    :NEW.nama_obat := i_obat;
    :NEW.nama_bahan := i_bahan;
END set_nama_obat_nama_bahan;


-- Goals : Sebelum resep di tebus, di cek untuk tiap obat yang ada i resep
-- apakah stock nya masih ada

create or replace TRIGGER check_before_tebus_resep
    BEFORE UPDATE OF STATUS_TEBUS ON RESEP
    REFERENCING OLD AS OLD NEW AS NEW
    FOR EACH ROW
    DECLARE i_id_obat varchar2(8);
            i_jumlah integer;
            CURSOR cur_list IS
                SELECT id_obat, jumlah
                FROM RESEP_OBAT
                WHERE id_resep = :NEW.id_resep ;
            curChoice cur_list%ROWTYPE;
BEGIN
    IF (:new.STATUS_TEBUS = 'SUDAH DITEBUS')
    THEN
        OPEN cur_list;
        LOOP
            FETCH cur_list INTO curChoice;
            EXIT WHEN cur_list%NOTFOUND;
            SELECT stock_fisik INTO i_jumlah FROM OBAT WHERE id_obat = curChoice.id_obat;
            if(i_jumlah < curChoice.jumlah)
            THEN
                UPDATE RESEP_OBAT 
                SET jumlah =  i_jumlah
                WHERE id_obat = curChoice.id_obat AND id_resep = :new.id_resep;

                :new.keterangan := 'Beli sisa obat di apotek lain';
            END IF;
        END LOOP;
        CLOSE cur_list;
    END IF;
END;


create or replace TRIGGER clearYesterdayQueue
BEFORE INSERT ON RIWAYAT_PENDAFTARAN
FOR EACH ROW
BEGIN
    DELETE FROM ANTRIAN
    WHERE tgl_registrasi < SYSDATE();
END;


-- Ket : Biaya Inap Per hari, akan ditambah otomatis jika update status bayar dipangil oleh procedure
-- bukan dengan trigger, karena terjadi mutasi jika dengan trigger.