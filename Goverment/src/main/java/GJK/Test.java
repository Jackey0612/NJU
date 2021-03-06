package GJK;
import Util.InfoUtil;
import Util.NoticesUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.wp.usermodel.CharacterRun;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import pojo.notice;
import pojo.textObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {


    /*
    * 通过 XWPFWordExtractor访问XWPFDocument的内容
    * */

/*    public void testReadByExtractor(XWPFDocument document){

        XWPFWordExtractor extractor = new XWPFWordExtractor(document);

        String content = extractor.getText();

        System.out.println("通过XWPFWordExtractor读取XWPFDocumt内容：");
        System.out.println(content);

        System.out.println("输出CorePropeties：");
        POIXMLProperties.CoreProperties coreProps = extractor.getCoreProperties();
        System.out.println(coreProps.getCategory());   //分类
        System.out.println(coreProps.getCreator()); //创建者
        System.out.println(coreProps.getCreated()); //创建时间
        System.out.println(coreProps.getTitle());   //标题

    }*/

    //获取发布机构
    public void getIsuuanceAgency(int issuanceAgencyIndex,List<String> paragraphlist){

        System.out.println("发布机构:");
        System.out.println(paragraphlist.get(issuanceAgencyIndex));

    }

    //获取唯一标识号
    public void getIssuanceID(int issuanceIDIndex,List<String> paragraphlist){

        System.out.println("唯一标识号：");
        System.out.println(paragraphlist.get(issuanceIDIndex));

    }

    //获取文档标题
    public void getTitle(int titleIndex,List<String>paragraphlist){

        System.out.println("文档标题：");
        System.out.println(paragraphlist.get(titleIndex));

    }

    //获取发布去向
    public void getTargetAgency(int targetAgencyIndex,List<String>paragraphlist){

        System.out.println("发布去向：");
        System.out.println(paragraphlist.get(targetAgencyIndex));

    }

    //获取文档正文
    public void getTargetText(int targetTextIndex,List<String>paragraphlist){

        System.out.println("文档正文：");
        System.out.println(paragraphlist.get(targetTextIndex));

    }

    //获取通知内容
    public void getNotices(int noticesIndex,List<String>paragraphlist){

        System.out.println("通知内容：");
        System.out.println(paragraphlist.get(noticesIndex));

    }



    public static void main(String[] args) throws IOException {

        Test test = new Test();
        textObject docxObjcet = new textObject();

        //文件路径
        String path = "E:\\NJU\\Goverment\\src\\main\\resources\\政策\\关于组织开展2020年度首批省星级上云企业认定工作的通知.docx";
        // 读取文件
        InputStream inputStream = new FileInputStream(path);

        //创建XWPF对象
        XWPFDocument document = new XWPFDocument(inputStream);

        //获取所有段落
        List<XWPFParagraph> paras = document.getParagraphs();

        // 存储所有段落
        ArrayList<String> paragraphList = new ArrayList<>();

        // 获取文章info
        InfoUtil infoUtil = new InfoUtil();
        infoUtil.getInfo(paras,docxObjcet,paragraphList);

        // 获取文章notices
        NoticesUtil noticesUtil = new NoticesUtil();


        // 打印文章内容

        System.out.println("发布机构：");
        System.out.println(docxObjcet.getIssuanceAgency());

        System.out.println();
        System.out.println("唯一标识号：");
        System.out.println(docxObjcet.getIssueId());

        System.out.println();
        System.out.println("文档标题：");
        System.out.println(docxObjcet.getTitle());

        System.out.println();
        System.out.println("发布去向：");
        System.out.println(docxObjcet.getTargetAgency());

        System.out.println();
        System.out.println("文档正文：");
        System.out.println(docxObjcet.getTargetText());

        System.out.println();
        System.out.println("通知主体：");

        noticesUtil.getNotices(paragraphList);
        noticesUtil.showNotices();



        //尝试使用map<string,string[]>的方法进行存储
/*        Map<String,String[]> map = new HashMap<>();
        String[] s = new String[3];
        s[0]="1";
        s[1]="2";
        s[2]="3";
        map.put("a",s);
        System.out.println(map.get("a"));

        System.out.println(map.get("a").toString());*/
/*        //获取通知主体一级标题
        int i,j,k=0;
        for (String para : paragraphList){
            if (para.contains("一、")){
                i=paragraphList.indexOf(para);
                System.out.println(para);
            }
            if (para.contains("二、")){
                j=paragraphList.indexOf(para);
                System.out.println(para);
            }
            if (para.contains("三、")){
                k=paragraphList.indexOf(para);
                System.out.println(para);
            }
        }*/






        //通过extractor读取xwpfdocument内容
        //test.testReadByExtractor(document);


    }
}
