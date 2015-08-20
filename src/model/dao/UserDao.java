package model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.ContextUtil;

import model.po.User;

public class UserDao {
    
	
	public User getUserById(int userId) {
		SqlSession sqlSession = ContextUtil.getSqlSession();
		
		User user = sqlSession.selectOne("model.mybatis.mapper.UserMapper.findById", userId);
		
		return user;
	}
	
    
    
    public List<User> getUserList(int sort , int offset , int limit){
        
        List<User> userList = new ArrayList<User>();
        
        User user1 = new User();
        user1.setName("cclehui");
        user1.setBirthday("1989-03-18");
        user1.setSex(1);
        
        User user2 = new User();
        user2.setName("mahongjuan");
        user2.setBirthday("1989-02-06");
        user2.setSex(0);
        
        userList.add(user1);
        userList.add(user2);
        
        return userList;
    }
    
    
    public int insertUser(User user){
    	
    	SqlSession sqlSession = ContextUtil.getSqlSession();
    	
    	int result = 0;
    	
    	if (sqlSession != null) {
    		
    		sqlSession.insert("model.mybatis.mapper.UserMapper.insertUser", user);
    		
    		result = user.getId();
    		
    		sqlSession.commit();
    		sqlSession.close();
    	}
    	
    	return result;
    }
    

}
