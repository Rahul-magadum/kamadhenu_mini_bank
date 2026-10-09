import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long txnId;

    @ManyToOne
    @JoinColumn(name = "account_number", referencedColumnName = "accountNumber")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private TransactionType txnType; // DEPOSIT / WITHDRAWAL

    private Double amount;
    private Double balanceAfter;

    private LocalDateTime txnDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    // getters & setters
    public enum TransactionType {
        DEPOSIT, WITHDRAWAL
    }
}
