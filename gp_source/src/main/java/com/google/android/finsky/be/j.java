package com.google.android.finsky.be;

import android.os.Bundle;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class j
{
  public Calendar a;
  public final t b;
  public final w c;
  
  public j(t paramt, w paramw, Bundle paramBundle)
  {
    this.b = paramt;
    this.c = paramw;
    if ((paramBundle != null) && (paramBundle.containsKey("DialogCalendarDateModel.year"))) {
      this.a = new GregorianCalendar(paramBundle.getInt("DialogCalendarDateModel.year"), paramBundle.getInt("DialogCalendarDateModel.month"), paramBundle.getInt("DialogCalendarDateModel.day"));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */