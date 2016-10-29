package frank.java.chapter13.anno.demo;

import java.lang.reflect.Proxy;

public abstract class DaoFactory {
	
	public static void main(String[] args) {
		Context.INSTANCE.setCurrentPermission(PermissionValue.READ + PermissionValue.UPDATE);
		IAccountDao dao = DaoFactory.getDao(IAccountDao.class);
		Account account = dao.load("test");
		dao.update(account);
		dao.delete("test");
	}

	@SuppressWarnings("unchecked")
	public static <T> T getDao(Class<T> infClz) {
		Dao anno = infClz.getAnnotation(Dao.class);
		if (anno == null)
			throw new IllegalArgumentException(infClz.getName() + "不是一个有效的 DAO 接口");
		
		Class<?> targetClz = anno.value();
		Object target;
		try {
			target = targetClz.newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException("无法实例化 DAO 的实现类");
		}
		return (T) Proxy.newProxyInstance(DaoFactory.class.getClassLoader(), 
				new Class<?>[]{infClz},
				new PermissionHandler(target));
	}
}
