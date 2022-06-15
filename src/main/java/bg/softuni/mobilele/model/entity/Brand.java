package bg.softuni.mobilele.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{

    @Column(nullable = false)
    private String name;
    @OneToMany(
            mappedBy = "brand",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    private List<Model> models;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                ", models=" + models +
                '}';
    }
}
