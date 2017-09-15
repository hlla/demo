package com.tencent.mm.sdk.platformtools;

import com.tencent.gmtrace.GMTrace;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class bg
{
  public static ThreadLocal<XmlPullParser> uuB;
  
  static
  {
    GMTrace.i(13867509874688L, 103321);
    uuB = new ThreadLocal();
    GMTrace.o(13867509874688L, 103321);
  }
  
  public static String b(Node paramNode)
  {
    GMTrace.i(17568697942016L, 130897);
    StringWriter localStringWriter = new StringWriter();
    try
    {
      Transformer localTransformer = TransformerFactory.newInstance().newTransformer();
      localTransformer.setOutputProperty("omit-xml-declaration", "yes");
      localTransformer.transform(new DOMSource(paramNode), new StreamResult(localStringWriter));
      paramNode = localStringWriter.toString();
      GMTrace.o(17568697942016L, 130897);
      return paramNode;
    }
    catch (TransformerException paramNode)
    {
      for (;;)
      {
        v.e("MicroMsg.SDK.XmlParser", "nodeToString: %s", new Object[] { paramNode.getMessage() });
      }
    }
  }
  
  public static Map<String, String> q(String paramString1, String paramString2)
  {
    GMTrace.i(13867241439232L, 103319);
    if (paramString1 == null) {}
    for (int i = -1; i < 0; i = paramString1.indexOf("<" + paramString2))
    {
      v.e("MicroMsg.SDK.XmlParser", "can not find the tag <%s>", new Object[] { paramString2 });
      GMTrace.o(13867241439232L, 103319);
      return null;
    }
    String str = paramString1;
    if (i > 0) {
      str = paramString1.substring(i);
    }
    try
    {
      paramString1 = new a(str, paramString2).bJW();
      GMTrace.o(13867241439232L, 103319);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      v.printErrStackTrace("MicroMsg.SDK.XmlParser", paramString1, "[ %s ]", new Object[] { str });
      GMTrace.o(13867241439232L, 103319);
    }
    return null;
  }
  
  private static final class a
  {
    private XmlPullParser uuC;
    private String uuD;
    private StringBuilder uuE;
    private Map<String, String> uuF;
    private Map<Integer, Integer> uuG;
    
    public a(String paramString1, String paramString2)
    {
      GMTrace.i(13913278119936L, 103662);
      this.uuE = new StringBuilder();
      this.uuD = paramString2;
      paramString2 = (XmlPullParser)bg.uuB.get();
      this.uuC = paramString2;
      if (paramString2 == null)
      {
        paramString2 = bg.uuB;
        XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        this.uuC = localXmlPullParser;
        paramString2.set(localXmlPullParser);
      }
      this.uuC.setInput(new StringReader(paramString1));
      this.uuG = new HashMap();
      this.uuF = new HashMap();
      GMTrace.o(13913278119936L, 103662);
    }
    
    public final Map<String, String> bJW()
    {
      GMTrace.i(13913412337664L, 103663);
      int i = this.uuC.getEventType();
      for (;;)
      {
        Object localObject;
        if (i != 1)
        {
          i = this.uuC.next();
          if (i == 2)
          {
            this.uuE.append('.').append(this.uuC.getName());
            localObject = this.uuE.toString();
            int j = ((String)localObject).hashCode();
            Integer localInteger = (Integer)this.uuG.get(Integer.valueOf(j));
            if (localInteger != null)
            {
              localInteger = Integer.valueOf(localInteger.intValue() + 1);
              this.uuE.append(localInteger);
              this.uuG.put(Integer.valueOf(j), localInteger);
              localObject = (String)localObject + localInteger;
            }
            for (;;)
            {
              this.uuF.put(localObject, "");
              j = 0;
              while (j < this.uuC.getAttributeCount())
              {
                this.uuF.put((String)localObject + ".$" + this.uuC.getAttributeName(j), this.uuC.getAttributeValue(j));
                j += 1;
              }
              this.uuG.put(Integer.valueOf(j), Integer.valueOf(0));
            }
          }
          else if (i == 4)
          {
            localObject = this.uuC.getText();
            if (localObject != null) {
              this.uuF.put(this.uuE.toString(), localObject);
            }
          }
          else if (i == 3)
          {
            this.uuE = this.uuE.delete(this.uuE.lastIndexOf("."), this.uuE.length());
            if (this.uuE.length() != 0) {}
          }
        }
        else
        {
          localObject = this.uuF;
          GMTrace.o(13913412337664L, 103663);
          return (Map<String, String>)localObject;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */