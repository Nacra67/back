package com.campusdual.api;



import com.campusdual.model.dto.ContactDto;

import java.util.List;

public interface IContactService {
    ContactDto queryContact(ContactDto contactDto);
    List<ContactDto> queryAllContacts();
    int insertContact(ContactDto contactDto);
    int updateContact(ContactDto contactDto);
    int deleteContact(ContactDto contactDto);
}
