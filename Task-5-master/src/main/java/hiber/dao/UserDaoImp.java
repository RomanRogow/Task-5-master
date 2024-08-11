package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=
              sessionFactory.getCurrentSession()
              .createQuery("from User");
      return query.getResultList();
   }

   @Override
   @Transactional
   public List<User> getCarModelSeries(String model, int series) {
      Session session=sessionFactory.getCurrentSession();
      Query query=session.createQuery("from User user left join fetch" +
              " user.car where user.car.model = :model and user.car.series = :series");
      query.setParameter("model", model);
      query.setParameter("series", series);
      List<User> list = query.getResultList();

      return list;
   }
}
