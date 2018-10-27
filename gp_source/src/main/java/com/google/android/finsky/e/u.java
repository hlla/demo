package com.google.android.finsky.e;

import android.accounts.Account;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.android.finsky.api.ab;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.i;
import com.google.android.play.b.l;
import com.google.android.play.b.m;
import com.google.android.play.b.r;
import com.google.android.volley.DisplayMessageError;
import com.google.wireless.android.a.b.a.a.bg;
import com.google.wireless.android.a.b.a.a.bh;
import com.google.wireless.android.a.b.a.a.bj;
import com.google.wireless.android.a.b.a.a.bm;
import com.google.wireless.android.a.b.a.a.bo;
import com.google.wireless.android.a.b.a.a.bp;
import com.google.wireless.android.a.b.a.a.bt;
import com.google.wireless.android.a.b.a.a.bu;
import com.google.wireless.android.a.b.a.a.bv;
import com.google.wireless.android.a.b.a.a.bz;
import com.google.wireless.android.a.b.a.a.cc;
import com.google.wireless.android.a.b.a.a.ch;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class u
  implements com.google.android.play.b.b, com.google.android.play.b.n
{
  private static final int[] f;
  private static final int[] g;
  private static final int[] h = { 1700, 1701, 19 };
  private static final String[] i = { "", "1", "", "3", "4", "5", "6", "7", "8" };
  private static boolean v;
  private static boolean w;
  private static Boolean x;
  private static long y;
  private boolean A = false;
  private boolean B;
  private boolean C = false;
  private boolean D = true;
  private boolean E = false;
  public com.google.android.finsky.adid.a a;
  public com.google.android.finsky.bo.c b;
  public aa c;
  public ad d;
  public al e;
  private final String j;
  private final List k = new ArrayList();
  private final Object l = new Object();
  private final h m;
  private final int[] n = new int[9];
  private final com.google.android.finsky.bo.f o;
  private final ak p;
  private final com.google.android.play.b.a q;
  private final an r;
  private final ao s;
  private final com.google.android.play.b.q t;
  private final j u;
  private final boolean z;
  
  static
  {
    f = new int[] { 538 };
    g = new int[] { 1112, 1111, 1102, 6 };
    w = false;
  }
  
  public u(Context paramContext, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, an paraman, ao paramao, ap paramap)
  {
    ((b)com.google.android.finsky.dt.b.a(b.class)).a(this);
    if (paramAccount != null) {}
    for (Object localObject = paramAccount.name;; localObject = null)
    {
      this.j = ((String)localObject);
      this.o = this.b.h(this.j);
      this.p = ak.a();
      this.z = paramBoolean2;
      this.r = paraman;
      this.s = paramao;
      if (!((Boolean)com.google.android.finsky.ag.d.cD.b()).booleanValue()) {
        paramAccount = null;
      }
      for (;;)
      {
        this.q = paramAccount;
        this.u = j.d;
        this.t = com.google.android.play.b.q.a();
        this.m = h.a(paramContext);
        if (this.o.a(12603408L)) {
          this.A = true;
        }
        if (this.o.a(12602374L))
        {
          this.E = true;
          this.C = true;
        }
        while (!this.o.a(12604366L)) {
          return;
        }
        this.C = true;
        return;
        if (paramAccount != null) {}
        label723:
        while (paramBoolean1)
        {
          localObject = this.e;
          if (paramAccount != null) {}
          for (paraman = paramAccount.name;; paraman = null)
          {
            com.google.android.finsky.bo.f localf = ((al)localObject).e.h(paraman);
            paramBoolean1 = localf.a(12627477L);
            boolean bool = localf.a(12648202L);
            l locall = new l();
            locall.o = ((Long)com.google.android.finsky.ag.d.gQ.b()).longValue();
            locall.q = ((Long)com.google.android.finsky.ag.d.gS.b()).longValue();
            locall.b = ((Long)com.google.android.finsky.ag.d.gO.b()).longValue();
            locall.p = ((Long)com.google.android.finsky.ag.d.gR.b()).longValue();
            locall.m = paramap.a();
            locall.n = paramap.b();
            locall.l = ((Integer)com.google.android.finsky.ag.d.hf.b()).intValue();
            locall.a = ((Boolean)com.google.android.finsky.ag.d.gM.b()).booleanValue();
            locall.g = ((Long)com.google.android.finsky.ag.d.dh.b()).longValue();
            locall.k = true;
            if (paramBoolean2) {
              locall.c = "safe_mode_logs";
            }
            paramap = ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperator();
            paramao = m.a;
            paraman = paramao;
            if (localf.a(12608094L))
            {
              paraman = paramao;
              if (((al)localObject).c.a(paramAccount)) {
                paraman = m.c;
              }
            }
            locall.f = localf.a(12619566L);
            locall.e = localf.a(12619745L);
            if (paramBoolean1) {
              locall.d = ((Long)com.google.android.finsky.ag.d.gN.b()).longValue();
            }
            locall.j = true;
            locall.h = true;
            locall.i = true;
            paramao = ab.b(paramContext);
            paramAccount = new com.google.android.play.b.g(paramContext, com.google.android.finsky.r.c.a(paramAccount, localf, 12604382L), paraman, paramao, ((Long)com.google.android.finsky.ag.d.a().b()).longValue(), Integer.toString(((al)localObject).f), paramap, locall, paramAccount);
            paramAccount.a = true;
            paramAccount.a(this);
            paramAccount.b = ((al)localObject).b;
            if (((al)localObject).d.c)
            {
              paraman = com.google.android.finsky.fg.a.a(paramContext);
              if (!paraman.b()) {
                break label723;
              }
              paramAccount.g = com.google.android.play.b.o.a;
            }
            for (;;)
            {
              if (!bool) {}
              for (;;)
              {
                paramAccount.a(this);
                break;
                paramAccount.h = ((al)localObject).a;
              }
              if (paraman.c()) {
                paramAccount.g = com.google.android.play.b.o.b;
              }
            }
          }
        }
        paramAccount = null;
      }
    }
  }
  
  public static int a(VolleyError paramVolleyError)
  {
    if (paramVolleyError != null)
    {
      if (!(paramVolleyError instanceof TimeoutError))
      {
        if ((paramVolleyError instanceof NetworkError))
        {
          if (!(paramVolleyError instanceof NoConnectionError)) {
            return 2;
          }
          return 6;
        }
        if (!(paramVolleyError instanceof ParseError))
        {
          if (!(paramVolleyError instanceof AuthFailureError))
          {
            if (!(paramVolleyError instanceof ServerError))
            {
              if (!(paramVolleyError instanceof DisplayMessageError)) {
                return 0;
              }
              return 7;
            }
            return 5;
          }
          return 4;
        }
        return 3;
      }
      return 1;
    }
    return 8;
  }
  
  private static int a(bt parambt, int[] paramArrayOfInt)
  {
    parambt = parambt.b;
    int i4 = parambt.length;
    int i2 = 0;
    int i1 = 0;
    if (i2 < i4)
    {
      bt localbt = parambt[i2];
      paramArrayOfInt[0] += 1;
      int i3 = a(localbt, paramArrayOfInt) + 1;
      if (i3 > i1) {
        i1 = i3;
      }
      for (;;)
      {
        i2 += 1;
        break;
      }
    }
    return i1;
  }
  
  public static bp a(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean1, VolleyError paramVolleyError, NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2, int paramInt3, int paramInt4, boolean paramBoolean2, int paramInt5, Boolean paramBoolean, int paramInt6, String paramString2, long paramLong5)
  {
    int i1 = a(paramVolleyError);
    paramVolleyError = new bp();
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      if (paramLong1 >= 0L)
      {
        paramVolleyError.c |= 0x2;
        paramVolleyError.h = paramLong1;
      }
      if (paramLong2 >= 0L)
      {
        paramVolleyError.c |= 0x4;
        paramVolleyError.o = paramLong2;
      }
      if (paramLong3 >= 0L)
      {
        paramVolleyError.c |= 0x10000;
        paramVolleyError.r = paramLong3;
      }
      if (paramLong4 >= 0L)
      {
        paramVolleyError.c |= 0x20000;
        paramVolleyError.n = paramLong4;
      }
      if (paramInt1 >= 0)
      {
        paramVolleyError.c |= 0x8;
        paramVolleyError.k = paramInt1;
      }
      if (paramInt2 >= 0)
      {
        paramVolleyError.c |= 0x10;
        paramVolleyError.q = paramInt2;
      }
      if (paramFloat <= 0.0F) {}
      for (;;)
      {
        paramVolleyError.c |= 0x40;
        paramVolleyError.u = paramBoolean1;
        if (!paramBoolean1) {
          paramVolleyError.a(i1);
        }
        switch (com.google.android.play.utils.f.a(paramNetworkInfo1))
        {
        default: 
          paramInt1 = 0;
        }
        for (;;)
        {
          paramVolleyError.p = paramInt1;
          paramVolleyError.c |= 0x80;
          switch (com.google.android.play.utils.f.a(paramNetworkInfo2))
          {
          default: 
            paramInt1 = 0;
          }
          for (;;)
          {
            paramVolleyError.i = paramInt1;
            paramVolleyError.c |= 0x100;
            if (paramInt3 >= 0)
            {
              paramVolleyError.c |= 0x8000;
              paramVolleyError.l = paramInt3;
            }
            if (paramInt4 < 0) {}
            for (;;)
            {
              paramVolleyError.c |= 0x800;
              paramVolleyError.g = paramBoolean2;
              if (paramBoolean != null)
              {
                paramBoolean1 = paramBoolean.booleanValue();
                paramVolleyError.c |= 0x1000;
                paramVolleyError.a = paramBoolean1;
              }
              if (paramInt5 != 0)
              {
                paramVolleyError.f = paramInt5;
                paramVolleyError.c |= 0x4000;
              }
              if (paramInt6 != 0)
              {
                paramVolleyError.e = paramInt6;
                paramVolleyError.c |= 0x40000;
              }
              if (TextUtils.isEmpty(paramString2)) {}
              for (;;)
              {
                if (paramLong5 >= 0L)
                {
                  paramVolleyError.c |= 0x100000;
                  paramVolleyError.d = paramLong5;
                }
                return paramVolleyError;
                if (paramString2 == null) {
                  break;
                }
                paramVolleyError.c |= 0x80000;
                paramVolleyError.j = paramString2;
              }
              paramVolleyError.c |= 0x200;
              paramVolleyError.m = paramInt4;
            }
            paramInt1 = 4;
            continue;
            paramInt1 = 1;
            continue;
            paramInt1 = 8;
            continue;
            paramInt1 = 2;
            continue;
            paramInt1 = 7;
            continue;
            paramInt1 = 3;
            continue;
            paramInt1 = 6;
            continue;
            paramInt1 = 5;
          }
          paramInt1 = 4;
          continue;
          paramInt1 = 1;
          continue;
          paramInt1 = 8;
          continue;
          paramInt1 = 2;
          continue;
          paramInt1 = 7;
          continue;
          paramInt1 = 3;
          continue;
          paramInt1 = 6;
          continue;
          paramInt1 = 5;
        }
        paramVolleyError.c |= 0x20;
        paramVolleyError.b = paramFloat;
      }
      if (paramString1 == null) {
        break label755;
      }
      paramVolleyError.c |= 0x1;
      paramVolleyError.s = paramString1;
    }
    throw new NullPointerException();
    label755:
    throw new NullPointerException();
  }
  
  public static bt a(int paramInt)
  {
    bt localbt = j.d.c();
    localbt.b(paramInt);
    return localbt;
  }
  
  public static bt a(bt parambt)
  {
    bt localbt = a(0);
    c(parambt, localbt);
    return localbt;
  }
  
  public static bt a(bt parambt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      parambt.a(paramArrayOfByte);
    }
    return parambt;
  }
  
  public static bt a(List paramList)
  {
    Object localObject = a((bt)paramList.get(0));
    int i1 = 1;
    while (i1 < paramList.size())
    {
      bt localbt = a((bt)paramList.get(i1));
      localbt.b = ((bt[])a(localbt.b, localObject));
      i1 += 1;
      localObject = localbt;
    }
    return (bt)localObject;
  }
  
  private final void a(int paramInt, bo parambo, long paramLong, com.google.android.play.b.a.p paramp)
  {
    String str = i[paramInt];
    try
    {
      byte[] arrayOfByte = com.google.protobuf.nano.g.a(parambo);
      m();
      com.google.android.play.b.p localp;
      if (this.q != null)
      {
        localp = (com.google.android.play.b.p)this.t.d.a();
        localp.e = paramp;
        if (paramLong == -1L) {
          break label135;
        }
      }
      label135:
      for (paramp = Long.valueOf(paramLong);; paramp = null)
      {
        localp.d = paramp;
        localp.a = this.d.a(this.j);
        localp.c = str;
        localp.b = arrayOfByte;
        this.q.a(localp);
        this.u.a(parambo);
        parambo = this.t;
        localp.a();
        parambo.d.a(localp);
        return;
      }
      return;
    }
    catch (Exception parambo)
    {
      a(parambo);
    }
  }
  
  public static void a(Handler paramHandler, long paramLong, aq paramaq1, aq paramaq2, af paramaf)
  {
    if ((paramaq2 == null) || (paramaq2.getPlayStoreUiElement() == null)) {
      throw new IllegalArgumentException("null child node or element");
    }
    bt localbt = paramaq1.getPlayStoreUiElement();
    if (paramaq2 != null) {
      a(paramaq1, paramaq2.getPlayStoreUiElement());
    }
    if (k()) {
      a("Collecting", localbt);
    }
    if (k()) {
      a("Collecting", 0L, localbt, null);
    }
    paramHandler.removeCallbacksAndMessages(null);
    paramHandler.postDelayed(new v(paramaf, paramLong, paramaq1), ((Long)com.google.android.finsky.ag.d.gP.b()).longValue());
  }
  
  public static void a(Handler paramHandler, long paramLong, av paramav, af paramaf)
  {
    bt localbt = paramav.getPlayStoreUiElement();
    if (k()) {
      a("Flushing", localbt);
    }
    if (k()) {
      a("Flushing", 0L, localbt, null);
    }
    paramHandler.removeCallbacksAndMessages(null);
    paramHandler = localbt.b;
    if ((paramHandler != null) && (paramHandler.length != 0)) {
      paramaf.a(new z().a(paramLong).a(paramav).a(), null);
    }
  }
  
  public static void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null) {
      b(paramViewGroup);
    }
  }
  
  public static void a(com.google.android.finsky.bw.ap paramap)
  {
    if ((paramap instanceof ViewGroup)) {
      b((ViewGroup)paramap);
    }
  }
  
  public static void a(aq paramaq1, aq paramaq2)
  {
    paramaq2 = paramaq2.getPlayStoreUiElement();
    if (paramaq2 == null) {
      throw new IllegalArgumentException("childNode has null element");
    }
    if ((a(paramaq1, paramaq2)) && (paramaq2.b.length == 0)) {
      if (k()) {
        FinskyLog.a("Skip reporting existing leaf node type=%d", new Object[] { Integer.valueOf(paramaq2.e) });
      }
    }
    while (paramaq1.getParentNode() == null) {
      return;
    }
    paramaq1.getParentNode().a(paramaq1);
  }
  
  static void a(bh parambh)
  {
    int i1 = 0;
    if ((k()) && (k()))
    {
      FinskyLog.a("Sending click event:", new Object[0]);
      bt[] arrayOfbt = parambh.a;
      int i2 = arrayOfbt.length;
      parambh = "";
      while (i1 < i2)
      {
        a(arrayOfbt[i1], parambh);
        parambh = String.valueOf(parambh).concat("  ");
        i1 += 1;
      }
    }
  }
  
  private static void a(bt parambt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder(str);
    paramString.append("type=");
    paramString.append(parambt.e);
    a(paramString, parambt.d);
    FinskyLog.a("%s", new Object[] { paramString });
  }
  
  private static void a(String paramString1, long paramLong, bt parambt, String paramString2)
  {
    int i1 = 0;
    if (k())
    {
      if (paramString1 != null) {
        FinskyLog.a("%s impression tree, id=%x", new Object[] { paramString1, Long.valueOf(paramLong) });
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      a(parambt, paramString1);
      paramString1 = String.valueOf(paramString1).concat("  ");
      parambt = parambt.b;
      int i2 = parambt.length;
      while (i1 < i2)
      {
        a(null, 0L, parambt[i1], paramString1);
        i1 += 1;
      }
    }
  }
  
  private static void a(String paramString, bt parambt)
  {
    if (k())
    {
      int i1 = parambt.e;
      int i2 = parambt.b.length;
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 0;
      int i3 = a(parambt, arrayOfInt);
      FinskyLog.a("%s impression at root. Type=%d top children=%d total children=%d depth=%d", new Object[] { paramString, Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(arrayOfInt[0]), Integer.valueOf(i3) });
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      int i1 = paramArrayOfByte.length;
      paramStringBuilder.append(" s.cookie[");
      paramStringBuilder.append(i1);
      paramStringBuilder.append("]={ ");
      paramStringBuilder.append(Base64.encodeToString(paramArrayOfByte, 10));
      paramStringBuilder.append(" }");
      return;
    }
    paramStringBuilder.append(" (no s-cookie)");
  }
  
  public static void a(boolean paramBoolean)
  {
    v = paramBoolean;
  }
  
  public static boolean a(aq paramaq, bt parambt)
  {
    paramaq = paramaq.getPlayStoreUiElement();
    bt[] arrayOfbt = paramaq.b;
    int i2 = arrayOfbt.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label68;
      }
      if (d(parambt, arrayOfbt[i1])) {
        break;
      }
      i1 += 1;
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        paramaq.b = ((bt[])a(paramaq.b, parambt));
      }
      return bool;
    }
  }
  
  public static boolean a(bt parambt1, bt parambt2)
  {
    boolean bool2 = false;
    bt[] arrayOfbt = parambt1.b;
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= arrayOfbt.length) {
        return bool1;
      }
      if (d(arrayOfbt[i1], parambt2)) {
        break;
      }
      i1 += 1;
    }
    parambt1.b = ((bt[])com.google.android.finsky.utils.b.a(arrayOfbt, i1));
    boolean bool1 = true;
    return bool1;
  }
  
  public static Object[] a(Object[] paramArrayOfObject, Object paramObject)
  {
    if (paramObject != null)
    {
      Object localObject = paramObject.getClass();
      int i1 = paramArrayOfObject.length;
      localObject = (Object[])Array.newInstance((Class)localObject, i1 + 1);
      System.arraycopy(paramArrayOfObject, 0, localObject, 0, i1);
      localObject[(localObject.length - 1)] = paramObject;
      return (Object[])localObject;
    }
    FinskyLog.e("Adding null to element array.", new Object[0]);
    return paramArrayOfObject;
  }
  
  private static void b(ViewGroup paramViewGroup)
  {
    int i2 = paramViewGroup.getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = paramViewGroup.getChildAt(i1);
      if (!(localView instanceof ViewGroup)) {}
      for (;;)
      {
        i1 += 1;
        break;
        b((ViewGroup)localView);
      }
    }
    if ((paramViewGroup instanceof aq)) {
      d((aq)paramViewGroup);
    }
    do
    {
      do
      {
        return;
        if (!(paramViewGroup instanceof com.google.android.play.layout.d)) {
          break;
        }
        paramViewGroup = (aq)((com.google.android.play.layout.d)paramViewGroup).getLoggingData();
      } while (paramViewGroup == null);
      d(paramViewGroup);
      return;
    } while (!(paramViewGroup.getTag() instanceof aq));
    d((aq)paramViewGroup.getTag());
  }
  
  public static void b(aq paramaq)
  {
    while (paramaq != null)
    {
      if ((paramaq instanceof av))
      {
        ((av)paramaq).m();
        return;
      }
      paramaq = paramaq.getParentNode();
    }
    FinskyLog.b("No RootUiElementNode found in parent chain", new Object[0]);
  }
  
  static void b(bt parambt1, bt parambt2)
  {
    c(parambt1, parambt2);
    bt[] arrayOfbt = parambt1.b;
    int i2 = arrayOfbt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      bt localbt1 = arrayOfbt[i1];
      bt localbt2 = a(0);
      b(localbt1, localbt2);
      parambt2.b = ((bt[])a(parambt2.b, localbt2));
      i1 += 1;
    }
    parambt1.b = bt.a;
  }
  
  private final void b(boolean paramBoolean)
  {
    try
    {
      this.B = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static bg c()
  {
    return (bg)j.d.a.a();
  }
  
  public static void c(aq paramaq)
  {
    aq localaq2 = paramaq.getParentNode();
    aq localaq1 = paramaq;
    for (paramaq = localaq2; paramaq != null; paramaq = localaq2)
    {
      localaq2 = paramaq.getParentNode();
      localaq1 = paramaq;
    }
    if ((localaq1 instanceof av)) {
      ((av)localaq1).p_();
    }
  }
  
  private static void c(bt parambt1, bt parambt2)
  {
    parambt2.b(parambt1.e);
    parambt2.c = parambt1.c;
    parambt2.a(parambt1.d);
  }
  
  public static bh d()
  {
    return j.d.b();
  }
  
  private static void d(aq paramaq)
  {
    if (k()) {
      FinskyLog.c("TRAVERSE: Found %s", new Object[] { paramaq.getClass().getSimpleName() });
    }
    aq localaq = paramaq.getParentNode();
    if (localaq != null) {
      localaq.a(paramaq);
    }
  }
  
  private static boolean d(bt parambt1, bt parambt2)
  {
    if (parambt1 != parambt2)
    {
      Object localObject1;
      Object localObject2;
      if ((parambt1 != null) && (parambt2 != null) && (parambt1.e == parambt2.e) && (Arrays.equals(parambt1.d, parambt2.d)))
      {
        if (!v) {
          break label304;
        }
        parambt1 = parambt1.c;
        parambt2 = parambt2.c;
        if (parambt1 == parambt2) {
          break label304;
        }
        if ((parambt1 != null) && (parambt2 != null))
        {
          localObject1 = parambt1.f;
          localObject2 = parambt2.f;
          if (localObject1 != localObject2) {
            break label272;
          }
        }
      }
      label187:
      label219:
      label240:
      label272:
      do
      {
        if ((TextUtils.equals(parambt1.e, parambt2.e)) && (parambt1.i == parambt2.i) && (parambt1.g == parambt2.g))
        {
          localObject1 = parambt1.a;
          localObject2 = parambt2.a;
          if (localObject1 != localObject2) {
            break label240;
          }
          localObject1 = parambt1.d;
          localObject2 = parambt2.d;
          if (localObject1 != localObject2) {
            break label219;
          }
          localObject1 = parambt1.j;
          localObject2 = parambt2.j;
          if (localObject1 != localObject2) {
            break label187;
          }
          if ((parambt1.c == parambt2.c) && (parambt1.h == parambt2.h)) {
            break;
          }
        }
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
              } while ((localObject1 == null) || (localObject2 == null) || (((ch)localObject1).b != ((ch)localObject2).b));
              if (((ch)localObject1).c == ((ch)localObject2).c) {
                break;
              }
              return false;
            } while ((localObject1 == null) || (localObject2 == null));
            if (((com.google.wireless.android.a.b.a.a.aa)localObject1).b == ((com.google.wireless.android.a.b.a.a.aa)localObject2).b) {
              break;
            }
            return false;
          } while ((localObject1 == null) || (localObject2 == null) || (((com.google.wireless.android.a.b.a.a.n)localObject1).b != ((com.google.wireless.android.a.b.a.a.n)localObject2).b));
          if (((com.google.wireless.android.a.b.a.a.n)localObject1).a == ((com.google.wireless.android.a.b.a.a.n)localObject2).a) {
            break;
          }
          return false;
        } while ((localObject1 == null) || (localObject2 == null) || (((bv)localObject1).a != ((bv)localObject2).a));
      } while (((bv)localObject1).b == ((bv)localObject2).b);
      return false;
      label304:
      return true;
    }
    return true;
  }
  
  public static bm e()
  {
    return (bm)j.d.b.a();
  }
  
  public static cc f()
  {
    return (cc)j.d.c.a();
  }
  
  public static long g()
  {
    if (!w)
    {
      y = i.a() ^ System.nanoTime();
      w = true;
    }
    long l1 = y + 1L;
    y = l1;
    if (l1 == 0L) {
      y += 1L;
    }
    return y;
  }
  
  private static boolean k()
  {
    if (x == null) {
      x = (Boolean)com.google.android.finsky.ag.d.bq.b();
    }
    return x.booleanValue();
  }
  
  private final boolean l()
  {
    try
    {
      boolean bool = this.B;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static void m() {}
  
  final long a(int paramInt, bo parambo, com.google.android.play.b.a.p paramp, long paramLong)
  {
    Object localObject2 = null;
    int i2 = 0;
    if (this.r.a())
    {
      if (paramLong != -1L)
      {
        parambo.c |= 0x4;
        parambo.j = paramLong;
      }
      int i1;
      if (this.j != null)
      {
        localObject1 = this.n;
        i1 = localObject1[paramInt] + 1;
        localObject1[paramInt] = i1;
        parambo.c |= 0x1;
        parambo.l = i1;
      }
      Object localObject1 = (String)com.google.android.finsky.ag.c.bI.b(this.j).a();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = Base64.decode((String)localObject1, 0);
        if (localObject1 != null)
        {
          parambo.c |= 0x10;
          parambo.m = ((byte[])localObject1);
        }
      }
      else
      {
        paramLong = this.m.a();
        parambo.c |= 0x2;
        parambo.e = paramLong;
        this.c.a = paramLong;
        if (paramp == null) {
          paramp = com.google.android.play.b.q.a().b();
        }
        for (;;)
        {
          if (this.o.a(12639027L))
          {
            localObject1 = parambo.b;
            if (localObject1 == null)
            {
              localObject1 = this.a;
              if (localObject1 != null)
              {
                localObject1 = ((com.google.android.finsky.adid.a)localObject1).c();
                label233:
                com.google.android.finsky.adid.a locala = this.a;
                if (locala != null) {
                  localObject2 = locala.d();
                }
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
              }
            }
          }
          label526:
          do
          {
            for (;;)
            {
              if ((l()) || (!this.p.b()))
              {
                parambo.f = this.p.c();
                b(false);
                this.p.a(true);
              }
              localObject1 = parambo.b;
              if ((localObject1 != null) && ((((bg)localObject1).l & 0x1) != 0))
              {
                localObject1 = h;
                i3 = localObject1.length;
                i1 = i2;
                while (i1 < i3)
                {
                  if (localObject1[i1] == parambo.b.aE)
                  {
                    this.k.add(new w(parambo, i.a()));
                    return paramLong;
                  }
                  i1 += 1;
                }
              }
              this.s.a();
              a(paramInt, parambo, -1L, paramp);
              return paramLong;
              if (localObject2 != null)
              {
                if (localObject1 == null) {
                  break;
                }
                paramp.b |= 0x8;
                paramp.a = ((String)localObject1);
                boolean bool = ((Boolean)localObject2).booleanValue();
                paramp.b |= 0x10;
                paramp.c = bool;
              }
            }
            localObject1 = null;
            break label233;
            if ((((bg)localObject1).l & 0x1) == 0) {
              break;
            }
            localObject1 = g;
            i3 = localObject1.length;
            i1 = 0;
            for (;;)
            {
              if (i1 >= i3) {
                break label526;
              }
              if (localObject1[i1] == parambo.b.aE) {
                break;
              }
              i1 += 1;
            }
            break;
            localObject1 = parambo.b;
          } while ((localObject1 == null) || ((((bg)localObject1).l & 0x1) == 0));
          localObject2 = f;
          int i3 = localObject2.length;
          i1 = 0;
          label562:
          if (i1 < i3) {
            if (localObject2[i1] == parambo.b.aE) {
              break label593;
            }
          }
          label593:
          label647:
          for (;;)
          {
            i1 += 1;
            break label562;
            break;
            localObject1 = this.a;
            if (localObject1 != null) {}
            for (localObject1 = ((com.google.android.finsky.adid.a)localObject1).b();; localObject1 = null)
            {
              if (localObject1 == null) {
                break label647;
              }
              if (localObject1 == null) {
                break label679;
              }
              parambo.c |= 0x8;
              parambo.a = ((String)localObject1);
              break;
            }
          }
        }
      }
    }
    else
    {
      this.u.a(parambo);
      return paramLong;
    }
    throw new NullPointerException();
    throw new NullPointerException();
    label679:
    throw new NullPointerException();
  }
  
  public final long a(int paramInt, boolean paramBoolean)
  {
    return a(new d(paramInt).a(paramBoolean).a, null, -1L);
  }
  
  public final long a(bg parambg)
  {
    return a(parambg, null, -1L);
  }
  
  public final long a(bg parambg, com.google.android.play.b.a.p paramp, long paramLong)
  {
    if (!this.z) {}
    for (;;)
    {
      Object localObject1;
      if ((k()) && (k()))
      {
        localObject1 = new StringBuilder("timestamp=");
        ((StringBuilder)localObject1).append(i.a());
        ((StringBuilder)localObject1).append(", type=");
        ((StringBuilder)localObject1).append(parambg.aE);
        if ((parambg.l & 0x80000) != 0) {
          break label1681;
        }
      }
      for (;;)
      {
        if ((parambg.l & 0x2) == 0) {}
        for (;;)
        {
          if ((parambg.l & 0x8) != 0)
          {
            ((StringBuilder)localObject1).append(", error_code=");
            ((StringBuilder)localObject1).append(parambg.D);
          }
          if (parambg.d())
          {
            ((StringBuilder)localObject1).append(", reason=");
            ((StringBuilder)localObject1).append(parambg.aj);
          }
          if ((parambg.l & 0x10) == 0) {}
          for (;;)
          {
            if ((parambg.l & 0x40) == 0) {}
            for (;;)
            {
              if ((parambg.l & 0x200) == 0) {}
              for (;;)
              {
                if ((parambg.l & 0x400) != 0)
                {
                  ((StringBuilder)localObject1).append(", client_latency_ms=");
                  ((StringBuilder)localObject1).append(parambg.s);
                }
                Object localObject2 = parambg.as;
                if (localObject2 != null)
                {
                  ((StringBuilder)localObject1).append(", query=");
                  ((StringBuilder)localObject1).append(((cc)localObject2).d);
                  if ((((cc)localObject2).a & 0x2) != 0) {
                    break label1570;
                  }
                }
                for (;;)
                {
                  ((StringBuilder)localObject1).append(", client_latency_ms=");
                  ((StringBuilder)localObject1).append(((cc)localObject2).b);
                  localObject2 = parambg.ao;
                  if (localObject2 == null) {}
                  label551:
                  label663:
                  label942:
                  while (!k())
                  {
                    localObject2 = parambg.j;
                    if ((localObject2 == null) || (!k()))
                    {
                      if ((parambg.l & 0x40000) != 0)
                      {
                        ((StringBuilder)localObject1).append(", safe_mode=");
                        ((StringBuilder)localObject1).append(parambg.ap);
                      }
                      localObject2 = parambg.b;
                      if (localObject2 == null)
                      {
                        localObject2 = parambg.Z;
                        if (localObject2 == null) {}
                        for (;;)
                        {
                          localObject2 = parambg.am;
                          if (localObject2 == null)
                          {
                            FinskyLog.a("Sending background event %s", new Object[] { localObject1 });
                            localObject1 = this.u.a();
                            ((bo)localObject1).b = parambg;
                            return a(4, (bo)localObject1, paramp, paramLong);
                          }
                          if ((((bz)localObject2).a & 0x1) == 0) {}
                          for (;;)
                          {
                            if ((((bz)localObject2).a & 0x2) != 0)
                            {
                              ((StringBuilder)localObject1).append(", roOemKey1=");
                              ((StringBuilder)localObject1).append(((bz)localObject2).c);
                            }
                            if (((bz)localObject2).b.length <= 0) {
                              break;
                            }
                            ((StringBuilder)localObject1).append(", packageNames=");
                            ((StringBuilder)localObject1).append(Arrays.toString(parambg.am.b));
                            break;
                            ((StringBuilder)localObject1).append(", type=");
                            ((StringBuilder)localObject1).append(((bz)localObject2).d);
                          }
                          if ((((com.google.wireless.android.a.b.a.a.aq)localObject2).a & 0x1) == 0) {}
                          for (;;)
                          {
                            if ((((com.google.wireless.android.a.b.a.a.aq)localObject2).a & 0x2) == 0) {
                              break label551;
                            }
                            ((StringBuilder)localObject1).append(", module_version=");
                            ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.aq)localObject2).d);
                            break;
                            ((StringBuilder)localObject1).append(", module_name=");
                            ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.aq)localObject2).b);
                          }
                        }
                      }
                      if ((((com.google.wireless.android.a.b.a.a.f)localObject2).a & 0x1) == 0) {}
                      for (;;)
                      {
                        if ((((com.google.wireless.android.a.b.a.a.f)localObject2).a & 0x2) == 0) {}
                        for (;;)
                        {
                          if ((((com.google.wireless.android.a.b.a.a.f)localObject2).a & 0x4) == 0) {}
                          for (;;)
                          {
                            if ((((com.google.wireless.android.a.b.a.a.f)localObject2).a & 0x100) == 0) {}
                            for (;;)
                            {
                              if ((((com.google.wireless.android.a.b.a.a.f)localObject2).a & 0x1000) == 0) {}
                              for (;;)
                              {
                                if ((((com.google.wireless.android.a.b.a.a.f)localObject2).a & 0x2000) == 0) {
                                  break label663;
                                }
                                ((StringBuilder)localObject1).append(", download_status=");
                                ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.f)localObject2).e);
                                break;
                                ((StringBuilder)localObject1).append(", total_bytes=");
                                ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.f)localObject2).q);
                              }
                              break;
                              ((StringBuilder)localObject1).append(", downloaded_bytes=");
                              ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.f)localObject2).f);
                            }
                            ((StringBuilder)localObject1).append(", system_app=");
                            ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.f)localObject2).p);
                          }
                          ((StringBuilder)localObject1).append(", old_version=");
                          ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.f)localObject2).l);
                        }
                        ((StringBuilder)localObject1).append(", version=");
                        ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.f)localObject2).r);
                      }
                    }
                    if ((((com.google.wireless.android.a.b.a.a.o)localObject2).a & 0x10) == 0) {}
                    for (;;)
                    {
                      if ((((com.google.wireless.android.a.b.a.a.o)localObject2).a & 0x20) == 0) {}
                      for (;;)
                      {
                        if ((((com.google.wireless.android.a.b.a.a.o)localObject2).a & 0x40) == 0) {}
                        for (;;)
                        {
                          if ((((com.google.wireless.android.a.b.a.a.o)localObject2).a & 0x80) == 0) {}
                          for (;;)
                          {
                            if ((((com.google.wireless.android.a.b.a.a.o)localObject2).a & 0x100) == 0) {}
                            for (;;)
                            {
                              if ((((com.google.wireless.android.a.b.a.a.o)localObject2).a & 0x200) == 0) {}
                              for (;;)
                              {
                                if ((((com.google.wireless.android.a.b.a.a.o)localObject2).a & 0x400) == 0) {}
                                for (;;)
                                {
                                  if ((((com.google.wireless.android.a.b.a.a.o)localObject2).a & 0x800) == 0) {}
                                  for (;;)
                                  {
                                    if ((((com.google.wireless.android.a.b.a.a.o)localObject2).a & 0x4000) == 0) {}
                                    for (;;)
                                    {
                                      if ((((com.google.wireless.android.a.b.a.a.o)localObject2).a & 0x2000) == 0) {}
                                      for (;;)
                                      {
                                        if ((((com.google.wireless.android.a.b.a.a.o)localObject2).a & 0x1000) == 0) {}
                                        for (;;)
                                        {
                                          if ((((com.google.wireless.android.a.b.a.a.o)localObject2).a & 0x8000) == 0) {
                                            break label942;
                                          }
                                          ((StringBuilder)localObject1).append(", rescheduled=");
                                          ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.o)localObject2).h);
                                          break;
                                          ((StringBuilder)localObject1).append(", num_packages_installed=");
                                          ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.o)localObject2).d);
                                        }
                                        break;
                                        ((StringBuilder)localObject1).append(", num_packages_deferred=");
                                        ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.o)localObject2).c);
                                      }
                                      ((StringBuilder)localObject1).append(", skipped_due_to_foreground=");
                                      ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.o)localObject2).j);
                                    }
                                    ((StringBuilder)localObject1).append(", skipped_due_to_global_disabled=");
                                    ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.o)localObject2).k);
                                  }
                                  ((StringBuilder)localObject1).append(", skipped_due_to_disabled_by_user=");
                                  ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.o)localObject2).i);
                                }
                                ((StringBuilder)localObject1).append(", skipped_due_to_large_download=");
                                ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.o)localObject2).l);
                              }
                              ((StringBuilder)localObject1).append(", skipped_due_to_new_permission=");
                              ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.o)localObject2).m);
                            }
                            ((StringBuilder)localObject1).append(", recheck_state=");
                            ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.o)localObject2).e);
                          }
                          ((StringBuilder)localObject1).append(", skipped_due_to_wifi=");
                          ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.o)localObject2).p);
                        }
                        ((StringBuilder)localObject1).append(", skipped_due_to_power=");
                        ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.o)localObject2).n);
                      }
                      ((StringBuilder)localObject1).append(", skipped_due_to_projection=");
                      ((StringBuilder)localObject1).append(((com.google.wireless.android.a.b.a.a.o)localObject2).o);
                    }
                  }
                  if ((((bp)localObject2).c & 0x1) == 0) {}
                  for (;;)
                  {
                    if ((((bp)localObject2).c & 0x2) == 0) {}
                    for (;;)
                    {
                      if ((((bp)localObject2).c & 0x4) == 0) {}
                      for (;;)
                      {
                        if ((((bp)localObject2).c & 0x8) == 0) {}
                        for (;;)
                        {
                          if ((((bp)localObject2).c & 0x10) == 0) {}
                          for (;;)
                          {
                            if ((((bp)localObject2).c & 0x20) == 0) {}
                            for (;;)
                            {
                              if ((((bp)localObject2).c & 0x40) == 0) {}
                              for (;;)
                              {
                                if ((((bp)localObject2).c & 0x80) == 0) {}
                                for (;;)
                                {
                                  if ((((bp)localObject2).c & 0x100) == 0) {}
                                  for (;;)
                                  {
                                    if ((((bp)localObject2).c & 0x200) == 0) {}
                                    for (;;)
                                    {
                                      if ((((bp)localObject2).c & 0x400) != 0)
                                      {
                                        ((StringBuilder)localObject1).append(", volley_error_type=");
                                        ((StringBuilder)localObject1).append(((bp)localObject2).t);
                                      }
                                      FinskyLog.a("%s", new Object[] { localObject1 });
                                      break;
                                      ((StringBuilder)localObject1).append(", response_body_size_bytes=");
                                      ((StringBuilder)localObject1).append(((bp)localObject2).m);
                                    }
                                    ((StringBuilder)localObject1).append(", end_connection_type=");
                                    ((StringBuilder)localObject1).append(((bp)localObject2).i);
                                  }
                                  ((StringBuilder)localObject1).append(", cur_connection_type=");
                                  ((StringBuilder)localObject1).append(((bp)localObject2).p);
                                }
                                ((StringBuilder)localObject1).append(", was_successful=");
                                ((StringBuilder)localObject1).append(((bp)localObject2).u);
                              }
                              ((StringBuilder)localObject1).append(", backoff_multiplier=");
                              ((StringBuilder)localObject1).append(((bp)localObject2).b);
                            }
                            ((StringBuilder)localObject1).append(", timeout_ms=");
                            ((StringBuilder)localObject1).append(((bp)localObject2).q);
                          }
                          ((StringBuilder)localObject1).append(", num_attempts=");
                          ((StringBuilder)localObject1).append(((bp)localObject2).k);
                        }
                        ((StringBuilder)localObject1).append(", server_latency_ms=");
                        ((StringBuilder)localObject1).append(((bp)localObject2).o);
                      }
                      ((StringBuilder)localObject1).append(", client_latency_ms=");
                      ((StringBuilder)localObject1).append(((bp)localObject2).h);
                    }
                    ((StringBuilder)localObject1).append(", url=");
                    ((StringBuilder)localObject1).append(((bp)localObject2).s);
                  }
                  label1570:
                  ((StringBuilder)localObject1).append(", suggested_query=");
                  ((StringBuilder)localObject1).append(((cc)localObject2).h);
                }
                ((StringBuilder)localObject1).append(", server_latency_ms=");
                ((StringBuilder)localObject1).append(parambg.at);
              }
              ((StringBuilder)localObject1).append(", offer_type=");
              ((StringBuilder)localObject1).append(parambg.ac);
            }
            ((StringBuilder)localObject1).append(", exception_type=");
            ((StringBuilder)localObject1).append(parambg.F);
          }
          ((StringBuilder)localObject1).append(", document=");
          ((StringBuilder)localObject1).append(parambg.A);
        }
        label1681:
        ((StringBuilder)localObject1).append(", page_type=");
        ((StringBuilder)localObject1).append(parambg.ae);
      }
      parambg.l |= 0x40000;
      parambg.ap = true;
    }
  }
  
  public final long a(bj parambj, long paramLong)
  {
    if ((k()) && (k()))
    {
      localObject = new StringBuilder("Sending deeplink event");
      ((StringBuilder)localObject).append(" type=");
      ((StringBuilder)localObject).append(parambj.o);
      ((StringBuilder)localObject).append(" package_name=");
      ((StringBuilder)localObject).append(parambj.l);
      ((StringBuilder)localObject).append(" external_referrer=");
      ((StringBuilder)localObject).append(parambj.f);
      ((StringBuilder)localObject).append(" external_url=");
      ((StringBuilder)localObject).append(parambj.g);
      a((StringBuilder)localObject, parambj.p);
      FinskyLog.a("%s", new Object[] { localObject });
    }
    Object localObject = this.u.a();
    ((bo)localObject).g = parambj;
    return a(6, (bo)localObject, null, paramLong);
  }
  
  public final long a(bm parambm, com.google.android.play.b.a.p paramp, long paramLong)
  {
    if (k()) {
      a("Sending", parambm.d);
    }
    if (k()) {
      a("Sending", parambm.b, parambm.d, null);
    }
    bo localbo = this.u.a();
    localbo.i = parambm;
    return a(1, localbo, paramp, paramLong);
  }
  
  public final void a()
  {
    b(true);
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, aq paramaq)
  {
    bh localbh = this.u.b();
    Object localObject = this.u.c();
    ((bt)localObject).b(paramInt);
    if (paramArrayOfByte != null) {
      ((bt)localObject).a(paramArrayOfByte);
    }
    localbh.a = ((bt[])a(localbh.a, localObject));
    if (paramaq == null)
    {
      a(localbh);
      a(3, b(localbh), null, -1L);
      return;
    }
    localObject = localbh.a;
    for (paramArrayOfByte = paramaq;; paramArrayOfByte = paramArrayOfByte.getParentNode())
    {
      bt localbt;
      if (paramArrayOfByte != null)
      {
        localbt = paramArrayOfByte.getPlayStoreUiElement();
        if (localbt == null) {
          FinskyLog.c("Unexpected null PlayStoreUiElement from node %s", new Object[] { paramArrayOfByte });
        }
      }
      else
      {
        localbh.a = ((bt[])localObject);
        for (paramArrayOfByte = paramaq;; paramArrayOfByte = paramaq)
        {
          paramaq = paramArrayOfByte.getParentNode();
          if (paramaq == null)
          {
            if (!(paramArrayOfByte instanceof av)) {
              break;
            }
            paramArrayOfByte = (av)paramArrayOfByte;
            if (paramArrayOfByte.J_() == null) {
              break;
            }
            paramArrayOfByte.J_().a(localbh, null);
            return;
          }
        }
      }
      localObject = (bt[])a((Object[])localObject, a(localbt));
    }
  }
  
  public final void a(aq paramaq)
  {
    a(new z().a(0L).b(paramaq).a(), null, -1L);
  }
  
  public final void a(Exception paramException)
  {
    FinskyLog.d("Caught and ignored: %s", new Object[] { paramException });
    try
    {
      if (this.o.a(12619746L)) {
        a(new d(13).b(paramException).a(paramException).a, null, -1L);
      }
      return;
    }
    catch (Exception paramException)
    {
      FinskyLog.d("Error logging an event to track exception: %s", new Object[] { paramException });
    }
  }
  
  public final void a(Runnable paramRunnable)
  {
    com.google.android.play.b.a locala = this.q;
    if (locala != null) {
      locala.a(paramRunnable);
    }
  }
  
  public final void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean1, VolleyError paramVolleyError, NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2, int paramInt3, boolean paramBoolean2, int paramInt4, Boolean paramBoolean, int paramInt5, String paramString2, long paramLong5)
  {
    a(new d(5).a(a(paramString1, paramLong1, paramLong2, paramLong3, paramLong4, paramInt1, paramInt2, paramFloat, paramBoolean1, paramVolleyError, paramNetworkInfo1, paramNetworkInfo2, -1, paramInt3, paramBoolean2, paramInt4, paramBoolean, paramInt5, paramString2, paramLong5)).a, null, -1L);
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (this.A))
    {
      if (!paramBoolean2) {
        return this.C;
      }
      return this.E;
    }
    return false;
  }
  
  final bo b(bh parambh)
  {
    bo localbo = this.u.a();
    localbo.d = parambh;
    return localbo;
  }
  
  public final void b()
  {
    a(new d(527).a, null, -1L);
  }
  
  public final void h()
  {
    synchronized (this.l)
    {
      if (this.D)
      {
        a(new d(19).a);
        this.D = false;
      }
      return;
    }
  }
  
  public final void i()
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      w localw = (w)localIterator.next();
      a(4, localw.a, localw.b, null);
    }
    j();
  }
  
  public final void j()
  {
    this.k.clear();
    synchronized (this.l)
    {
      this.D = true;
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */