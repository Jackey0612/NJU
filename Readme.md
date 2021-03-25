# 2021.3.9

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

# 2021.3.10

尝试使用git监控每次改动

git指令

git add * 

git commit -m'注释'

git push -u origin master



# 2021.3.11

开始探索通知正文部分的提取

尝试使用map<string,list[]>存储，key存所有一级标题，每个key对应的list存该一级标题下的所有二级标题





# 2021.3.21

1.确定使用map<String,Arraylist< notice > >的方法存储通知主体

2.编写NoticesUtil类，负责获取通知主体部分的内容，成功

遗留问题：

每个小标题中，description部分ok，text部分总是以“。”开头，推测是split的相关原因，代更新



# 2021.3.25

1.优化了main函数，notice之前的部分命名为info，获取info的方式从在main函数中实施，改为新增infoUtil类，完成info部分的获取和打印

2.NoticesUtil下新增showNotices()功能，将获取和打印分开

3.优化了NoticeUtil类，将“大标题索引、大标题、描述、具体内容、notices映射、下标题数组”这六项从getNotices()函数中抽取出来，作为公共类使用，方便showNotices()函数调用。

4.理想main函数：

 1. 读文件

 2. 创建doc docx pdf对象

 3. 获取文章所有段落 

    List<XWPFParagraph> paras = document.getParagraphs();

 4. 存储所有段落

     ArrayList<String> paragraphList = new ArrayList<>();

 5. 获取文章info 

    ```java
    InfoUtil infoUtil = new InfoUtil();
    infoUtil.getInfo(paras,docxObjcet,paragraphList);
    ```

 6. 获取文章notices 

    ```java
    NoticesUtil noticesUtil = new NoticesUtil();
    ```

#### 待解决问题：

1. 读取文件时的路径每次需要手动修改，是否能传参进来
2. doc docx pdf对象手动规定，是否能根据文件路径这个参数的后缀自动判别生成对应对象
3. List<XWPFParagraph> paras 和question2同理
4. infoUtil中的getInfo()函数，段落类型是写死的
5. NoticesUtil中getNotices()函数中，获取通知主体大标题部分是写死的，默认3个大标题，对应只写了3个index和3个highTitle。能否根据文章内容自动判别需要几个大标题，暂时想到的是用数组存储
6. NoticesUtil中getNotices()函数中，获取通知主体小标题部分逻辑相似，目前是分了3个部分分别入组，能否用一个for循环统一三部分的逻辑
7. NoticesUtil中showNotices()函数中，若question5解决，需要重写这部分的逻辑

#### 下一步工作：

1. try to work out above questions
2. docx文档处理完毕，着手开始处理doc文档和pdf文档