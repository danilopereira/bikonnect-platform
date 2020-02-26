package br.com.bikonnect.dao.documentType.repository;

import br.com.bikonnect.entities.DocumentType;

/**
 * Created by danilopereira on 22/07/17.
 */
public interface DocumentTypeRepositoryService {

    DocumentType findByName(String name);
}
