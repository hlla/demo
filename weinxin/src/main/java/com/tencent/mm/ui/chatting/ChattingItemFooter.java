package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelbiz.i;
import com.tencent.mm.modelbiz.p;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.n;
import java.util.List;

public class ChattingItemFooter
  extends LinearLayout
  implements View.OnClickListener
{
  private static final int[] vBO;
  private static final int[] vBP;
  private LayoutInflater Du;
  private String jgK;
  private Context mContext;
  
  static
  {
    GMTrace.i(2505173893120L, 18665);
    vBO = new int[] { R.g.bdU, R.g.bdU, R.g.bdW, R.g.bdV };
    vBP = new int[] { R.g.biK, R.g.biL, R.g.biN, R.g.biM };
    GMTrace.o(2505173893120L, 18665);
  }
  
  public ChattingItemFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(2504502804480L, 18660);
    this.mContext = paramContext;
    this.Du = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    GMTrace.o(2504502804480L, 18660);
  }
  
  private TextView a(int paramInt1, int paramInt2, LinearLayout.LayoutParams paramLayoutParams)
  {
    GMTrace.i(2504771239936L, 18662);
    if (paramInt1 < paramInt2)
    {
      paramLayoutParams = (TextView)getChildAt(paramInt1);
      GMTrace.o(2504771239936L, 18662);
      return paramLayoutParams;
    }
    TextView localTextView = (TextView)this.Du.inflate(R.i.cXu, null);
    localTextView.setLongClickable(false);
    localTextView.setOnClickListener(this);
    localTextView.setLayoutParams(paramLayoutParams);
    addView(localTextView);
    GMTrace.o(2504771239936L, 18662);
    return localTextView;
  }
  
  private void d(i parami)
  {
    GMTrace.i(17898470899712L, 133354);
    parami = new p(this.jgK, 1, parami.getInfo());
    ap.vd().a(parami, 0);
    GMTrace.o(17898470899712L, 133354);
  }
  
  public final boolean b(List<i> paramList, String paramString, boolean paramBoolean)
  {
    GMTrace.i(2504637022208L, 18661);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      v.d("ChattingItemFooter", "no menulist!");
      setVisibility(8);
      GMTrace.o(2504637022208L, 18661);
      return false;
    }
    this.jgK = paramString;
    int i = getChildCount();
    Object localObject;
    int j;
    if (paramBoolean)
    {
      paramString = vBP;
      localObject = new LinearLayout.LayoutParams(0, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      j = paramList.size();
      switch (j)
      {
      }
    }
    for (;;)
    {
      if ((i > j) && (i - 1 > 0)) {
        removeViews(j, i - 1);
      }
      setLongClickable(true);
      setVisibility(0);
      GMTrace.o(2504637022208L, 18661);
      return true;
      paramString = vBO;
      break;
      paramList = (i)paramList.get(0);
      localObject = a(0, i, (LinearLayout.LayoutParams)localObject);
      ((TextView)localObject).setText(paramList.name);
      ((TextView)localObject).setTag(paramList);
      ((TextView)localObject).setBackgroundResource(paramString[3]);
      continue;
      i locali = (i)paramList.get(1);
      TextView localTextView = a(1, i, (LinearLayout.LayoutParams)localObject);
      localTextView.setText(locali.name);
      localTextView.setTag(locali);
      localTextView.setBackgroundResource(paramString[1]);
      locali = (i)paramList.get(0);
      localTextView = a(0, i, (LinearLayout.LayoutParams)localObject);
      localTextView.setText(locali.name);
      localTextView.setTag(locali);
      localTextView.setBackgroundResource(paramString[0]);
      paramList = (i)paramList.get(j - 1);
      localObject = a(j - 1, i, (LinearLayout.LayoutParams)localObject);
      ((TextView)localObject).setText(paramList.name);
      ((TextView)localObject).setTag(paramList);
      ((TextView)localObject).setBackgroundResource(paramString[2]);
    }
  }
  
  public void onClick(View paramView)
  {
    GMTrace.i(2505039675392L, 18664);
    paramView = paramView.getTag();
    if (!(paramView instanceof i))
    {
      GMTrace.o(2505039675392L, 18664);
      return;
    }
    paramView = (i)paramView;
    switch (paramView.type)
    {
    }
    for (;;)
    {
      GMTrace.o(2505039675392L, 18664);
      return;
      v.d("ChattingItemFooter", "get latest message");
      paramView.state = i.hvs;
      d(paramView);
      GMTrace.o(2505039675392L, 18664);
      return;
      v.d("ChattingItemFooter", "start webview url");
      paramView.state = i.hvs;
      d(paramView);
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView.value);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("geta8key_username", this.jgK);
      d.b(this.mContext, "webview", ".ui.tools.WebViewUI", localIntent);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ChattingItemFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */