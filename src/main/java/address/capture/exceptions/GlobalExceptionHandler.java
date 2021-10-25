package address.capture.exceptions;

import address.capture.models.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(AddressNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ResponseEntity<Object> handleAddressNotFoundException(
            AddressNotFoundException exception) {

        var error = String.format("Address %s not found", exception.getAddressId());

        Set<String> result = new HashSet<>();
        result.add(error);

        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        responseDTO.setErrors(result);
        log.error(error);


        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(responseDTO);

    }

    @ExceptionHandler(ProvinceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ResponseEntity<Object> handleProvinceNotFoundException(
            ProvinceNotFoundException exception) {

        var error = String.format("Province %s not found for country code %s ", exception.getProvinceCode(), exception.getCountryCode());

        Set<String> result = new HashSet<>();
        result.add(error);

        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        responseDTO.setErrors(result);
        log.error(error);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(responseDTO);

    }


    @ExceptionHandler(CountryNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ResponseEntity<Object> handleProvinceNotFoundException(
            CountryNotFoundException exception) {

        var error = String.format("Country %s not found ", exception.getCountryCode());


        Set<String> result = new HashSet<>();
        result.add(error);

        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        responseDTO.setErrors(result);

        log.error(error);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(responseDTO);

    }


}
