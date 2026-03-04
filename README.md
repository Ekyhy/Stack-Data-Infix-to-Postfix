# <h1> Stack Infix To Postfix </h1>
<p> Implementasi pemrogaman translator ekspresi matematika dari ekspresi infix ke ekspresi postfix (Java & Python)</p>

<h2>Deskripsi Projek: </h2>
<p>Ekspresi infiks adalah cara umum untuk menulis ekspresi matematika di mana operator ditulis di antara operan, sedangkan postfiks adalah jenis ekspresi di mana sepasang operan diikuti oleh operator.</p>
<p>Struktur data ini dibuat dalam dua bahasa pemrograman:</p>
<ul>
  <li>
    ☕ Java
  </li>
  <li>
    🐍 Python
  </li>
</ul>

<h2>Pendekatan Pembuatan: </h2>
  <p>Untuk mengkonversi ekspresi infix ke ekspresi postfix, kita dapat mengikuti pendekatan alur di bawah ini.</p>

<table>
  <tr>
    <th>Alur Proses</th>
  </tr>
  <tr>
    <td>Membuat stack kosong sebagai wadah untuk menyimpan operator dan string untuk menyimpan hasil</td>
  </tr>
    <tr>
    <td>Memindai ekspresi infix dari kiri ke kanan</td>
  </tr>
    <tr>
    <td>Jika karakter yang dipindai adalah operan, tambahkan ke hasil</td>
  </tr>
    <tr>
    <td>Jika karakter yang dipindai adalah operator, keluarkan operator dari tumpukan ke hasil hingga bagian atas tumpukan memiliki operator dengan prioritas lebih rendah atau tumpukan kosong, kemudian masukkan operator yang dipindai ke dalam tumpukan.</td>
  </tr>
    <tr>
    <td>Jika karakter yang dipindai adalah '(', dorong karakter tersebut ke dalam tumpukan.</td>
  </tr>
      <tr>
    <td>Jika karakter yang dipindai adalah ')', keluarkan operator dari tumpukan ke hasil hingga '(' ditemui, dan keluarkan '(' dari tumpukan.</td>
  </tr>
      <tr>
    <td>Setelah semua karakter dipindai, keluarkan operator yang tersisa dari tumpukan ke hasil.</td>
  </tr>
  
  
</table>



<h2> Demo Project: </h2>


1. Java
   [![Demo Project Java]](https://youtu.be/OwKwEt4XDZQ)
2. Python
   [![Demo Project Python]](https://youtu.be/vzl9HwBLHKE)
