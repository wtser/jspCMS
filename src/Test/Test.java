package Test;

import java.util.ArrayList;
import java.util.List;

import com.xwfb.bean.News;
import com.xwfb.bean.Sort;
import com.xwfb.bean.User;
import com.xwfb.dao.NewsDao;
import com.xwfb.dao.SortDao;
import com.xwfb.dao.UserDao;

public class Test {
	public static void main(String[] args) {
		User user = new User();
		user.setLogTime(2);
		user.setName("wtser");
		user.setPass("admin");
		user.setPrivileges(2);
		
		
		
		UserDao userdao = new UserDao();
		userdao.insertUser(user);
		//News news = new News();
		//news.setAuthor("我了个去 ");
		//news.setContent("neir");
		
		//NewsDao newsdao = new NewsDao();
		//newsdao.updateNews(news, 8);
		//newsdao.insertNews(news);
		
		
		//System.out.println(newsdao.getNewsAll());
		
		
		
		//newsclass.setClassName(className);
		//newsclass.setClassName("jbb");
		//newsclass.setTopCLass(0);
		//newsclass.setId(5);
		
		
		
		//News_classDao newsclassdao=new News_classDao();
		//newsclassdao.insertClass(newsclass);
		//newsclassdao.deleteClass(5);
		
		//News_class newsclass = new News_class();
		/*newsclass.setClassName("改变的名称 ");*/
		
		
		/*newsclassdao.updateClass(newsclass, 6);*/
		
		//List<News_class> al = newsclassdao.getAllNewsClass();
		//ArrayList<News_class> al = newsclassdao.getAllNewsClass();
		//System.out.print(newsclassdao.getAllNewsClass());
		//for (int i = 0; i < al.size(); i++) {
			//News_class newsclass=al.get(i);
			//System.out.print(newsclass.getClassName());
		//}
		//newsclassdao.getNewsByIdClass(0);
		//Sort newsclass= new Sort();
		//SortDao newsclassdao = new SortDao();
		
		//System.out.print());
			
			
	
		
		
	}
}
