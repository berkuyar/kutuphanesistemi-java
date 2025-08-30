import java.time.LocalDate;
import java.util.Scanner;

public class KutuphaneSistemi {
    private KitapService kitapService;
    private UserService userService;
    private OduncService oduncService;
    private Scanner scanner;

    public KutuphaneSistemi() {
        // DAO'ları oluştur
        KitapDAO kitapDAO = new KitapDAO();
        UserDAO userDAO = new UserDAO();
        OduncDAO oduncDAO = new OduncDAO();

        // Service'leri oluştur (Dependency Injection)
        this.kitapService = new KitapService(kitapDAO);
        this.userService = new UserService(userDAO);
        this.oduncService = new OduncService(oduncDAO, userDAO, kitapDAO);

        this.scanner = new Scanner(System.in);

        // Test verisi ekle
        testVerisiEkle();
    }

    private void testVerisiEkle() {
        // Test kitapları
        kitapService.kitapEkle("Java Programlama", "Ahmet Yılmaz", 101);
        kitapService.kitapEkle("Spring Boot", "Ayşe Kaya", 102);
        kitapService.kitapEkle("OOP Temelleri", "Mehmet Demir", 103);

        // Test üyeleri
        userService.userEkle("Ali", "Veli", 5551234567L, "İstanbul");
        userService.userEkle("Fatma", "Özkan", 5559876543L, "Ankara");
    }

    public void calistir() {
        System.out.println("=== KÜTÜPHANE YÖNETİM SİSTEMİ ===");

        while (true) {
            anaMenuGoster();
            int secim = scanner.nextInt();
            scanner.nextLine(); // Buffer temizle

            switch (secim) {
                case 1: kitapIslemleriMenu(); break;
                case 2: uyeIslemleriMenu(); break;
                case 3: oduncIslemleriMenu(); break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }

            System.out.println("\nDevam etmek için Enter'a basın...");
            scanner.nextLine();
        }
    }

    private void anaMenuGoster() {
        System.out.println("\n=== ANA MENÜ ===");
        System.out.println("1. Kitap İşlemleri");
        System.out.println("2. Üye İşlemleri");
        System.out.println("3. Ödünç İşlemleri");
        System.out.println("0. Çıkış");
        System.out.print("Seçiminiz: ");
    }

    private void kitapIslemleriMenu() {
        while (true) {
            System.out.println("\n=== KİTAP İŞLEMLERİ ===");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitapları Listele");
            System.out.println("3. Kitap Sil");
            System.out.println("0. Ana Menüye Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1: kitapEkleMenu(); break;
                case 2: kitapService.tumKitaplariListele(); break;
                case 3: kitapSilMenu(); break;
                case 0: return;
                default: System.out.println("Geçersiz seçim!");
            }

            if (secim != 0) {
                System.out.println("\nDevam etmek için Enter'a basın...");
                scanner.nextLine();
            }
        }
    }

    private void uyeIslemleriMenu() {
        while (true) {
            System.out.println("\n=== ÜYE İŞLEMLERİ ===");
            System.out.println("1. Üye Ekle");
            System.out.println("2. Üyeleri Listele");
            System.out.println("3. Üye Sil");
            System.out.println("0. Ana Menüye Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1: uyeEkleMenu(); break;
                case 2: userService.tumUserleriListele(); break;
                case 3: uyeSilMenu(); break;
                case 0: return;
                default: System.out.println("Geçersiz seçim!");
            }

            if (secim != 0) {
                System.out.println("\nDevam etmek için Enter'a basın...");
                scanner.nextLine();
            }
        }
    }

    private void oduncIslemleriMenu() {
        while (true) {
            System.out.println("\n=== ÖDÜNÇ İŞLEMLERİ ===");
            System.out.println("1. Ödünç Ver");
            System.out.println("2. Kitap İade Et");
            System.out.println("3. Aktif Ödünçleri Listele");
            System.out.println("0. Ana Menüye Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1: oduncVerMenu(); break;
                case 2: kitapIadeMenu(); break;
                case 3: oduncService.aktifOduncleriListele(); break;
                case 0: return;
                default: System.out.println("Geçersiz seçim!");
            }

            if (secim != 0) {
                System.out.println("\nDevam etmek için Enter'a basın...");
                scanner.nextLine();
            }
        }
    }

    private void kitapEkleMenu() {
        System.out.println("\n=== KİTAP EKLE ===");
        System.out.print("Kitap Adı: ");
        String ad = scanner.nextLine();

        System.out.print("Yazar: ");
        String yazar = scanner.nextLine();

        System.out.print("Raf No: ");
        int rafNo = scanner.nextInt();
        scanner.nextLine();

        kitapService.kitapEkle(ad, yazar, rafNo);
    }

    private void kitapSilMenu() {
        kitapService.tumKitaplariListele();
        System.out.print("\nSilinecek kitap ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        kitapService.kitapSil(id);
    }

    private void uyeEkleMenu() {
        System.out.println("\n=== ÜYE EKLE ===");
        System.out.print("Ad: ");
        String ad = scanner.nextLine();

        System.out.print("Soyad: ");
        String soyad = scanner.nextLine();

        System.out.print("Telefon: ");
        long telefon = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Adres: ");
        String adres = scanner.nextLine();

        userService.userEkle(ad, soyad, telefon, adres);
    }

    private void uyeSilMenu() {
        userService.tumUserleriListele();
        System.out.print("\nSilinecek üye ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        userService.userSil(id);
    }

    private void oduncVerMenu() {
        System.out.println("\n=== ÖDÜNÇ VER ===");

        // Üyeleri göster
        userService.tumUserleriListele();
        System.out.print("\nÜye ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        // Kitapları göster
        kitapService.tumKitaplariListele();
        System.out.print("\nKitap ID: ");
        int kitapId = scanner.nextInt();
        scanner.nextLine();

        oduncService.oduncVer(userId, kitapId);
    }

    private void kitapIadeMenu() {
        oduncService.aktifOduncleriListele();
        System.out.print("\nİade edilecek ödünç ID: ");
        int oduncId = scanner.nextInt();
        scanner.nextLine();

        oduncService.kitapIadeEt(oduncId);
    }

    public static void main(String[] args) {
        KutuphaneSistemi sistem = new KutuphaneSistemi();
        sistem.calistir();
    }
}