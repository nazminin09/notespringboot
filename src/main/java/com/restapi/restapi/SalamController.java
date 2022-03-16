package com.restapi.restapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalamController {

    @RequestMapping("/testing")
    public String getSalam(){
        return "Assalamualaikum salamat petang semua saya nazmi";
    }


}
