package com.edgarli.toPdf;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordToPDFs {

    /**
     * 将word文档， 转换成pdf, 中间替换掉变量
     * @param source 源为word文档， 必须为docx文档
     * @param target 目标输出
     * @throws Exception
     */
    public static void wordConverterToPdf(InputStream source, OutputStream target) throws Exception {
        XWPFDocument doc = new XWPFDocument(source);
        PdfOptions options = null;//因为是简单处理，该参数就设置成了null，有需要的可以研究一下
        PdfConverter.getInstance().convert(doc, target, options);
    }

    //测试
    public static void main(String[] args) {
        String filepath = "E:\\pdf\\app更新操作手册.docx";
        String outpath = "E:\\pdf\\test.pdf";
        InputStream source;
        OutputStream target;
        try {
            source = new FileInputStream(filepath);
            target = new FileOutputStream(outpath);
            Map<String, String> params = new HashMap<String, String>();
            wordConverterToPdf(source, target);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
