package mapper;

import com.xu.dao.AccountDao;
import com.xu.po.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class DaoTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void Test01() throws Exception{
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void Test02() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用反射交给mybatis实现Dao类
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        Account account = accountDao.findAccountById(1);
        System.out.println(account.getUsername());
    }
    @Test
    public void Test03() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        Account account = accountDao.findAccountByName("张");
        System.out.println(account.getUsername());
    }
}
