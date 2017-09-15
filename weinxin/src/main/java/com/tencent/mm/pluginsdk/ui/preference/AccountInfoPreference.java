package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.bg.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.s;

public class AccountInfoPreference
  extends Preference
{
  public SpannableString sQh;
  public String sQi;
  private int sQj;
  public View.OnClickListener sQk;
  public String userName;
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(1048777326592L, 7814);
    GMTrace.o(1048777326592L, 7814);
  }
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1048911544320L, 7815);
    this.sQk = null;
    GMTrace.o(1048911544320L, 7815);
  }
  
  protected final void onBindView(View paramView)
  {
    GMTrace.i(1049045762048L, 7816);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(R.h.bqF);
    if ((this.userName != null) && (localObject != null)) {
      a.b.a((ImageView)localObject, this.userName);
    }
    NoMeasuredTextView localNoMeasuredTextView = (NoMeasuredTextView)paramView.findViewById(R.h.cnU);
    if ((this.userName != null) && (localNoMeasuredTextView != null))
    {
      localNoMeasuredTextView.vng = true;
      localNoMeasuredTextView.H(a.T(this.mContext, R.f.aXH));
      localNoMeasuredTextView.setTextColor(a.S(this.mContext, R.e.aVo));
      if (this.sQh == null)
      {
        localObject = this.userName;
        localNoMeasuredTextView.setText((CharSequence)localObject);
      }
    }
    else
    {
      localObject = (TextView)paramView.findViewById(R.h.cKY);
      if ((this.sQi == null) || (localObject == null)) {
        break label260;
      }
      ((TextView)localObject).setText(paramView.getResources().getString(R.l.dCZ, new Object[] { this.sQi }));
      label164:
      localObject = (TextView)paramView.findViewById(R.h.cyM);
      if (localObject != null)
      {
        if (this.sQj <= 99) {
          break label273;
        }
        ((TextView)localObject).setText(this.mContext.getString(R.l.fkr));
        ((TextView)localObject).setBackgroundResource(s.fg(this.mContext));
        ((TextView)localObject).setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.sQk != null) {
        ((ImageView)paramView.findViewById(R.h.bmM)).setOnClickListener(this.sQk);
      }
      GMTrace.o(1049045762048L, 7816);
      return;
      localObject = this.sQh;
      break;
      label260:
      if (localObject == null) {
        break label164;
      }
      ((TextView)localObject).setVisibility(8);
      break label164;
      label273:
      if (this.sQj > 0)
      {
        ((TextView)localObject).setText(this.sQj);
        ((TextView)localObject).setVisibility(0);
      }
      else
      {
        ((TextView)localObject).setVisibility(8);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/preference/AccountInfoPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */