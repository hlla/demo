package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public final class cg
{
  public ArrayList a = new ArrayList();
  public String b;
  public String c;
  public int d = 0;
  public PendingIntent e;
  public CharSequence f;
  public CharSequence g;
  public Context h;
  public Bundle i;
  public String j;
  public boolean k;
  public ArrayList l = new ArrayList();
  public Bitmap m;
  public boolean n = false;
  public Notification o = new Notification();
  public int p;
  @Deprecated
  public ArrayList q;
  public int r;
  public int s;
  public boolean t;
  public int u;
  public boolean v = true;
  private ci w;
  
  @Deprecated
  public cg(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public cg(Context paramContext, String paramString)
  {
    this.h = paramContext;
    this.c = paramString;
    this.o.when = System.currentTimeMillis();
    this.o.audioStreamType = -1;
    this.r = 0;
    this.q = new ArrayList();
  }
  
  protected static CharSequence d(CharSequence paramCharSequence)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence != null)
    {
      localCharSequence = paramCharSequence;
      if (paramCharSequence.length() > 5120) {
        localCharSequence = paramCharSequence.subSequence(0, 5120);
      }
    }
    return localCharSequence;
  }
  
  public final Bundle a()
  {
    if (this.i == null) {
      this.i = new Bundle();
    }
    return this.i;
  }
  
  public final cg a(int paramInt)
  {
    this.o.icon = paramInt;
    return this;
  }
  
  public final cg a(int paramInt1, int paramInt2)
  {
    this.u = paramInt1;
    this.s = paramInt2;
    this.t = true;
    return this;
  }
  
  public final cg a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this.a.add(new cd(paramInt, paramCharSequence, paramPendingIntent));
    return this;
  }
  
  public final cg a(long paramLong)
  {
    this.o.when = paramLong;
    return this;
  }
  
  public final cg a(PendingIntent paramPendingIntent)
  {
    this.o.deleteIntent = paramPendingIntent;
    return this;
  }
  
  public final cg a(Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = paramBitmap;
      if (Build.VERSION.SDK_INT < 27)
      {
        localObject = this.h.getResources();
        int i1 = ((Resources)localObject).getDimensionPixelSize(2131165398);
        int i2 = ((Resources)localObject).getDimensionPixelSize(2131165397);
        if (paramBitmap.getWidth() <= i1)
        {
          localObject = paramBitmap;
          if (paramBitmap.getHeight() <= i2) {}
        }
        else
        {
          double d1 = Math.min(i1 / Math.max(1, paramBitmap.getWidth()), i2 / Math.max(1, paramBitmap.getHeight()));
          localObject = Bitmap.createScaledBitmap(paramBitmap, (int)Math.ceil(paramBitmap.getWidth() * d1), (int)Math.ceil(d1 * paramBitmap.getHeight()), true);
        }
      }
    }
    this.m = ((Bitmap)localObject);
    return this;
  }
  
  public final cg a(cd paramcd)
  {
    this.a.add(paramcd);
    return this;
  }
  
  public final cg a(ch paramch)
  {
    paramch.a(this);
    return this;
  }
  
  public final cg a(ci paramci)
  {
    if (this.w != paramci)
    {
      this.w = paramci;
      paramci = this.w;
      if ((paramci != null) && (paramci.b != this))
      {
        paramci.b = this;
        cg localcg = paramci.b;
        if (localcg != null) {
          localcg.a(paramci);
        }
      }
    }
    return this;
  }
  
  public final cg a(CharSequence paramCharSequence)
  {
    this.g = d(paramCharSequence);
    return this;
  }
  
  public final cg a(boolean paramBoolean)
  {
    a(16, paramBoolean);
    return this;
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localNotification = this.o;
      localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
      return;
    }
    Notification localNotification = this.o;
    localNotification.flags |= paramInt;
  }
  
  public final Notification b()
  {
    Object localObject2 = new ck(this);
    ci localci = ((ck)localObject2).c.w;
    if (localci != null) {
      localci.a((cb)localObject2);
    }
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 26) {
      localObject1 = ((ck)localObject2).b.build();
    }
    for (;;)
    {
      if ((Build.VERSION.SDK_INT >= 16) && (localci != null)) {
        cc.a((Notification)localObject1);
      }
      return (Notification)localObject1;
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject1 = ((ck)localObject2).b.build();
      }
      else if (Build.VERSION.SDK_INT >= 21)
      {
        ((ck)localObject2).b.setExtras(((ck)localObject2).d);
        localObject1 = ((ck)localObject2).b.build();
      }
      else if (Build.VERSION.SDK_INT >= 20)
      {
        ((ck)localObject2).b.setExtras(((ck)localObject2).d);
        localObject1 = ((ck)localObject2).b.build();
      }
      else if (Build.VERSION.SDK_INT >= 19)
      {
        localObject1 = cl.a(((ck)localObject2).a);
        if (localObject1 != null) {
          ((ck)localObject2).d.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
        }
        ((ck)localObject2).b.setExtras(((ck)localObject2).d);
        localObject1 = ((ck)localObject2).b.build();
      }
      else
      {
        localObject1 = ((ck)localObject2).b.build();
        Bundle localBundle1 = cc.a((Notification)localObject1);
        Bundle localBundle2 = new Bundle(((ck)localObject2).d);
        Iterator localIterator = ((ck)localObject2).d.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (localBundle1.containsKey(str)) {
            localBundle2.remove(str);
          }
        }
        localBundle1.putAll(localBundle2);
        localObject2 = cl.a(((ck)localObject2).a);
        if (localObject2 != null) {
          cc.a((Notification)localObject1).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject2);
        }
      }
    }
  }
  
  public final cg b(CharSequence paramCharSequence)
  {
    this.f = d(paramCharSequence);
    return this;
  }
  
  public final cg c(CharSequence paramCharSequence)
  {
    this.o.tickerText = d(paramCharSequence);
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */