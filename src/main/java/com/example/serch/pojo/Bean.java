package com.example.serch.pojo;

import lombok.Data;

/**
 * @author 亦梦里 亦书予
 * @version 1.0
 * @date 2021/7/7 10:00
 */
@Data
public class Bean {
    private String id;//_id
    private  String sourceSite;//来源网站
    private  String internetSite;//网址
    private  String classification;// 分类
    private  String financialClassification;//金融分类
    private  String downloadDate;//下载日期
    private String releaseDate;// 发布日期
    private String title;//标题
    private String transferFrom;// 转自
    private String originalTitle;//原标题
    private String editingReporter;//编辑记者
    private String originalWebsiteLink;//原网站链接
    private String extrainfo;//extra—info
    private String summary;//摘要
    private String textContent;//文本内容
    private String webPageSourceCode;//网页源码
}
