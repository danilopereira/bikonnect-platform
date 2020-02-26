package br.com.bikonnect.configuration;

import br.com.bikonnect.dao.locker.repository.LockerRepository;
import br.com.bikonnect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonnect.dao.locker.repository.LockerRepositoryServiceImpl;
import br.com.bikonnect.handler.MqttHandler;
import br.com.bikonnect.subscriber.MqttSubscriber;
import br.com.bikonnect.subscriber.MqttSubscriberImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by danilopereira on 26/08/17.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"br.com.bikonnect.dao"})
@EntityScan(basePackages = {"br.com.bikonnect.entities"})
public class MQTTSubscriberConfig {

    @Value("${mqtt.broker.url}")
    private String mqttBrokerUrl;

    @Value("${mqtt.topic}")
    private String mqttTopic;

    @Value("${mqtt.user}")
    private String user;

    @Value("${mqtt.password}")
    private String password;

    @Value("${worker.thread.poll.core.size}")
    private Integer workerThreadPoolCoreSize;

    @Value("${worker.thread.poll.max.size}")
    private Integer workerThreadPoolMaxSize;

    @Bean
    public LockerRepositoryService lockerRepositoryService(LockerRepository lockerRepository){
        return new LockerRepositoryServiceImpl(lockerRepository);
    }

    @Bean
    public MqttSubscriber subscriber(LockerRepositoryService lockerRepositoryService){
        return new MqttSubscriberImpl(mqttBrokerUrl, mqttTopic, lockerRepositoryService, user, password);
    }

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(workerThreadPoolCoreSize);
        pool.setMaxPoolSize(workerThreadPoolMaxSize);
        pool.setWaitForTasksToCompleteOnShutdown(true);
        return pool;
    }

    @Bean
    public MqttHandler mqttHandler(){
        return new MqttHandler();
    }


}
