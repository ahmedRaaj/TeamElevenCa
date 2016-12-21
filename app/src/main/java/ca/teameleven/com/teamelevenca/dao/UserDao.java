package ca.teameleven.com.teamelevenca.dao;

import java.util.List;

import ca.teameleven.com.teamelevenca.model.User;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public interface UserDao {
    public User getUser(int id);
    public List<User> getAllUser();
    public void Save(User cat);
    public void Delete(int id);
}
