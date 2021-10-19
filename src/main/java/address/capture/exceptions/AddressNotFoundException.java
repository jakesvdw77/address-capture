package address.capture.exceptions;

public class AddressNotFoundException extends RuntimeException {
    private final int addressId;

    public AddressNotFoundException(int addressId) {
        this.addressId = addressId;
    }

    public int getAddressId() {
        return addressId;
    }
}
