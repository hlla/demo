package com.tencent.mm.plugin.w.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import java.util.LinkedList;

public abstract interface a
{
  public abstract f Cj(String paramString);
  
  public abstract void Ck(String paramString);
  
  public abstract void Z(LinkedList<String> paramLinkedList);
  
  public abstract Bitmap a(String paramString, int paramInt, float paramFloat);
  
  public abstract i aRm();
  
  public abstract Cursor aRn();
  
  public abstract void bv(String paramString, int paramInt);
  
  public abstract void c(f paramf);
  
  public abstract Cursor cG(int paramInt1, int paramInt2);
  
  public abstract void d(f paramf);
  
  public abstract void e(f paramf);
  
  public abstract Cursor m(int[] paramArrayOfInt);
  
  public abstract Cursor qP(int paramInt);
  
  public static final class a
  {
    private static a odM;
    
    static
    {
      GMTrace.i(18733842038784L, 139578);
      odM = null;
      GMTrace.o(18733842038784L, 139578);
    }
    
    public static void a(a parama)
    {
      GMTrace.i(18733573603328L, 139576);
      odM = parama;
      GMTrace.o(18733573603328L, 139576);
    }
    
    public static a aRo()
    {
      GMTrace.i(18733707821056L, 139577);
      a locala = odM;
      GMTrace.o(18733707821056L, 139577);
      return locala;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/w/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */