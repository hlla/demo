package com.tencent.mm.pluginsdk.j;

import android.content.Context;
import android.text.format.Time;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class o
{
  private static final Locale sDo;
  private static final boolean sDp;
  
  static
  {
    GMTrace.i(705314160640L, 5255);
    sDo = u.Pn(u.bID());
    sDp = u.bIA();
    GMTrace.o(705314160640L, 5255);
  }
  
  public static String M(Context paramContext, int paramInt)
  {
    GMTrace.i(704374636544L, 5248);
    long l1 = 1000L * paramInt;
    Object localObject1 = new GregorianCalendar();
    if (l1 < 3600000L)
    {
      GMTrace.o(704374636544L, 5248);
      return "";
    }
    Object localObject2 = new GregorianCalendar(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2), ((GregorianCalendar)localObject1).get(5));
    long l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = p(paramContext, l2) + ";" + aa(paramContext.getString(a.g.kCA), l1);
      GMTrace.o(704374636544L, 5248);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() - 86400000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(a.g.elz) + " " + p(paramContext, l2) + ";" + aa(paramContext.getString(a.g.kCA), l1);
      GMTrace.o(704374636544L, 5248);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() - 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(a.g.kCD) + " " + p(paramContext, l2) + ";" + aa(paramContext.getString(a.g.kCA), l1);
      GMTrace.o(704374636544L, 5248);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(a.g.kCL) + " " + p(paramContext, l2) + ";" + aa(paramContext.getString(a.g.kCA), l1);
      GMTrace.o(704374636544L, 5248);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() + 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(a.g.kCC) + " " + p(paramContext, l2) + ";" + aa(paramContext.getString(a.g.kCA), l1);
      GMTrace.o(704374636544L, 5248);
      return paramContext;
    }
    localObject2 = new GregorianCalendar();
    ((GregorianCalendar)localObject2).setTimeInMillis(l1);
    paramInt = ((GregorianCalendar)localObject2).get(11);
    int i;
    if ((((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1)) && (((GregorianCalendar)localObject1).get(3) == ((GregorianCalendar)localObject2).get(3)))
    {
      i = ((GregorianCalendar)localObject2).get(7);
      localObject2 = new StringBuilder();
      switch (i)
      {
      default: 
        localObject1 = "";
      }
      for (;;)
      {
        paramContext = (String)localObject1 + " " + N(paramContext, paramInt) + ";" + aa(paramContext.getString(a.g.kCA), l1);
        GMTrace.o(704374636544L, 5248);
        return paramContext;
        localObject1 = paramContext.getString(a.g.kCP);
        continue;
        localObject1 = paramContext.getString(a.g.kCN);
        continue;
        localObject1 = paramContext.getString(a.g.kCR);
        continue;
        localObject1 = paramContext.getString(a.g.kCS);
        continue;
        localObject1 = paramContext.getString(a.g.kCQ);
        continue;
        localObject1 = paramContext.getString(a.g.kCM);
        continue;
        localObject1 = paramContext.getString(a.g.kCO);
      }
    }
    if ((((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1)) && (((GregorianCalendar)localObject1).get(3) + 1 == ((GregorianCalendar)localObject2).get(3)))
    {
      i = ((GregorianCalendar)localObject2).get(7);
      localObject2 = new StringBuilder();
      switch (i)
      {
      default: 
        localObject1 = "";
      }
      for (;;)
      {
        paramContext = (String)localObject1 + " " + N(paramContext, paramInt) + ";" + aa(paramContext.getString(a.g.kCA), l1);
        GMTrace.o(704374636544L, 5248);
        return paramContext;
        localObject1 = paramContext.getString(a.g.kCH);
        continue;
        localObject1 = paramContext.getString(a.g.kCF);
        continue;
        localObject1 = paramContext.getString(a.g.kCJ);
        continue;
        localObject1 = paramContext.getString(a.g.kCK);
        continue;
        localObject1 = paramContext.getString(a.g.kCI);
        continue;
        localObject1 = paramContext.getString(a.g.kCE);
        continue;
        localObject1 = paramContext.getString(a.g.kCG);
      }
    }
    if (((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1))
    {
      paramContext = android.text.format.DateFormat.format(paramContext.getString(a.g.elh), l1) + " " + N(paramContext, paramInt) + ";" + aa(paramContext.getString(a.g.kCA), l1);
      GMTrace.o(704374636544L, 5248);
      return paramContext;
    }
    paramContext = android.text.format.DateFormat.format(paramContext.getString(a.g.elr), l1) + " " + N(paramContext, paramInt) + ";" + aa(paramContext.getString(a.g.kCA), l1);
    GMTrace.o(704374636544L, 5248);
    return paramContext;
  }
  
  private static CharSequence N(Context paramContext, int paramInt)
  {
    GMTrace.i(704911507456L, 5252);
    if (paramInt < 0)
    {
      GMTrace.o(704911507456L, 5252);
      return "";
    }
    if (paramInt < 6L)
    {
      paramContext = paramContext.getString(a.g.kCv);
      GMTrace.o(704911507456L, 5252);
      return paramContext;
    }
    if (paramInt < 12L)
    {
      paramContext = paramContext.getString(a.g.kCy);
      GMTrace.o(704911507456L, 5252);
      return paramContext;
    }
    if (paramInt < 13L)
    {
      paramContext = paramContext.getString(a.g.kCz);
      GMTrace.o(704911507456L, 5252);
      return paramContext;
    }
    if (paramInt < 18L)
    {
      paramContext = paramContext.getString(a.g.kCu);
      GMTrace.o(704911507456L, 5252);
      return paramContext;
    }
    paramContext = paramContext.getString(a.g.kCw);
    GMTrace.o(704911507456L, 5252);
    return paramContext;
  }
  
  public static String Z(String paramString, long paramLong)
  {
    GMTrace.i(704240418816L, 5247);
    paramString = new SimpleDateFormat(paramString).format(new Date(1000L * paramLong));
    GMTrace.o(704240418816L, 5247);
    return paramString;
  }
  
  public static String aa(String paramString, long paramLong)
  {
    GMTrace.i(704508854272L, 5249);
    paramString = android.text.format.DateFormat.format(paramString, paramLong).toString();
    if (bf.mA(paramString))
    {
      GMTrace.o(704508854272L, 5249);
      return "";
    }
    String str = paramString.trim();
    paramString = str;
    if (str.startsWith("0")) {
      paramString = str.substring(1);
    }
    GMTrace.o(704508854272L, 5249);
    return paramString;
  }
  
  public static CharSequence c(Context paramContext, long paramLong, boolean paramBoolean)
  {
    GMTrace.i(705179942912L, 5254);
    if (!sDp)
    {
      localObject1 = sDo;
      localObject2 = new GregorianCalendar();
      if (paramLong < 3600000L)
      {
        GMTrace.o(705179942912L, 5254);
        return "";
      }
      GregorianCalendar localGregorianCalendar = new GregorianCalendar(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2), ((GregorianCalendar)localObject2).get(5));
      long l = paramLong - localGregorianCalendar.getTimeInMillis();
      if ((l > 0L) && (l <= 86400000L))
      {
        paramContext = java.text.DateFormat.getTimeInstance(3, (Locale)localObject1);
        paramContext = paramContext.format(Long.valueOf(paramLong));
        GMTrace.o(705179942912L, 5254);
        return paramContext;
      }
      l = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
      if ((l > 0L) && (l <= 86400000L))
      {
        if (paramBoolean)
        {
          paramContext = paramContext.getString(a.g.elz);
          GMTrace.o(705179942912L, 5254);
          return paramContext;
        }
        paramContext = paramContext.getString(a.g.elz) + " " + java.text.DateFormat.getTimeInstance(3, (Locale)localObject1).format(Long.valueOf(paramLong));
        GMTrace.o(705179942912L, 5254);
        return paramContext;
      }
      paramContext = new GregorianCalendar();
      paramContext.setTimeInMillis(paramLong);
      if ((((GregorianCalendar)localObject2).get(1) == paramContext.get(1)) && (((GregorianCalendar)localObject2).get(3) == paramContext.get(3)))
      {
        paramContext = new SimpleDateFormat("E", (Locale)localObject1);
        paramContext = paramContext.format(Long.valueOf(paramLong));
        if (paramBoolean)
        {
          GMTrace.o(705179942912L, 5254);
          return paramContext;
        }
        paramContext = paramContext + " " + java.text.DateFormat.getTimeInstance(3, (Locale)localObject1).format(Long.valueOf(paramLong));
        GMTrace.o(705179942912L, 5254);
        return paramContext;
      }
      if (((GregorianCalendar)localObject2).get(1) == paramContext.get(1))
      {
        if (paramBoolean)
        {
          paramContext = java.text.DateFormat.getDateInstance(3, (Locale)localObject1).format(Long.valueOf(paramLong));
          GMTrace.o(705179942912L, 5254);
          return paramContext;
        }
        paramContext = java.text.DateFormat.getDateTimeInstance(3, 3, (Locale)localObject1).format(Long.valueOf(paramLong));
        GMTrace.o(705179942912L, 5254);
        return paramContext;
      }
      if (paramBoolean)
      {
        paramContext = java.text.DateFormat.getDateInstance(3, (Locale)localObject1).format(Long.valueOf(paramLong));
        GMTrace.o(705179942912L, 5254);
        return paramContext;
      }
      paramContext = java.text.DateFormat.getDateTimeInstance(3, 3, (Locale)localObject1).format(Long.valueOf(paramLong));
      GMTrace.o(705179942912L, 5254);
      return paramContext;
    }
    if (paramLong < 3600000L)
    {
      GMTrace.o(705179942912L, 5254);
      return "";
    }
    Object localObject2 = new Time();
    Object localObject1 = new Time();
    ((Time)localObject2).set(paramLong);
    ((Time)localObject1).setToNow();
    if ((((Time)localObject2).year == ((Time)localObject1).year) && (((Time)localObject2).yearDay == ((Time)localObject1).yearDay))
    {
      if (android.text.format.DateFormat.is24HourFormat(aa.getContext()))
      {
        paramContext = n.a(paramContext.getString(a.g.elw), (Time)localObject2);
        GMTrace.o(705179942912L, 5254);
        return paramContext;
      }
      paramContext = N(paramContext, ((Time)localObject2).hour) + n.a(paramContext.getString(a.g.kCA), (Time)localObject2);
      GMTrace.o(705179942912L, 5254);
      return paramContext;
    }
    if ((((Time)localObject2).year == ((Time)localObject1).year) && (((Time)localObject1).yearDay - ((Time)localObject2).yearDay == 1))
    {
      boolean bool = android.text.format.DateFormat.is24HourFormat(aa.getContext());
      if (paramBoolean)
      {
        paramContext = paramContext.getString(a.g.elz);
        GMTrace.o(705179942912L, 5254);
        return paramContext;
      }
      localObject1 = new StringBuilder().append(paramContext.getString(a.g.elz)).append(" ");
      if (bool) {}
      for (paramContext = n.a(paramContext.getString(a.g.elw), (Time)localObject2);; paramContext = N(paramContext, ((Time)localObject2).hour) + n.a(paramContext.getString(a.g.kCA), (Time)localObject2))
      {
        paramContext = paramContext;
        GMTrace.o(705179942912L, 5254);
        return paramContext;
      }
    }
    if ((((Time)localObject2).year == ((Time)localObject1).year) && (((Time)localObject2).getWeekNumber() == ((Time)localObject1).getWeekNumber()))
    {
      localObject1 = n.a("E ", (Time)localObject2);
      if (paramBoolean)
      {
        GMTrace.o(705179942912L, 5254);
        return (CharSequence)localObject1;
      }
      paramContext = (String)localObject1 + n.a(paramContext.getString(a.g.kCB), (Time)localObject2);
      GMTrace.o(705179942912L, 5254);
      return paramContext;
    }
    if (((Time)localObject2).year == ((Time)localObject1).year)
    {
      if (paramBoolean)
      {
        paramContext = n.a(paramContext.getString(a.g.elh), (Time)localObject2);
        GMTrace.o(705179942912L, 5254);
        return paramContext;
      }
      paramContext = n.a(paramContext.getString(a.g.eli, new Object[] { p(paramContext, ((Time)localObject2).hour * 3600000L) }).toString(), (Time)localObject2);
      GMTrace.o(705179942912L, 5254);
      return paramContext;
    }
    if (paramBoolean)
    {
      paramContext = n.a(paramContext.getString(a.g.elr), (Time)localObject2);
      GMTrace.o(705179942912L, 5254);
      return paramContext;
    }
    paramContext = n.a(paramContext.getString(a.g.kCx, new Object[] { p(paramContext, ((Time)localObject2).hour * 3600000L) }).toString(), (Time)localObject2);
    GMTrace.o(705179942912L, 5254);
    return paramContext;
  }
  
  public static CharSequence n(Context paramContext, long paramLong)
  {
    GMTrace.i(704643072000L, 5250);
    paramContext = paramContext.getString(a.g.kCU) + android.text.format.DateFormat.format(paramContext.getString(a.g.kCT), paramLong);
    GMTrace.o(704643072000L, 5250);
    return paramContext;
  }
  
  public static CharSequence o(Context paramContext, long paramLong)
  {
    GMTrace.i(704777289728L, 5251);
    paramContext = paramContext.getString(a.g.kCV) + android.text.format.DateFormat.format(paramContext.getString(a.g.kCT), paramLong);
    GMTrace.o(704777289728L, 5251);
    return paramContext;
  }
  
  public static CharSequence p(Context paramContext, long paramLong)
  {
    GMTrace.i(705045725184L, 5253);
    if (paramLong < 0L)
    {
      GMTrace.o(705045725184L, 5253);
      return "";
    }
    if (paramLong < 21600000L)
    {
      paramContext = paramContext.getString(a.g.kCv);
      GMTrace.o(705045725184L, 5253);
      return paramContext;
    }
    if (paramLong < 43200000L)
    {
      paramContext = paramContext.getString(a.g.kCy);
      GMTrace.o(705045725184L, 5253);
      return paramContext;
    }
    if (paramLong < 46800000L)
    {
      paramContext = paramContext.getString(a.g.kCz);
      GMTrace.o(705045725184L, 5253);
      return paramContext;
    }
    if (paramLong < 64800000L)
    {
      paramContext = paramContext.getString(a.g.kCu);
      GMTrace.o(705045725184L, 5253);
      return paramContext;
    }
    paramContext = paramContext.getString(a.g.kCw);
    GMTrace.o(705045725184L, 5253);
    return paramContext;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/j/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */