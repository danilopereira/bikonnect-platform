package br.com.bikonnect.locker.config;

import br.com.bikonnect.dao.locker.repository.LockerRepository;
import br.com.bikonnect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonnect.dao.locker.repository.LockerRepositoryServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by danilopereira on 23/09/17.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"br.com.bikonnect.dao"})
@EntityScan(basePackages = {"br.com.bikonnect.entities"})
public class DaoConfig {

    @Bean
    public LockerRepositoryService lockerRepositoryService(LockerRepository lockerRepository){
        return new LockerRepositoryServiceImpl(lockerRepository);
    }

}
