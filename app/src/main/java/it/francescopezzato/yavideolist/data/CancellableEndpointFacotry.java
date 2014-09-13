package it.francescopezzato.yavideolist.data;

import com.google.common.util.concurrent.SettableFuture;

/**
 * Created by francesco on 13/09/2014.
 */
public class CancellableEndpointFacotry {


	public SettableFuture<WideConfiguration> getConfigService(EndpointFactory endpointFactory) {

		//ConfigService result = endpointFactory.create(ConfigService.class);
		//return endpointFactory.getConfigService();
		ConfigEndpoint configEndpoint = new ConfigEndpoint();

		return configEndpoint.getWideConfig(endpointFactory.getConfigService());

	}

}
