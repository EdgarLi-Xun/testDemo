package com.edgarli.toPdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

/**
 * @ClassName TxtToPDF
 * @Description
 * @Author lixun
 * @Date 2020/5/19 14:39
 * @Version 1.0
 **/
public class TxtToPDF {
    public static void text2pdf(String text, String pdf) throws DocumentException, IOException {
        Document document = new Document();
        OutputStream os = new FileOutputStream(new File(pdf));
        PdfWriter.getInstance(document, os);
        document.open();
        //方法一：使用Windows系统字体(TrueType)
        BaseFont baseFont=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        Font font = new Font(baseFont);
        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(text)), "GBK");
        BufferedReader bufferedReader = new BufferedReader(isr);
        String str = "";
        while ((str = bufferedReader.readLine()) != null) {
            document.add(new Paragraph(str, font));
        }
        document.close();
    }

    public static void main(String[] args) throws Exception {
        String text = "E:\\pdf\\123.txt";
        String pdf = "E:\\pdf\\123.pdf";
        text2pdf(text, pdf);
    }
}
