import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    private String name;
    private LocalDate dob;
    private String address;
    private String idProof;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING; // PENDING / APPROVED

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    // getters & setters
}