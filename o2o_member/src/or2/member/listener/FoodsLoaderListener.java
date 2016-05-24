package or2.member.listener;

import java.lang.reflect.Member;
import java.util.List;

import javax.ejb.SessionContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.hibernate.Session;

import o2o.member.pojo.Food;
import o2o.member.service.impl.LoadFoodsServiceImpl;

public class FoodsLoaderListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
