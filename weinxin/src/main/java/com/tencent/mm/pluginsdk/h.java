package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;

@Deprecated
public abstract interface h
{
  public abstract Bitmap a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract k a(f paramf);
  
  public abstract void a(Context paramContext, au.a parama, Bundle paramBundle);
  
  public abstract void a(Context paramContext, x paramx, au.a parama, Bundle paramBundle, String paramString);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong);
  
  public abstract void a(Intent paramIntent, String paramString);
  
  public abstract void a(amb paramamb, String paramString);
  
  public abstract boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean a(x paramx);
  
  public abstract void ah(Context paramContext);
  
  public abstract k am(boolean paramBoolean);
  
  public abstract boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract String bm(String paramString);
  
  public abstract boolean bn(String paramString);
  
  public abstract boolean bo(String paramString);
  
  public abstract void bp(String paramString);
  
  public abstract boolean c(Activity paramActivity);
  
  public abstract void cT(int paramInt);
  
  public abstract void d(Activity paramActivity);
  
  public abstract String e(Context paramContext, String paramString1, String paramString2);
  
  public abstract String i(String paramString, int paramInt);
  
  public abstract String m(Context paramContext, String paramString);
  
  public abstract boolean n(Context paramContext, String paramString);
  
  public abstract void oA();
  
  public abstract boolean oB();
  
  public abstract void ou();
  
  public abstract void ow();
  
  public abstract void ox();
  
  public abstract Intent oy();
  
  public abstract boolean oz();
  
  public abstract String s(String paramString1, String paramString2);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */