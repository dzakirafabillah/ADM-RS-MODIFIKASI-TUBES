-------------------------------------DAFTAR FUNCTION-------------------------------------


-- Goals : Mendapatkna pemasukan rumah ssakit pada tahun tertentu
-- Dihitung dari total tari setiap pendaftaran pada tahun itu
-- yang status bayarnya = 'SUDAH DIBAYAR'

create or replace FUNCTION get_income(
    in_year PLS_INTEGER)
RETURN NUMBER
IS
    pemasukan NUMBER := 0;
BEGIN
    SELECT SUM(total_pembayaran)
    INTO pemasukan
    FROM pembayaran
    INNER JOIN riwayat_pendaftaran 
    ON no_registrasi = rp_no_registrasi
    AND
    status_pembayaran = 'SUDAH DIBAYAR'
    GROUP BY EXTRACT(YEAR FROM tgl_registrasi)
    HAVING EXTRACT(YEAR FROM tgl_registrasi) = in_year;
    
    RETURN pemasukan;
END;


-- Goals : Mendapatkan total jumlah pendaftaran ke poliklinik tertentu
-- pada bulan dan tahun tertentu (dijadikan parameter)

create or replace FUNCTION get_jml_riwayat_pendaftaran(
    pol in VARCHAR2, bln in number, thn in number
)RETURN NUMBER
IS
  rp_count NUMBER;
BEGIN
  -- get jumlah riwayat pendaftaran based on poliklinik id
  SELECT count(*) INTO rp_count
  FROM RIWAYAT_PENDAFTARAN
  WHERE poliklinik_id_poliklinik = (SELECT id_poliklinik FROM POLIKLINIK WHERE nama_poliklinik = pol) 
        AND (SELECT EXTRACT( MONTH FROM TO_DATE( tgl_registrasi, 'DD-MM-YYYY' ) ) MONTH FROM DUAL) =  bln
        AND (SELECT EXTRACT( YEAR FROM TO_DATE( tgl_registrasi, 'DD-MM-YYYY' ) ) YEAR FROM DUAL) =  thn;
    return rp_count;
END;


-- Goals : Mendapatkan total tarif pada suatu resep
-- Digunakkan untuk dipanggil sebelum menebus obat-obat pada resep

create or replace FUNCTION get_total_tarif_resep (
    id_rsp IN VARCHAR2)
RETURN NUMBER
IS
    jml_tarif NUMBER := 0;
BEGIN
        SELECT SUM(total_harga)
        INTO jml_tarif
        FROM resep_obat
        WHERE id_resep = id_rsp;

        return jml_tarif;
END;


-- Goals : Mendapatkan daftar obat yang setara dengan obat yang dijadikan parameter

CREATE TYPE rec_obat IS OBJECT ( id_obat VARCHAR2(8), nama_obat VARCHAR2(50));

CREATE OR REPLACE TYPE list_obat IS TABLE OF rec_obat;

create or replace FUNCTION get_obat_setara (
    id_jenis_obt in number
)
RETURN list_obat
is
tt_t list_obat;
BEGIN

SELECT rec_obat(id_obat, nama_obat)
BULK COLLECT INTO tt_t
FROM OBAT
where id_jenis_obat = id_jenis_obt;

RETURN tt_t;
END;


-- Goals : Mendapatkan list bahan bahan suatu obat tertentu

CREATE TYPE rec_bahan IS OBJECT ( id_bahan VARCHAR2(8), nama_bahan VARCHAR2(50));

CREATE OR REPLACE TYPE list_bahan IS TABLE OF rec_bahan;

create or replace FUNCTION get_ingredient_obat (
    id_obt in varchar2
)
RETURN list_bahan
IS
tt_t list_bahan;
BEGIN

SELECT rec_bahan(id_bahan, nama_bahan)
BULK COLLECT INTO tt_t
FROM KANDUNGAN_OBAT
where id_obat = id_obt;

RETURN tt_t;
END;  


-- Goals : list tindakan yg diterima pasien, serta harga nya

CREATE TYPE rec_struk IS OBJECT ( id VARCHAR2(8), jumlah number, total_harga number);

CREATE OR REPLACE TYPE list_tindakan IS TABLE OF rec_struk;

create or replace FUNCTION get_struk_pemeriksaan (
    no_reg in varchar2
)
RETURN list_tindakan
IS
tt_t list_tindakan;
BEGIN

SELECT rec_struk(id_tindakan, jumlah, total_tarif)
BULK COLLECT INTO tt_t
FROM TINDAKAN_HISTORY
where no_registrasi = no_reg;

RETURN tt_t;
END;


-- Goals : list obat pada resep, serta harga nya

CREATE OR REPLACE TYPE list_obat IS TABLE OF rec_struk; 

create or replace FUNCTION get_struk_resep (
    id_rsp in varchar2
)
RETURN list_obat
IS
tt_t list_obat;
BEGIN

SELECT rec_struk(id_obat, jumlah, total_harga)
BULK COLLECT INTO tt_t
FROM RESEP_OBAT
where id_resep = id_rsp;

RETURN tt_t;
END;


-- Goals : list dokter yang praktik di klinik tertentu

CREATE TYPE rec_dokter IS OBJECT ( id_dok VARCHAR2(8), nama varchar2(50), phone_number varchar(13));

CREATE OR REPLACE TYPE list_dokter IS TABLE OF rec_dokter;

create or replace FUNCTION get_list_dokter (
    id_pol in varchar2
)
RETURN list_dokter
IS
tt_t list_dokter;
BEGIN

SELECT rec_dokter(id_dokter, nama_dokter, phone_number)
BULK COLLECT INTO tt_t
FROM DOKTER
where poliklinik_id_poliklinik = id_pol;

RETURN tt_t;
END;

-- Goals : Mendapatkan nomor antrian terakhir ke suatu dokter

create or replace FUNCTION get_last_queue_number (
    i_id_dokter in varchar2,
    i_tgl_registrasi in date
)
RETURN NUMBER
IS
    queue_number NUMBER := 0;
BEGIN

SELECT count(*) INTO queue_number
    FROM ANTRIAN
    WHERE dokter_id_dokter = i_id_dokter;
    RETURN queue_number;
END;