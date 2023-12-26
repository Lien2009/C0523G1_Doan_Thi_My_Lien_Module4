package com.example.cs4.account.model;


import com.example.cs4.role.model.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    @Column(name = "username", nullable = false,unique = true)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonManagedReference
    private Set<Role> role;

    public Account() {
    }


    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Account(int accountId, String userName, String password, boolean isDeleted, Set<Role> role) {
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
        this.isDeleted = isDeleted;
        this.role = role;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRoleSet(Set<Role> role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isDeleted=" + isDeleted +
                ", role=" + role +
                '}';
    }
}
