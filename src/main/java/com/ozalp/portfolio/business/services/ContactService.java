package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.business.dtos.requests.MailContactRequest;
import com.ozalp.portfolio.business.dtos.requests.create.CreateContactRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateContactRequest;
import com.ozalp.portfolio.business.dtos.responses.ContactResponse;
import com.ozalp.portfolio.entities.Contact;

public interface ContactService extends BaseService<Contact> {

    ContactResponse getContact();
    void update(int id, UpdateContactRequest request);

    void send(MailContactRequest request);

    void add(CreateContactRequest createContactRequest);
}
