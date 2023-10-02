package com.campusdual.service;

import com.campusdual.api.IContactService;
import com.campusdual.model.Contact;
import com.campusdual.model.dao.ContactDao;
import com.campusdual.model.dto.ContactDto;
import com.campusdual.model.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ContactService")
@Lazy
public class ContactService implements IContactService {
    @Autowired
    private ContactDao contactDao;

    @Override
    public ContactDto queryContact(ContactDto contactDto) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDto);
        Contact contactResult = contactDao.getReferenceById(contact.getId());
        ContactDto resultado = ContactMapper.INSTANCE.toDto(contactResult);
        return resultado;
    }

    @Override
    public List<ContactDto> queryAllContacts() {
        List<Contact> contactList = contactDao.findAll();
        List<ContactDto> result = ContactMapper.INSTANCE.toDtoList(contactList);
        return result;
    }

    @Override
    public int insertContact(ContactDto contactDto) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDto);
        contactDao.saveAndFlush(contact);
        return contact.getId();
    }

    @Override
    public int updateContact(ContactDto contactDto) {

        return insertContact(contactDto);
    }

    @Override
    public int deleteContact(ContactDto contactDto) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDto);
        contactDao.delete(contact);
        return contactDto.getId();
    }
}
