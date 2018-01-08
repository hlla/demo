package com.android.launcher2;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;

public class KeyboardDialog
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  public static final int CREATE_REQ_SRC_INVALID = 0;
  private static final String CREATE_REQ_SRC_KEY = "FOLDER_CREATE_REQ_SRC_KEY";
  private static final String TITLE_KEY = "TITLE_KEY";
  private static final String sFragmentTag = KeyboardDialog.class.getName();
  private EditText mEditText = null;
  Listener mListener = null;
  String mTitle = "";
  private int mWho = 0;
  
  public static void createAndShow(FragmentManager paramFragmentManager, Listener paramListener, String paramString)
  {
    if (isActive(paramFragmentManager)) {
      return;
    }
    KeyboardDialog localKeyboardDialog = new KeyboardDialog();
    localKeyboardDialog.init(paramListener, paramString);
    localKeyboardDialog.show(paramFragmentManager, sFragmentTag);
  }
  
  static void dismiss(FragmentManager paramFragmentManager)
  {
    paramFragmentManager = (DialogFragment)paramFragmentManager.findFragmentByTag(sFragmentTag);
    if (paramFragmentManager != null) {
      paramFragmentManager.dismissAllowingStateLoss();
    }
  }
  
  private void init(Listener paramListener, String paramString)
  {
    this.mListener = paramListener;
    this.mTitle = paramString;
    this.mWho = paramListener.hashCode();
  }
  
  static boolean isActive(FragmentManager paramFragmentManager)
  {
    return paramFragmentManager.findFragmentByTag(sFragmentTag) != null;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      this.mListener.confirmed(this.mEditText.getText().toString());
      continue;
      this.mListener.cancelled();
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    ViewGroup localViewGroup = (ViewGroup)getActivity().getLayoutInflater().inflate(2130903046, null);
    this.mEditText = ((EditText)localViewGroup.findViewById(2131689507));
    this.mEditText.setHint("");
    int j = 0;
    int i = j;
    if (paramBundle != null)
    {
      this.mWho = paramBundle.getInt("FOLDER_CREATE_REQ_SRC_KEY", 0);
      this.mEditText.setText("");
      i = j;
      if (this.mWho == 0) {
        i = 1;
      }
    }
    paramBundle = new AlertDialog.Builder(getActivity()).setTitle(this.mTitle).setIconAttribute(16843605).setView(localViewGroup).setPositiveButton(2131755021, this).setNegativeButton(2131755022, this).create();
    paramBundle.getWindow().setSoftInputMode(37);
    if (i != 0) {
      dismiss();
    }
    return paramBundle;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("FOLDER_CREATE_REQ_SRC_KEY", this.mWho);
    paramBundle.putString("TITLE_KEY", this.mEditText.getText().toString());
  }
  
  public void onStart()
  {
    super.onStart();
    if (!getShowsDialog()) {
      dismissAllowingStateLoss();
    }
  }
  
  public static abstract interface Listener
  {
    public abstract void cancelled();
    
    public abstract void confirmed(String paramString);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/KeyboardDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */