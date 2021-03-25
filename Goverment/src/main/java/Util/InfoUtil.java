package Util;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import pojo.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InfoUtil {

    public void getInfo(List<XWPFParagraph> paras,textObject docxObjcet, ArrayList<String> paragraphList){

        int issuanceAgencyFontSize = 0,titleFontSize=0;

        for (XWPFParagraph para:paras) {
            //读取段落内容
            String paraContent = para.getText();

            //删除空白段落
            if (paraContent.equals(""))
                continue;
            paragraphList.add(paraContent);
            //获取段落字号
            List<XWPFRun> runs = para.getRuns();

            //判断是否和发布机构字号一样，追加到发布机构部分
            if (runs.get(0).getFontSize() == issuanceAgencyFontSize) {
                docxObjcet.setIssuanceAgency(docxObjcet.getIssuanceAgency() + paraContent);
                continue;
            }

            //判断是否和文档标题字号一样，追加到文档标题部分
            if (runs.get(0).getFontSize() == titleFontSize) {

                docxObjcet.setTitle(docxObjcet.getTitle() + paraContent);
                continue;
            }

            //设置发布机构
            if (docxObjcet.getIssuanceAgency() == null) {

                docxObjcet.setIssuanceAgency(paraContent);
                issuanceAgencyFontSize = runs.get(0).getFontSize();
                continue;
            }

            // 设置唯一标识号
            if (docxObjcet.getIssueId() == null) {

                docxObjcet.setIssueId(paraContent);
                continue;
            }

            // 设置文档标题
            if (docxObjcet.getTitle() == null) {

                docxObjcet.setTitle(paraContent);
                titleFontSize = runs.get(0).getFontSize();
                continue;

            }

            //设置发布去向
            if (docxObjcet.getTargetAgency() == null) {

                docxObjcet.setTargetAgency(paraContent);
                continue;

            }

            // 设置文档正文
            if (docxObjcet.getTargetText() == null) {

                docxObjcet.setTargetText(paraContent);
                continue;
            }

        }
        }

}
