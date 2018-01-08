package com.android.launcher2;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class FolderEditText
  extends EditText
{
  private Folder mFolder;
  
  public FolderEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public FolderEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FolderEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    boolean bool = true;
    switch (paramDragEvent.getAction())
    {
    case 4: 
    default: 
      bool = super.onDragEvent(paramDragEvent);
    }
    return bool;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) || (paramKeyEvent.getKeyCode() == 23))
    {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
      this.mFolder.doneEditingFolderName(true);
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public Parcelable onSaveInstanceState()
  {
    ViewParent localViewParent = getParent();
    View localView = ((ViewGroup)localViewParent).findFocus();
    setFocusableInTouchMode(true);
    requestFocus();
    Parcelable localParcelable = super.onSaveInstanceState();
    if (localView != null) {
      localView.requestFocus();
    }
    for (;;)
    {
      setFocusableInTouchMode(false);
      return localParcelable;
      localViewParent.requestChildFocus(null, null);
    }
  }
  
  public void setFolder(Folder paramFolder)
  {
    this.mFolder = paramFolder;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/FolderEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */