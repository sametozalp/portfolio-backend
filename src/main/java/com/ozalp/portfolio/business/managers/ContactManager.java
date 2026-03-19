package com.ozalp.portfolio.business.managers;

import com.ozalp.portfolio.business.dtos.requests.MailContactRequest;
import com.ozalp.portfolio.business.dtos.requests.create.CreateContactRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateContactRequest;
import com.ozalp.portfolio.business.dtos.responses.ContactResponse;
import com.ozalp.portfolio.business.exeptions.errors.DataAlreadyExist;
import com.ozalp.portfolio.business.mappers.ContactMapper;
import com.ozalp.portfolio.business.services.ContactService;
import com.ozalp.portfolio.dataAccess.ContactRepository;
import com.ozalp.portfolio.entities.Contact;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactManager implements ContactService {

    @Value("${GMAIL_SENT_TO}")
    private String mailSentTo;

    @Value("${GMAIL_EMAIL}")
    private String mailFrom;

    private final ContactRepository repository;
    private final ContactMapper mapper;
    private final JavaMailSender mailSender;

    @Override
    public void add(CreateContactRequest createContactRequest) {
        if (!repository.findAll().isEmpty()) {
            throw new DataAlreadyExist();
        }
        repository.save(mapper.toEntity(createContactRequest));
    }

    @Override
    public void delete(int id) {
        var entity = findById(id);
        entity.markAsDeleted();
        repository.save(entity);

    }

    @Override
    public void setShowable(int id, Boolean value) {
        Contact contact = findById(id);
        contact.setShowable(value);
        repository.save(contact);
    }

    @Override
    public Contact findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }

    @Override
    public ContactResponse getContact() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(int id, UpdateContactRequest request) {
        var entity = findById(id);
        mapper.updateEntity(request, entity);
        repository.save(entity);
    }

    @Override
    public void send(MailContactRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailFrom);
        message.setTo(mailSentTo);
        message.setSubject("Portfolyo Mesajı -> Kimden: " + request.getName().trim());
        message.setText(request.getMessage().trim() + "\n\n" + "Kişi mail: " + request.getEmail().trim() + "\nPortfolyo sitesinden...");
        mailSender.send(message);
    }
}
