package com.tencent.c.d.a;

import android.text.TextUtils;
import com.tencent.c.d.b.d.a;
import com.tencent.c.e.g;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements b
{
  private final List<d.a> wQa = new ArrayList();
  
  public final void a(d.a parama)
  {
    if (parama.uid != 0) {}
    while ((TextUtils.isEmpty(parama.wQi)) || (!"u:r:zygote:s0".equals(parama.wQi)) || (TextUtils.isEmpty(parama.name)) || ("zygote".equals(parama.name)) || ("zygote64".equals(parama.name))) {
      return;
    }
    g.Ve("JavaProcessAnalyzer match : " + parama.toString());
    this.wQa.add(parama);
  }
  
  public final boolean cdw()
  {
    return this.wQa.size() > 0;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/d/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */