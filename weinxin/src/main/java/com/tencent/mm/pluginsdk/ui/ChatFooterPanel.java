package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel
  extends LinearLayout
{
  public static int SCENE_SNS;
  public static int sGV;
  public static int sGW;
  public static int sGX;
  public a sGS;
  public f sGT;
  protected int sGU;
  
  static
  {
    GMTrace.i(1156151508992L, 8614);
    sGV = 0;
    sGW = 1;
    SCENE_SNS = 2;
    sGX = 3;
    GMTrace.o(1156151508992L, 8614);
  }
  
  public ChatFooterPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1153467154432L, 8594);
    GMTrace.o(1153467154432L, 8594);
  }
  
  public void a(f paramf)
  {
    GMTrace.i(1155614638080L, 8610);
    this.sGT = paramf;
    GMTrace.o(1155614638080L, 8610);
  }
  
  public abstract void anG();
  
  public abstract void anH();
  
  public abstract void anI();
  
  public abstract void anJ();
  
  public abstract void anM();
  
  public abstract void anN();
  
  public void destroy()
  {
    GMTrace.i(1155883073536L, 8612);
    GMTrace.o(1155883073536L, 8612);
  }
  
  public abstract void dx(boolean paramBoolean);
  
  public abstract void dy(boolean paramBoolean);
  
  public abstract void k(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void lr(int paramInt);
  
  public abstract void ls(int paramInt);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void refresh();
  
  public abstract void uB(String paramString);
  
  public abstract void uC(String paramString);
  
  public final void xf(int paramInt)
  {
    GMTrace.i(1155748855808L, 8611);
    this.sGU = paramInt;
    GMTrace.o(1155748855808L, 8611);
  }
  
  public static abstract interface a
  {
    public abstract void Zb();
    
    public abstract void aIG();
    
    public abstract void append(String paramString);
    
    public abstract void fx(boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/ChatFooterPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */