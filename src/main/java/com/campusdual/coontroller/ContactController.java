package com.campusdual.coontroller;

import com.campusdual.api.IContactService;
import com.campusdual.model.dto.ContactDto;
import com.campusdual.model.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    IContactService contactService;
    @GetMapping("/test")
    public String testController() {
        return "no quedan aceitunas";
    }
    @PostMapping("/get")
    public ContactDto queryContact(@RequestBody ContactDto contactDto){
        return contactService.queryContact(contactDto);
    }
    @GetMapping("/getAll")
    public List<ContactDto> queryAllContact() {
        return contactService.queryAllContacts();
    }

    @PostMapping("/add")
    public int addContact(@RequestBody ContactDto contactDto) {
        return contactService.insertContact(contactDto);
    }

    @PutMapping("/update")
    public int updateContact(@RequestBody ContactDto contactDto) {
        return contactService.updateContact((contactDto));
    }

    @DeleteMapping("/delete")
    public int deleteContact(@RequestBody ContactDto contactDto) {
        return contactService.deleteContact(contactDto);
    }



}
