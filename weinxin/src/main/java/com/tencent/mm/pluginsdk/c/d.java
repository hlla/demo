package com.tencent.mm.pluginsdk.c;

import android.content.Context;
import com.tencent.mm.ap.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.a.s;
import com.tencent.mm.storage.a.u;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.d.a;
import java.util.ArrayList;
import java.util.List;

public abstract interface d
{
  public abstract String a(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString);
  
  public abstract void a(Context paramContext, au paramau);
  
  public abstract void a(String paramString, c paramc, au paramau);
  
  public abstract boolean a(Context paramContext, c paramc, int paramInt, String paramString);
  
  public abstract boolean a(String paramString1, String paramString2, long paramLong, String paramString3, d.a parama);
  
  public abstract f alA();
  
  public abstract boolean alw();
  
  public abstract ArrayList<s> alx();
  
  public abstract ArrayList<String> aly();
  
  public abstract ArrayList<u> alz();
  
  public abstract al bO(String paramString1, String paramString2);
  
  public abstract String bP(String paramString1, String paramString2);
  
  public abstract c c(c paramc);
  
  public abstract void d(c paramc);
  
  public abstract int e(c paramc);
  
  public abstract int[] f(c paramc);
  
  public abstract byte[] g(c paramc);
  
  public abstract boolean l(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean s(ArrayList<s> paramArrayList);
  
  public abstract boolean t(ArrayList<u> paramArrayList);
  
  public abstract c tX(String paramString);
  
  public abstract String tY(String paramString);
  
  public abstract List<c> tZ(String paramString);
  
  public abstract String ua(String paramString);
  
  public abstract boolean ub(String paramString);
  
  public abstract ArrayList<String> uc(String paramString);
  
  public abstract String ud(String paramString);
  
  public abstract String ue(String paramString);
  
  public abstract int uf(String paramString);
  
  public abstract String ug(String paramString);
  
  public abstract void uh(String paramString);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */