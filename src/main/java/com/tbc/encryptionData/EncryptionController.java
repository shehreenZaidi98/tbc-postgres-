package com.tbc.encryptionData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class EncryptionController {
@Autowired
EncryptionRepository encryptionRepository;
@PostMapping("/create")
    public String create(@RequestBody EncryptionData encryptionData){
    encryptionRepository.save(encryptionData);
    return  "Save";

}
    @GetMapping("getEncrypted")
    public List<EncryptionData> getAllData(){
    return encryptionRepository.findAll();
    }


}
