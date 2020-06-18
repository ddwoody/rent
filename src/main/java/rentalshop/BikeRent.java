package rentalshop;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="BikeRent_table")
public class BikeRent {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String borrowerName;
    private String cardNo;
    private String bikeName;
    private Long useAmount;
    private Long bikeId;
    private Long paymentId;
    private String status;

    @PostPersist
    public void onPostPersist(){
        BikeRented bikeRented = new BikeRented();
        BeanUtils.copyProperties(this, bikeRented);
        bikeRented.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        if(this.status.equals("RETURNED")) {
            BikeReturned bikeReturned = new BikeReturned();
            BeanUtils.copyProperties(this, bikeReturned);
            bikeReturned.publishAfterCommit();
        }

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }
    public Long getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(Long useAmount) {
        this.useAmount = useAmount;
    }
    public Long getBikeId() {
        return bikeId;
    }

    public void setBikeId(Long bikeId) {
        this.bikeId = bikeId;
    }
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
