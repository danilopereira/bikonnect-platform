package br.com.bikonect.config;

import br.com.bikonect.dao.bike.repository.BikeRepository;
import br.com.bikonect.dao.bike.repository.BikeRepositoryService;
import br.com.bikonect.dao.bike.repository.BikeRepositoryServiceImpl;
import br.com.bikonect.dao.documentType.repository.DocumentTypeRepository;
import br.com.bikonect.dao.documentType.repository.DocumentTypeRepositoryService;
import br.com.bikonect.dao.documentType.repository.DocumentTypeRepositoryServiceImpl;
import br.com.bikonect.dao.rider.repository.RiderRepository;
import br.com.bikonect.dao.rider.repository.RiderRepositoryService;
import br.com.bikonect.dao.rider.repository.RiderRepositoryServiceImpl;
import br.com.bikonect.entities.Bike;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by danilopereira on 24/07/17.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"br.com.bikonect.dao"})
@EntityScan(basePackages = {"br.com.bikonect.entities"})
public class DaoConfig {

    @Bean
    RiderRepositoryService riderRepositoryService(RiderRepository riderRepository){
        return new RiderRepositoryServiceImpl(riderRepository);
    }

    @Bean
    DocumentTypeRepositoryService documentTypeRepositoryService(DocumentTypeRepository documentTypeRepository){
        return new DocumentTypeRepositoryServiceImpl(documentTypeRepository);
    }

    @Bean
    BikeRepositoryService bikeRepositoryService(BikeRepository bikeRepository){
        return new BikeRepositoryServiceImpl(bikeRepository);
    }
}
