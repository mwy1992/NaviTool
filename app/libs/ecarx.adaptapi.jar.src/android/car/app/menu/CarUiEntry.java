/*    */ package android.car.app.menu;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.content.res.Configuration;
/*    */ import android.graphics.Bitmap;
/*    */ import android.os.Bundle;
/*    */ import android.view.View;
/*    */ import android.widget.EditText;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CarUiEntry
/*    */ {
/*    */   protected final Context mAppContext;
/*    */   protected final Context mUiLibContext;
/*    */   
/*    */   public CarUiEntry(Context paramContext1, Context paramContext2) {
/* 42 */     Configuration configuration = paramContext2.getResources().getConfiguration(); this.mUiLibContext = paramContext1.createConfigurationContext(configuration);
/* 43 */     this.mAppContext = paramContext2;
/*    */   }
/*    */   
/*    */   public abstract void closeDrawer();
/*    */   
/*    */   public abstract View getContentView();
/*    */   
/*    */   public abstract int getFragmentContainerId();
/*    */   
/*    */   public abstract CharSequence getSearchBoxText();
/*    */   
/*    */   public abstract void hideMenuButton();
/*    */   
/*    */   public abstract void hideTitle();
/*    */   
/*    */   public abstract void onPause();
/*    */   
/*    */   public abstract void onRestoreInstanceState(Bundle paramBundle);
/*    */   
/*    */   public abstract void onResume();
/*    */   
/*    */   public abstract void onSaveInstanceState(Bundle paramBundle);
/*    */   
/*    */   public abstract void onStart();
/*    */   
/*    */   public abstract void onStop();
/*    */   
/*    */   public abstract void openDrawer();
/*    */   
/*    */   public abstract void restoreMenuDrawable();
/*    */   
/*    */   public abstract void setAutoLightDarkMode();
/*    */   
/*    */   public abstract void setBackground(Bitmap paramBitmap);
/*    */   
/*    */   public abstract void setCarMenuCallbacks(CarMenuCallbacks paramCarMenuCallbacks);
/*    */   
/*    */   public abstract void setDarkMode();
/*    */   
/*    */   public abstract void setLightMode();
/*    */   
/*    */   public abstract void setMenuButtonBitmap(Bitmap paramBitmap);
/*    */   
/*    */   public abstract void setMenuButtonColor(int paramInt);
/*    */   
/*    */   public abstract void setScrimColor(int paramInt);
/*    */   
/*    */   public abstract void setSearchBoxColors(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */   
/*    */   public abstract void setSearchBoxEditListener(SearchBoxEditListener paramSearchBoxEditListener);
/*    */   
/*    */   public abstract void setSearchBoxEndView(View paramView);
/*    */   
/*    */   public abstract void setTitle(CharSequence paramCharSequence);
/*    */   
/*    */   public abstract void showMenu(String paramString1, String paramString2);
/*    */   
/*    */   public abstract void showSearchBox(View.OnClickListener paramOnClickListener);
/*    */   
/*    */   public abstract void showTitle();
/*    */   
/*    */   public abstract void showToast(String paramString, long paramLong);
/*    */   
/*    */   public abstract EditText startInput(String paramString, View.OnClickListener paramOnClickListener);
/*    */   
/*    */   public abstract void stopInput();
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\app\menu\CarUiEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */