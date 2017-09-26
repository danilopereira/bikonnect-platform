package br.com.bikonect.locker.config;

import br.com.bikonect.dao.locker.repository.LockerRepository;
import br.com.bikonect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonect.dao.locker.repository.LockerRepositoryServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by danilopereira on 23/09/17.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"br.com.bikonect.dao"})
@EntityScan(basePackages = {"br.com.bikonect.entities"})
public class DaoConfig {

    @Bean
    public LockerRepositoryService lockerRepositoryService(LockerRepository lockerRepository){
        return new LockerRepositoryServiceImpl(lockerRepository);
    }

}
