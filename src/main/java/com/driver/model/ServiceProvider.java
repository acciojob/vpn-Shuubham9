package com.driver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ServiceProvider")
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    @ManyToOne
    @JoinColumn
    Admin admin;

    @ManyToMany(mappedBy = "ServiceProviderList", cascade = CascadeType.ALL)
    List<User> users;

    @OneToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL)
    List <Connection> connectionList;

    @OneToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL)
    List<Country> countryList;

    public ServiceProvider() {
    }

    public ServiceProvider(int id, String name, Admin admin, List<User> users, List<Connection> connectionList, List<Country> countryList) {
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.users = users;
        this.connectionList = connectionList;
        this.countryList = countryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}
