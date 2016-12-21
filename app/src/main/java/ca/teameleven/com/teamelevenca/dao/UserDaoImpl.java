package ca.teameleven.com.teamelevenca.dao;

import java.util.List;

import ca.teameleven.com.teamelevenca.model.User;
import ca.teameleven.com.teamelevenca.util.DummyData;

/**
 * Created by ahmedraaj on 21/12/16.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(int id) {
       return DummyData.users.get(id);
    }

    @Override
    public List<User> getAllUser() {
        return  DummyData.users;
    }

    @Override
    public void Save(User user) {

        DummyData.users.add(user);
    }

    @Override
    public void Delete(int id) {
      DummyData.users.remove(id);
    }
}
