// PicPicService.aidl
package com.picpic;
import com.picpic.RequestCallback;
// Declare any non-default types here with import statements

interface PicPicInterface {
   void newService();
   void login(String params,RequestCallback callback);
   void startApp(String params);
}
