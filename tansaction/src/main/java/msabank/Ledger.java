package msabank;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Ledger_table")
public class Ledger {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long accountNo;
    private String transactionType;
    private Double amount;
    private Date transactionTime;

    @PrePersist
    public void onPrePersist(){
        DepositRequested depositRequested = new DepositRequested();
        BeanUtils.copyProperties(this, depositRequested);
        depositRequested.publishAfterCommit();


        WithdrawRequested withdrawRequested = new WithdrawRequested();
        BeanUtils.copyProperties(this, withdrawRequested);
        withdrawRequested.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }




}
