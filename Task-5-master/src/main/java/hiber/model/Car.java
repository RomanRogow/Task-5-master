package hiber.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @OneToOne(mappedBy = "car")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private User user;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return  " model= '" + model + '\'' +
                ", series= " + series;
    }
}
