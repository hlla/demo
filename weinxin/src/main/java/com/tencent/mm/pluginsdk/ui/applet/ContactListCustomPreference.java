package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactListCustomPreference
  extends Preference
{
  int background;
  View.OnClickListener oOv;
  private final View.OnTouchListener sLB;
  private View sbS;
  
  public ContactListCustomPreference(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(948114030592L, 7064);
    this.background = -1;
    this.sLB = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(961401585664L, 7163);
        GMTrace.o(961401585664L, 7163);
        return true;
      }
    };
    setLayoutResource(a.e.kBT);
    GMTrace.o(948114030592L, 7064);
  }
  
  public ContactListCustomPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(948248248320L, 7065);
    this.background = -1;
    this.sLB = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(961401585664L, 7163);
        GMTrace.o(961401585664L, 7163);
        return true;
      }
    };
    setLayoutResource(a.e.kBT);
    GMTrace.o(948248248320L, 7065);
  }
  
  public ContactListCustomPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(948382466048L, 7066);
    this.background = -1;
    this.sLB = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(961401585664L, 7163);
        GMTrace.o(961401585664L, 7163);
        return true;
      }
    };
    setLayoutResource(a.e.kBT);
    GMTrace.o(948382466048L, 7066);
  }
  
  public final void onBindView(View paramView)
  {
    GMTrace.i(948650901504L, 7068);
    ViewGroup localViewGroup = (ViewGroup)paramView;
    if ((this.sbS != null) && (this.sbS != null))
    {
      localViewGroup.removeAllViews();
      if (this.sbS.getParent() != null) {
        ((ViewGroup)this.sbS.getParent()).removeAllViews();
      }
      localViewGroup.addView(this.sbS);
      if (this.oOv == null) {
        break label103;
      }
      localViewGroup.setOnClickListener(this.oOv);
    }
    for (;;)
    {
      if (this.background >= 0) {
        paramView.setBackgroundResource(this.background);
      }
      GMTrace.o(948650901504L, 7068);
      return;
      label103:
      localViewGroup.setOnTouchListener(this.sLB);
    }
  }
  
  public final void setCustomView(View paramView)
  {
    GMTrace.i(948516683776L, 7067);
    if (paramView == null)
    {
      GMTrace.o(948516683776L, 7067);
      return;
    }
    this.sbS = paramView;
    GMTrace.o(948516683776L, 7067);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/applet/ContactListCustomPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */