package segment;

import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 中文分词工具
 */
public class segmentUtil {
    private static String chineseStopWords = "segment/stopWords.txt";

    public static String segmenter(String str){
        JiebaSegmenter segmenter = new JiebaSegmenter();
        //把段落中的所有中文整理出来
        str = chineseClean(str);
        //对提取出的中文段落进行分词
        List<String> strings = segmenter.sentenceProcess(str);
        //对提取出的所有词汇，用空格分隔开
        str = String.join(" ", strings);
        //删除无用词汇
        str = Stopwords.remover(str,chineseStopWords);
        return str;

    }

    public static String chineseClean(String input) {

        StringBuilder sb = new StringBuilder();
        // 正则表达式规则：匹配至少一个汉字
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]+");
        // 返回匹配结果
        Matcher m = p.matcher(input);

        while (m.find()) {
            // trim删除首尾空白符
            sb.append(m.group().trim());
//            sb.append(" ");
        }
        return sb.toString();
    }
}
