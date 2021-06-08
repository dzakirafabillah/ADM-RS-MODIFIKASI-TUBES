------------------------------------- INDEXING -------------------------------------
CREATE INDEX Idx_poli_nama_poliklinik ON Poliklinik(nama_poliklinik);
CREATE INDEX Idx_no_regis_resep ON Resep(no_registrasi);
CREATE INDEX Idx_jenis_obat ON OBAT(id_jenis_obat);
CREATE INDEX Idx_RP_No_Rekam_Medis ON Riwayat_Pendaftaran(PASIEN_NO_REKAM_MEDIS);
CREATE INDEX Idx_RP_Diagnosa ON Riwayat_Pendaftaran(DIAGNOSA);
CREATE INDEX Idx_id_resep_resep_obat ON Resep_obat (id_resep);
CREATE INDEX Idx_tdk_no_registrasi ON tindakan_history(no_registrasi);
CREATE INDEX Id_obat_in_kandungan ON KANDUNGAN_OBAT (id_obat);