import java.time.LocalDate;
import java.util.List;

public class OduncService {

    private OduncDAO oduncDAO;
    private UserDAO userDAO;
    private KitapDAO kitapDAO;

    public OduncService(OduncDAO oduncDAO, UserDAO userDAO, KitapDAO kitapDAO) {
        this.oduncDAO = oduncDAO;
        this.userDAO = userDAO;
        this.kitapDAO = kitapDAO;
    }

    public boolean oduncVer(int kitapId, int userId) {
        User user = userDAO.userGetir(userId);
        if (user == null) {
            System.out.println("Hata: Böyle bir kullanıcı yok.");
            return false;
        }
        Kitap kitap = kitapDAO.kitapGetir(kitapId);
        if (kitap == null) {
            System.out.println("Hata: Böyle bir kitap yok.");
        }
        if (kitapOduncteMi(kitapId)) {
            System.out.println("Bu kitap zaten ödünçte");
            return false;
        }
        LocalDate iadeTarihi = LocalDate.now().plusDays(14);
        OduncIslemi oduncIslemi = new OduncIslemi(0, user, kitap, LocalDate.now(), iadeTarihi, false);
        oduncDAO.oduncEkle(oduncIslemi);
        System.out.println(user.getAd() + " " + user.getSoyad() + " kullanıcısına " +
                kitap.getIsim() + " kitabı ödünç verildi. İade tarihi: " + iadeTarihi);
        return true;
    }


    public boolean kitapOduncteMi(int kitapId) {
        List<OduncIslemi> aktifOduncler = oduncDAO.aktifOduncler();
        for (OduncIslemi o : aktifOduncler) {
            if (o.getKitap().getId() == kitapId) {
                return true;
            }
        }
        return false;
    }

    public boolean kitapIadeEt(int oduncId) {

        OduncIslemi odunc = oduncDAO.oduncGetir(oduncId);
        if (odunc == null) {
            System.out.println("Hata: Ödünç işlemi bulunamadı!");
            return false;
        }

        if (odunc.isVerildiMi()) {
            System.out.println("Hata: Bu kitap zaten iade edilmiş!");
            return false;
        }
        odunc.setVerildiMi(true);
        System.out.println("Kitap iade edildi");
        return true;
    }
    public void aktifOduncleriListele(){
        List<OduncIslemi> oduncIslemiList = oduncDAO.aktifOduncler();
        if(oduncIslemiList.isEmpty()){
            System.out.println("Aktif ödünç işlemi yok");
            return;
        }
        for(OduncIslemi odunc : oduncIslemiList){
            System.out.println("ID: " + odunc.getId() + " | " +
                    odunc.getUser().getAd() + " " + odunc.getUser().getSoyad() +
                    " | " + odunc.getKitap().getIsim() +
                    " | İade Tarihi: " + odunc.getIadeTarihi());
        }

    }
}