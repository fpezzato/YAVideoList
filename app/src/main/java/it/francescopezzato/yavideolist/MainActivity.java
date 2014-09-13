package it.francescopezzato.yavideolist;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;

import it.francescopezzato.yavideolist.data.CancellableEndpointFacotry;
import it.francescopezzato.yavideolist.data.EndpointFactory;
import it.francescopezzato.yavideolist.data.WideConfiguration;


public class MainActivity extends Activity {

	EndpointFactory endpointFactory = new EndpointFactory();
	private TextView mDebugTExt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDebugTExt = (TextView) findViewById(R.id.debug_text);
	}


	private Handler handler = new Handler();

	SettableFuture<WideConfiguration> mFuture;
	private Runnable runnable = new Runnable() {
		@Override
		public void run() {
			Log.i("MainActivity", "-> cancel future");
			mFuture.cancel(true);
		}
	};


	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();

		CancellableEndpointFacotry c = new CancellableEndpointFacotry();
		Log.i("MainActivity", "-> ");
		Log.i("MainActivity", "-> ##########START################");
		mFuture = c.getConfigService(endpointFactory);

		Futures.addCallback(mFuture, new FutureCallback<WideConfiguration>() {
			@Override
			public void onSuccess(WideConfiguration result) {
				Log.i("MainActivity", "-> onSuccess");
			}

			@Override
			public void onFailure(Throwable t) {
				if(mFuture.isCancelled()){

				}
				else {
					Log.i("MainActivity", "-> onFailure" + t.getMessage());
				}
			}
		});

		handler.postDelayed(runnable, 5000);


		//endpointFactory.getConfigService().wideConfig(c);

	}

	@Override
	public void onDetachedFromWindow() {

		super.onDetachedFromWindow();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
