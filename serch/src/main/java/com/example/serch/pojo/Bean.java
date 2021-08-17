package com.example.serch.pojo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author 亦梦里 亦书予
 * @version 1.0
 * @date 2021/7/7 10:00
 */
@Data
@Document(indexName = "user" ,shards = 5, replicas = 1)
public class Bean implements Serializable {
//    @JSONField(name = "_id")
    @Id
    private String id;//_id
    @JSONField(name = "来源网站")
    private  String sourceSite;//来源网站
    @JSONField(name = "网址")
    private  String internetSite;//网址
    @JSONField(name = "分类")
    private  String classification;// 分类
    @JSONField(name = "金融分类")
    private  String financialClassification;//金融分类
    @JSONField(name = "下载日期")
    private  String downloadDate;//下载日期
    @JSONField(name = "发布日期")
    private String releaseDate;// 发布日期
    @JSONField(name = "标题")
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;//标题
    @JSONField(name = "转自")
    private String transferFrom;// 转自
    @JSONField(name = "原标题")
    private String originalTitle;//原标题
    @JSONField(name = "编辑记者")
    private String editingReporter;//编辑记者
    @JSONField(name = "原网站链接")
    private String originalWebsiteLink;//原网站链接
    @JSONField(name = "extrainfo")
    private String extrainfo;//extra—info
    @JSONField(name = "摘要")
    private String summary;//摘要
    @JSONField(name = "文本内容")
    private String textContent;//文本内容
    @JSONField(name = "网页源码")
    private String webPageSourceCode;//网页源码
}
