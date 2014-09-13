package it.francescopezzato.yavideolist.data;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by francesco on 25/08/2014.
 */
public interface ConfigService {

	@GET("/configuration")
	void wideConfig(Callback<WideConfiguration> callback);

}
