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

/**
 * @author 亦梦里 亦书予
 * @version 1.0
 * @date 2021/7/7 10:01
 */
@Service
public class Inserviceimpl {
    @Autowired
    private Mapper mapper;

    public String in() {
        return null;
    }

    //读取json文件
    public String readJsonFile(String fileName) {
//        String jsonStr = "";
//        try {
//            File jsonFile = new File(fileName);
//            FileReader fileReader = new FileReader(jsonFile);
//            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8);
//            int ch = 0;
//            StringBuilder sb = new StringBuilder();
//            while ((ch = reader.read()) != -1) {
//                sb.append((char) ch);
//            }
//            fileReader.close();
//            reader.close();
//            jsonStr = sb.toString();
//            Bean bean= JSON.parseObject(jsonStr,Bean.class);
//            System.out.println(bean);
//            return bean;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;

//        try {
//            FileInputStream fis = new FileInputStream(fileName);
//            //Construct BufferedReader from InputStreamReader
//            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//        return line;
//        }
//            catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8);
            int ch = 0;
            StringBuilder sb = new StringBuilder();

            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
//            JSONObject jobj =JSON.parseObject(String.valueOf(sb));
//            JSONArray movies = jobj.getJSONArray("RECORDS");//构建JSONArray数组
//            for (int i = 0 ; i < movies.size();i++){
//                JSONObject key = (JSONObject)movies.get(i);
//                String id = (String)key.get("_id");
//                String sourceStie = (String)key.get("来源网站");
//                String internetSite=((String)key.get("网址"));
//                String classification=((String)key.get("分类"));
//                String financialClassification=((String)key.get("金融分类"));
//                String downloadDate=((String)key.get("下载日期"));
//                String releaseDate=((String)key.get("发布日期"));
//                String title=((String)key.get("标题"));
//                String transfrFrom=((String)key.get("转自"));
//                String originalTttle=((String)key.get("原标题"));
//                String editingReporter=((String)key.get("编辑记者"));
//                String orignalWebsiteLink=((String)key.get("原网站链接"));
//                String extrainfo=((String)key.get("extra-info"));
//                String summary=((String)key.get("摘要"));
//                String textContent=((String)key.get("文本内容"));
//                String webPageSourceCode=((String)key.get("网页源码"));
//                System.out.println(id);
//                System.out.println(sourceStie);
//                System.out.println(internetSite);
//                System.out.println(classification);
//                System.out.println(financialClassification);
//                System.out.println(downloadDate);
//                System.out.println(releaseDate);
//                System.out.println(title);
//                System.out.println(transfrFrom);
//                System.out.println(originalTttle);
//                System.out.println(editingReporter);
//                System.out.println(orignalWebsiteLink);
//                System.out.println(extrainfo);
//                System.out.println(summary);
//                System.out.println(textContent);
//                System.out.println(webPageSourceCode);
//            }
            JSONObject jobj =JSON.parseObject(String.valueOf(sb),Bean.class);
            JSONArray movies = jobj.getJSONArray("RECORDS");//构建JSONArray数组

                for (Object p:movies){
                    System.out.println(p);
                }

            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


