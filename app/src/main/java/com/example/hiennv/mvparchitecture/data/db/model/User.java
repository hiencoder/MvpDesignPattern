package com.example.hiennv.mvparchitecture.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "user")
public class User {
    /*Database local*/
    //Primary key
    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "created_at")
    private String createtAt;

    @Property(nameInDb = "updated_at")
    private String updatetAt;

    @Generated(hash = 1821505769)
    public User(Long id, String name, String createtAt, String updatetAt) {
        this.id = id;
        this.name = name;
        this.createtAt = createtAt;
        this.updatetAt = updatetAt;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatetAt() {
        return createtAt;
    }

    public void setCreatetAt(String createtAt) {
        this.createtAt = createtAt;
    }

    public String getUpdatetAt() {
        return updatetAt;
    }

    public void setUpdatetAt(String updatetAt) {
        this.updatetAt = updatetAt;
    }
}
