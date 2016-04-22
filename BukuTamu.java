//buatlah sistem buku tamu dengan syarat sebagai berikut:
//* tamu memiliki ID yang auto incremnt(bertambah sendiri)
//  *harus menggunakan konsep static:
//contoh tamu 1 = 1 , tamu 1 = 2, DST.
//* Tentukan variable vinal yang dapat digunakan tamu dan implementasikan
//* Buku Tamu harus memiliki 1 atau lebih method yang static
//  *penggunaan harus berdasarkan konsep static
//* Buku Tamu dapat menampilkan tamu serta data - data identitas tamu
//* Buat program se-kreatif mungkin dan memenuhi syarat diatas
package BAB_5;

/**
 *
 * @author Deltaviyahya
 */
public class BukuTamu {
    int id;
    String nama,email;
    boolean logged = false;
    int index;

    public BukuTamu() {
    }

    public BukuTamu(int id, String nama, String email) {
        this.id = id;
        this.nama = nama;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
