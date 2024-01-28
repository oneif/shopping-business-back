package com.business.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "file.upload")
public class Upload {
    private String path;
    private List<String> allowTypeList;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getAllowTypes() {
        return allowTypeList;
    }

    public void setAllowType(List<String> allowTypeList) {
        this.allowTypeList = allowTypeList;
    }
}