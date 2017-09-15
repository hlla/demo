package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.fts.d.d.a;
import com.tencent.mm.plugin.fts.d.e;

public final class f
  extends a
{
  public String[] lYu;
  public CharSequence pfk;
  private a.b vYC;
  a.a vYD;
  
  public f(int paramInt)
  {
    super(5, paramInt);
    GMTrace.i(1772076662784L, 13203);
    this.vYC = new b();
    this.vYD = new a();
    GMTrace.o(1772076662784L, 13203);
  }
  
  public final a.b Oc()
  {
    GMTrace.i(1772345098240L, 13205);
    a.b localb = this.vYC;
    GMTrace.o(1772345098240L, 13205);
    return localb;
  }
  
  protected final a.a Od()
  {
    GMTrace.i(1772479315968L, 13206);
    a.a locala = this.vYD;
    GMTrace.o(1772479315968L, 13206);
    return locala;
  }
  
  public final void br(Context paramContext)
  {
    GMTrace.i(1772210880512L, 13204);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String[] arrayOfString = this.lYu;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new ForegroundColorSpan(d.a.maM), 0, str.length(), 33);
      localSpannableStringBuilder.append(localSpannableString);
      localSpannableStringBuilder.append("、");
      i += 1;
    }
    this.pfk = TextUtils.concat(new CharSequence[] { paramContext.getString(R.l.eQs), localSpannableStringBuilder.subSequence(0, localSpannableStringBuilder.length() - 1), paramContext.getString(R.l.eQr) });
    GMTrace.o(1772210880512L, 13204);
  }
  
  public final class a
    extends a.a
  {
    public TextView ipd;
    public View vYE;
    
    public a()
    {
      super();
      GMTrace.i(1776908500992L, 13239);
      GMTrace.o(1776908500992L, 13239);
    }
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
      GMTrace.i(1770600267776L, 13192);
      GMTrace.o(1770600267776L, 13192);
    }
    
    public final boolean Oe()
    {
      GMTrace.i(1771002920960L, 13195);
      GMTrace.o(1771002920960L, 13195);
      return false;
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      GMTrace.i(1770734485504L, 13193);
      paramContext = LayoutInflater.from(paramContext).inflate(R.i.dnz, paramViewGroup, false);
      paramViewGroup = (f.a)f.this.vYD;
      paramViewGroup.ipd = ((TextView)paramContext.findViewById(R.h.bHU));
      paramViewGroup.vYE = paramContext.findViewById(R.h.bVR);
      paramContext.setTag(paramViewGroup);
      GMTrace.o(1770734485504L, 13193);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      GMTrace.i(1770868703232L, 13194);
      paramContext = (f.a)parama;
      e.a(((f)parama1).pfk, paramContext.ipd);
      if (f.this.position == 0)
      {
        paramContext.vYE.setVisibility(8);
        GMTrace.o(1770868703232L, 13194);
        return;
      }
      paramContext.vYE.setVisibility(0);
      GMTrace.o(1770868703232L, 13194);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */