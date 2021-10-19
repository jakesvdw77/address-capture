package address.capture.controllers;


import address.capture.models.Country;
import address.capture.models.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Country REST Api Controller")
@RequestMapping(path = "/country", produces = "application/json")
public interface CountryControllerInterface {

    @Operation(description = "List Countries alphabetically")
    @GetMapping("/list")
    ResponseEntity<ResponseDTO<List<Country>>> listCountries(@RequestParam(name = "sort", required = false, defaultValue = "asc") String sort);
}
