package br.com.bikonnect.dao.documentType.repository;

import br.com.bikonnect.entities.DocumentType;

/**
 * Created by danilopereira on 22/07/17.
 */
public class DocumentTypeRepositoryServiceImpl implements DocumentTypeRepositoryService {

    private DocumentTypeRepository documentTypeRepository;

    public DocumentTypeRepositoryServiceImpl(DocumentTypeRepository documentTypeRepository){
        this.documentTypeRepository = documentTypeRepository;
    }

    @Override
    public DocumentType findByName(String name) {
        return documentTypeRepository.findByName(name);
    }
}
