import java.util.ArrayList;
import java.util.List;

public class OduncDAO {
    private List<OduncIslemi> oduncListesi;
    private int nextId = 1;

    public OduncDAO() {
        this.oduncListesi = new ArrayList<>();
    }

    public void oduncEkle(OduncIslemi odunc) {
        odunc.setId(nextId++);
        oduncListesi.add(odunc);
    }

    public OduncIslemi oduncGetir(int id) {
        for (OduncIslemi odunc : oduncListesi) {
            if (odunc.getId() == id) {
                return odunc;
            }
        }
        return null;
    }

    public List<OduncIslemi> tumOduncleriGetir() {
        return new ArrayList<>(oduncListesi);
    }

    public List<OduncIslemi> aktifOduncler() {
        List<OduncIslemi> aktifler = new ArrayList<>();
        for (OduncIslemi odunc : oduncListesi) {
            if (!odunc.isVerildiMi()) {
                aktifler.add(odunc);
            }
        }
        return aktifler;
    }

    public List<OduncIslemi> userOduncleri(int userId) {
        List<OduncIslemi> userOduncs = new ArrayList<>();
        for (OduncIslemi odunc : oduncListesi) {
            if (odunc.getUser().getId() == userId) {
                userOduncs.add(odunc);
            }
        }
        return userOduncs;
    }
}



