import cn.pzhu.domain.Customer;
import cn.pzhu.domain.LinkMan;
import cn.pzhu.domain.User;
import cn.pzhu.util.DBCPUtil;
import cn.pzhu.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
//    Integer
    @org.junit.Test
    public void demo2(){
//        System.out.println(Integer.valueOf("1001",2));
        //System.out.println("digit:"+digit);
        //System.out.println((char)(44));
//        Integer i=new Integer(Integer.MAX_VALUE);

        //2147483647
//        System.out.println(i);
/*    Integer a1 = 100;
    Integer a2 = 100;
    int a3 = 100;
    Integer b1 = 127;//通过自动装箱调用valueOf（）指向缓存的127
    Integer b2 = 127;
    Integer b3 = new Integer(127);//指向自己内存中的127
        System.out.println(a1==a3);
        System.out.println(b1==b3);//false*/
//        System.out.println(Integer.valueOf("1001",2));
//    String s = Integer.toString(123,2);
//        System.out.println(s);
//
        Map<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"张三");
        System.out.println(hashMap.put(1,"李四"));
    }

    @org.junit.Test
    public void demo3(){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
//        String hql = "from Customer where cust_id = :cust_id";//条件查询
        //分页查询
//        String hql= "from  Customer ";
//        Query query = session.createQuery(hql);
//        //设置分页信息
//        query.setFirstResult(1);
//        query.setMaxResults(2);
//        List<Customer> list = query.list();
//        System.out.println(list);
//        query.setLong(0,1l);
//        query.setParameter("cust_id",1l);

//        Customer customer = (Customer) query.uniqueResult();
//        System.out.println(customer);
        transaction.commit();
        session.close();

    }
    @org.junit.Test
    public void demo4(){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Customer c = new Customer();
        c.setCust_name("攀枝花学院");

        LinkMan lm1 = new LinkMan();
        LinkMan lm2 = new LinkMan();
        lm1.setLkm_name("yty");
        lm2.setLkm_name("lh");
        //多对一
        c.getLinkMens().add(lm1);
        c.getLinkMens().add(lm2);
        //一对多
        lm1.setCustomer(c);
        lm2.setCustomer(c);
        //瞬时态->持久态
        session.save(c);
        session.save(lm1);
        session.save(lm2);
        transaction.commit();
        session.close();

    }
    @org.junit.Test
    public void demo5(){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Customer c = (Customer) session.get(Customer.class, 1l);
        LinkMan lm = new LinkMan();
        lm.setLkm_name("yth");
        c.getLinkMens().add(lm);
        lm.setCustomer(c);
        session.save(lm);
        transaction.commit();
        session.close();

    }
    @org.junit.Test
    public void demo6(){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        LinkMan lm = (LinkMan) session.get(LinkMan.class, 4l);
        Customer c = (Customer) session.get(Customer.class, 1l);
        c.getLinkMens().remove(lm);
        lm.setLkm_name(null);
        transaction.commit();
        session.close();

    }

    @org.junit.Test
    public void springtest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);

    }
}
