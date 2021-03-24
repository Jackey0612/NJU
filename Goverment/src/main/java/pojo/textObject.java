package pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 文档的数据结构
 */
public class textObject {
    String issuanceAgency;
    String issueId;
    String title;
    String targetAgency;
    String targetText;
    Map<String, ArrayList<notice>> notices ;

    public String getTargetAgency() {
        return targetAgency;
    }

    public void setTargetAgency(String targetAgency) {
        this.targetAgency = targetAgency;
    }



    public String getIssuanceAgency() {
        return issuanceAgency;
    }

    public void setIssuanceAgency(String issuanceAgency) {
        this.issuanceAgency = issuanceAgency;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTargetText() {
        return targetText;
    }

    public void setTargetText(String targetText) {
        this.targetText = targetText;
    }

    public Map<String, ArrayList<notice>> getNotices() {
        return notices;
    }

    public void setNotices(Map<String, ArrayList<notice>> notices) {
        this.notices = notices;
    }
}
