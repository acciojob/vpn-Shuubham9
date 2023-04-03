package com.driver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String username;

    String password;

    String originIP;

    String maskedIp;

    boolean connected;

    @ManyToMany
    @JoinColumn
    List<ServiceProvider> serviceProviderList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Connection> connectionList;

    @OneToOne
    @JoinColumn
    Country country;

    public User() {
    }

    public User(String username, String password,boolean connected, Country country) {

        this.username = username;
        this.password = password;
        this.connected = connected;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOriginIP() {
        return originIP;
    }

    public void setOriginIP(String originIP) {
        this.originIP = originIP;
    }

    public String getMaskedIp() {
        return maskedIp;
    }

    public void setMaskedIp(String maskedIp) {
        this.maskedIp = maskedIp;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public List<ServiceProvider> getServiceProviderList() {
        return serviceProviderList;
    }

    public void setServiceProviderList(List<ServiceProvider> serviceProviderList) {
        this.serviceProviderList = serviceProviderList;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public Country getCountry() {
        return country;
    }

    public boolean getConnected(){
        return this.connected;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
