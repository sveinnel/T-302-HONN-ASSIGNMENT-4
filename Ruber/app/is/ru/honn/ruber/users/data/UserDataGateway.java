package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.pojo.Trip;
import is.ru.honn.ruber.domain.pojo.User;
import is.ruframework.data.RuDataAccess;

import java.util.List;

public interface UserDataGateway extends RuDataAccess
{
    public int addUser(User user);
    public User getUserByUsername(String username);
    public User getUserById(int id);
    public List<User> getDrivers();
}