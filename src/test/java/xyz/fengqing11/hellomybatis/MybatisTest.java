package xyz.fengqing11.hellomybatis;

import jdk.management.resource.ResourceRequest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.fengqing11.hellomybatis.dao.IUserDao;
import xyz.fengqing11.hellomybatis.domain.User;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建factory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.创建sqlSession
        SqlSession sqlSession = factory.openSession();
        //4.使用sqlSession创建Dao代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = iUserDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        in.close();
    }
}
