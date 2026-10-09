import jakarta.persistence.*;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "account_number", referencedColumnName = "accountNumber")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private LoanType loanType; // FLAT / REDUCING

    private Double principal;
    private Double interestRate;
    private Integer tenureMonths;

    @Enumerated(EnumType.STRING)
    private LoanStatus status = LoanStatus.PENDING;

    @Lob
    private String emiSchedule; // JSON string

    // getters & setters
    public enum LoanType {
        FLAT, REDUCING
    }

    public enum LoanStatus {
        PENDING, APPROVED, DISBURSED, CLOSED
    }

}
