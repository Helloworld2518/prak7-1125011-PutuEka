package minggu.Model;
import java.util.ArrayList;

public class UserModel {
    private ArrayList<User> userData = new ArrayList<>();

    public UserModel(){
        this.userData = new ArrayList<>();
    }

    public User getUsername(String username){
        for (User u: userData){
            if (u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }

    public void addUsername(String user, String password){
        userData.add(new User(user, password));
    }
}
