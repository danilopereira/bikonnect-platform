package br.com.bikonect.locker.config;

import br.com.bikonect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonect.locker.business.LockerBusiness;
import br.com.bikonect.locker.business.LockerBusinessImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by danilopereira on 23/09/17.
 */
@Configuration
public class LockerConfig {

    @Bean
    public LockerBusiness lockerBusiness(LockerRepositoryService lockerRepositoryService){
        return new LockerBusinessImpl(lockerRepositoryService);
    }
}
