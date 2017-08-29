package br.com.bikonect.config;

import br.com.bikonect.br.com.bikonect.rider.business.RiderBusiness;
import br.com.bikonect.br.com.bikonect.rider.business.RiderBusinessImpl;
import br.com.bikonect.dao.documentType.repository.DocumentTypeRepositoryService;
import br.com.bikonect.dao.rider.repository.RiderRepositoryService;
import br.com.bikonect.rider.service.RiderService;
import br.com.bikonect.rider.service.RiderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by danilopereira on 24/07/17.
 */
@Configuration
public class RiderConfig {

    @Bean
    RiderBusiness riderBusiness(RiderService riderService){
        return new RiderBusinessImpl(riderService);
    }

    @Bean
    RiderService riderService(RiderRepositoryService riderRepositoryService,
                              DocumentTypeRepositoryService documentTypeRepositoryService){
        return new RiderServiceImpl(riderRepositoryService, documentTypeRepositoryService);
    }
}
