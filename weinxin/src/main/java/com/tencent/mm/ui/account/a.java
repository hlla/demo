package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public final class a
  extends BaseAdapter
{
  private LayoutInflater mwN;
  private String[] uVk;
  private Drawable uVl;
  private View.OnTouchListener uVm;
  
  public a(Context paramContext, String[] paramArrayOfString)
  {
    GMTrace.i(2681938640896L, 19982);
    this.uVl = null;
    this.uVm = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(2736565256192L, 20389);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ((TextView)paramAnonymousView.findViewById(R.h.bor)).setTextColor(-10395295);
          GMTrace.o(2736565256192L, 20389);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          ((TextView)paramAnonymousView.findViewById(R.h.bor)).setTextColor(-1);
          GMTrace.o(2736565256192L, 20389);
          return false;
        }
        GMTrace.o(2736565256192L, 20389);
        return false;
      }
    };
    this.uVk = paramArrayOfString;
    this.mwN = LayoutInflater.from(paramContext);
    this.uVl = paramContext.getResources().getDrawable(R.g.bjY);
    this.uVl.setBounds(0, 0, this.uVl.getIntrinsicWidth(), this.uVl.getIntrinsicHeight());
    GMTrace.o(2681938640896L, 19982);
  }
  
  private boolean zu(int paramInt)
  {
    GMTrace.i(2682341294080L, 19985);
    if (paramInt == this.uVk.length - 1)
    {
      GMTrace.o(2682341294080L, 19985);
      return true;
    }
    GMTrace.o(2682341294080L, 19985);
    return false;
  }
  
  public final int getCount()
  {
    GMTrace.i(2682072858624L, 19983);
    int i = this.uVk.length;
    GMTrace.o(2682072858624L, 19983);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    GMTrace.i(2682207076352L, 19984);
    String str = this.uVk[paramInt];
    GMTrace.o(2682207076352L, 19984);
    return str;
  }
  
  public final long getItemId(int paramInt)
  {
    GMTrace.i(2682475511808L, 19986);
    long l = paramInt;
    GMTrace.o(2682475511808L, 19986);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    GMTrace.i(2682609729536L, 19987);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.mwN.inflate(R.i.cTA, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(R.h.bor);
    paramViewGroup.setOnTouchListener(this.uVm);
    int i;
    if (paramInt == 0)
    {
      i = 1;
      if ((i == 0) || (!zu(paramInt))) {
        break label120;
      }
      paramView.setPadding(25, 0, 25, 10);
      paramView.setCompoundDrawablePadding(0);
      paramView.setCompoundDrawables(null, null, null, null);
    }
    for (;;)
    {
      paramView.setText(this.uVk[paramInt]);
      GMTrace.o(2682609729536L, 19987);
      return paramViewGroup;
      i = 0;
      break;
      label120:
      if (paramInt == 0) {}
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label170;
        }
        paramView.setPadding(25, 0, 10, 10);
        paramView.setCompoundDrawablePadding(10);
        paramView.setCompoundDrawables(null, null, this.uVl, null);
        break;
      }
      label170:
      if (zu(paramInt))
      {
        paramView.setPadding(0, 0, 25, 10);
        paramView.setCompoundDrawablePadding(0);
        paramView.setCompoundDrawables(null, null, null, null);
      }
      else
      {
        paramView.setPadding(0, 0, 10, 10);
        paramView.setCompoundDrawablePadding(10);
        paramView.setCompoundDrawables(null, null, this.uVl, null);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */