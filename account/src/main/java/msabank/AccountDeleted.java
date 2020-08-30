package msabank;

public class AccountDeleted extends AbstractEvent {

    private Long id;

    public AccountDeleted(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
