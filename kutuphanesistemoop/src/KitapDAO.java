import java.util.ArrayList;
import java.util.List;
public class KitapDAO {

    private List<Kitap> kitapListesi;
    private int nextId = 1;

    public KitapDAO(){
        this.kitapListesi = new ArrayList<>();
    }


    public void kitapEkle(Kitap kitap){

        kitap.setId(nextId);
        nextId++;
        kitapListesi.add(kitap);
    }
    public boolean kitapSil(int id) {
        for (int i = kitapListesi.size() - 1; i >= 0; i--) {
            if (kitapListesi.get(i).getId() == id) {
                kitapListesi.remove(i);
                return true; // Buldu, sildi
            }
        }
        return false; // Bulamadı
    }

    public Kitap kitapGetir(int id){

        for(Kitap k : kitapListesi){

            if(k.getId() == id){
                return k;
            }
        }
        return null;
    }

    public List<Kitap> tumKitaplariGetir(){
        List<Kitap> tumkitaplar = new ArrayList<>();

        for (Kitap k : kitapListesi){
            tumkitaplar.add(k);
        }

        return tumkitaplar;
    }
    public List<Kitap> ismeGoreAra(String ad){

        List <Kitap> list = new ArrayList<>();
        for (Kitap k : kitapListesi){
            if(k.getIsim().equals(ad)){
                list.add(k);
            }
        }
        return list;
    }

}
