package cn.pzhu.domain;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private Long role_id;
    private String role_name;
    private Set<User> users = new HashSet<User>();

    public Role() {
    }

    public Role(Long role_id, String role_name, Set<User> users) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.users = users;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getrole_name() {
        return role_name;
    }

    public void setrole_name(String role_name) {
        this.role_name = role_name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
