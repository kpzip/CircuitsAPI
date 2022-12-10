package com.kpzip.circuitsapi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class CircuitsAPI implements ModInitializer {
	
	public static final Logger LOGGER = LogManager.getLogger(Instances.MOD_ID);

	@Override
	public void onInitialize() {
		

		LOGGER.info("loading circuits api...");
	}
}
