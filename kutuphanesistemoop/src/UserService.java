import java.time.LocalDate;
import java.util.List;

public class UserService {

    private UserDAO userDAO;
    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public boolean userEkle(String ad, String soyad, Long telefon, String adres){
        if(ad == null || ad.trim().isEmpty()){
            System.out.println("Hata: Ad boş olamaz");
            return false;
        }
        if(soyad == null || soyad.trim().isEmpty()){
            System.out.println("Hata: Soyad boş olamaz");
            return false;
        }
        User yeniUser = new User (0, ad, soyad, telefon , adres, LocalDate.now());
        userDAO.userEkle(yeniUser);
        System.out.println("Üye eklendi: " + ad + " " + soyad);
        return true;
    }

    public void tumUserleriListele(){
        List<User> userList = userDAO.tumUserleriGetir();
        if(userList.isEmpty()){
            System.out.println("Henüz hiç üye yok.");
            return;
        }

        System.out.println("\n=== ÜYE LİSTESİ ===");
        for (User u : userList) {
            System.out.println("ID: " + u.getId() + " | " + u.getAd() + " " + u.getSoyad() +
                    " | Tel: " + u.getTelefon() + " | Kayıt: " + u.getKayitTarihi());
        }
    }
    public boolean userSil(int id){
        User user = userDAO.userGetir(id);
        if(user == null){
            System.out.println("Silinecek kullanıcı bulunamadı.");
            return false;
        }
        boolean silindi = userDAO.userSil(id);
        System.out.println("Kullanıcı başarıyla silindi.");
        return true;


    }

}
