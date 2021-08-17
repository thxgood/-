package com.example.serch.service;

import java.io.IOException;

/**
 * @author 亦梦里 亦书予
 * @version 1.0
 * @date 2021/7/7 10:01
 */
public interface Inservice {
    int readJsonFile(String fileName);
    boolean getData();

    boolean elasticsearch() throws IOException;

    boolean CreateIndex() throws IOException;

    boolean create() throws IOException;

    boolean search() throws IOException;
}
