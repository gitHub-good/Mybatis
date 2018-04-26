package mapper;

import com.xu.mapper.AccountMapper;
import com.xu.po.Account;
import com.xu.vo.AccountVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Mapper {
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
        //创建AccountMapper对象，mybatis自动生成mapper代理对象
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        AccountVo accountVo = new AccountVo();
        Account account = new Account();
        account.setUsername("张");
        account.setBalance(10000);
        accountVo.setAccount(account);
        List<Account> list = accountMapper.findAccountList(accountVo);
        System.out.println(list);
    }
}
