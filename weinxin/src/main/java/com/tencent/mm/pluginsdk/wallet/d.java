package com.tencent.mm.pluginsdk.wallet;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.kv;
import com.tencent.mm.e.a.kv.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;
import org.json.JSONObject;

public final class d
{
  public String appId;
  public String extInfo;
  public String fRj;
  public String fRk;
  public int fRl;
  public int fRm;
  public int fRn;
  public String nonceStr;
  public String packageExt;
  public String partnerId;
  public int sWI;
  public String sWJ;
  public int sWK;
  public String signType;
  public String timeStamp;
  public String url;
  
  public d(kv paramkv)
  {
    GMTrace.i(1229971259392L, 9164);
    this.sWI = 0;
    this.sWK = 0;
    if ((paramkv == null) || (paramkv.fRi == null))
    {
      GMTrace.o(1229971259392L, 9164);
      return;
    }
    this.appId = paramkv.fRi.appId;
    this.partnerId = paramkv.fRi.partnerId;
    this.signType = paramkv.fRi.signType;
    this.nonceStr = paramkv.fRi.nonceStr;
    this.timeStamp = paramkv.fRi.timeStamp;
    this.packageExt = paramkv.fRi.packageExt;
    this.fRj = paramkv.fRi.fRj;
    this.url = paramkv.fRi.url;
    this.fRk = paramkv.fRi.fRk;
    this.fRl = paramkv.fRi.fRl;
    this.fRn = paramkv.fRi.fRn;
    this.fRm = paramkv.fRi.fRm;
    GMTrace.o(1229971259392L, 9164);
  }
  
  public d(Map<String, Object> paramMap)
  {
    GMTrace.i(1229702823936L, 9162);
    this.sWI = 0;
    this.sWK = 0;
    this.appId = ((String)paramMap.get("appId"));
    this.partnerId = ((String)paramMap.get("partnerId"));
    this.signType = ((String)paramMap.get("signType"));
    this.nonceStr = ((String)paramMap.get("nonceStr"));
    this.timeStamp = ((String)paramMap.get("timeStamp"));
    this.packageExt = ((String)paramMap.get("package"));
    this.fRj = ((String)paramMap.get("paySign"));
    this.url = ((String)paramMap.get("url"));
    this.fRk = ((String)paramMap.get("src_username"));
    this.fRl = bf.getInt((String)paramMap.get("scene"), 0);
    this.fRn = bf.getInt((String)paramMap.get("pay_channel"), 0);
    this.extInfo = bf.mz((String)paramMap.get("ext_info"));
    this.sWJ = bf.mz((String)paramMap.get("token"));
    this.sWK = bf.getInt(bf.ap((String)paramMap.get("result_jump_mode"), "0"), 0);
    GMTrace.o(1229702823936L, 9162);
  }
  
  public d(JSONObject paramJSONObject)
  {
    GMTrace.i(1229837041664L, 9163);
    this.sWI = 0;
    this.sWK = 0;
    this.appId = paramJSONObject.optString("appId");
    this.partnerId = paramJSONObject.optString("partnerId");
    this.signType = paramJSONObject.optString("signType");
    this.nonceStr = paramJSONObject.optString("nonceStr");
    this.timeStamp = paramJSONObject.optString("timeStamp");
    this.packageExt = paramJSONObject.optString("package");
    this.fRj = paramJSONObject.optString("paySign");
    this.url = paramJSONObject.optString("url");
    this.fRk = paramJSONObject.optString("src_username");
    this.fRl = paramJSONObject.optInt("scene", 0);
    this.fRn = paramJSONObject.optInt("pay_channel", 0);
    this.extInfo = paramJSONObject.optString("ext_info", "");
    this.sWJ = paramJSONObject.optString("token", "");
    this.sWK = bf.getInt(paramJSONObject.optString("result_jump_mode", "0"), 0);
    GMTrace.o(1229837041664L, 9163);
  }
  
  public static int dK(int paramInt1, int paramInt2)
  {
    GMTrace.i(14909710532608L, 111086);
    int i;
    if (paramInt1 != 1037) {
      i = paramInt1;
    }
    for (;;)
    {
      if ((i == 1000) || (i == 1018) || (i == 1017) || (i == 1033)) {
        i = 0;
      }
      for (;;)
      {
        v.i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        GMTrace.o(14909710532608L, 111086);
        return i;
        if (paramInt2 <= 0) {
          break label488;
        }
        i = paramInt2;
        break;
        if (i == 1019) {
          i = 1;
        } else if (i == 1010) {
          i = 5;
        } else if ((i == 1007) || (i == 1008)) {
          i = 6;
        } else if (i == 1009) {
          i = 7;
        } else if ((i == 1035) || (i == 1020)) {
          i = 8;
        } else if ((i == 1011) || (i == 1047) || (i == 1025)) {
          i = 12;
        } else if ((i == 1012) || (i == 1032) || (i == 1048) || (i == 1050)) {
          i = 13;
        } else if ((i == 1005) || (i == 1027) || (i == 1042) || (i == 1006)) {
          i = 15;
        } else if ((i == 1024) || (i == 1021)) {
          i = 16;
        } else if ((i == 1029) || (i == 1028)) {
          i = 23;
        } else if ((i == 1013) || (i == 1031) || (i == 1049)) {
          i = 24;
        } else if ((i == 1001) || (i == 1003)) {
          i = 25;
        } else if ((i == 1045) || (i == 1046)) {
          i = 26;
        } else if (i == 1022) {
          i = 27;
        } else if (i == 1023) {
          i = 28;
        } else if (i == 1026) {
          i = 29;
        } else if (i == 1039) {
          i = 30;
        } else if ((i == 1034) || (i == 1060)) {
          i = 31;
        } else if ((i == 1014) || (i == 1043) || (i == 1044) || (i == 1036)) {
          i = 32;
        } else {
          i = 0;
        }
      }
      label488:
      i = paramInt1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/wallet/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */