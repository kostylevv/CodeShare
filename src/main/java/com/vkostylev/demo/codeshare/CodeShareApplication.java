package com.vkostylev.demo.codeshare;

import com.vkostylev.demo.codeshare.model.Treadmill;
import com.vkostylev.demo.codeshare.repository.TreadmillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Optional;

@SpringBootApplication
public class CodeShareApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeShareApplication.class, args);
    }

    @Component
    public class Runner implements CommandLineRunner {
        private final TreadmillRepository repository;

        public Runner(TreadmillRepository repository) {
            this.repository = repository;
        }

        @Override
        public void run(String... args) {
            // work with the repository here
            System.out.println("Before save:");
            doWeHaveSomethingInDb();

            System.out.println("Saving...");
            repository.save(new Treadmill("aaa", "Yamaguchi runway"));

            System.out.println("After save:");
            doWeHaveSomethingInDb();
        }

        private void doWeHaveSomethingInDb() {
            long count = repository.count();
            if (count > 0) {
                System.out.printf("Db has %d treadmill(s)%n", count);
            } else {
                System.out.println("Db is empty");
            }

            System.out.println("Looking for the treadmill with code='bbb'... ");
            Optional<Treadmill> treadmill = repository.findById("bbb");
            String result = treadmill.map(this::createTreadmillView).orElse("Not found");
            System.out.println(result);

            System.out.println("Looking for the treadmill with code='non-existing-code'... ");
            treadmill = repository.findById("non-existing-code");
            result = treadmill.map(this::createTreadmillView).orElse("Not found");
            System.out.println(result);
        }

        private String createTreadmillView(Treadmill treadmill) {
            return "Treadmill(code: %s, model: %s)"
                    .formatted(treadmill.getCode(), treadmill.getModel());
        }
    }
}
