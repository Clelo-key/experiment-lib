package org.example.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Fly
 * @CreateTime: 2024-11-19
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
}
