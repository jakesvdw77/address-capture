package address.capture.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @Column(name = "address_id")
    private int addressId;

    private String line1;

    private String line2;

    private String city;

//
//    @OneToOne(mappedBy = "")
//    private Province province;
//
//    @OneToOne(mappedBy = "")
//    private Country country;

}
