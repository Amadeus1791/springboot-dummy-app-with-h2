package com.codersbay.depoloymentReplit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class DemoApplication implements CommandLineRunner {

    @Value("${server.port:8080}")
    private String serverPort;

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "🎉 Willkommen zur Spring Boot Demo!");
        response.put("timestamp", LocalDateTime.now());
        response.put("port", serverPort);
        response.put("status", "running");
        return response;
    }

    @GetMapping("/hello")
    public Map<String, String> hello(@RequestParam(defaultValue = "World") String name) {
        Map<String, String> response = new HashMap<>();
        response.put("greeting", "Hallo " + name + "!");
        response.put("message", "Diese Anwendung läuft auf Replit 🚀");
        return response;
    }

    @GetMapping("/info")
    public Map<String, Object> info() {
        Map<String, Object> info = new HashMap<>();
        info.put("application", "Spring Boot Demo");
        info.put("version", "1.0.0");
        info.put("java.version", System.getProperty("java.version"));
        info.put("os.name", System.getProperty("os.name"));
        info.put("spring.profiles.active", System.getProperty("spring.profiles.active", "default"));
        return info;
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student("test", "a", 20);
        studentRepository.save(student);
        System.out.println(student);
    }
}

