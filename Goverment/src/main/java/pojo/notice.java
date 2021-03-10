package pojo;

import java.util.List;

/**
 * 通知正文的结构
 */
public class notice {
    // 一级标题
    String description;
    // 二级标题
    String text;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
