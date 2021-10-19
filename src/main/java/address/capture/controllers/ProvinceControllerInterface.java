package address.capture.controllers;


import address.capture.models.Province;
import address.capture.models.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Managing Province Api Controller")
@RequestMapping(path = "/province", produces = "application/json")
public interface ProvinceControllerInterface {

    @Operation(description = "Find provinces for specified country")
    @GetMapping("/list")
    ResponseEntity<ResponseDTO<List<Province>>> listProvinces(@PathVariable String countryCode);


}
