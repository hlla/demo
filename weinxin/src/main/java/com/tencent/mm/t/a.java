package com.tencent.mm.t;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.Map;

public class a
  extends c
{
  public boolean hgY;
  public String hgZ;
  
  public a()
  {
    GMTrace.i(16384360710144L, 122073);
    GMTrace.o(16384360710144L, 122073);
  }
  
  public final void a(StringBuilder paramStringBuilder, f.a parama, String paramString, keep_SceneResult paramkeep_SceneResult, int paramInt1, int paramInt2)
  {
    GMTrace.i(16384629145600L, 122075);
    paramStringBuilder.append("<weappinfo>");
    if (!bf.mA(parama.hjB)) {
      paramStringBuilder.append("<pagepath>" + f.a.el(parama.hjB) + "</pagepath>");
    }
    paramStringBuilder.append("<username>" + bf.PV(parama.hjC) + "</username>");
    paramStringBuilder.append("<appid>" + bf.PV(parama.hjD) + "</appid>");
    if (parama.hjK != 0) {
      paramStringBuilder.append("<version>" + parama.hjK + "</version>");
    }
    if (parama.hjE != 0) {
      paramStringBuilder.append("<type>" + parama.hjE + "</type>");
    }
    if (!bf.mA(parama.hjL)) {
      paramStringBuilder.append("<weappiconurl>" + f.a.el(parama.hjL) + "</weappiconurl>");
    }
    if (!bf.mA(parama.hjH)) {
      paramStringBuilder.append("<shareId>" + f.a.el(parama.hjH) + "</shareId>");
    }
    if ((parama.hjJ == 1) || (parama.hjJ == 2))
    {
      paramStringBuilder.append("<pkginfo>");
      paramStringBuilder.append("<type>");
      paramStringBuilder.append(parama.hjJ);
      paramStringBuilder.append("</type>");
      paramStringBuilder.append("<md5>");
      paramStringBuilder.append(parama.hjF);
      paramStringBuilder.append("</md5>");
      paramStringBuilder.append("</pkginfo>");
    }
    if (!bf.mA(parama.hjI)) {
      paramStringBuilder.append("<sharekey>" + f.a.el(parama.hjI) + "</sharekey>");
    }
    if (this.hgY)
    {
      paramStringBuilder.append("<wadynamicpageinfo>");
      paramStringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
      paramStringBuilder.append("<cacheKey>");
      paramStringBuilder.append(f.a.el(this.hgZ));
      paramStringBuilder.append("</cacheKey>");
      paramStringBuilder.append("</wadynamicpageinfo>");
    }
    paramStringBuilder.append("</weappinfo>");
    GMTrace.o(16384629145600L, 122075);
  }
  
  public final void a(Map<String, String> paramMap, f.a parama)
  {
    GMTrace.i(16384763363328L, 122076);
    if (bf.getInt((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.hgY = bool;
      this.hgZ = ((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey"));
      GMTrace.o(16384763363328L, 122076);
      return;
    }
  }
  
  public final c wD()
  {
    GMTrace.i(16384494927872L, 122074);
    a locala = new a();
    locala.hgY = this.hgY;
    locala.hgZ = this.hgZ;
    GMTrace.o(16384494927872L, 122074);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/t/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */