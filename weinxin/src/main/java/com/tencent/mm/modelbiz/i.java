package com.tencent.mm.modelbiz;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  public static String hvs;
  public static String hvt;
  public static String hvu;
  public String arH;
  public String content;
  public String fZv;
  public List<i> hvv;
  public int hvw;
  public int id;
  public String name;
  public String state;
  public int type;
  public String value;
  
  static
  {
    GMTrace.i(18618817445888L, 138721);
    hvs = "menu_click";
    hvt = "menu_action_start";
    hvu = "menu_action_success";
    GMTrace.o(18618817445888L, 138721);
  }
  
  public i()
  {
    GMTrace.i(18618146357248L, 138716);
    this.hvv = null;
    GMTrace.o(18618146357248L, 138716);
  }
  
  public static List<i> c(JSONArray paramJSONArray)
  {
    GMTrace.i(18618549010432L, 138719);
    Object localObject;
    if (paramJSONArray != null) {
      try
      {
        ArrayList localArrayList = new ArrayList();
        int j = paramJSONArray.length();
        int i = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i >= j) {
            break;
          }
          localObject = paramJSONArray.getJSONObject(i);
          i locali = new i();
          locali.id = ((JSONObject)localObject).getInt("id");
          locali.type = ((JSONObject)localObject).getInt("type");
          locali.name = ((JSONObject)localObject).getString("name");
          locali.arH = ((JSONObject)localObject).getString("key");
          locali.value = ((JSONObject)localObject).optString("value");
          locali.fZv = ((JSONObject)localObject).optString("native_url");
          v.d("MicroMsg.BizMenuItem", "menuItem.nativeurl : " + locali.fZv);
          locali.hvv = c(((JSONObject)localObject).optJSONArray("sub_button_list"));
          locali.hvw = ((JSONObject)localObject).optInt("acttype");
          localArrayList.add(locali);
          i += 1;
        }
        localObject = null;
      }
      catch (JSONException paramJSONArray)
      {
        v.e("MicroMsg.BizMenuItem", "exception:%s", new Object[] { bf.g(paramJSONArray) });
        GMTrace.o(18618549010432L, 138719);
        return null;
      }
    }
    GMTrace.o(18618549010432L, 138719);
    return (List<i>)localObject;
  }
  
  public static LinkedList<i> l(Map<String, String> paramMap)
  {
    GMTrace.i(18618683228160L, 138720);
    if (paramMap == null)
    {
      GMTrace.o(18618683228160L, 138720);
      return null;
    }
    int j = bf.getInt((String)paramMap.get(".msg.appmsg.buttonlist.$count"), 0);
    if (j > 0) {
      try
      {
        LinkedList localLinkedList = new LinkedList();
        v.v("MicroMsg.BizMenuItem", "menuItem.jsonArray.length : " + j);
        int i = 0;
        if (i < j)
        {
          i locali = new i();
          StringBuilder localStringBuilder = new StringBuilder(".msg.appmsg.buttonlist.button");
          if (i == 0) {}
          for (String str = "";; str = String.valueOf(i))
          {
            str = str;
            locali.id = bf.getInt((String)paramMap.get(str + ".id"), 0);
            locali.type = bf.getInt((String)paramMap.get(str + ".type"), 0);
            locali.name = ((String)paramMap.get(str + ".name"));
            locali.arH = ((String)paramMap.get(str + ".key"));
            locali.value = ((String)paramMap.get(str + ".value"));
            locali.hvw = bf.getInt((String)paramMap.get(str + ".acttype"), 0);
            localLinkedList.add(locali);
            i += 1;
            break;
          }
        }
        GMTrace.o(18618683228160L, 138720);
        return localLinkedList;
      }
      catch (Exception paramMap)
      {
        v.e("MicroMsg.BizMenuItem", "exception:%s", new Object[] { bf.g(paramMap) });
        GMTrace.o(18618683228160L, 138720);
        return null;
      }
    }
    GMTrace.o(18618683228160L, 138720);
    return null;
  }
  
  public final void e(ArrayList<String> paramArrayList)
  {
    GMTrace.i(18618012139520L, 138715);
    if (paramArrayList.size() == 0)
    {
      v.e("MicroMsg.BizMenuItem", "value null!");
      GMTrace.o(18618012139520L, 138715);
      return;
    }
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("pic_md5", str);
        localJSONArray.put(localJSONObject);
      }
      paramArrayList = new JSONObject();
    }
    catch (JSONException paramArrayList)
    {
      v.e("MicroMsg.BizMenuItem", paramArrayList.toString());
      GMTrace.o(18618012139520L, 138715);
      return;
    }
    paramArrayList.put("pics", localJSONArray);
    this.content = paramArrayList.toString();
    v.v("MicroMsg.BizMenuItem", this.content);
    GMTrace.o(18618012139520L, 138715);
  }
  
  public final String getInfo()
  {
    GMTrace.i(18618280574976L, 138717);
    if (this.content == null) {
      this.content = "";
    }
    if (this.state == null) {
      if (this.type != 4) {
        break label103;
      }
    }
    label103:
    for (this.state = hvt;; this.state = hvs)
    {
      String str = String.format("%s<info><id><![CDATA[%d]]></id><key><![CDATA[%s]]></key><status><![CDATA[%s]]></status><content><![CDATA[%s]]></content></info>", new Object[] { "#bizmenu#", Integer.valueOf(this.id), this.arH, this.state, this.content });
      GMTrace.o(18618280574976L, 138717);
      return str;
    }
  }
  
  public final String toString()
  {
    GMTrace.i(18618414792704L, 138718);
    int i = this.id;
    int j = this.hvw;
    int k = this.type;
    String str1;
    String str2;
    label46:
    String str3;
    if (this.name == null)
    {
      str1 = "";
      if (this.arH != null) {
        break label144;
      }
      str2 = "";
      if (this.value != null) {
        break label153;
      }
      str3 = "";
      label57:
      if (this.content != null) {
        break label162;
      }
    }
    label144:
    label153:
    label162:
    for (String str4 = "";; str4 = this.content)
    {
      str1 = String.format("id:%d, type:%d, acttype:%s, name:%s, key:%s, value:%s, content:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str1, str2, str3, str4 });
      GMTrace.o(18618414792704L, 138718);
      return str1;
      str1 = this.name;
      break;
      str2 = this.arH;
      break label46;
      str3 = this.value;
      break label57;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */