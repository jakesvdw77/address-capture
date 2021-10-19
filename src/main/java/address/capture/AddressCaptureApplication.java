package address.capture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "address.capture")

public class AddressCaptureApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressCaptureApplication.class, args);
    }


}
