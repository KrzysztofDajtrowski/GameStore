package pl.camp.it.rant.a.game.database;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import pl.camp.it.rant.a.game.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDatabase {
    private final List<User> users = new ArrayList<>();

    public List<User> getUsers(){return users;}

    public UserDatabase() {
        this.users.add(new User("Zbyszek","Król","admin",
                DigestUtils.md5Hex("admin"),"zbychu@wp.pl"));
        this.users.add(new User("Karol","Kowalski","user",
                DigestUtils.md5Hex("user"), "kkk@wp.pl"));

    }

    public User getUserByLogin(String login){
        for(User user: this.users){
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }
    public void addUser(User user){
        this.users.add(user);
    }


}
