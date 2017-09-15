package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.HorizontalListView.a;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class l
{
  private View Ih;
  private AdapterView.OnItemClickListener acN;
  private int jxr;
  ArrayList<c> kQi;
  public Context mContext;
  public ad mHandler;
  public a sNI;
  public int sOS;
  int sOT;
  public o sOU;
  View sOV;
  public j sOW;
  public String sOX;
  public String sOY;
  public boolean sOZ;
  private HorizontalListView sPa;
  public b sPb;
  private boolean sPc;
  private Comparator sPd;
  private HorizontalListView.a sPe;
  
  public l(Context paramContext)
  {
    GMTrace.i(16689840259072L, 124349);
    this.sOY = "";
    this.sOZ = true;
    this.kQi = new ArrayList();
    this.jxr = 3;
    this.sPc = true;
    this.mHandler = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        int i = 0;
        GMTrace.i(998043025408L, 7436);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          GMTrace.o(998043025408L, 7436);
          return;
          paramAnonymousMessage = l.this;
          paramAnonymousMessage.mHandler.removeMessages(20001);
          Object localObject;
          label167:
          String str;
          if (paramAnonymousMessage.sOZ)
          {
            localObject = paramAnonymousMessage.sPb;
            ((l.b)localObject).mData = paramAnonymousMessage.kQi;
            ((l.b)localObject).notifyDataSetInvalidated();
            if ((paramAnonymousMessage.kQi == null) || (paramAnonymousMessage.kQi.size() <= 2)) {
              break label242;
            }
            paramAnonymousMessage.sOU.setWidth((int)(paramAnonymousMessage.sOS * 2.5D) + paramAnonymousMessage.sOT * 2);
            paramAnonymousMessage.bFV();
            if ((paramAnonymousMessage.kQi == null) || (paramAnonymousMessage.kQi.size() < 3)) {
              break label304;
            }
            paramAnonymousMessage.mHandler.sendEmptyMessageDelayed(20001, 5000L);
            localObject = g.oSF;
            str = paramAnonymousMessage.sOX;
            if (paramAnonymousMessage.kQi != null) {
              break label321;
            }
          }
          for (;;)
          {
            ((g)localObject).i(10994, new Object[] { Integer.valueOf(0), str, "", Integer.valueOf(0), "", Integer.valueOf(i) });
            GMTrace.o(998043025408L, 7436);
            return;
            label242:
            if ((paramAnonymousMessage.kQi != null) && (paramAnonymousMessage.kQi.size() == 2))
            {
              paramAnonymousMessage.sOU.setWidth(paramAnonymousMessage.sOS * 2 + paramAnonymousMessage.sOT * 2);
              break;
            }
            paramAnonymousMessage.sOU.setWidth(paramAnonymousMessage.sOS + paramAnonymousMessage.sOT * 2);
            break;
            label304:
            paramAnonymousMessage.mHandler.sendEmptyMessageDelayed(20001, 3000L);
            break label167;
            label321:
            i = paramAnonymousMessage.kQi.size();
          }
          l.this.hide();
          GMTrace.o(998043025408L, 7436);
          return;
          removeMessages(20001);
        }
      }
    };
    this.sPd = new Comparator() {};
    this.acN = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(1015893983232L, 7569);
        if (l.this.sPb == null) {}
        for (paramAnonymousAdapterView = null;; paramAnonymousAdapterView = l.this.sPb.lo(paramAnonymousInt))
        {
          if ((paramAnonymousAdapterView != null) && (l.this.sOW != null) && (l.this.sNI != null))
          {
            l.this.sOW.n(paramAnonymousAdapterView);
            l.this.sNI.clear();
            g.oSF.i(10994, new Object[] { Integer.valueOf(1), l.this.sOX, "", Integer.valueOf(paramAnonymousInt), paramAnonymousAdapterView.EQ(), Integer.valueOf(l.this.sPb.getCount()) });
          }
          l.this.sOU.dismiss();
          GMTrace.o(1015893983232L, 7569);
          return;
        }
      }
    };
    this.sPe = new HorizontalListView.a()
    {
      public final boolean E(MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(990929485824L, 7383);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          GMTrace.o(990929485824L, 7383);
          return false;
          l.this.mHandler.sendEmptyMessage(20002);
          continue;
          l.this.mHandler.sendEmptyMessageDelayed(20001, 3000L);
        }
      }
    };
    this.mContext = paramContext;
    this.Ih = View.inflate(this.mContext, a.f.kYw, null);
    this.sPa = ((HorizontalListView)this.Ih.findViewById(a.e.kYv));
    this.sPb = new b();
    this.sPa.setAdapter(this.sPb);
    this.sPa.setOnItemClickListener(this.acN);
    this.sPa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(980057849856L, 7302);
        v.d("MicroMsg.emoji.SuggestEmoticonBubble", "onItemSelected ...");
        GMTrace.o(980057849856L, 7302);
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
      {
        GMTrace.i(980192067584L, 7303);
        GMTrace.o(980192067584L, 7303);
      }
    });
    this.sPa.sPe = this.sPe;
    this.sOS = a.T(this.mContext, a.c.kYl);
    this.sOT = a.T(this.mContext, a.c.aXy);
    this.sOU = new o(this.Ih, this.sOS + this.sOT * 2, this.sOS + this.sOT * 2, true);
    this.sOU.setBackgroundDrawable(new ColorDrawable(0));
    this.sOU.setOutsideTouchable(true);
    this.sOU.setFocusable(false);
    GMTrace.o(16689840259072L, 124349);
  }
  
  public final void bFV()
  {
    GMTrace.i(983950163968L, 7331);
    if (this.sOV != null)
    {
      int[] arrayOfInt = new int[2];
      this.sOV.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[0];
      int j = (this.sOU.getWidth() - this.sOV.getWidth()) / 2;
      int k = arrayOfInt[1];
      int m = this.sOU.getHeight();
      this.sOU.showAtLocation(this.sOV, 0, i - j, k - m);
    }
    GMTrace.o(983950163968L, 7331);
  }
  
  public final boolean ba(String paramString)
  {
    GMTrace.i(984218599424L, 7333);
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        if (!bf.mA(paramString))
        {
          localObject = ((PluginEmoji)h.j(PluginEmoji.class)).getEmojiMgr().uc(paramString);
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
          {
            this.sOX = paramString.replaceAll(",", "");
            if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
            {
              GMTrace.o(984218599424L, 7333);
              return false;
            }
            paramString = new ArrayList();
            this.kQi.clear();
            int j = ((ArrayList)localObject).size();
            i = 0;
            if ((i < j) && (i < 100))
            {
              localc = ((PluginEmoji)h.j(PluginEmoji.class)).getEmojiMgr().tX((String)((ArrayList)localObject).get(i));
              if (localc == null) {
                break label394;
              }
              paramString.add(localc);
              break label394;
            }
            if (paramString.isEmpty())
            {
              v.i("MicroMsg.emoji.SuggestEmoticonBubble", "sorEmojiList return. empty list.");
              GMTrace.o(984218599424L, 7333);
              return false;
            }
            if (!this.sPc) {
              break label305;
            }
            localObject = (c)Collections.max(paramString, this.sPd);
            this.kQi.add(localObject);
            paramString = paramString.iterator();
            if (!paramString.hasNext()) {
              break label355;
            }
            c localc = (c)paramString.next();
            if ((localc.bA(localObject)) || (this.kQi.contains(localc))) {
              continue;
            }
            this.kQi.add(localc);
            continue;
          }
        }
        paramString = paramString.iterator();
      }
      catch (Exception paramString)
      {
        v.e("MicroMsg.emoji.SuggestEmoticonBubble", bf.g(paramString));
        this.sOX = "";
        GMTrace.o(984218599424L, 7333);
        return false;
      }
      label305:
      while (paramString.hasNext())
      {
        localObject = (c)paramString.next();
        if (!this.kQi.contains(localObject)) {
          this.kQi.add(localObject);
        }
      }
      label355:
      if ((this.kQi == null) || (this.kQi.isEmpty()))
      {
        GMTrace.o(984218599424L, 7333);
        return false;
      }
      GMTrace.o(984218599424L, 7333);
      return true;
      label394:
      i += 1;
    }
  }
  
  public final void hide()
  {
    GMTrace.i(984084381696L, 7332);
    if (this.sOU == null)
    {
      GMTrace.o(984084381696L, 7332);
      return;
    }
    if (this.sOU.isShowing()) {
      this.sOU.dismiss();
    }
    GMTrace.o(984084381696L, 7332);
  }
  
  public static abstract interface a
  {
    public abstract void clear();
  }
  
  final class b
    extends BaseAdapter
  {
    ArrayList<c> mData;
    
    b()
    {
      GMTrace.i(1030389497856L, 7677);
      GMTrace.o(1030389497856L, 7677);
    }
    
    public final int getCount()
    {
      GMTrace.i(1030523715584L, 7678);
      if (this.mData == null)
      {
        GMTrace.o(1030523715584L, 7678);
        return 0;
      }
      int i = this.mData.size();
      GMTrace.o(1030523715584L, 7678);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(1030792151040L, 7680);
      long l = paramInt;
      GMTrace.o(1030792151040L, 7680);
      return l;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(1030926368768L, 7681);
      c localc;
      String str;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(l.this.mContext).inflate(a.f.kYx, null);
        paramViewGroup = new l.c(l.this, paramView);
        paramView.setTag(paramViewGroup);
        localc = lo(paramInt);
        paramViewGroup.kMJ.hP = l.this.sOS;
        paramViewGroup.kMJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        str = ((PluginEmoji)h.j(PluginEmoji.class)).getEmojiMgr().ua(localc.EQ());
        if (!bf.mA(str)) {
          break label200;
        }
        paramViewGroup.kMJ.setContentDescription(l.this.mContext.getString(a.g.edG));
        label138:
        if (localc == null) {
          break label226;
        }
        if (!localc.bNj()) {
          break label212;
        }
        paramViewGroup.kMJ.a(c.bb(l.this.mContext, localc.getName()), localc.getName());
      }
      for (;;)
      {
        GMTrace.o(1030926368768L, 7681);
        return paramView;
        paramViewGroup = (l.c)paramView.getTag();
        break;
        label200:
        paramViewGroup.kMJ.setContentDescription(str);
        break label138;
        label212:
        paramViewGroup.kMJ.a(localc, "");
        continue;
        label226:
        v.w("MicroMsg.emoji.SuggestEmoticonBubble", "emoji info is null.");
      }
    }
    
    public final c lo(int paramInt)
    {
      GMTrace.i(1030657933312L, 7679);
      if ((this.mData != null) && (this.mData.size() > paramInt))
      {
        c localc = (c)this.mData.get(paramInt);
        GMTrace.o(1030657933312L, 7679);
        return localc;
      }
      GMTrace.o(1030657933312L, 7679);
      return null;
    }
  }
  
  final class c
  {
    PreViewEmojiView kMJ;
    
    public c(View paramView)
    {
      GMTrace.i(1027705143296L, 7657);
      this.kMJ = ((PreViewEmojiView)paramView.findViewById(a.e.kYu));
      this.kMJ.hP = l.this.sOS;
      GMTrace.o(1027705143296L, 7657);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/chat/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */