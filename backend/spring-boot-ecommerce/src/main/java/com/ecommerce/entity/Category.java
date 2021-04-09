package com.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 *
 * @author <a href="bishoy.georgy@incorta.com">Bishoy Georgy</a>
 * @version 1.0
 * @date 08/04/2021
 */
@Entity
@Table(name = "category")
@Setter
@Getter
public class Category {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryByCategoryId")
    private Set<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
