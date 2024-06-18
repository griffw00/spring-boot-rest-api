package com.springapi.rest_demo.controller;

import com.springapi.rest_demo.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {

    // Dictionary for vendors
    private Map<String, CloudVendor> cloudVendors = new HashMap<>();;

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable String vendorId) throws Exception {


        if (cloudVendors.get(vendorId) != null) {
            return cloudVendors.get(vendorId);
        } else {
            // Vendor not in dictionary
            throw new Exception("Vendor not found");
        }
    }

    @PostMapping("{vendorId}")
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        CloudVendor cv = new CloudVendor(cloudVendor.getVendorId(),
                cloudVendor.getVendorName(),
                cloudVendor.getVendorAddress(),
                cloudVendor.getVendorPhoneNumber());
        cloudVendors.put(cloudVendor.getVendorId(), cv);
        return "Cloud Vendor Added";
    }

    @PutMapping("{vendorId}")
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        if (cloudVendors.get(cloudVendor.getVendorId()) != null) {
            cloudVendors.put(cloudVendor.getVendorId(), cloudVendor);
            return "Vendor Updated";
        } else {
            return "Vendor Does Not Exist";
        }
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        if (cloudVendors.get(cloudVendor.getVendorId()) != null) {
            cloudVendors.remove(cloudVendor.getVendorId());
            return "Vendor Removed";
        } else {
            return "Vendor Does Not Exist";
        }
    }

}
