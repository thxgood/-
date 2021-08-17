package com.example.serch.serviceimpl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.serch.SerchApplication;
import com.example.serch.mapper.Mapper;
import com.example.serch.pojo.Bean;
import com.example.serch.service.Inservice;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Source;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 亦梦里 亦书予
 * @version 1.0
 * @date 2021/7/7 10:01
 */
@Service
public class Inserviceimpl implements Inservice {
    List<Bean> list = null;
    private static final String Exchange_name = "test";
    @Autowired
    private Mapper mapper;
    //读取json文件
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RestHighLevelClient client;


    @Override
    public int readJsonFile(String fileName) {

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

            int pointsDataLimit = 500;
            int listSize = beanList.size();
            int maxSize = listSize - 1;
            List<Bean> newList = new ArrayList<Bean>();//新建一个载体list
            for (int i = 0; i < listSize; i++) {
                //分批次处理
                newList.add(beanList.get(i));//循环将数据填入载体list
                if (pointsDataLimit == newList.size() || i == maxSize) {  //载体list达到要求,进行批量操作
                    //调用批量插入
                    mapper.Saveadd(newList);
                    newList.clear();//每次批量操作后,清空载体list,等待下次的数据填入
                }
            }

            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean getData() {
        List<Bean> list = mapper.Gatdata();
        rabbitTemplate.convertAndSend(Exchange_name, "*", list);
        return true;
    }

    @Override
    public boolean elasticsearch() throws IOException {
        if (list == null || list.size() == 0) {
            System.out.println("队列消息调用失败，请检查mq");
            return false;
        } else {
            System.out.println("成功");
            BulkRequest request = new BulkRequest();
            for (Bean bean : list) {
                request.add(
                        new IndexRequest("user")
                                .source(JSON.toJSONString(bean), XContentType.JSON));
                BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
                System.out.println(bulkResponse.hasFailures());
            }
            return true;
        }
    }

    @Override
    public boolean CreateIndex() throws IOException {
//        System.out.println(list.get(0));
//        Map<Long,String> map=list.stream().collect(Collectors.toMap(Bean::getId,Bean::getSourceSite,Bean::getInternetSite,Bean::getClassification,Bean::getFinancialClassification,Bean::getDownloadDate,Bean::getReleaseDate,Bean::getTitle,Bean::getTransferFrom,Bean::getOriginalTitle,Bean::getEditingReporter,Bean::getOriginalWebsiteLink,Bean::getExtrainfo,Bean::getSummary,Bean::getTextContent,Bean::getWebPageSourceCode,(key1,key2)->key2));
//        System.out.println(map); //        CreateIndexRequest request=new CreateIndexRequest("user");
//        //---------------------
//        CreateIndexRequest request =new CreateIndexRequest("user");
////        String a = JSON.toJSONString(list);
//
//        ObjectMapper mapper = new ObjectMapper();
//        Bean bean=new Bean();
//        byte[] json = mapper.writeValueAsBytes(bean);
//        IndexResponse response = client
//                .setSource(json,XContentType.JSON)
//                .get();
//        request.mapping(json, XContentType.JSON);
//        System.out.println(a);
//        client.indices().create(request, RequestOptions.DEFAULT);


        //++++++++++++++++++++++++++++++++++
//        ObjectMapper mapper=new ObjectMapper();
//        Bean bean =new Bean();
//        byte[] json=mapper.writeValueAsBytes(bean);
//      IndexRequest indexRequest =new IndexRequest("user").source(json,XContentType.JSON);
//        client.indices().create(indexRequest,RequestOptions.DEFAULT);


//-----------------------------------------------------------------------
//        CreateIndexRequest request = new CreateIndexRequest("user");
////        CreateIndexResponse createIndexResponse =
//        client.indices().create(request, RequestOptions.DEFAULT);
//        //响应状态
////       boolean acknowledged= createIndexResponse.isAcknowledged();
////        System.out.println("响应状态"+acknowledged);
//       client.close();
        //=======================================================
//        CreateIndexRequest request = new CreateIndexRequest("user");
//        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
//        List<Bean> a = new ArrayList<>();
//        a.add(list.get(0));
//        Object jsonObject = JSON.toJSON(a);

//        System.out.println(jsonObject);
//        IndexRequest request1 = new IndexRequest("user").source(jsonObject, XContentType.JSON);
//        IndexResponse response1=client.index(request1,RequestOptions.DEFAULT);
//        System.out.println(response1.toString());
        //-----------------------------------
//        int pointsDataLimit = 500;
//        int maxSize = list.size() - 1;
//        List<Bean> a = new ArrayList<>();
        BulkRequest bulkRequestl = new BulkRequest("user");
        for (int i = 0; i < list.size(); i++) {
//            a.add(list.get(i));
//            if (pointsDataLimit == a.size() || i == maxSize) {
            Bean bean = list.get(i);
            String jsonString = JSON.toJSONString(bean);
            bulkRequestl.add(new IndexRequest().id(bean.getId()).source(jsonString, XContentType.JSON));
//            Object jsonObject = JSON.toJSON(list.get(i));
//                bulkRequestl.add(new IndexRequest().source(jsonObject, XContentType.JSON));
//                client.bulk(bulkRequestl, RequestOptions.DEFAULT);
//                IndexRequest request1 = new IndexRequest("user").source(jsonObject, XContentType.JSON);
//                client.index(request1,RequestOptions.DEFAULT);
//                a.clear();
            if (bulkRequestl.requests().size() == 1000) {
                batchSubmit(bulkRequestl);
                bulkRequestl = new BulkRequest("user");
            }
        }
        if (bulkRequestl.requests().size() > 0) {
            batchSubmit(bulkRequestl);
        }
//        }
        client.close();
        return true;
    }
    public void batchSubmit(BulkRequest bulkRequestl) throws IOException {
        BulkResponse bulkResponse = client.bulk(bulkRequestl, RequestOptions.DEFAULT);
        if (!bulkResponse.hasFailures()) {
            System.out.println("success");
        }
    }
    @Override
    public boolean create() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("user");
        client.indices().create(request, RequestOptions.DEFAULT);
        return true;
    }
    @Override
    public boolean search() throws IOException{
        SearchRequest request =new SearchRequest();
        request.indices("user");
        request.source(new SearchSourceBuilder().query(QueryBuilders.matchQuery("标题","大型央企新能源发展提速 去年大唐集团可再生能源发电量增9.62%")));
        SearchResponse response=client.search(request,RequestOptions.DEFAULT);
        SearchHits hits= response.getHits();
        System.out.println(hits.getTotalHits());
        for (SearchHit hit:hits)
        {
            System.out.println(hit.getSourceAsString());
        }
        //        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()).size(10000));
//        client.search(request,RequestOptions.DEFAULT);
//        SearchResponse response=client.search(request,RequestOptions.DEFAULT);
//        SearchHits hits=response.getHits();
//        System.out.println(hits.getHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit: hits){
//            System.out.println(hit.getSourceAsString());
//        }
        return true;
    }
}



