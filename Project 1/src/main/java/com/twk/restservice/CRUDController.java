package com.twk.restservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CRUDController {


    @RequestMapping("/read")
    public CRUD CRUD(@RequestParam(value="business_name") String name) {
        DocData doc = new DocData();
        
        return new CRUD(doc.toString());
    }

}
