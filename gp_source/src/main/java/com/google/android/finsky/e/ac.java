package com.google.android.finsky.e;

import android.content.Context;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.ao.a;
import com.google.android.finsky.ao.b;
import com.google.android.finsky.bo.c;
import com.google.android.finsky.cy.e;
import com.google.wireless.android.a.b.a.a.bg;
import com.google.wireless.android.a.b.a.a.s;

public final class ac
{
  public boolean a;
  public boolean b;
  private final Context c;
  private final com.google.android.finsky.volley.d d;
  private final c e;
  
  public ac(com.google.android.finsky.volley.d paramd, c paramc, Context paramContext)
  {
    this.d = paramd;
    this.e = paramc;
    this.c = paramContext;
  }
  
  private final af a(af paramaf, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    Object localObject = paramaf;
    if ((this.b ^ true))
    {
      localObject = new d(paramInt1);
      if (paramInt2 != -1) {
        ((d)localObject).e(paramInt2);
      }
      if (paramString != null) {
        break label283;
      }
    }
    for (;;)
    {
      ((d)localObject).f(c());
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1 != null))
      {
        paramString = ((d)localObject).a;
        if (paramArrayOfByte1 == null) {
          break;
        }
        paramString.l |= 0x10000000;
        paramString.aC = paramArrayOfByte1;
      }
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2 != null))
      {
        paramString = ((d)localObject).a;
        if (paramArrayOfByte2 == null) {
          break label302;
        }
        paramString.l |= 0x20000000;
        paramString.az = paramArrayOfByte2;
      }
      if (paramBoolean)
      {
        paramString = ((d)localObject).a;
        paramString.l |= 0x80000000;
        paramString.S = paramBoolean;
      }
      if (this.e.cY().a(12627544L))
      {
        paramString = new s();
        paramString.a(((Integer)b.l.a()).intValue());
        paramString.a(((Long)b.p.a()).longValue());
        if (this.d.cZ() != null) {
          paramString.a(a.a(this.d.cZ()));
        }
        ((d)localObject).a(paramString);
      }
      localObject = paramaf.a(((d)localObject).a, null);
      return (af)localObject;
      label283:
      ((d)localObject).b(paramString);
    }
    throw new NullPointerException();
    label302:
    throw new NullPointerException();
  }
  
  private final d b()
  {
    return new d(640).f(c());
  }
  
  private final int c()
  {
    switch (com.google.android.play.utils.f.a(e.a(this.c)))
    {
    default: 
      return 0;
    case 8: 
      return 1;
    case 7: 
      return 8;
    case 6: 
      return 2;
    case 5: 
      return 7;
    case 4: 
      return 3;
    case 3: 
      return 6;
    case 2: 
      return 5;
    }
    return 4;
  }
  
  public final af a(af paramaf, int paramInt)
  {
    return a(paramaf, paramInt, -1, null);
  }
  
  public final af a(af paramaf, int paramInt1, int paramInt2)
  {
    return a(paramaf, paramInt1, paramInt2, null);
  }
  
  public final af a(af paramaf, int paramInt1, int paramInt2, String paramString)
  {
    return a(paramaf, paramInt1, paramInt2, paramString, null, null, false);
  }
  
  public final af a(af paramaf, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    return a(paramaf, paramInt1, paramInt2, null, paramArrayOfByte1, paramArrayOfByte2, paramBoolean);
  }
  
  public final af a(af paramaf, String paramString)
  {
    return paramaf.a(b().b(paramString));
  }
  
  public final void a()
  {
    if ((this.e.cY().a(12627947L)) && (this.a)) {
      this.b = true;
    }
  }
  
  public final af b(af paramaf, String paramString)
  {
    d locald = b();
    paramString = String.valueOf(paramString);
    String str = String.valueOf("_started");
    if (str.length() == 0) {}
    for (paramString = new String(paramString);; paramString = paramString.concat(str)) {
      return paramaf.a(locald.b(paramString).a, null);
    }
  }
  
  public final af c(af paramaf, String paramString)
  {
    d locald = b();
    paramString = String.valueOf(paramString);
    String str = String.valueOf("_finished");
    if (str.length() == 0) {}
    for (paramString = new String(paramString);; paramString = paramString.concat(str)) {
      return paramaf.a(locald.b(paramString).a, null);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */