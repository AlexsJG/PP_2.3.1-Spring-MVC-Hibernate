package web.usersForTable;

import org.springframework.stereotype.Component;
import web.model.User;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class FillingUsers {

    private final UserService userDao;


    public FillingUsers(UserService userDao) {
        this.userDao = userDao;
    }

    @PostConstruct
    public void fillUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Иван", "Иванов", 20));
        users.add(new User("Петр", "Петров", 40));
        users.add(new User("Семен", "Семенов", 50));
        users.add(new User("Валерий", "Сидоров", 100));
        users.add(new User("Михаил", "Васильев", 75));
        for (User user : users) {
            userDao.addUser(user);
        }
    }
}
