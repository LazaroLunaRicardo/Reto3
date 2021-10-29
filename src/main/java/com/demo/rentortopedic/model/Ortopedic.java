package com.demo.rentortopedic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;//<rule ref="category/java/bestpractices.xml/UnusedImports" />
import java.io.Serializable;
import java.util.List;

/**
 *
 *
 * @author Patricia Munevar
 */
@Entity
@Table(name = "ortopedic")
/**
 *
 *
 * Clase publica
 */
public class Ortopedic implements Serializable {


    /**
     *
     *
     * Metodo para generar valores de la tabla
     */
    @Id
    /**
     *
     *
     * anotacion para ignorar
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)// anotacion llave primaria autoincrementable
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    /**
     *
     *
     * Relacion muchos a unos category
     */
    @ManyToOne
    /**
     *
     *
     * anotacion para unir las columnas
     */
    @JoinColumn(name = "idCategory")
    /**
     *
     *
     * anotacion para ignorar
     */
    @JsonIgnoreProperties("ortopedics")
    private Category category;

    /**
     *
     *
     * Relacion muchos a unos
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ortopedic")
    /**
     *
     *
     * anotacion para ignorar
     */
    @JsonIgnoreProperties({"ortopedic","client"})//ignorar ortopetic, client
    private List<Message> messages;
    /**
     *
     *
     * Relacion muchos a unos
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ortopedic")
    /**
     *
     *
     * anotacion para ignorar
     */
    @JsonIgnoreProperties({"ortopedic","messages"})//ignorar ortopedic, messages
    public List<Reservation> reservations;
    /**
     *
     *
     * Getters and setters
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
