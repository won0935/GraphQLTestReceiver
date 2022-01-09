package com.example.graphqltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReceiverProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceiverProjectApplication.class, args);
    }

//    @Bean
//    ApplicationRunner init(LoanService loanService) {
//        return args -> {
//            Stream.of("title1", "title2", "title3", "title4", "title5", "title6")
//                    .forEach(title -> {
//                        LoanModel loan = new LoanModel();
//                        loan.setName(title);
//                        loanService.saveLoan(loan);
//                    });
//            loanService.getLoans().forEach(System.out::println);
//        };
//    }
}
