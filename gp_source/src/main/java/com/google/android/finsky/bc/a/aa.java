package com.google.android.finsky.bc.a;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.t;
import com.google.android.finsky.be.w;
import com.google.android.finsky.be.x;
import com.google.wireless.android.finsky.dfe.e.a.de;
import com.google.wireless.android.finsky.dfe.e.a.df;
import com.google.wireless.android.finsky.dfe.e.a.ee;
import com.google.wireless.android.finsky.dfe.e.a.en;
import java.util.Set;

public final class aa
  extends m
{
  public final de a;
  public final t b;
  public final w c;
  
  public aa(LayoutInflater paramLayoutInflater, de paramde, w paramw, t paramt)
  {
    super(paramLayoutInflater);
    this.a = paramde;
    this.c = paramw;
    this.b = paramt;
  }
  
  public final int a()
  {
    return 2131625298;
  }
  
  public final void a(d paramd, View paramView)
  {
    EditText localEditText = (EditText)paramView.findViewById(2131428366);
    TextView localTextView = (TextView)paramView.findViewById(2131427663);
    Object localObject1 = this.a;
    Object localObject2 = ((de)localObject1).d;
    boolean bool1;
    if (localObject2 != null)
    {
      localObject2 = ((df)localObject2).h;
      if (localObject2 != null) {
        if ((((en)localObject2).f & 0x1) != 0) {
          if (((de)localObject1).d()) {
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = this.a;
      boolean bool2;
      if (((de)localObject1).d != null)
      {
        localObject1 = ((de)localObject1).e;
        if (localObject1 != null) {
          if (this.c.c((String)localObject1)) {
            bool2 = true;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.a;
        localObject2 = ((de)localObject1).d;
        boolean bool3;
        if (localObject2 != null) {
          if ((((df)localObject2).a & 0x4) != 0) {
            bool3 = true;
          }
        }
        for (;;)
        {
          localObject2 = ((de)localObject1).a;
          boolean bool4;
          if (localObject2 != null) {
            if ((((ee)localObject2).a & 0x1) != 0) {
              bool4 = true;
            }
          }
          for (;;)
          {
            localObject2 = ((de)localObject1).e;
            if (localObject2 == null) {}
            for (;;)
            {
              this.e.a(this.a.d, localEditText, paramd);
              boolean bool5;
              if (bool1)
              {
                if (localEditText.getText() == null) {
                  break label556;
                }
                if (localEditText.getText().toString().isEmpty()) {
                  break label550;
                }
                bool5 = localEditText.getText().toString().matches(this.a.g);
              }
              for (;;)
              {
                this.b.a(this.a.d.h.C, bool5);
                if (bool2) {
                  localEditText.setText(this.c.b(this.a.e));
                }
                localObject1 = this.a;
                if ((((de)localObject1).c != null) && (((de)localObject1).d()))
                {
                  paramView = (TextView)paramView.findViewById(2131428052);
                  this.e.a(this.a.c, paramView, paramd, null);
                  paramView.setVisibility(4);
                  localEditText.setOnFocusChangeListener(new ab(this, localEditText, paramView));
                }
                if (!bool3) {}
                for (;;)
                {
                  localEditText.addTextChangedListener(new ac(this, bool3, bool4, localTextView, localEditText, bool1));
                  paramd = this.c;
                  paramView = this.a.e;
                  paramd.a = new ad(this, bool2, localEditText);
                  paramd.a.a();
                  if (paramd.b.containsKey(paramView)) {
                    paramd.a.a(paramd.b.getString(paramView));
                  }
                  return;
                  int i = this.a.d.f;
                  localEditText.setFilters(new InputFilter[] { new LengthFilter(i) });
                  if (bool4)
                  {
                    this.e.a(this.a.a, localTextView, paramd, null);
                    localTextView.setText(String.format(this.a.a.e, new Object[] { Integer.valueOf(0), Integer.valueOf(i) }));
                  }
                }
                label550:
                bool5 = false;
                continue;
                label556:
                bool5 = false;
              }
              if (((de)localObject1).f) {
                this.c.c.add(localObject2);
              }
            }
            bool4 = false;
            continue;
            bool4 = false;
          }
          bool3 = false;
          continue;
          bool3 = false;
        }
        bool2 = false;
        continue;
        bool2 = false;
        continue;
        bool2 = false;
      }
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */