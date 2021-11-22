package com.example.springboot03_demo.domain;


//lombok 一个Java库，提供了一组注解，简化POJO实体类的开发，使用的时候先在pom文件里面导入lombok
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *         <dependency>
 *             <groupId>org.projectlombok</groupId>
 *             <artifactId>lombok</artifactId>
 *         </dependency>
 */
@Data
@NoArgsConstructor
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;

}
