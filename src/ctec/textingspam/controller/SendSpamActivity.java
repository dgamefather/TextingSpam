package ctec.textingspam.controller;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SendSpamActivity extends Activity
{
	
	private Button fifthsense;
	private EditText numbphone;
	private EditText messy;
	private TextView andAction;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_spam);
		
		fifthsense = (Button) findViewById(R.id.sendButt);
		messy = (EditText) findViewById(R.id.messageText);
		numbphone = (EditText) findViewById(R.id.phoneText);
		andAction = (TextView) findViewById(R.id.actionNotifier);
		
		heyListen();
	}
	
	private void heyListen()
	{
		fifthsense.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				try
				{
					String contact = numbphone.getText().toString();
					String message = messy.getText().toString();
					sendSMS(contact, message);
					
					andAction.setText(getString(R.string.success_mess));
				}
				catch(Exception currentException)
				{
					andAction.setText(getString(R.string.epic_fail_mess));
				}
			}
			
		});
	}
	
	private void sendSMS(String messageAds, String messageDownload)
	{
		SmsManager myMessMan = SmsManager.getDefault();
		myMessMan.sendTextMessage(messageAds, null, messageDownload, null, null);
		
	}
}
