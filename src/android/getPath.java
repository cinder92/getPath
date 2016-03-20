package cordova.com.getPath;

import java.io.File;
import android.os.Environment;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class getSdCard extends CordovaPlugin{
    @Override
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("getExternal")) {
            this.getExternal(callbackContext);
            return true;
        }else{
          if(action.equals("getInternal")){
            this.getInternal(callbackContext);
            return true;
          }
        }
        return false;
    }

    private void getInternal(CallbackContext callbackContext){
        String baseDir = "";
        baseDir +=  Environment.getExternalStorageDirectory().getAbsolutePath();
        baseDir += "/";
        callbackContext.success(baseDir);
    }

    private void getExternal(CallbackContext callbackContext) {
        String baseDir = "";

        if(new File("/storage/extSdCard/").exists()){
            baseDir+="/storage/extSdCard/";
        }else{
          if(new File("/storage/sdcard1/").exists()){
            baseDir+="/storage/sdcard1/";
          }else{
            if(new File("/storage/usbcard1/").exists()){
                baseDir+="/storage/usbcard1/";
            }else{
              if(new File("/storage/external_SD/").exists()){
                baseDir+="/storage/external_SD/";
              }
            }
          }
        }

        callbackContext.success(baseDir);
    }

}