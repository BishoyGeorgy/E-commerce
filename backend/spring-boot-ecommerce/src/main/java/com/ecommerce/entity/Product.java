package com.ecommerce.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author @Bishoy
 * @version 1.0
 * @date 08/04/2021
 */
@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "sku", nullable = false, length = 255)
    private String sku;
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Column(name = "unit_price", nullable = true, precision = 2)
    private BigDecimal unitPrice;
    @Column(name = "image_url", nullable = true, length = 255)
    private String imageUrl;
    @Column(name = "active", nullable = true)
    private Boolean active;
    @Column(name = "units_in_stock", nullable = true)
    private Integer unitsInStock;
    @Column(name = "date_created", nullable = true)
    @CreationTimestamp
    private Timestamp dateCreated;
    @Column(name = "last_updated", nullable = false)
    @UpdateTimestamp
    private Timestamp lastUpdated;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category categoryByCategoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (sku != null ? !sku.equals(product.sku) : product.sku != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (unitPrice != null ? !unitPrice.equals(product.unitPrice) : product.unitPrice != null) return false;
        if (imageUrl != null ? !imageUrl.equals(product.imageUrl) : product.imageUrl != null) return false;
        if (active != null ? !active.equals(product.active) : product.active != null) return false;
        if (unitsInStock != null ? !unitsInStock.equals(product.unitsInStock) : product.unitsInStock != null)
            return false;
        if (dateCreated != null ? !dateCreated.equals(product.dateCreated) : product.dateCreated != null) return false;
        if (lastUpdated != null ? !lastUpdated.equals(product.lastUpdated) : product.lastUpdated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (unitsInStock != null ? unitsInStock.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        return result;
    }
}
