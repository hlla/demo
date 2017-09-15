package com.tencent.mm.modelfriend;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.ajj;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends BaseAdapter
{
  private Context context;
  public LinkedList<ajj> hAG;
  private LinkedList<ajj> hAH;
  public List<String[]> hAI;
  private List<String[]> hAJ;
  public int[] hAK;
  private a hAL;
  public com.tencent.mm.ui.applet.b hAM;
  private b.b hAN;
  int showType;
  
  public j(Context paramContext, a parama, int paramInt)
  {
    GMTrace.i(4416702775296L, 32907);
    this.hAG = new LinkedList();
    this.hAH = new LinkedList();
    this.hAJ = new LinkedList();
    this.showType = 1;
    this.hAM = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap jg(String paramAnonymousString)
      {
        GMTrace.i(4454820610048L, 33191);
        paramAnonymousString = com.tencent.mm.x.b.a(paramAnonymousString, false, -1);
        GMTrace.o(4454820610048L, 33191);
        return paramAnonymousString;
      }
    });
    this.hAN = null;
    this.context = paramContext;
    this.showType = paramInt;
    this.hAL = parama;
    this.hAK = new int[this.hAG.size()];
    GMTrace.o(4416702775296L, 32907);
  }
  
  private void a(ajj paramajj, String[] paramArrayOfString)
  {
    GMTrace.i(4417642299392L, 32914);
    Iterator localIterator = this.hAH.iterator();
    while (localIterator.hasNext())
    {
      ajj localajj = (ajj)localIterator.next();
      if ((localajj.oSl != null) && (paramajj.oSl != null) && (localajj.oSl.equals(paramajj.oSl)))
      {
        v.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
        GMTrace.o(4417642299392L, 32914);
        return;
      }
    }
    this.hAH.add(paramajj);
    paramajj = paramArrayOfString[2];
    paramArrayOfString = paramArrayOfString[1];
    this.hAJ.add(new String[] { paramajj, paramArrayOfString });
    GMTrace.o(4417642299392L, 32914);
  }
  
  public final int Fg()
  {
    int k = 0;
    GMTrace.i(4416836993024L, 32908);
    int[] arrayOfInt = this.hAK;
    int m = arrayOfInt.length;
    int j = 0;
    if (j < m)
    {
      int n = arrayOfInt[j];
      int i;
      if (this.showType == 1)
      {
        i = k;
        if (n == 1) {
          i = k + 1;
        }
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        i = k;
        if (this.showType == 2)
        {
          i = k;
          if (n == 2) {
            i = k + 1;
          }
        }
      }
    }
    GMTrace.o(4416836993024L, 32908);
    return k;
  }
  
  public final boolean Fh()
  {
    GMTrace.i(4416971210752L, 32909);
    if ((this.hAK == null) || (this.hAK.length == 0))
    {
      GMTrace.o(4416971210752L, 32909);
      return false;
    }
    int i = 0;
    while (i < this.hAK.length)
    {
      int j = this.hAK[i];
      if (this.showType == 1)
      {
        if (j == 0)
        {
          GMTrace.o(4416971210752L, 32909);
          return false;
        }
      }
      else if ((this.showType == 2) && (j == 0))
      {
        GMTrace.o(4416971210752L, 32909);
        return false;
      }
      i += 1;
    }
    GMTrace.o(4416971210752L, 32909);
    return true;
  }
  
  public final void bh(boolean paramBoolean)
  {
    GMTrace.i(4417239646208L, 32911);
    int i;
    int[] arrayOfInt;
    int j;
    if (this.showType == 1)
    {
      i = 0;
      if (i < this.hAK.length)
      {
        arrayOfInt = this.hAK;
        if (paramBoolean) {}
        for (j = 1;; j = 0)
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
    }
    else if (this.showType == 2)
    {
      i = 0;
      if (i < this.hAK.length)
      {
        arrayOfInt = this.hAK;
        if (paramBoolean) {}
        for (j = 2;; j = 0)
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
    }
    notifyDataSetChanged();
    GMTrace.o(4417239646208L, 32911);
  }
  
  public final void e(LinkedList<ajj> paramLinkedList)
  {
    GMTrace.i(4417508081664L, 32913);
    if (paramLinkedList != null)
    {
      this.hAH.clear();
      this.hAG.clear();
      this.hAJ.clear();
      Iterator localIterator1 = this.hAI.iterator();
      while (localIterator1.hasNext())
      {
        String[] arrayOfString = (String[])localIterator1.next();
        Iterator localIterator2 = paramLinkedList.iterator();
        while (localIterator2.hasNext())
        {
          ajj localajj = (ajj)localIterator2.next();
          if (this.showType == 1)
          {
            if (((localajj.jLP == 1) || (localajj.jLP == 0)) && (!bf.mA(arrayOfString[2])) && (localajj.oSl.equals(g.n(arrayOfString[2].getBytes())))) {
              a(localajj, arrayOfString);
            }
          }
          else if ((this.showType == 2) && (localajj.jLP == 2) && (!bf.mA(arrayOfString[2])) && (localajj.oSl.equals(g.n(arrayOfString[2].getBytes())))) {
            a(localajj, arrayOfString);
          }
        }
      }
    }
    this.hAK = new int[this.hAH.size()];
    this.hAG.addAll(this.hAH);
    this.hAH.clear();
    GMTrace.o(4417508081664L, 32913);
  }
  
  public final void fC(int paramInt)
  {
    GMTrace.i(4417105428480L, 32910);
    if (this.showType == 1) {
      this.hAK[paramInt] = 1;
    }
    for (;;)
    {
      notifyDataSetChanged();
      GMTrace.o(4417105428480L, 32910);
      return;
      if (this.showType == 2) {
        this.hAK[paramInt] = 2;
      }
    }
  }
  
  public final ajj fD(int paramInt)
  {
    GMTrace.i(4417910734848L, 32916);
    ajj localajj = (ajj)this.hAG.get(paramInt);
    GMTrace.o(4417910734848L, 32916);
    return localajj;
  }
  
  public final int getCount()
  {
    GMTrace.i(4417776517120L, 32915);
    int i = this.hAG.size();
    GMTrace.o(4417776517120L, 32915);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    GMTrace.i(4418044952576L, 32917);
    long l = ((ajj)this.hAG.get(paramInt)).hashCode();
    GMTrace.o(4418044952576L, 32917);
    return l;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(4418179170304L, 32918);
    if (this.showType == 1)
    {
      if (this.hAN == null) {
        this.hAN = new b.b()
        {
          public final int Fi()
          {
            GMTrace.i(4439922442240L, 33080);
            int i = j.this.getCount();
            GMTrace.o(4439922442240L, 33080);
            return i;
          }
          
          public final String fE(int paramAnonymousInt)
          {
            GMTrace.i(4439788224512L, 33079);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= j.this.getCount()))
            {
              v.e("MicroMsg.FriendAdapter", "pos is invalid");
              GMTrace.o(4439788224512L, 33079);
              return null;
            }
            Object localObject = j.this.fD(paramAnonymousInt);
            if (localObject == null)
            {
              GMTrace.o(4439788224512L, 33079);
              return null;
            }
            localObject = ((ajj)localObject).jLx;
            GMTrace.o(4439788224512L, 33079);
            return (String)localObject;
          }
        };
      }
      if (this.hAM != null) {
        this.hAM.a(paramInt, this.hAN);
      }
    }
    ajj localajj = (ajj)this.hAG.get(paramInt);
    b localb;
    if (paramView == null)
    {
      localb = new b();
      if (this.showType == 1)
      {
        paramView = View.inflate(this.context, R.i.dcK, null);
        localb.hAR = ((TextView)paramView.findViewById(R.h.cks));
        localb.hAS = ((TextView)paramView.findViewById(R.h.ckl));
        localb.hAT = ((Button)paramView.findViewById(R.h.ckm));
        localb.hAU = ((Button)paramView.findViewById(R.h.cko));
        localb.hAQ = ((ImageView)paramView.findViewById(R.h.bRN));
        localb.hAV = ((TextView)paramView.findViewById(R.h.ckt));
        localb.hAW = ((TextView)paramView.findViewById(R.h.ckw));
        paramView.setTag(localb);
        paramViewGroup = localb;
        paramViewGroup.hAW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(4429050806272L, 32999);
            paramAnonymousView = j.this;
            int i = paramInt;
            if (paramAnonymousView.showType == 1) {
              paramAnonymousView.hAK[i] = 0;
            }
            for (;;)
            {
              paramAnonymousView.notifyDataSetChanged();
              GMTrace.o(4429050806272L, 32999);
              return;
              if (paramAnonymousView.showType == 2) {
                paramAnonymousView.hAK[i] = 0;
              }
            }
          }
        });
        if (this.showType != 1) {
          break label531;
        }
        if (bf.mA(((String[])this.hAJ.get(paramInt))[1])) {
          break label490;
        }
        paramViewGroup.hAR.setText(((String[])this.hAJ.get(paramInt))[1]);
        label281:
        paramViewGroup.hAT.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(4442338361344L, 33098);
            j.this.fC(paramInt);
            GMTrace.o(4442338361344L, 33098);
          }
        });
        a.b.a(paramViewGroup.hAQ, localajj.jLx);
        label309:
        switch (this.hAK[paramInt])
        {
        }
      }
    }
    for (;;)
    {
      GMTrace.o(4418179170304L, 32918);
      return paramView;
      paramViewGroup = localb;
      if (this.showType != 2) {
        break;
      }
      paramView = View.inflate(this.context, R.i.dcL, null);
      localb.hAR = ((TextView)paramView.findViewById(R.h.cks));
      localb.hAS = ((TextView)paramView.findViewById(R.h.ckl));
      localb.hAT = ((Button)paramView.findViewById(R.h.ckm));
      localb.hAU = ((Button)paramView.findViewById(R.h.cko));
      localb.hAV = ((TextView)paramView.findViewById(R.h.ckt));
      localb.hAW = ((TextView)paramView.findViewById(R.h.ckw));
      paramView.setTag(localb);
      paramViewGroup = localb;
      break;
      paramViewGroup = (b)paramView.getTag();
      break;
      label490:
      if (bf.mA(localajj.jMD))
      {
        paramViewGroup.hAR.setText(localajj.jLx);
        break label281;
      }
      paramViewGroup.hAR.setText(localajj.jMD);
      break label281;
      label531:
      if (this.showType != 2) {
        break label309;
      }
      paramViewGroup.hAR.setText(((String[])this.hAJ.get(paramInt))[1]);
      paramViewGroup.hAU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(4444485844992L, 33114);
          j.this.fC(paramInt);
          GMTrace.o(4444485844992L, 33114);
        }
      });
      break label309;
      paramViewGroup.hAT.setVisibility(8);
      paramViewGroup.hAS.setVisibility(0);
      paramViewGroup.hAV.setVisibility(0);
      paramViewGroup.hAW.setVisibility(0);
      continue;
      paramViewGroup.hAT.setVisibility(8);
      paramViewGroup.hAS.setVisibility(0);
      paramViewGroup.hAV.setVisibility(0);
      paramViewGroup.hAW.setVisibility(0);
      continue;
      paramViewGroup.hAT.setVisibility(8);
      paramViewGroup.hAU.setVisibility(8);
      paramViewGroup.hAS.setVisibility(0);
      paramViewGroup.hAV.setVisibility(0);
      paramViewGroup.hAW.setVisibility(0);
      continue;
      if (this.showType == 1)
      {
        paramViewGroup.hAS.setVisibility(8);
        paramViewGroup.hAT.setVisibility(0);
        paramViewGroup.hAU.setVisibility(8);
        paramViewGroup.hAV.setVisibility(8);
        paramViewGroup.hAW.setVisibility(8);
      }
      else if (this.showType == 2)
      {
        paramViewGroup.hAS.setVisibility(8);
        paramViewGroup.hAT.setVisibility(8);
        paramViewGroup.hAU.setVisibility(0);
        paramViewGroup.hAV.setVisibility(8);
        paramViewGroup.hAW.setVisibility(8);
      }
    }
  }
  
  public final void jf(String paramString)
  {
    GMTrace.i(4418313388032L, 32919);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.hAJ.size())
    {
      if (this.hAK[i] == 2) {
        localArrayList.add(((String[])this.hAJ.get(i))[0]);
      }
      i += 1;
    }
    paramString = new z(paramString, localArrayList);
    ap.vd().a(paramString, 0);
    GMTrace.o(4418313388032L, 32919);
  }
  
  public final void notifyDataSetChanged()
  {
    GMTrace.i(4417373863936L, 32912);
    super.notifyDataSetChanged();
    if (this.hAL != null) {
      this.hAL.notifyDataSetChanged();
    }
    GMTrace.o(4417373863936L, 32912);
  }
  
  public static abstract interface a
  {
    public abstract void notifyDataSetChanged();
  }
  
  static final class b
  {
    ImageView hAQ;
    TextView hAR;
    TextView hAS;
    Button hAT;
    Button hAU;
    TextView hAV;
    TextView hAW;
    
    b()
    {
      GMTrace.i(4436298563584L, 33053);
      GMTrace.o(4436298563584L, 33053);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */