package com.chau.test;

import com.chau.domain.User;
import com.chau.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

/**
 * @author wilfred
 */
public class MybatisTest {

    @Test
    public void testFindAllResultMap() throws IOException {
        InputStream inputStream = getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findAllResultMap();
        for(User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByIdAndUsername() throws IOException {
        InputStream resourceAsStream = getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findByIdAndUsername1(1, "chau");
        System.out.println(list);
    }

    @Test
    public void testFindByIdAndUsername2() throws Exception {
        InputStream resourceAsStream = getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setUsername("chau");
        List<User> list = mapper.findByIdAndUsername2(user);
        System.out.println(list);
    }

    @Test
    public void testFindByUsername() throws IOException {
        InputStream resourceAsStream = getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findByUsername("%ilfre%");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByUsername2() throws IOException {
        InputStream resourceAsStream = getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findByUsername2("ilfre");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave() throws IOException {
        InputStream resourceAsStream = getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("zywoo");
        user.setAddress("法国");
        user.setTelephone("654321");
        user.setBirthday(new Date());
        user.setGender("男");
        mapper.save(user);
        System.out.println("返回主键：" + user.getId());
    }

    @Test
    public void testSave2() throws IOException {
        InputStream resourceAsStream = getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("shox");
        user.setAddress("法国");
        user.setTelephone("666666");
        user.setBirthday(new Date());
        user.setGender("男");
        mapper.save2(user);
        System.out.println("返回主键：" + user.getId());
    }

    @Test
    public void testIf() throws IOException {
        InputStream resourceAsStream = getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(3);
        // user.setUsername("curry");
        List<User> list = mapper.findByIdAndUsernameIf(user);
        System.out.println(list);

    }

    @Test
    public void testChoose() throws IOException {
        InputStream resourceAsStream = getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        // user.setId(2);
        user.setUsername("wilfred");
        List<User> list = mapper.findByIdAndUsernameChoose(user);
        System.out.println(list);
    }

    @Test
    public void testSet() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(5);
        user.setUsername("kobe");
        user.setGender("男");
        user.setBirthday(new Date());
        user.setAddress("洛杉矶");
        mapper.updateIf(user);
    }

    @Test
    public void testForeach() throws IOException {
        InputStream resourceAsStream = getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<User> list = mapper.findByList(ids);
        System.out.println(list);
    }

    @Test
    public void testPageHelper() throws IOException {
        // 设置分页参数
        PageHelper.startPage(1,2);
    }
}
