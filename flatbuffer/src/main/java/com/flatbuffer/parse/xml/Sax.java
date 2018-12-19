package com.flatbuffer.parse.xml;


import android.util.Log;

import com.flatbuffer.activity.XmlActivity;
import com.flatbuffer.model.MMAConfig;
import com.flatbuffer.service.ParseService;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Sax implements ParseService {
    private SAXParser parser;

    public Sax() {
        SAXParserFactory f = SAXParserFactory.newInstance();
        try {
            parser = f.newSAXParser();
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("Sax", e.getMessage());
        }
    }

    @Override
    public List<MMAConfig> doParse(InputStream in) {
        XmlHandler h = new XmlHandler();
        try {
            parser.parse(in, h);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return h.getMMAConfigs();
    }

    class XmlHandler extends DefaultHandler {
        List<MMAConfig> persons = null;
        private MMAConfig mmaConfig;
        private Object currentEleName;


        @Override
        public void startDocument() throws SAXException {
            Log.d(XmlActivity.TAG, "Sax StartDocument");
            persons = new ArrayList<MMAConfig>();
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
            Log.d(XmlActivity.TAG, "Sax endDocument");
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            Log.d(XmlActivity.TAG, "Sax startElement uri=" + uri + "  localName=" + localName + "" +
                    " " +
                    "   qName = " + qName);
            if ("config".equals(localName)) {
                mmaConfig = new MMAConfig();
                mmaConfig.version = attributes.getValue("version");
                Log.d(XmlActivity.TAG, "Sax StartElement version=" + mmaConfig.version);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            Log.d(XmlActivity.TAG, "Sax endElement uri=" + uri + "  localName=" + localName + " " +
                    "   qName = " + qName);
            if ("config".equals(localName)) {
                persons.add(mmaConfig);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
//            Log.d(XmlActivity.TAG, "Sax characters ch=" + new String(ch) + "  start=" + start + "" +
//                    "    length = " + length);
        }

        public List<MMAConfig> getMMAConfigs() {
            return persons;
        }

    }

}
