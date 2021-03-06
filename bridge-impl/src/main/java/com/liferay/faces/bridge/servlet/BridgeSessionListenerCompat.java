/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.bridge.servlet;

import javax.faces.context.FacesContext;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * This class provides a compatibility layer that isolates differences between JSF1 and JSF2.
 *
 * @author  Neil Griffin
 */
public abstract class BridgeSessionListenerCompat {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(BridgeSessionListenerCompat.class);

	// Private Constants
	private static final String MOJARRA_INJECTION_PROVIDER_TASK =
		"com.sun.faces.config.ConfigManager_INJECTION_PROVIDER_TASK";

	public Object getMojarraInjectionProvider(FacesContext facesContext) {

		Object mojarraInjectionProvider = facesContext.getAttributes().get(MOJARRA_INJECTION_PROVIDER_TASK);

		if (mojarraInjectionProvider == null) {
			logger.warn("Unable to determine Mojarra InjectionProvider. " +
				"For more info, see http://issues.liferay.com/browse/FACES-1511");
		}

		return mojarraInjectionProvider;
	}
}
