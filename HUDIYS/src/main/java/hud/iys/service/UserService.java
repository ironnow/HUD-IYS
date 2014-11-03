package hud.iys.service;

import java.util.List;

import hud.iys.dao.IUserDAO;
import hud.iys.model.User;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class UserService implements IUserService
{

   // UserDAO is injected...
   IUserDAO userDAO;

   @Transactional(readOnly = false)
   @Override
   public void addUser(final User User)
   {
      getUserDAO().addUser(User);
   }

   @Transactional(readOnly = false)
   @Override
   public void deleteUser(final User User)
   {
      getUserDAO().deleteUser(User);
   }

   @Transactional(readOnly = false)
   @Override
   public void updateUser(final User User)
   {
      getUserDAO().updateUser(User);
   }

   @Override
   public User getUserById(final Long id)
   {
      return getUserDAO().getUserById(id);
   }

   @Override
   public List<User> getUserlar()
   {
      return getUserDAO().getUserlar();
   }

   @Override
   public User getUserByUserName(String userName)
   {
      return getUserDAO().getUserByUserName(userName);
   }

   public IUserDAO getUserDAO()
   {
      return userDAO;
   }

   public void setUserDAO(final IUserDAO userDAO)
   {
      this.userDAO = userDAO;
   }
}