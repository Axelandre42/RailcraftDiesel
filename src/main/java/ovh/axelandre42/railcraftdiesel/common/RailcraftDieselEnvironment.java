/*
 * Copyright 2019 Alexandre Waeles
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the
 * Software, and to permit persons to whom the Software is furnished to
 * do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package ovh.axelandre42.railcraftdiesel.common;

import java.io.File;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.config.Configuration;

/**
 * @author Alexandre Waeles <www.axelandre42.ovh>
 *
 */
public class RailcraftDieselEnvironment {
	
	public static class Spec {
		
		private Logger logger;
		private File configFile;
		
		public Logger getLogger() {
			return logger;
		}
		
		public void setLogger(Logger logger) {
			this.logger = logger;
		}
		
		public File getConfigFile() {
			return configFile;
		}
		
		public void setConfigFile(File configFile) {
			this.configFile = configFile;
		}
		
	}
	
	private static RailcraftDieselEnvironment INSTANCE = null;
	
	public static RailcraftDieselEnvironment instance() {
		if (INSTANCE == null)
			throw new NullPointerException();
		
		return INSTANCE;
	}
	
	public static RailcraftDieselEnvironment instance(RailcraftDieselEnvironment.Spec spec) {
		if (INSTANCE == null) {
			INSTANCE = new RailcraftDieselEnvironment(
					spec.getLogger(),
					spec.getConfigFile()
			);
		}
		
		return INSTANCE;
	}
	
	public final Logger logger;
	public final Configuration config;
	public boolean unofficial = false;
	
	private RailcraftDieselEnvironment(Logger logger, File configFile) {
		this.logger = logger;
		this.config = new Configuration(configFile);
	}
}
