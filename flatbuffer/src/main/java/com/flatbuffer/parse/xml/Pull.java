package com.flatbuffer.parse.xml;

import android.util.Log;
import android.util.Xml;

import com.flatbuffer.activity.XmlActivity;
import com.flatbuffer.model.MMAConfig;
import com.flatbuffer.service.ParseService;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Pull implements ParseService {

    private String tagName;

    @Override
    public List<MMAConfig> doParse(InputStream in) {
        List<MMAConfig> mmaConfigs = null;
        MMAConfig mmaConfig = null;

        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setInput(in, "utf-8");
            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        mmaConfigs = new ArrayList<MMAConfig>();
                        break;
                    case XmlPullParser.START_TAG:
                        tagName = parser.getName();
                        if ("config".equals(tagName)) {
                            mmaConfig = new MMAConfig();
                            int count = parser.getAttributeCount();
                            for (int i = 0; i < count; i++) {
                                String name = parser.getAttributeName(i);
                                Log.d(XmlActivity.TAG, "pull doParse name=" + name);
                                if ("version".equalsIgnoreCase(name)) {
                                    mmaConfig.version = parser.getAttributeValue(i);
                                    Log.d(XmlActivity.TAG, "pull doParse version=" + mmaConfig
                                            .version);
                                }
                            }
                            mmaConfigs.add(mmaConfig);
                            return mmaConfigs;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("mmaConfig".equals(parser.getName())) {
                            mmaConfigs.add(mmaConfig);
                        }
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mmaConfigs;
    }

}
