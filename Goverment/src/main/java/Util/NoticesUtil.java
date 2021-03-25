package Util;

import pojo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoticesUtil {

    int index1 = 0, index2 = 0, index3 = 0;

    String highTitleA = null, highTitleB = null, highTitleC = null;

    String description = null, text = null;

    Map<String, ArrayList<notice>> notices = new HashMap<>();

    ArrayList<notice> lowTitle1 = new ArrayList<>();
    ArrayList<notice> lowTitle2 = new ArrayList<>();
    ArrayList<notice> lowTitle3 = new ArrayList<>();

    // 获取小标题描述
    public String getDescription(String content) {

        String[] chars = new String[10];
        chars = content.split("。");
        return chars[0];
    }

    // 判断某大标题下是否有多个小标题
    public boolean hasMoreTitles(ArrayList<String> paragraphList, int i, String tag) {
        if (paragraphList.get(i).contains(tag)) {
            return true;
        }

        return false;
    }

    // 获取通知主体部分内容

    public void getNotices(ArrayList<String> paragraphList) {

        // 获取通知主体中的大标题及其位置

        for (String para : paragraphList) {
            if (para.contains("一、")) {
                index1 = paragraphList.indexOf(para);
                highTitleA = para;
            }
            if (para.contains("二、")) {
                index2 = paragraphList.indexOf(para);
                highTitleB = para;
            }
            if (para.contains("三、")) {
                index3 = paragraphList.indexOf(para);
                highTitleC = para;
            }
        }

        // 获取第一个大标题下的小标题
        // 判断是否有多个子标题
        // 若无，直接将通知具体内容入数组
        if (!hasMoreTitles(paragraphList, index1 + 1, "1、")) {

            text = paragraphList.get(index1 + 1);
            lowTitle1.add(new notice(null, text));

        } else {
            // 若有，循环遍历入组
            for (int i = index1 + 1; i < index2; i++) {

                // 获取描述部分
                description = getDescription(paragraphList.get(i));
                // 获取具体内容
                text = paragraphList.get(i).replace(description+"。", "");
                // 新建notice对象并加入数组中
                lowTitle1.add(new notice(description, text));

            }
        }

        // 获取第二个大标题下的小标题
        // 判断是否有多个子标题
        // 若无，直接将通知具体内容入数组
        if (!hasMoreTitles(paragraphList, index2 + 1, "1、")) {

            text = paragraphList.get(index2 + 1);
            lowTitle2.add(new notice(null, text));

        } else {
            // 若有，循环遍历入组
            for (int i = index2 + 1; i < index3; i++) {

                // 获取描述部分
                description = getDescription(paragraphList.get(i));
                // 获取具体内容
                text = paragraphList.get(i).replace(description+"。", "");
                // 新建notice对象并加入数组中
                lowTitle2.add(new notice(description, text));

            }
        }

        //获取第三个大标题下的小标题

        // 判断是否有多个子标题
        // 若无，直接将通知具体内容入数组
        if (!hasMoreTitles(paragraphList, index3 + 1, "1、")) {

            text = paragraphList.get(index3 + 1);
            lowTitle3.add(new notice(null, text));

        } else {
            // 若有，循环遍历入组
            for (int i = index3 + 1; i < index3 + 4; i++) {

                // 获取描述部分
                description = getDescription(paragraphList.get(i));
                // 获取具体内容
                text = paragraphList.get(i).replace(description+"。", "");
                // 新建notice对象并加入数组中
                lowTitle3.add(new notice(description, text));

            }
        }

        // 将获取的大标题和小标题数组加入notices映射
        notices.put(highTitleA, lowTitle1);
        notices.put(highTitleB, lowTitle2);
        notices.put(highTitleC, lowTitle3);

    }

    public void showNotices() {

        System.out.println(highTitleA);
        for (int i = 0; i < lowTitle1.size(); i++) {
            if (lowTitle1.get(i).getDescription() != null) {
                System.out.print(lowTitle1.get(i).getDescription());
                System.out.println();
                System.out.println(lowTitle1.get(i).getText());
            } else
                System.out.println(lowTitle1.get(i).getText());
        }
        System.out.println(highTitleB);
        for (int i = 0; i < lowTitle2.size(); i++) {

            if (lowTitle2.get(i).getDescription() != null) {
                System.out.print(lowTitle2.get(i).getDescription());
                System.out.println();
                System.out.println(lowTitle2.get(i).getText());
            } else
                System.out.println(lowTitle2.get(i).getText());

        }
        System.out.println(highTitleC);
        for (int i = 0; i < lowTitle3.size(); i++) {

            if (lowTitle3.get(i).getDescription() != null) {
                System.out.print(lowTitle3.get(i).getDescription());
                System.out.println();
                System.out.println(lowTitle3.get(i).getText());
            } else
                System.out.println(lowTitle3.get(i).getText());
        }
    }
}

