package it.francescopezzato.yavideolist.data;

import com.google.common.util.concurrent.SettableFuture;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by francesco on 13/09/2014.
 */
public class ConfigEndpoint {


	public SettableFuture<WideConfiguration> getWideConfig(ConfigService service) {
		//service = endpointFactory.getConfigService();
		final SettableFuture<WideConfiguration> mSettableFuture = SettableFuture.create();

		Callback<WideConfiguration> callback = new Callback<WideConfiguration>() {
			@Override
			public void success(WideConfiguration wideConfiguration, Response response) {
				mSettableFuture.set(wideConfiguration);
			}

			@Override
			public void failure(RetrofitError error) {
				if (!mSettableFuture.isCancelled()) {
					mSettableFuture.setException(error);
				}
			}
		};

		service.wideConfig(callback);

		return mSettableFuture;
	}

}
