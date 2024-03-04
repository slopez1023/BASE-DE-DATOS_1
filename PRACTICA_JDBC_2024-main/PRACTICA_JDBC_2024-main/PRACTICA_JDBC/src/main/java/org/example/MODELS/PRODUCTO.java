package org.example.MODELS;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PRODUCTO {



        private Long Id;
        private String Name;
        private double Price;
        private LocalDate Register_date;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public LocalDate getRegister_date() {
        return Register_date;
    }

    public void setRegister_date(LocalDate register_date) {
        Register_date = register_date;
    }
}


