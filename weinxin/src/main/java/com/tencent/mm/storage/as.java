package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.g;
import com.tencent.mm.vending.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract interface as
  extends g
{
  public abstract boolean An(String paramString);
  
  public abstract void RA(String paramString);
  
  public abstract int RB(String paramString);
  
  public abstract void Rk(String paramString);
  
  public abstract ae Rl(String paramString);
  
  public abstract void Rm(String paramString);
  
  public abstract boolean Rn(String paramString);
  
  public abstract boolean Ro(String paramString);
  
  public abstract boolean Rp(String paramString);
  
  public abstract boolean Rq(String paramString);
  
  public abstract boolean Rr(String paramString);
  
  public abstract boolean Rs(String paramString);
  
  public abstract Cursor Rt(String paramString);
  
  public abstract Cursor Ru(String paramString);
  
  public abstract int Rv(String paramString);
  
  public abstract String Rw(String paramString);
  
  public abstract ae Rx(String paramString);
  
  public abstract int Ry(String paramString);
  
  public abstract void Rz(String paramString);
  
  public abstract void X(au paramau);
  
  public abstract int a(ae paramae, String paramString);
  
  public abstract int a(ae paramae, String paramString, boolean paramBoolean);
  
  public abstract Cursor a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean);
  
  public abstract Cursor a(ArrayList<String> paramArrayList, String paramString1, List<String> paramList, String paramString2);
  
  public abstract b a(e parame);
  
  public abstract void a(d paramd);
  
  public abstract void a(ae paramae, int paramInt1, int paramInt2);
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, Looper paramLooper);
  
  public abstract void a(b paramb);
  
  public abstract void aw(LinkedList<String> paramLinkedList);
  
  public abstract String az(int paramInt, String paramString);
  
  public abstract Cursor b(String paramString1, List<String> paramList, boolean paramBoolean, String paramString2);
  
  public abstract void b(a parama);
  
  public abstract boolean b(String paramString, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract int bLA();
  
  public abstract String bLB();
  
  public abstract Cursor bLC();
  
  public abstract ae bLD();
  
  public abstract boolean bLs();
  
  public abstract boolean bLt();
  
  public abstract HashMap<String, Long> bLu();
  
  public abstract void bLv();
  
  public abstract List<String> bLx();
  
  public abstract List<String> bLy();
  
  public abstract Cursor bLz();
  
  public abstract Cursor c(String paramString1, List<String> paramList, String paramString2);
  
  public abstract void c(a parama);
  
  public abstract Cursor cG(String paramString, int paramInt);
  
  public abstract long d(ae paramae);
  
  public abstract void e(String[] paramArrayOfString, String paramString);
  
  public abstract Cursor eK(String paramString1, String paramString2);
  
  public abstract boolean f(ae paramae);
  
  public abstract int fM(String paramString);
  
  public abstract boolean g(ae paramae);
  
  public abstract Cursor j(List<String> paramList, int paramInt);
  
  public abstract b oG();
  
  public abstract Cursor p(String paramString, List<String> paramList);
  
  public abstract Cursor q(String paramString, List<String> paramList);
  
  public abstract boolean wR(String paramString);
  
  public static abstract interface a
  {
    public abstract void a(ae paramae, as paramas);
  }
  
  public static abstract interface b
  {
    public abstract String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext);
    
    public abstract void a(au paramau, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */