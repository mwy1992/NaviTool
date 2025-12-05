/*    */ package com.ecarx.xui.adaptapi.diminteraction;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContactsInteraction
/*    */   extends AbsCarSignal
/*    */   implements IContactsInteraction
/*    */ {
/*    */   private static final String TAG = "ContactsInteraction";
/*    */   
/*    */   protected ContactsInteraction(Context paramContext) {
/* 17 */     super(paramContext);
/*    */   }
/*    */   
/*    */   public void updateContacts(int paramInt, List<IContactsInteraction.IContact> paramList) {}
/*    */   
/*    */   public void updateSearchContacts(int paramInt, List<IContactsInteraction.IContact> paramList, String paramString) {}
/*    */   
/*    */   public void updateCallLogList(List<IContactsInteraction.ICallLog> paramList) {}
/*    */   
/*    */   public void registerContactsInteractionCallback(IContactsInteraction.IContactsInteractionCallback paramIContactsInteractionCallback) {}
/*    */   
/*    */   public void unregisterContactsInteractionCallback(IContactsInteraction.IContactsInteractionCallback paramIContactsInteractionCallback) {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\ContactsInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */