package mapper;

import com.xu.po.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
import java.util.ListIterator;

public class findAccountByIdTest {
    @Test
    public void Test01() throws Exception{
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Account account = sqlSession.selectOne("test.findAccountById",1);
        System.out.println(account);
        System.out.println(account.getUsername());
        sqlSession.close();
    }
    @Test
    public void Test02() throws Exception{
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Account account = new Account();
        account.setUsername("张三");
        account.setBalance(5000);
        sqlSession.insert("test.insertAccount",account);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void Test03() throws Exception{
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Account> list = sqlSession.selectList("test.findAccountByName","张");
        ListIterator listIterator = list.listIterator();
        System.out.println(list);
        sqlSession.close();
    }
    @Test
    public void Test04() throws Exception{
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteAccount",3);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void Test05() throws Exception{
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Account account = new Account();
        account.setId(6);
        account.setBalance(10000);
        sqlSession.update("test.updateAccount",account);
        sqlSession.commit();
        sqlSession.close();
    }
}
