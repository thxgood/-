package com.example.serch.serviceimpl;


import com.example.serch.mapper.Mapper;
import com.example.serch.pojo.Bean;
import com.example.serch.service.Inservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

/**
 * @author 亦梦里 亦书予
 * @version 1.0
 * @date 2021/7/7 10:01
 */
@Service
public class Inserviceimpl {
    @Autowired
    private Mapper mapper;

    public String in(){
        return null;
    }
    //读取json文件
    public String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8);
            int ch = 0;
            StringBuilder sb = new StringBuilder();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
//        public List<Bean> getResourceTypes(ResourceTypeQo resourceTypeQo) {
//            String path = Objects.requireNonNull(ResourceTypeServiceImpl.class.getClassLoader().getResource("resource-type.json")).getPath();
//            String s = readJsonFile(path);
//            JSONObject jobj = JSON.parseObject(s);
//            //构建JSONArray数组
//            JSONArray movies = jobj.getJSONArray("RECORDS");
//            List<ResourceTypeVo> resourceTypeVos = new ArrayList<>();
//            List<ResourceTypeVo> resourceTypeVoList = nextList(resourceTypeQo.getId(), movies, resourceTypeVos);
//            if (resourceTypeVoList.size() > 0) {
//                return resourceTypeVoList;
//            } else {
//                throw new ResourceException(ResourceErrorCode.RESOURCE_TYPE_NOT_FOUND.getMsg(), ResourceErrorCode.RESOURCE_TYPE_NOT_FOUND.getCode());
//            }
//        }



//        private List<ResourceTypeVo> nextList(String id, JSONArray movies, List<ResourceTypeVo> resourceTypeVos) {
//            for (Object movie : movies) {
//                JSONObject object = (JSONObject) movie;
//                String aimsId = (String) object.get("id");
//                String name = (String) object.get("name");
//                JSONArray subLit = object.getJSONArray("subLit");
//                if (subLit != null && subLit.size() > 0) {
//                    if (id.equals(aimsId)) {
//                        for (Object sub : subLit) {
//                            JSONObject obj = (JSONObject) sub;
//                            String idNext = (String) obj.get("id");
//                            String nameNext = (String) obj.get("name");
//                            ResourceTypeVo resourceTypeVo = new ResourceTypeVo();
//                            resourceTypeVo.setId(idNext);
//                            resourceTypeVo.setName(nameNext);
//                            resourceTypeVos.add(resourceTypeVo);
//                        }
//                    } else {
//                        nextList(id, subLit, resourceTypeVos);
//                    }
//                } else {
//                    System.out.println(name+":没查询到当前子类");
//                }
//            }
//            return resourceTypeVos;

    }

