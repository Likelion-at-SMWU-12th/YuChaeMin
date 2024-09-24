package study.querydsl.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long number;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private Integer price;
//
//    @Column(nullable = false)
//    private Integer stock;
//
//    @OneToOne(mappedBy = "product")
//    @ToString.Exclude
//    ProductDetail productDetail;
//
//    @ManyToOne
//    @JoinColumn(name = "provider_id")
//    @ToString.Exclude
//    private Provider provider;
//
//    @ManyToMany
//    @ToString.Exclude
//    private List<Producer> producers = new ArrayList<>();
//
//    public void addProducer(Producer producer){
//        this.producers.add(producer);
//    }
//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
    private int stock;
//    private int popularity;

//    @Column(name = "created_at", updatable = false)
//    private LocalDateTime createdAt;
//    @PrePersist
//    protected void onCreate(){
//        createdAt = LocalDateTime.now();
//    }


    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
//        this.popularity = popularity;
    }
}
