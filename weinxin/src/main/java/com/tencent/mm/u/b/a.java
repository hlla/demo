package com.tencent.mm.u.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public abstract class a
  implements e
{
  protected e.a hoo;
  protected String hop;
  protected String[] hoq;
  
  public a()
  {
    GMTrace.i(681960275968L, 5081);
    this.hop = Ag();
    this.hoq = Af();
    GMTrace.o(681960275968L, 5081);
  }
  
  protected String[] Af()
  {
    GMTrace.i(682765582336L, 5087);
    GMTrace.o(682765582336L, 5087);
    return null;
  }
  
  public abstract String Ag();
  
  public final String O(String paramString1, String paramString2)
  {
    GMTrace.i(682362929152L, 5084);
    ap.yY();
    SharedPreferences localSharedPreferences = c.ef("banner");
    if (localSharedPreferences == null)
    {
      GMTrace.o(682362929152L, 5084);
      return null;
    }
    paramString1 = localSharedPreferences.getString(this.hop + paramString2 + paramString1, null);
    GMTrace.o(682362929152L, 5084);
    return paramString1;
  }
  
  public final void a(e.a parama)
  {
    GMTrace.i(682631364608L, 5086);
    this.hoo = parama;
    GMTrace.o(682631364608L, 5086);
  }
  
  public final void a(String paramString, boolean paramBoolean, String[] paramArrayOfString)
  {
    GMTrace.i(682228711424L, 5083);
    ap.yY();
    SharedPreferences localSharedPreferences = c.ef("banner");
    if (localSharedPreferences == null)
    {
      GMTrace.o(682228711424L, 5083);
      return;
    }
    localSharedPreferences.edit().putBoolean(this.hop + paramString, paramBoolean).commit();
    if ((this.hoq != null) && (paramArrayOfString != null) && (this.hoq.length == paramArrayOfString.length))
    {
      String[] arrayOfString = this.hoq;
      int k = arrayOfString.length;
      int j = 0;
      int i = 0;
      if (i < k)
      {
        String str2 = arrayOfString[i];
        if (str2 != null) {
          if (paramArrayOfString[j] == null) {
            break label206;
          }
        }
        label206:
        for (String str1 = paramArrayOfString[j];; str1 = "")
        {
          localSharedPreferences.edit().putString(this.hop + str2 + paramString, str1).commit();
          j += 1;
          i += 1;
          break;
        }
      }
    }
    if (this.hoo != null) {
      this.hoo.As();
    }
    GMTrace.o(682228711424L, 5083);
  }
  
  public final boolean gA(String paramString)
  {
    GMTrace.i(682094493696L, 5082);
    ap.yY();
    SharedPreferences localSharedPreferences = c.ef("banner");
    if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean(this.hop + paramString, false)))
    {
      GMTrace.o(682094493696L, 5082);
      return true;
    }
    GMTrace.o(682094493696L, 5082);
    return false;
  }
  
  public final void gB(String paramString)
  {
    GMTrace.i(682497146880L, 5085);
    ap.yY();
    SharedPreferences localSharedPreferences = c.ef("banner");
    if (localSharedPreferences == null)
    {
      GMTrace.o(682497146880L, 5085);
      return;
    }
    localSharedPreferences.edit().remove(this.hop + paramString).commit();
    if (this.hoq != null)
    {
      String[] arrayOfString = this.hoq;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (str != null) {
          localSharedPreferences.edit().remove(this.hop + str + paramString).commit();
        }
        i += 1;
      }
    }
    if (this.hoo != null) {
      this.hoo.At();
    }
    GMTrace.o(682497146880L, 5085);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */