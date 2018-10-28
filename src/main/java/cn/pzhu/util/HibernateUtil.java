package cn.pzhu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sf;
    static {
        Configuration configuration =  new Configuration().configure();
        sf = configuration.buildSessionFactory();
    }

    //获得session
    public static Session openSession(){
        return sf.openSession();

    }
    public static Session getCurrentSeesion(){
        org.hibernate.classic.Session currentSession = sf.getCurrentSession();
        return currentSession;
    }
}
