package lk.ijse.gdse.bean;

import org.springframework.beans.factory.DisposableBean;

import java.io.Closeable;

public class MyConnection implements DisposableBean {

    public MyConnection() {
//        System.out.println("This is the myconnection");
    }

    @Override
    public void destroy() throws Exception {
//        System.out.println("My connection destroy");
    }
}
