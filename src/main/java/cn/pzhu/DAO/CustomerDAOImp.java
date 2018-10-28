package cn.pzhu.DAO;

import cn.pzhu.domain.Customer;
import cn.pzhu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDAOImp implements CustomerDAO{

    @Override
    public void save(Customer c) {
        //获取session
        Session session = HibernateUtil.getCurrentSeesion();
        //执行保存
        session.save(c);

    }
}
