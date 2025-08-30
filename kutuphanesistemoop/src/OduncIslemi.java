import java.time.LocalDate;

public class OduncIslemi {

    private int id;
    private User user;
    private Kitap kitap;
    private LocalDate alinanTarih;
    private LocalDate iadeTarihi;
    private boolean verildiMi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Kitap getKitap() {
        return kitap;
    }

    public void setKitap(Kitap kitap) {
        this.kitap = kitap;
    }

    public LocalDate getAlinanTarih() {
        return alinanTarih;
    }

    public void setAlinanTarih(LocalDate alinanTarih) {
        this.alinanTarih = alinanTarih;
    }

    public LocalDate getIadeTarihi() {
        return iadeTarihi;
    }

    public void setIadeTarihi(LocalDate iadeTarihi) {
        this.iadeTarihi = iadeTarihi;
    }

    public boolean isVerildiMi() {
        return verildiMi;
    }

    public void setVerildiMi(boolean verildiMi) {
        this.verildiMi = verildiMi;
    }

    public OduncIslemi(int id, User user, Kitap kitap, LocalDate alinanTarih, LocalDate iadeTarihi, boolean verildiMi) {
        this.id = id;
        this.user = user;
        this.kitap = kitap;
        this.alinanTarih = alinanTarih;
        this.iadeTarihi = iadeTarihi;
        this.verildiMi = verildiMi;
    }
}
