package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.k;
import java.util.Calendar;
import java.util.Date;

public class a
{
  private static a wgF;
  private long wgC;
  private long wgD;
  private long wgE;
  
  private a()
  {
    GMTrace.i(16747553882112L, 124779);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(7, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.wgD = localCalendar.getTimeInMillis();
    localCalendar = Calendar.getInstance();
    localCalendar.set(5, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.wgE = localCalendar.getTimeInMillis();
    this.wgC = Calendar.getInstance().getTimeInMillis();
    GMTrace.o(16747553882112L, 124779);
  }
  
  public static a bYY()
  {
    GMTrace.i(16747419664384L, 124778);
    if (wgF == null) {}
    try
    {
      wgF = new a();
      a locala = wgF;
      GMTrace.o(16747419664384L, 124778);
      return locala;
    }
    finally {}
  }
  
  public static long eX(long paramLong)
  {
    GMTrace.i(16747822317568L, 124781);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.set(5, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    paramLong = localCalendar.getTimeInMillis();
    GMTrace.o(16747822317568L, 124781);
    return paramLong;
  }
  
  public final long a(Date paramDate)
  {
    GMTrace.i(16747688099840L, 124780);
    if (paramDate.getTime() >= this.wgD)
    {
      GMTrace.o(16747688099840L, 124780);
      return Long.MAX_VALUE;
    }
    if (paramDate.getTime() >= this.wgE)
    {
      GMTrace.o(16747688099840L, 124780);
      return 9223372036854775806L;
    }
    long l = paramDate.getYear() * 100 + paramDate.getMonth();
    GMTrace.o(16747688099840L, 124780);
    return l;
  }
  
  public final String a(Date paramDate, Context paramContext)
  {
    GMTrace.i(16747956535296L, 124782);
    if (paramDate.getTime() >= this.wgD)
    {
      paramDate = paramContext.getString(a.k.hfi);
      GMTrace.o(16747956535296L, 124782);
      return paramDate;
    }
    if (paramDate.getTime() >= this.wgE)
    {
      paramDate = paramContext.getString(a.k.hfh);
      GMTrace.o(16747956535296L, 124782);
      return paramDate;
    }
    paramDate = String.format("%d/%d", new Object[] { Integer.valueOf(paramDate.getYear() + 1900), Integer.valueOf(paramDate.getMonth() + 1) });
    GMTrace.o(16747956535296L, 124782);
    return paramDate;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/gridviewheaders/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */