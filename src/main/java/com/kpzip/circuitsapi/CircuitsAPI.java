package com.kpzip.circuitsapi;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CircuitsAPI implements ModInitializer {
	
	public static final Logger LOGGER = LogManager.getLogger(Instances.MOD_ID);

	@Override
	public void onInitialize() {
		

		LOGGER.info("loading circuits api...");
	}
}
