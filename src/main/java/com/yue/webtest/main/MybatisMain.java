package com.yue.webtest.main;

import com.yue.webtest.mapper.UserMapper;
import com.yue.webtest.po.User;
import com.yue.webtest.utils.DBTools;
import org.apache.ibatis.session.SqlSession;

public class MybatisMain {
    public static void main(String[] args) {
        selectUserById();
    }

    /**
     * 根据id查询用户
     */
    private static void selectUserById() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            User user = mapper.getUser("xiaoming");
            System.out.println(user.getName() + ";" + user.getDescribe());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
}
