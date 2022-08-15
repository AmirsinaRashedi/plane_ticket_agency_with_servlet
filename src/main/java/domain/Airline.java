package domain;

import base.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = Airline.TABLE_NAME)
public class Airline extends BaseEntity<Long> {

    public static final String TABLE_NAME = "airline";

    private String name;

    private String password;

    public Airline() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {

        return "Airline: "
                + name;

    }

}
