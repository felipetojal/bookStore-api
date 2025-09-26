package com.felipeMaven.BookStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_edition")
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long edition_id;

    @Column(nullable = false)
    private String publishYear;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false, unique = true)
    private String ISBN;

    @Column(nullable = false)
    private BigDecimal purchasePrice;

    @Column(nullable = false)
    private BigDecimal sellingPrice;

    @Column(nullable = false)
    private int stock;

    @OneToMany(mappedBy = "edition")
    private List<CartItem> cartItemList;

    @OneToMany(mappedBy = "edition")
    private List<OrderItem> orderItemList;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
