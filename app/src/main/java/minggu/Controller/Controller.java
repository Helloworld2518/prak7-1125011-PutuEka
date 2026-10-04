package minggu.Controller;
import minggu.Model.User;
import minggu.Model.UserModel;

public class Controller {
    private UserModel userModel = new UserModel();

    public Controller(UserModel userModel){
        this.userModel = userModel;
    }

    public void register(String username, String password){
        userModel.addUsername(username, password);
    }

    public boolean isValid(String username, String password){
       User user = userModel.getUsername(username);

       if(user.getPassword().equals(password)){
            return true;
       }
       return false;
    }
}
