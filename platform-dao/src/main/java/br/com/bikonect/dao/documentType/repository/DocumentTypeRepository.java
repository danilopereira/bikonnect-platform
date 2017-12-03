package br.com.bikonect.dao.documentType.repository;

import br.com.bikonect.entities.DocumentType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by danilopereira on 22/07/17.
 */
public interface DocumentTypeRepository extends CrudRepository<DocumentType, Long> {

    DocumentType findByName(String name);
}
