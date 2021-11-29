package com.example.springboot03_demo.Service;

import com.example.springboot03_demo.Dao.UserDao;
import com.example.springboot03_demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userDetailsService")
public class MyUserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> users = userDao.selectUserByUsername(s);
        if (users==null){
            throw new UsernameNotFoundException("用户名不存在");
        }else {
            User user = users.get(0);
            List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
            return new org.springframework.security.core.userdetails.User("merry", new BCryptPasswordEncoder().encode(user.getPassword())
                ,auths);
        }
}

}
