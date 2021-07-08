package com.example.serch.serviceimpl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.serch.mapper.Mapper;
import com.example.serch.pojo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author 亦梦里 亦书予
 * @version 1.0
 * @date 2021/7/7 10:01
 */
@Service
public class Inserviceimpl {
    @Autowired
    private Mapper mapper;

    //读取json文件
    public JSONArray readJsonFile(String fileName) {

        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8);
            int ch = 0;
            StringBuilder sb = new StringBuilder();

            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }


            JSONObject root = JSON.parseObject(sb.toString());
            JSONArray records = root.getJSONArray("RECORDS");

            List<Bean> beanList = JSON.parseArray(records.toJSONString(), Bean.class);
         return mapper.Saveadd(beanList);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


