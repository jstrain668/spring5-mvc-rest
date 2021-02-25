package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorListDTO;
import guru.springfamework.services.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Vendor Controller"})
@SwaggerDefinition(tags = {
        @Tag(name = "Vendor Controller", description = "This is the Vendor Controller")
})
@RestController
@RequestMapping(VendorController.BASE_URL)
public class VendorController {

    public static final String BASE_URL = "/api/v1/vendors";

    VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @ApiOperation(value = "This will get a list of al vendors.", notes = "These are some notes about the API.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getAllVendors() {

        return new VendorListDTO(vendorService.getAllVendors());
    }

    @ApiOperation(value = "This will retrieve the vendor for a vendor Id", notes = "These are some notes about the API.")
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorByID(@PathVariable Long id) {

        return vendorService.getVendorById(id);
    }

    @ApiOperation(value = "This will create a new vendor", notes = "These are some notes about the API.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO){
        return vendorService.createNewVendor(vendorDTO);
    }

    @ApiOperation(value = "This will update a vendor for a given vendor Id", notes = "These are some notes about the API.")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@PathVariable Long id,
                                      @RequestBody VendorDTO vendorDTO) {
        return vendorService.saveVendorByDTO(id, vendorDTO);
    }

    @ApiOperation(value = "This will update vendor properties for a given vendor Id.", notes = "These are some notes about the API.")
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@PathVariable Long id,
                                     @RequestBody VendorDTO vendorDTO){
        return vendorService.patchVendor(id, vendorDTO);
    }

    @ApiOperation(value = "This will delete a vendor for a given vendor Id.", notes = "These are some notes about the API.")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id){

        vendorService.deleteVendorById(id);
    }
}
