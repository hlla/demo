package com.tencent.mm.plugin.fts.d.b;

import android.text.TextPaint;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.fts.d.d.a;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public TextPaint haA;
  public boolean lYh;
  public CharSequence mbL;
  public String mbM;
  public boolean mbN;
  public List<a> mbO;
  public int mbP;
  public int mbQ;
  public float mbR;
  
  public a()
  {
    GMTrace.i(18563117088768L, 138306);
    this.mbO = new ArrayList();
    this.mbP = b.mbU;
    this.mbQ = d.a.maM;
    GMTrace.o(18563117088768L, 138306);
  }
  
  public static final a a(CharSequence paramCharSequence, String paramString, List<String> paramList)
  {
    GMTrace.i(18563788177408L, 138311);
    a locala = new a();
    locala.mbL = paramCharSequence;
    locala.mbM = paramString;
    paramCharSequence = paramList.iterator();
    while (paramCharSequence.hasNext())
    {
      paramString = (String)paramCharSequence.next();
      paramList = new a();
      paramList.mbM = paramString;
      locala.mbO.add(paramList);
    }
    GMTrace.o(18563788177408L, 138311);
    return locala;
  }
  
  public static final a a(CharSequence paramCharSequence, String paramString, List<String> paramList, float paramFloat, TextPaint paramTextPaint)
  {
    GMTrace.i(18564190830592L, 138314);
    paramCharSequence = a(paramCharSequence, paramString, paramList);
    paramCharSequence.mbR = paramFloat;
    paramCharSequence.haA = paramTextPaint;
    GMTrace.o(18564190830592L, 138314);
    return paramCharSequence;
  }
  
  public static final a a(CharSequence paramCharSequence, String paramString, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(18563922395136L, 138312);
    paramCharSequence = a(paramCharSequence, paramString, paramList);
    paramCharSequence.lYh = paramBoolean1;
    paramCharSequence.mbN = paramBoolean2;
    GMTrace.o(18563922395136L, 138312);
    return paramCharSequence;
  }
  
  public static final a a(CharSequence paramCharSequence, String paramString, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, TextPaint paramTextPaint)
  {
    GMTrace.i(18564056612864L, 138313);
    paramCharSequence = a(paramCharSequence, paramString, paramList, paramBoolean1, paramBoolean2);
    paramCharSequence.mbR = paramFloat;
    paramCharSequence.haA = paramTextPaint;
    GMTrace.o(18564056612864L, 138313);
    return paramCharSequence;
  }
  
  public static final b a(CharSequence paramCharSequence, List<String> paramList, int paramInt1, int paramInt2)
  {
    GMTrace.i(18563653959680L, 138310);
    a locala = new a();
    locala.mbL = paramCharSequence;
    locala.mbP = paramInt1;
    locala.mbQ = paramInt2;
    paramCharSequence = paramList.iterator();
    while (paramCharSequence.hasNext())
    {
      paramList = (String)paramCharSequence.next();
      a locala1 = new a();
      locala1.mbM = paramList;
      locala.mbO.add(locala1);
    }
    GMTrace.o(18563653959680L, 138310);
    return locala;
  }
  
  public static final a b(CharSequence paramCharSequence, List<String> paramList)
  {
    GMTrace.i(18563519741952L, 138309);
    a locala = new a();
    locala.mbL = paramCharSequence;
    paramCharSequence = paramList.iterator();
    while (paramCharSequence.hasNext())
    {
      paramList = (String)paramCharSequence.next();
      a locala1 = new a();
      locala1.mbM = paramList;
      locala.mbO.add(locala1);
    }
    GMTrace.o(18563519741952L, 138309);
    return locala;
  }
  
  public static final a d(CharSequence paramCharSequence, String paramString)
  {
    GMTrace.i(18563385524224L, 138308);
    a locala = new a();
    locala.mbL = paramCharSequence;
    locala.mbM = paramString;
    GMTrace.o(18563385524224L, 138308);
    return locala;
  }
  
  public final boolean isAvailable()
  {
    GMTrace.i(18563251306496L, 138307);
    if ((!bf.J(this.mbL)) && ((!bf.mA(this.mbM)) || (this.mbO.size() > 0)))
    {
      GMTrace.o(18563251306496L, 138307);
      return true;
    }
    GMTrace.o(18563251306496L, 138307);
    return false;
  }
  
  public static final class a
  {
    public String mbM;
    public int mbS;
    public int mbT;
    
    public a()
    {
      GMTrace.i(18562714435584L, 138303);
      this.mbS = -1;
      this.mbT = -1;
      GMTrace.o(18562714435584L, 138303);
    }
    
    public final boolean isAvailable()
    {
      GMTrace.i(18562848653312L, 138304);
      if ((this.mbS != -1) && (this.mbT != -1))
      {
        GMTrace.o(18562848653312L, 138304);
        return true;
      }
      GMTrace.o(18562848653312L, 138304);
      return false;
    }
    
    public final String toString()
    {
      GMTrace.i(18562982871040L, 138305);
      String str = String.format("HLIndexItem %s %d %d", new Object[] { this.mbM, Integer.valueOf(this.mbS), Integer.valueOf(this.mbT) });
      GMTrace.o(18562982871040L, 138305);
      return str;
    }
  }
  
  public static enum b
  {
    static
    {
      GMTrace.i(18564325048320L, 138315);
      mbU = 1;
      mbV = 2;
      mbW = 3;
      mbX = new int[] { mbU, mbV, mbW };
      GMTrace.o(18564325048320L, 138315);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/d/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */