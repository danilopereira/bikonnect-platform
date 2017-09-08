package br.com.bikonect.dao.documentType.repository;

import br.com.bikonect.entities.DocumentType;

/**
 * Created by danilopereira on 22/07/17.
 */
public interface DocumentTypeRepositoryService {

    DocumentType findByName(String name);
}
