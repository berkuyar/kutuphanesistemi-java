import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    List<User> userListesi;
    private int nextId = 1;

    public UserDAO(){
        this.userListesi = new ArrayList<>();
    }

    public void userEkle(User user){
        user.setId(nextId);
        nextId++;
        userListesi.add(user);
    }
    public boolean userSil(int id){

        for(int i = userListesi.size() - 1; i >= 0; i--){

            if(userListesi.get(i).getId() == id){
                userListesi.remove(i);
                return true;
            }
        }
        return false;
    }

    public User userGetir(int userId){

        for (User u : userListesi){

            if(u.getId() == userId){

                return u;

            }
        }
        return null;
    }
    public List<User> tumUserleriGetir(){
        return new ArrayList<>(userListesi);
    }


}
