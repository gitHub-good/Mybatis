//package com.xu.daoImpl;
//
//import com.xu.dao.AccountDao;
//import com.xu.po.Account;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//
//public class AccountDaoImpl implements AccountDao {
//    private SqlSessionFactory sqlSessionFactory;
//    public AccountDaoImpl(SqlSessionFactory sqlSessionFactory){
//        this.sqlSessionFactory = sqlSessionFactory;
//    }
//    @Override
//    public Account findAccountById(int id) throws Exception {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        Account account = sqlSession.selectOne("test.findAccountById",id);
//        sqlSession.close();
//        return account;
//    }
//}
