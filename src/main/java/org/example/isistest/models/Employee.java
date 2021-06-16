package org.example.isistest.models;

import lombok.Data;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String patronymic;

    private String sex;

    @Column(columnDefinition = "timestamptz")
    private Date dateBirthday;

    @OneToOne
    @JoinColumn(name = "positionName")
    private Position position;

    @Column(columnDefinition = "timestamptz")
    private Date dateOfEmployment;

    private String salaryLevel;

    private String mobileNumber;

    private String workPhoneNumber;

    @ManyToOne
    @JoinColumn(name = "bankId")
    private Bank bank;

    private String status;

    public Employee() {
        this.status="Действующий";
    }

    public void setDateBirthday(String dateBirthday) {
        try {
            this.dateBirthday = new SimpleDateFormat("yyyy-MM-dd").parse(dateBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        try {
            this.dateOfEmployment = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfEmployment);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDateBirthday() {
        return dateBirthday==null? null:new SimpleDateFormat("yyyy-MM-dd").format(dateBirthday);
    }

    public String getDateOfEmployment() {
        return dateOfEmployment==null? null: new SimpleDateFormat("yyyy-MM-dd").format(dateOfEmployment);
    }
}