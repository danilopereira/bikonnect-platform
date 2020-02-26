package br.com.bikonnect.locker.config;

import br.com.bikonnect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonnect.locker.business.LockerBusiness;
import br.com.bikonnect.locker.business.LockerBusinessImpl;
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
