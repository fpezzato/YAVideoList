package it.francescopezzato.yavideolist.data;

/**
 * Created by francesco on 25/08/2014.
 */
public class ConfigurationCache {

	ConfigService mConfigService;

	private WideConfiguration mConfiguration;

	public ConfigurationCache(ConfigService configService) {
		this.mConfigService = configService;
	}

	/*public Callback<WideConfiguration> getConfiguration() {
		mConfigService.wideConfig(new Callback<WideConfiguration>() {
			@Override
			public void success(WideConfiguration wideConfiguration, Response response) {

			}

			@Override
			public void failure(RetrofitError error) {

			}
		});


	}*/

}
