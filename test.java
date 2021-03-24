import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.wp.usermodel.CharacterRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import pojo.textObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class test {

    public int getIssuanceAgencyIndex(ArrayList<Integer> list){

        int index = 0;
        if (list.get(index++)==list.get(index))
            index++;
        return  index;
    }


    public static void main(String[] args) throws IOException {

            test t= new test();
            // 读入的文件路径
            String path = "E:\\NJU\\Goverment\\src\\main\\resources\\政策\\《江苏省知识产权专项资金管理办法》.docx";
            InputStream is = new FileInputStream(path);
            List<String> list = new ArrayList<String>();

            // 创建POJO对象
            textObject text = new textObject();

            // XWPF读取该文件
            XWPFDocument doc = new XWPFDocument(is);

            // 获取所有段落
            List<XWPFParagraph> paras = doc.getParagraphs();

            // 准备字号数组
            ArrayList<Integer> fontSize = new ArrayList<>();

            // 相关index
            int issuanceAgencyIndex;
            int issueIdIndex;
            int titleIndex;
            int targetAgencyIndex;
            int targetTextIndex;
            int noticesIndex;


            for (XWPFParagraph graph : paras) {
                // 获取段落内容
                String paragraphContent =  graph.getText();
                //System.out.println(paragraphContent);
                if("".equals(paragraphContent)){
                    continue;
                }
                // 获取段落文字的字体与大小

                List<XWPFRun> runs = graph.getRuns();// 获取一个段落中的所有runs
                if(runs.size() != 0){
                    fontSize.add(runs.get(0).getFontSize());
                    String fontFamily = runs.get(0).getFontFamily();

                    //int characterSpacing = runs.get(0).getCharacterSpacing();

                    //int kerning = runs.get(0).getKerning();
                    //System.out.println("fontFamily:"+ fontFamily);
                    //System.out.println("fontSize:"+fontSize);
                }

            }

            issuanceAgencyIndex = t.getIssuanceAgencyIndex(fontSize);
        for (int i = 0; i <=issuanceAgencyIndex ; i++) {
            System.out.println(paras.get(i).getParagraphText());
        }




        }


}
