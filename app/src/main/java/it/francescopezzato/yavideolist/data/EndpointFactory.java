package it.francescopezzato.yavideolist.data;

import com.squareup.okhttp.OkHttpClient;

import java.net.InetSocketAddress;
import java.net.Proxy;

import retrofit.Endpoints;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by francesco on 25/08/2014.
 */
public class EndpointFactory {

	RestAdapter mRestAdapter;

	{
		Proxy proxy =
			new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved("192.168.1.7", 8888));

		OkClient okClient = new OkClient(new OkHttpClient().setProxy(proxy));

		mRestAdapter = new RestAdapter.Builder()
			.setEndpoint(Endpoints.newFixedEndpoint("http://api.themoviedb.org/3"))
			.setClient(okClient)
			.setRequestInterceptor(new RequestInterceptor() {
				@Override
				public void intercept(RequestFacade request) {
					request.addQueryParam("api_key", "2339ad48747d1aa7e60846c6223afcac");
				}
			})


			.build();
	}


	public ConfigService getConfigService() {

		ConfigService result = mRestAdapter.create(ConfigService.class);

		return result;
	}

}
