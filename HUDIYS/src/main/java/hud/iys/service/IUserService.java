package hud.iys.service;

import java.util.List;

import hud.iys.model.User;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public interface IUserService
{
   public void addUser(User user);

   public void updateUser(User user);

   public void deleteUser(User user);

   public User getUserById(Long id);

   public User getUserByUserName(String userName);

   public List<User> getUserlar();
}
