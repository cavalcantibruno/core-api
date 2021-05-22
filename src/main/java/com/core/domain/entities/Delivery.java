package com.core.domain.entities;

import com.core.domain.enums.StatusDelivery;
import com.core.domain.exception.DomainException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrences> occurrences = new ArrayList<>();
    @Embedded
    private Recipient recipient;
    private BigDecimal rate;
    @Enumerated(EnumType.STRING)
    private StatusDelivery statusDelivery;
    private OffsetDateTime dateOrder;
    private OffsetDateTime dateDelivered;

    public Occurrences addOccurrences(String description) {
        Occurrences occurrences = new Occurrences();
        occurrences.setDescription(description);
        occurrences.setDateRegistration(OffsetDateTime.now());
        occurrences.setDelivery(this);
        this.getOccurrences().add(occurrences);
        return occurrences;
    }

    public void checkout() {
        if(statusCenceled()) { throw new DomainException("Entrega não pode ser finalizada, pois esta CANCELADA"); }
        else if (statusDelivered()) { throw new DomainException("Entrega não pode ser finalizada, pois esta FINALIZADA"); }
        else {
            setStatusDelivery(StatusDelivery.DELIVERED);
            setDateDelivered(OffsetDateTime.now());
        }
    }

    public boolean statusCenceled() {
        return StatusDelivery.CANCELED.equals(getStatusDelivery());
    }

    public boolean statusDelivered() {
        return StatusDelivery.DELIVERED.equals(getStatusDelivery());
    }
}
