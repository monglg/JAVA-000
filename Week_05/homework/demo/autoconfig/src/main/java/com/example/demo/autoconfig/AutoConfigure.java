package com.example.demo.autoconfig;

import com.example.demo.autoconfig.properties.Properties;
import com.example.demo.core.Klass;
import com.example.demo.core.School;
import com.example.demo.core.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ConditionalOnClass({Student.class })
@EnableConfigurationProperties(Properties.class)
public class AutoConfigure {

    private Properties properties;

    public AutoConfigure(Properties properties) {
        this.properties = properties;
    }

    @Bean
    public Student getStudent(){
        Student student = new Student();
        student.setId(properties.getId());
        student.setName(properties.getName());
        return student;
    }

    @Bean
    @ConditionalOnMissingBean
    public Klass getKlass(Student student){
        Klass klass = new Klass();
        klass.setStudents(Arrays.asList(student));
        return klass;
    }

    @Bean
    @ConditionalOnMissingBean
    public School getSchool(Student student, Klass klass){
        School school = new School();
        school.setClass1(klass);
        school.setStudent100(student);
        klass.setStudents(Arrays.asList(student));
        return school;
    }

}
