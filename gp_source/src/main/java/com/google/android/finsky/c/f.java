package com.google.android.finsky.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnTouchListener;
import com.android.volley.r;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.dp.a;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.ds.a.df;
import com.google.android.finsky.ds.a.e;
import com.google.android.finsky.ds.a.ix;
import com.google.android.finsky.ds.a.kd;
import com.google.android.finsky.ds.a.lb;
import com.google.android.finsky.ds.a.mc;
import com.google.android.finsky.ds.a.nb;
import com.google.android.finsky.utils.FinskyLog;
import java.util.List;

public final class f
{
  public final i a;
  public final com.google.android.finsky.bw.k b;
  public final com.google.android.finsky.e.i c;
  public final a d;
  public final r e;
  
  public f(i parami, com.google.android.finsky.bw.k paramk, com.google.android.finsky.e.i parami1, a parama, r paramr)
  {
    this.a = parami;
    this.b = paramk;
    this.c = parami1;
    this.d = parama;
    this.e = paramr;
  }
  
  public static CharSequence a(Document paramDocument)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    if (!paramDocument.cW())
    {
      if (!paramDocument.cX())
      {
        if (!paramDocument.cT())
        {
          if (paramDocument.bo()) {
            return paramDocument.bp().a;
          }
          if (paramDocument.bq())
          {
            if (paramDocument.bq()) {
              localObject1 = paramDocument.bA().ap;
            }
            return ((ix)localObject1).a;
          }
          return "";
        }
        localObject1 = localObject2;
        if (paramDocument.cT()) {
          localObject1 = paramDocument.bA().aI;
        }
        return ((nb)localObject1).a;
      }
      localObject1 = localObject3;
      if (paramDocument.cX()) {
        localObject1 = paramDocument.bA().v;
      }
      return ((df)localObject1).a;
    }
    localObject1 = localObject4;
    if (paramDocument.cW()) {
      localObject1 = paramDocument.bA().a;
    }
    return ((e)localObject1).a;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRecentTasks(2, 0);
      if (!localList.isEmpty())
      {
        String str2 = ((RecentTaskInfo)localList.get(0)).baseIntent.getComponent().getPackageName();
        String str1 = str2;
        if (paramContext.getPackageName().equals(str2))
        {
          str1 = str2;
          if (localList.size() > 1) {
            str1 = ((RecentTaskInfo)localList.get(1)).baseIntent.getComponent().getPackageName();
          }
        }
        return str1;
      }
    }
    catch (Exception paramContext)
    {
      FinskyLog.a(paramContext, "Exception while getting package.", new Object[0]);
    }
    return null;
  }
  
  public final OnTouchListener a()
  {
    return new k(this.a.d);
  }
  
  public final void a(Context paramContext, Document paramDocument, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramDocument != null) && (paramDocument.br()))
    {
      Object localObject3 = paramDocument.bA();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((mc)localObject3).ax;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((lb)localObject3).a;
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        FinskyLog.d("Empty ad click URL for docid: %s", new Object[] { paramDocument.a.s });
      }
    }
    else
    {
      return;
    }
    paramInt1 = this.b.a(paramContext, paramInt1);
    paramInt2 = this.b.a(paramContext, paramInt2);
    localObject2 = new StringBuilder(23);
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("x");
    ((StringBuilder)localObject2).append(paramInt2);
    localObject2 = ((StringBuilder)localObject2).toString();
    this.d.a(paramContext, new g(this, paramContext, paramDocument, (String)localObject1, paramString, (String)localObject2));
  }
  
  public final void a(View paramView)
  {
    paramView.setOnTouchListener(a());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */