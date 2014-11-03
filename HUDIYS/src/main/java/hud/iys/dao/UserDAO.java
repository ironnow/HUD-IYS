package hud.iys.dao;

import java.util.List;

import hud.iys.model.User;

import org.hibernate.SessionFactory;

/**
 * @author hud-iys2
 * @version 1.0.0 @date Oct 24, 2014 @time 1:46:22 PM
 */
public class UserDAO implements IUserDAO
{

   private SessionFactory sessionFactory;

   public SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }

   public void setSessionFactory(final SessionFactory sessionFactory)
   {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void addUser(final User User)
   {
      getSessionFactory().getCurrentSession().save(User);
   }

   @Override
   public void deleteUser(final User User)
   {
      getSessionFactory().getCurrentSession().delete(User);
   }

   @Override
   public void updateUser(final User User)
   {
      getSessionFactory().getCurrentSession().update(User);
   }

   @Override
   public User getUserById(final Long id)
   {
      List list =
            getSessionFactory().getCurrentSession()
            .createQuery("from User where UserId=?").setParameter(0, id).list();
      return (User) list.get(0);
   }

   @Override
   public List<User> getUserlar()
   {
      List list = getSessionFactory().getCurrentSession().createQuery("from User").list();
      return list;
   }

   @Override
   public User getUserByUserName(String userName)
   {
      List list = 
            getSessionFactory().getCurrentSession()
            .createQuery("from User where userName=?").setParameter(0, userName).list();
      if(list.size()>0){
    	  return (User) list.get(0);
      }
      else return null;
      
   }
   
}
