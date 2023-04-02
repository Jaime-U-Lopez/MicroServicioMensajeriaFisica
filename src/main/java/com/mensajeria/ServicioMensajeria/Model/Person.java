package com.mensajeria.ServicioMensajeria.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Person {

        private long cedula;
        private String name;
        private String lastName;



        @Autowired
        public Person(long cedula, String name, String lastName) {
            this.cedula = cedula;
            this.name = name;
            this.lastName = lastName;
        }

        public long getCedula() {
            return cedula;
        }

        public void setCedula(long cedula) {
            this.cedula = cedula;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

