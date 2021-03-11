1.可以使用 Jieba分词器对文章段落进行分词

2.可以使用 Apache POI的 XWPFDocument高级封装API对word进行操作

1. 读取文档
2. 获取所有段落、表格、图片、页眉、页脚
3. 基本元素XWPFRun，获取段落后通关相关API处理段落内的文本和图片，XWPFRun是段落的基本组成单元，可以是一个文本，也可以是一张图片
4. 获取段落内的文字
5. 获取段落内的所有XWPFRun
6. 修改指定Run    runs.get(0).setText("修改文本",0);

3.发布机构：提取所有段落的字体大小，最大的字号所对应的段落为所求 IssuanceAgencyIndex

4.唯一标识号：紧随发布机构之后的段落为所求  IssuanceIDIndex

5.文档标题：次大字号所对应段落为所求  TitleIndex

6.发布去向：紧随文档标题之后的段落为所求 TargetAgencyIndex

7.文档正文：紧随发不去想之后的段落为所求  TargetTextIndex

8.通知主体： NoticesIndex;



一个获取最大字号所在段落的方法 getIssuanceAgencyIndex()

一个获取次大字号所在段落的方法 getTitleIndex()



```
String issuanceAgency;
String issueId;
String title;
String targetAgency;
String targetText;
List<notice> notices;
```



检索 词袋 



尝试使用git监控每次改动



2021.3.11

开始探索通知正文部分的提取

使用map<string,list[]>存储，key存所有一级标题，每个key对应的list存该一级标题下的所有二级标题