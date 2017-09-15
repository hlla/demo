package com.tencent.mm.an;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a
{
  public static String hME;
  public static String hMF;
  public String TEXT;
  public String TYPE;
  public au fTa;
  public String hMG;
  public String hMH;
  public LinkedList<String> hMI;
  public LinkedList<Integer> hMJ;
  public LinkedList<Integer> hMK;
  public Map<String, String> values;
  
  static
  {
    GMTrace.i(13244202745856L, 98677);
    hME = "";
    hMF = "";
    GMTrace.o(13244202745856L, 98677);
  }
  
  a(Map<String, String> paramMap)
  {
    GMTrace.i(13243665874944L, 98673);
    this.hMG = "";
    this.hMI = new LinkedList();
    this.hMJ = new LinkedList();
    this.hMK = new LinkedList();
    this.values = paramMap;
    GMTrace.o(13243665874944L, 98673);
  }
  
  a(Map<String, String> paramMap, au paramau)
  {
    GMTrace.i(13243800092672L, 98674);
    this.hMG = "";
    this.hMI = new LinkedList();
    this.hMJ = new LinkedList();
    this.hMK = new LinkedList();
    this.values = paramMap;
    this.fTa = paramau;
    GMTrace.o(13243800092672L, 98674);
  }
  
  public final boolean HU()
  {
    GMTrace.i(13243934310400L, 98675);
    if ((this.values != null) && (this.values.size() > 0))
    {
      if (this.values.containsKey(".sysmsg.$type")) {
        this.TYPE = ((String)this.values.get(".sysmsg.$type"));
      }
      hME = ".sysmsg." + this.TYPE + ".text";
      if (this.values.containsKey(hME)) {
        this.TEXT = ((String)this.values.get(hME));
      }
      hMF = ".sysmsg." + this.TYPE + ".link.scene";
      if (this.values.containsKey(hMF)) {
        this.hMH = ((String)this.values.get(hMF));
      }
      boolean bool = HV();
      GMTrace.o(13243934310400L, 98675);
      return bool;
    }
    v.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
    GMTrace.o(13243934310400L, 98675);
    return false;
  }
  
  protected abstract boolean HV();
  
  public static abstract class a
  {
    private static HashMap<String, a> hML;
    
    static
    {
      GMTrace.i(13244873834496L, 98682);
      hML = new HashMap();
      GMTrace.o(13244873834496L, 98682);
    }
    
    public a()
    {
      GMTrace.i(13244336963584L, 98678);
      GMTrace.o(13244336963584L, 98678);
    }
    
    public static void a(String paramString, a parama)
    {
      GMTrace.i(13244605399040L, 98680);
      Assert.assertNotNull(paramString);
      Assert.assertNotNull(parama);
      synchronized (hML)
      {
        hML.put(paramString.toLowerCase(), parama);
        GMTrace.o(13244605399040L, 98680);
        return;
      }
    }
    
    public static a b(Map<String, String> paramMap, au paramau)
    {
      GMTrace.i(13244739616768L, 98681);
      if (paramMap == null)
      {
        v.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
        GMTrace.o(13244739616768L, 98681);
        return null;
      }
      String str = (String)paramMap.get(".sysmsg.$type");
      synchronized (hML)
      {
        a locala = (a)hML.get(str.toLowerCase());
        if (locala == null)
        {
          v.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", new Object[] { str });
          GMTrace.o(13244739616768L, 98681);
          return null;
        }
        paramMap = locala.a(paramMap, paramau);
        GMTrace.o(13244739616768L, 98681);
        return paramMap;
      }
    }
    
    public abstract a a(Map<String, String> paramMap, au paramau);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/an/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */