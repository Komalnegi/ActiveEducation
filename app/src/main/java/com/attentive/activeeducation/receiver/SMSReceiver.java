package com.fdcs.societyrewards.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import com.fdcs.societyrewards.constant.Constant;


/**
 * Created by digital-360 on 9/1/2016.
 */
public class SMSReceiver extends BroadcastReceiver {
    private static  final String TAG = "SMSReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
        try {
            if (bundle != null) {
                Object[] pdusObj = (Object[]) bundle.get("pdus");
                for (Object aPdusObj : pdusObj) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) aPdusObj);
                    String senderAddress = currentMessage.getDisplayOriginatingAddress();
                    String message = currentMessage.getDisplayMessageBody();

                    Log.e("sms", "Received SMS: " + message + ", Sender: " + senderAddress);
                  //  Toast.makeText(context,"Received SMS: " + message + ", Sender: " + senderAddress,Toast.LENGTH_LONG).show();

                    if (!senderAddress.toLowerCase().contains(Constant.SMS_ORIGIN.toLowerCase())) {
                        return;
                    }

                    String verificationCode = getVerificationCode(message);

                    Intent intentUpdate = new Intent();
                    intentUpdate.setAction(Constant.MY_INTENT);
                    intentUpdate.addCategory(Intent.CATEGORY_DEFAULT);
                    intentUpdate.putExtra("OTP", verificationCode);

                    context.sendBroadcast(intentUpdate);
                }
            }

        }catch(Exception e){
            Log.e("sms", "Exception: " + e.getMessage());
        }
        }

    private String getVerificationCode(String message) {

        String[] separated = message.split(Constant.OTP_DELIMITER);
        String start = separated[0].trim();
        String end = separated[1].trim();

        Log.e("Vinod", message);
        Log.e("Vinod", start);
        Log.e("Vinod", end);

        return end;
    }

}
