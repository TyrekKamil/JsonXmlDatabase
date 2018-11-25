package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.DateTime;

public class Payments {
    private int id;
    private int idPersonCourse;
    private int money;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private DateTime dayPayment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPersonCourse() {
        return idPersonCourse;
    }

    public void setIdPersonCourse(int idPersonCourse) {
        this.idPersonCourse = idPersonCourse;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public DateTime getDayPayment() {
        return dayPayment;
    }

    public void setDayPayment(DateTime dayPayment) {
        this.dayPayment = dayPayment;
    }
}
