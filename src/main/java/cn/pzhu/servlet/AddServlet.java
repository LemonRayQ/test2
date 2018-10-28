package cn.pzhu.servlet;

import cn.pzhu.domain.Customer;
import cn.pzhu.service.CustomerService;
import cn.pzhu.service.CustomerServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImp();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer c = new Customer();
        try {
            BeanUtils.populate(c,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        customerService.save(c);
        response.sendRedirect(request.getContextPath()+"/ListCustomerServlet");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}
