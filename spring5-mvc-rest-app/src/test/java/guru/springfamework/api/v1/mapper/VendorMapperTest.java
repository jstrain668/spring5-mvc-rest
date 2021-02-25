package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Vendor;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class VendorMapperTest {

    public static final String VENDOR_NAME = "Acme";
    public static final long ID = 1L;

    VendorMapper vendorMapper = VendorMapper.INSTANCE;

    @Test
    public void vendorDtoToVendor() {

        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(VENDOR_NAME);
        vendorDTO.setVendorUrl("/api/v1/shop/vendors/1");

        //when
        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);

        //then
        assertEquals(VENDOR_NAME, vendor.getName());
    }

    @Test
    public void vendorToVendorDto() {

        //given
        Vendor vendor = new Vendor();
        vendor.setName(VENDOR_NAME);
        vendor.setId(ID);

        //when
        VendorDTO vendorDTO = vendorMapper.vendorToVendorDto(vendor);

        //then
        assertEquals(VENDOR_NAME, vendorDTO.getName());

    }
}