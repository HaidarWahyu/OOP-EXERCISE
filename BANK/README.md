# Bank Exercise — Array & ArrayList (PBO 4)

Latihan PBO Java yang merupakan pengembangan dari latihan Bank sebelumnya, dengan menambahkan materi **Array** dan **ArrayList** (slide PBO 4, hal. 26-31).

## Gambaran Umum

Program ini mensimulasikan sebuah bank sederhana. Bank punya banyak nasabah, dan setiap nasabah bisa punya lebih dari satu rekening. Hubungan antar class-nya:

```
Bank ──(array Customer[])──► Customer ──(ArrayList<Account>)──► Account
```

## Penjelasan Class

### Account
Mewakili satu rekening bank. Menyimpan saldo (`balance`) yang bersifat private.
- `Account(initBalance)`: constructor untuk mengisi saldo awal.
- `getBalance()`: mengambil saldo saat ini.
- `deposit(amount)`: menambah saldo. Mengembalikan `true` kalau berhasil, `false` kalau jumlahnya nol atau negatif.
- `withdraw(amount)`: mengurangi saldo. Mengembalikan `true` kalau berhasil, `false` kalau saldo tidak cukup.

### Customer
Mewakili seorang nasabah. Menyimpan nama depan, nama belakang, dan daftar rekeningnya. Daftar rekening memakai **ArrayList** karena jumlah rekening seorang nasabah bisa bertambah kapan saja, sehingga tidak perlu menentukan ukuran di awal.
- `Customer(f, l)`: constructor untuk mengisi nama depan dan belakang.
- `getFirstName()` dan `getLastName()`: mengambil nama.
- `setAccount(acct)`: menambahkan rekening baru ke daftar (`add`).
- `getAccount(index)`: mengambil rekening pada index tertentu (`get`).
- `getNumOfAccounts()`: jumlah rekening yang dimiliki (`size`).

### Bank
Mewakili bank yang menampung semua nasabah. Daftar nasabah memakai **array** biasa (`Customer[]`) dengan ukuran tetap 10, sesuai soal yang meminta ukuran lebih dari 5. Atribut `numberOfCustomers` mencatat index kosong berikutnya sekaligus jumlah nasabah saat ini.
- `Bank()`: constructor yang membuat array kosong berukuran 10.
- `addCustomer(f, l)`: membuat objek `Customer` baru dan menaruhnya di array, lalu menaikkan `numberOfCustomers`. Kalau array sudah penuh, akan muncul pesan bahwa bank penuh.
- `getNumOfCustomers()`: jumlah nasabah saat ini.
- `getCustomer(index)`: mengambil nasabah pada index tertentu.
- `doDeposit(acc, amount)`: menjalankan deposit ke sebuah rekening dan menampilkan hasilnya (berhasil atau gagal) beserta saldo terbaru.
- `doWithdraw(acc, amount)`: menjalankan penarikan dan menampilkan hasilnya beserta saldo terbaru.
- `printCustomers()`: menampilkan semua nasabah beserta saldo tiap rekeningnya, memakai loop `for` bersarang.

### BankDemo
Program utama (`main`) untuk mencoba semuanya. Alurnya:
1. Membuat objek `Bank` dan menambahkan tiga nasabah.
2. Menambahkan rekening ke tiap nasabah (nasabah pertama punya dua rekening).
3. Menjalankan transaksi deposit dan withdraw, termasuk satu withdraw yang sengaja gagal karena saldo kurang.
4. Menampilkan daftar seluruh nasabah dan rekeningnya.

## Kenapa Array untuk Bank dan ArrayList untuk Customer?

Keduanya sengaja dipakai supaya materi slide tercakup semua, sekaligus untuk membandingkan sifatnya:
- **Array** cocok kalau ukurannya sudah diketahui dan tetap. Konsekuensinya, kapasitas harus dicek manual sebelum menambah data (lihat `addCustomer`).
- **ArrayList** cocok kalau jumlah datanya berubah-ubah. Ukurannya menyesuaikan otomatis lewat `add()`, tanpa perlu cek kapasitas.

## Perubahan dari Latihan Sebelumnya

- Class `Bank` lama (balance, deposit, withdraw) dipindah menjadi `Account`.
- `deposit()` dan `withdraw()` sekarang mengembalikan `boolean` (berhasil atau gagal), dan withdraw ditolak kalau saldo kurang.
- Typo `getBalence` diperbaiki menjadi `getBalance`, dan penamaan atribut mengikuti camelCase.
- Ditambahkan class `Customer` (memakai `ArrayList<Account>`) dan `Bank` yang baru (memakai array `Customer[]`).
- Operator `? :` diganti dengan `if-else`, lalu dipindah menjadi method `doDeposit`, `doWithdraw`, dan `printCustomers` di class `Bank`.

## Cara Menjalankan

```bash
javac *.java
java BankDemo
```
