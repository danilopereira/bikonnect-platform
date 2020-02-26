package br.com.bikonnect.config;

import br.com.bikonnect.rider.business.RiderBusiness;
import br.com.bikonnect.rider.business.RiderBusinessImpl;
import br.com.bikonnect.dao.documentType.repository.DocumentTypeRepositoryService;
import br.com.bikonnect.dao.rider.repository.RiderRepositoryService;
import br.com.bikonnect.rider.service.RiderService;
import br.com.bikonnect.rider.service.RiderServiceImpl;
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
