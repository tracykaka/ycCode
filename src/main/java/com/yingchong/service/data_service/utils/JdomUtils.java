package com.yingchong.service.data_service.utils;

import com.yingchong.service.data_service.service.ReligionService;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Text;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdomUtils {

    private static final Logger logger = LoggerFactory.getLogger(ReligionService.class);

    /**
     * 将 XML 转化为 map
     *
     * @param strxml
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static Map<String,String> transferXmlToMap(String strxml) {
        strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");
        if ("".equals(strxml)) {
            return null;
        }
        Map<String,String> m = new HashMap<>();
        try {
            InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
            SAXBuilder builder = new SAXBuilder();
            Document doc = null;
            doc = builder.build(in);
            // 解析 DOM
            Element root = doc.getRootElement();
            List list = root.getChildren();
            for (Object o : list) {
                Element e = (Element) o;
                Text t = (Text) e.getContent().get(0);
                m.put(e.getAttribute("n").getValue(), t.getValue());
            }
            //关闭流
            in.close();
        } catch (Exception e) {
            logger.error("",e);
            //throw new IOException(e.getMessage()); // 统一转化为 IO 异常输出
        }
        return m;
    }

//    public static void main(String[] args) throws IOException {
//        String str = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
//                "<_d>\n" +
//                "  <_f n=\"private_type\">jb</_f>\n" +
//                "  <_f n=\"is_webapp\">henda</_f>\n" +
//                "  <_f n=\"line_no\">hhhhh</_f>\n" +
//                "  <_f n=\"dealed_line_no\">aaaaa</_f>\n" +
//                "  <_f n=\"urllog_type\">0</_f>\n" +
//                "  <_f n=\"mac\">64-a0-e7-41-64-41</_f>\n" +
//                "  <_f n=\"termtype\">ç§»åŠ¨ç»ˆç«¯(Androidç³»ç»Ÿç§»åŠ¨ç»ˆç«¯)</_f>\n" +
//                "  <_f n=\"nProtocol\">6</_f>\n" +
//                "  <_f n=\"host\">m.sogo.com</_f>\n" +
//                "  <_f n=\"trace_t\">web_url</_f>\n" +
//                "  <_f n=\"urltype\">3858868786</_f>\n" +
//                "  <_f n=\"urldata\">m.sogo.com/</_f>\n" +
//                "  <_f n=\"url\">m.sogo.com/</_f>\n" +
//                "  <_f n=\"usr_name\">10.30.102.80</_f>\n" +
//                "  <_f n=\"DNS\">get.shouji.sogou.com</_f>\n" +
//                "</_d>";
//        Map<String,String> map = transferXmlToMap(str);
//        for (Object o : map.keySet()) {
//            String key = o.toString(); // 拿到键
//            String val = String.valueOf(map.get(key)); // 拿到值
//            System.out.println(key + "=====" + val);
//        }
//    }
}
