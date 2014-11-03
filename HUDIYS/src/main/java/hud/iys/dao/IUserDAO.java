package hud.iys.dao;

import java.util.List;

import hud.iys.model.User;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IUserDAO
{
   public void addUser(User user);

   public void updateUser(User user);

   public void deleteUser(User user);

   public User getUserById(Long id);

   public List<User> getUserlar();

   public User getUserByUserName(String userName);

}
