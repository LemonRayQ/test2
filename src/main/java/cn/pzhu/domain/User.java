package cn.pzhu.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Long user_id;
    private String user_name;
    private Set<Role> roles = new HashSet<Role>();

    public User() {
    }
    public User(Long user_id, String user_name, Set<Role> roles) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.roles = roles;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
