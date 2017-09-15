package com.tencent.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
  implements Runnable
{
  public static long aQB = -1L;
  int aQA = 0;
  private a aQz = null;
  private Context mContext = null;
  private int mType = 0;
  
  public n(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if ((i.aQp == null) || (j.aQv == 1)) {
      return;
    }
    if ((j.aQw > 0) && (this.aQA > j.aQw))
    {
      new StringBuilder("limit dispatch:").append(j.aQw);
      return;
    }
    paramJSONObject = new m(this.mContext, paramJSONObject).nQ().toString();
    i.aQp.aH("[" + paramJSONObject + "]");
    aQB = System.currentTimeMillis();
    this.aQA += 1;
  }
  
  private void nR()
  {
    g localg1 = r.T(this.mContext).n(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1) })));
    g localg2 = r.T(this.mContext).n(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2) })));
    g localg3 = r.T(this.mContext).n(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    if ((s.b(localg1, localg2)) && (s.b(localg1, localg3))) {
      return;
    }
    localg1 = s.a(s.a(localg1, localg2), s.a(localg1, localg3));
    new StringBuilder("local mid check failed, redress with mid:").append(localg1.toString());
    r.T(this.mContext).b(localg1);
  }
  
  public final void run()
  {
    new StringBuilder("request type:").append(this.mType);
    switch (this.mType)
    {
    default: 
      new StringBuilder("wrong type:").append(this.mType);
    }
    for (;;)
    {
      return;
      a(null);
      return;
      if (this.aQz == null) {
        this.aQz = r.T(this.mContext).nT();
      }
      long l1 = System.currentTimeMillis();
      if (i.aQq <= 0L) {
        i.aQq = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
      }
      long l2 = Math.abs(l1 - i.aQq);
      new StringBuilder("check entity: ").append(this.aQz.toString()).append(",duration:").append(l2);
      if ((this.aQz.aPQ < 0) || (this.aQz.aPQ > 100)) {
        this.aQz.aPQ = 3;
      }
      long l3 = this.aQz.aPQ * e.aQk;
      new StringBuilder("duration:").append(l2).append(",maxCheckDays:").append(l3).append(",mLastCheckTime:").append(i.aQq).append(",mCheckEntity:").append(this.aQz);
      if (l2 < l3)
      {
        if (l2 <= e.aQk) {
          continue;
        }
        nR();
        return;
      }
      nR();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("dur", l2);
        localJSONObject.put("md", l3);
        localJSONObject.put("lct", i.aQq);
        localJSONObject.put("cur", l1);
        if (aQB > 0L) {
          continue;
        }
        a(localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/b/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */