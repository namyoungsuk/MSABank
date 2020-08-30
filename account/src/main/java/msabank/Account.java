package msabank;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Account_table")
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long accountNo;
    private String customerName;
    private Double balance;

    @PrePersist
    public void onPrePersist(){
        AccountCreated accountCreated = new AccountCreated();
        BeanUtils.copyProperties(this, accountCreated);
        accountCreated.publishAfterCommit();


        AccountDeleted accountDeleted = new AccountDeleted();
        BeanUtils.copyProperties(this, accountDeleted);
        accountDeleted.publishAfterCommit();


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
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }




}
