# Tugas Pemrograman Berorientasi Objek (Java)

## 1. Pengertian Class dan Object
* **Class:** Merupakan cetak biru (blueprint), template, atau rancangan yang mendefinisikan karakteristik (atribut) dan perilaku (method) dari suatu objek.
* **Object:** Merupakan wujud nyata atau instansiasi (instance) dari sebuah Class.

## 2. Jenis-Jenis Method dalam Java
1. **Method Void (Setter/Mutator):** Method yang digunakan untuk mengubah nilai atau melakukan aksi tanpa mengembalikan nilai (menggunakan keyword `void`).
2. **Method Non-Void (Getter/Accessor):** Method yang digunakan untuk mengambil atau mengembalikan nilai tertentu (menggunakan tipe data return dan keyword `return`).
3. **Method Constructor:** Method khusus yang otomatis dijalankan saat objek dibuat, namanya wajib sama dengan nama Class.

## 3. Penjelasan Kode Program (Gambar 1)
* **Nomor 1:** Deklarasi Class dengan nama `Komputer`.
* **Nomor 2:** Deklarasi Atribut/Variabel Instance (`jenis_komputer` dan `merk`).
* **Nomor 3:** Method Void (Setter) `setDataKomputer` untuk mengisi data objek.
* **Nomor 4:** Method Non-Void (Getter) `getJenis` untuk mengambil data jenis komputer.
* **Nomor 5:** Method Non-Void (Getter) `getMerk` untuk mengambil data merk komputer.
* **Nomor 6:** Instansiasi atau pembuatan objek baru bernama `mykom`.
* **Nomor 7:** Pemanggilan method setter untuk mengisi nilai ke objek `mykom`.
* **Nomor 8:** Pemanggilan method getter sekaligus mencetak hasilnya ke layar konsol.
