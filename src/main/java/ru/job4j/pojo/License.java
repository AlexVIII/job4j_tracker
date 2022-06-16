package ru.job4j.pojo;

import java.util.Date;
import java.util.Objects;

public class License {
    private String owner;
    private String code;
    private Date created;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        License license = (License) o;
        return Objects.equals(owner, license.owner) && Objects.equals(code, license.code) && Objects.equals(created, license.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, code, created);
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
