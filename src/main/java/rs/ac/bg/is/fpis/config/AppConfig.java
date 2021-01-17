/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Milos
 */
@EnableWebMvc
@ComponentScan(basePackages="rs.ac.bg.is.fpis")
@Configuration
@Import(DatabaseConfiguration.class)
@EnableJpaRepositories(basePackages = "rs.ac.bg.is.fpis.spring.springdata.repository")
@EnableTransactionManagement
public class AppConfig {
    
}
