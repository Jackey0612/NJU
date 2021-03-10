package pojo;

import java.util.List;

/**
 * 文档的数据结构
 */
public class textObject {
    String issuanceAgency;
    String issueId;
    String title;
    String targetAgency;
    String targetText;
    List<notice> notices;
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

    public List<notice> getNotices() {
        return notices;
    }

    public void setNotices(List<notice> notices) {
        this.notices = notices;
    }
}
