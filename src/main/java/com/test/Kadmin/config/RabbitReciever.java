package com.test.Kadmin.config;

import com.test.Kadmin.entities.NotificationEntity;
import com.test.Kadmin.entities.OngoingTransactions;
import com.test.Kadmin.entities.UserEntity;
import com.test.Kadmin.jpaRepos.OngoingTransactionsRepo;
import com.test.Kadmin.jpaRepos.UserRepo;
import com.test.Kadmin.services.OneTimeCodeGen;
import com.test.Kadmin.services.SendNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class RabbitReciever {

    @Autowired
    SendNotificationService notificationservice;
    @Autowired
    UserRepo userRepo;
    @Autowired
    OngoingTransactionsRepo ongoingTransactionsRepo;
    @Autowired
    OneTimeCodeGen oneTimeCodeGen;

    @Bean
    public Consumer<String> recieve() {

        return data -> {
            UserEntity userEntity = userRepo.findUserEntityByIdentityCardNumber(data);
            String code = oneTimeCodeGen.generateCode();
            NotificationEntity notification = new NotificationEntity(userEntity.getToken(), "Code de confirmation de votre transaction :", code,
                    "high");
            notificationservice.SendNotification(notification);
            ongoingTransactionsRepo
                    .save(OngoingTransactions.builder().identityCardNumber(userEntity.getIdentityCardNumber()).oneTimeCode(code).build());
        };
        //System.out.println("Data received..." + data);
    }

}
