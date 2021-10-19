package address.capture.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddressNotFoundException extends RuntimeException {
    private final int addressId;

}
