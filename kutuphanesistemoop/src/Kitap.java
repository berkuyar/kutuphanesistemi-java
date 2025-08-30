public class Kitap {

    private int id;
    private String isim;
    private String yazar;
    private int rafNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public int getRafNo() {
        return rafNo;
    }

    public void setRafNo(int rafNo) {
        this.rafNo = rafNo;
    }

    public Kitap(int id, String isim, String yazar, int rafNo) {
        this.id = id;
        this.isim = isim;
        this.yazar = yazar;
        this.rafNo = rafNo;
    }
}
