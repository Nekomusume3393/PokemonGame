package pokemon.pokedex.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XQuery {
	
	public static <B> B getSingleBean(Class<B> beanClass, String sql, Object... values) {
		List<B> list = XQuery.getBeanList(beanClass, sql, values);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	public static <B> List<B> getBeanList(Class<B> beanClass, String sql, Object... values) {
		List<B> list = new ArrayList<>();
		try {
			ResultSet rs = XJdbc.executeQuery(sql, values);
			while (rs.next()) {
				list.add(XQuery.readBean(rs, beanClass));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public static <B> B readBean(ResultSet rs, Class<B> beanClass) throws Exception {
		B bean = beanClass.getDeclaredConstructor().newInstance();
		Method[] methods = beanClass.getDeclaredMethods();
		for (Method method : methods) {
			String name = method.getName();
			if (name.startsWith("set") && method.getParameterCount() == 1) {
				try {
					Object value = rs.getObject(name.substring(3));
					method.invoke(bean, value);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SQLException e) {
					System.out.printf("+ Column '%s' not found!\r\n", name.substring(3));
				}
			}
		}
		return bean;
	}
	
	// Summary of the XQuery class:
	// Provides utility methods to execute SQL queries and map the results to Java beans.
	// - getSingleBean: Retrieves a single bean from the database based on the provided SQL query.
	// - getBeanList: Retrieves a list of beans from the database based on the provided SQL query.
	// - readBean: Maps a ResultSet row to a Java bean by invoking setter methods.
	// This class is useful for simplifying database interactions and object mapping in Java applications.
	
}