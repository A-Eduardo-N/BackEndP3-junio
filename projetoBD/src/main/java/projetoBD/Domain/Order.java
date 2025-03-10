package projetoBD.Domain;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private OrderStatus status;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;
/*
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();
*/


}