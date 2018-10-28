package cn.pzhu.service;

import cn.pzhu.DAO.CustomerDAO;
import cn.pzhu.DAO.CustomerDAOImp;
import cn.pzhu.domain.Customer;
import cn.pzhu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerServiceImp implements CustomerService {
    private CustomerDAO customerDAO = new CustomerDAOImp();
    @Override
    public void save(Customer c) {
        Session session = HibernateUtil.getCurrentSeesion();
        Transaction transaction = session.beginTransaction();
        try {
            customerDAO.save(c);
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

        transaction.commit();
    }
}
