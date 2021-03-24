package pojo;

import java.util.List;

/**
 * 通知正文的结构
 */
public class notice {
    // 描述
    String description;
    // 具体内容
    String text;

    public notice(String description,String text){
        this.description=description;
        this.text = text;
    }

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
