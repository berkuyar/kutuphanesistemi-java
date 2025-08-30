import java.util.List;

public class KitapService {

    private KitapDAO kitapDAO;

    public KitapService(KitapDAO kitapDAO) {
        this.kitapDAO = new KitapDAO();
    }

    public boolean kitapEkle(String isim, String yazar, int rafNo) {

        if (isim == null || isim.trim().isEmpty()) {
            System.out.println("Hata: Kitap ismi boş olamaz");
            return false;
        }
        Kitap kitap = new Kitap(0, isim, yazar, rafNo);
        kitapDAO.kitapEkle(kitap);
        System.out.println("Kitap eklendi");
        return true;
    }

    public void tumKitaplariListele() {
        List<Kitap> kitaplar = kitapDAO.tumKitaplariGetir();
        if (kitaplar.isEmpty()) {
            System.out.println("Henüz kitap yok.");
            return;
        }

        System.out.println("\n=== KİTAP LİSTESİ ===");
        for (Kitap k : kitaplar) {
            System.out.println("ID: " + k.getId() + " | " + k.getIsim() +
                    " - " + k.getYazar() + " | Raf: " + k.getRafNo());
        }
    }

    public boolean kitapSil(int id){
        Kitap kitap = kitapDAO.kitapGetir(id);
        if(kitap == null){
            System.out.println("Hata: Silinecek kitap bulunamadı.");
            return false;
        }
        boolean silindi = kitapDAO.kitapSil(id);
        System.out.println("Kitap başarıyla silindi.");
        return silindi;
    }
}