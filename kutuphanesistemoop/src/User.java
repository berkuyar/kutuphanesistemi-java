import java.time.LocalDate;

public class User {

    private int id;
    private String ad;
    private String soyad;
    private Long telefon;
    private String adress;
    private LocalDate kayitTarihi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public Long getTelefon() {
        return telefon;
    }

    public void setTelefon(Long telefon) {
        this.telefon = telefon;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LocalDate getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(LocalDate kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public User(int id, String ad, String soyad, Long telefon, String adress, LocalDate kayitTarihi) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.adress = adress;
        this.kayitTarihi = kayitTarihi;
    }
}
