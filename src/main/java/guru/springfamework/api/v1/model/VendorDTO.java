package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VendorDTO {

    @ApiModelProperty(value = "This is the Vendor name", required = true)
    private String name;

    @ApiModelProperty(value = "This is the Vendor's Url", required = true)
    @JsonProperty("vendor_url")
    private String vendorUrl;
}
