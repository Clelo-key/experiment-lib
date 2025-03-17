package cn.example.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: Fly
 * @CreateTime: 2025-03-17
 * @Version: 1.0
 */
@ConfigurationProperties("api.custom")
public class ApiProperties {
    private Boolean enable;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 作者
     */
    private String author;
    /**
     * 版本
     */
    private String version;

    public Boolean getEnabled() {
        return enable;
    }

    public void setEnabled(Boolean enabled) {
        this.enable = enabled;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
