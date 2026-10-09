import jakarta.persistence.*;

@Entity
@Table(name = "fixed_deposits")
public class FixedDeposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fdId;

    @ManyToOne
    @JoinColumn(name = "account_number", referencedColumnName = "accountNumber")
    private Customer customer;

    private Double amount;
    private Double interestRate;
    private Integer tenureMonths;
    private Double maturityAmount;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    // getters & setters
}
