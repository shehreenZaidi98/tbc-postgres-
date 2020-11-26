package com.tbc.things;

import com.tbc.converter.StringEncryptDecryptConverter;

import javax.persistence.*;

@Entity
@Table(name = "user_credentials")
public class Things {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id")
    @Convert(converter = StringEncryptDecryptConverter.class)
    private String user_id;
    @Column(name = "password")
    @Convert(converter = StringEncryptDecryptConverter.class)
    private String password;
    @Column(name = "reset_token")
    @Convert(converter = StringEncryptDecryptConverter.class)
    private String reset_token;
    @Column(name = "created_time")
    @Convert(converter = StringEncryptDecryptConverter.class)
    private String created_time;
    @Column(name = "enabled")
    @Convert(converter = StringEncryptDecryptConverter.class)
    private String enabled;
    @Column(name = "activate_token")
    @Convert(converter = StringEncryptDecryptConverter.class)
    private String activate_token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReset_token() {
        return reset_token;
    }

    public void setReset_token(String reset_token) {
        this.reset_token = reset_token;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getActivate_token() {
        return activate_token;
    }

    public void setActivate_token(String activate_token) {
        this.activate_token = activate_token;
    }
}