package com.springapi.rest_demo.controller;

import com.springapi.rest_demo.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {

    CloudVendor cloudVendor;

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable String vendorId) {

        if (cloudVendor == null) {
            cloudVendor = new CloudVendor("C1", "Vendor 1",
                    "Address One", "xxxxx");
        }
        return cloudVendor;
    }

    @PostMapping("{vendorId}")
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        this.cloudVendor = cloudVendor;
        return "Success";
    }
}
