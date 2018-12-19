package com.flatbuffer.parse.xml;


import android.util.Log;

import com.flatbuffer.activity.XmlActivity;
import com.flatbuffer.model.MMAConfig;
import com.flatbuffer.service.ParseService;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/*
 * DOM解析
 */
public class Dom implements ParseService {

    /**
     * 文档构建器
     */
    private DocumentBuilder builder;
    private MMAConfig config;

    public Dom() {
        //获取构建器
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        try {
            builder = f.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            Log.d(XmlActivity.TAG, "Dom() e=" + e);
        }
    }

    @Override
    public List<MMAConfig> doParse(InputStream in) {
        List<MMAConfig> MMAConfigs = new ArrayList<MMAConfig>();
        try {
            Document doc = builder.parse(in);
            NodeList list = doc.getElementsByTagName("config");
            for (int i = 0; i < list.getLength(); i++) {
                //提取MMAConfig元素
                Element el = (Element) list.item(i);
                MMAConfig mmaConfig = new MMAConfig();
                //获取ID节点
                mmaConfig.plat = el.getAttribute("plat");
                mmaConfig.version = el.getAttribute("version");
                Log.d(XmlActivity.TAG, " plat=" + mmaConfig.plat + "  version=" + mmaConfig
                        .version);
                MMAConfigs.add(mmaConfig);
            }
            return MMAConfigs;
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到指定元素的子元素文本 节点(
     *
     * @param el   父元素
     * @param name 子元素名称
     * @return
     */
    private String getSubelementTextContentByName(Element el, String name) {
        NodeList list = el.getElementsByTagName(name);
        Element e = (Element) list.item(0);
        return e.getTextContent();
    }


}
