package com.wat.zpm.rest.address;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(AddressController.ENDPOINT)
public class AddressController {
    static final String ENDPOINT = "/address";

}
