package com.chau.mapper;

import com.chau.domain.User;

import java.util.List;

/**
 * @author wilfred
 */
public interface UserMapper {

    public List<User> findAllResultMap();

    // 多条件查询一： 根据id和username查询user表
    public List<User> findByIdAndUsername1(Integer id, String username);

    // 最推荐的多条件查询方法：用pojo对象传递参数
    public List<User> findByIdAndUsername2(User user);

    // 模糊查询方式一：根据username模糊查询user表
    public List<User> findByUsername(String username);

    // 模糊查询最推荐方式：concat()函数
    public List<User> findByUsername2(String username);

    // 返回主键
    public void save(User user);

    // 返回主键方法二：也适用于不支持主键自增的数据库
    public void save2(User user);

    // 动态SQL1：根据id和username查询，但是不确定是否两个都有值
    public List<User> findByIdAndUsernameIf(User user);

    // 动态SQL2：如果有id只用id查询，没有id的话就看是否有username，有就用username做查询，都没有就不带条件
    public List<User> findByIdAndUsernameChoose(User user);

    // 动态SQL3：动态更新user表数据 如果该属性有值就更新，没有值不做处理
    public void updateIf(User user);

    // 动态SQL4：foreach标签主要用作数据的循环遍历
    // 案例：select * from user where id in (1,2,3) 这种语句中，传入的参数部分必须依靠foreach遍历才能实现
    public List<User> findByList(List<Integer> ids);

}
