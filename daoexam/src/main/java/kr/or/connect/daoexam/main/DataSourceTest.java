package kr.or.connect.daoexam.main;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;

public class DataSourceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DataSource ds = ac.getBean(DataSource.class);
		Connection conn = null;
		try {
			conn = ds.getConnection();
			if(conn != null)
				System.out.println("접속 성공");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
				conn.close();
				}catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}	
		}
	}
}

