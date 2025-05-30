package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.ContactSubmissionDTO;
import com.shop.freshcart.entities.ContactSubmissions;
import java.time.Instant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-30T16:28:35+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public ContactSubmissions toEntity(ContactSubmissionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ContactSubmissions contactSubmissions = new ContactSubmissions();

        contactSubmissions.setName( dto.getName() );
        contactSubmissions.setEmail( dto.getEmail() );
        contactSubmissions.setMessage( dto.getMessage() );
        contactSubmissions.setCreatedAt( dto.getCreatedAt() );

        return contactSubmissions;
    }

    @Override
    public ContactSubmissionDTO toDto(ContactSubmissions entity) {
        if ( entity == null ) {
            return null;
        }

        String name = null;
        String email = null;
        String message = null;
        Instant createdAt = null;

        name = entity.getName();
        email = entity.getEmail();
        message = entity.getMessage();
        createdAt = entity.getCreatedAt();

        ContactSubmissionDTO contactSubmissionDTO = new ContactSubmissionDTO( name, email, message, createdAt );

        return contactSubmissionDTO;
    }
}
