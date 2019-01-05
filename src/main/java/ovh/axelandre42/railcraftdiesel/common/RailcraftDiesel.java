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

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Alexandre Waeles <www.axelandre42.ovh>
 * 
 */
@Mod(modid = "railcraftdiesel", useMetadata = true, certificateFingerprint = "040b147c3cfaf18aa82014381f847033a93f41f6")
public class RailcraftDiesel {
	
	private RailcraftDieselEnvironment environment;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		RailcraftDieselEnvironment.Spec spec = new RailcraftDieselEnvironment.Spec();
		spec.setLogger(event.getModLog());
		spec.setConfigFile(event.getSuggestedConfigurationFile());
		
		this.environment = RailcraftDieselEnvironment.instance(spec);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	@EventHandler
	public void fingerprintViolation(FMLFingerprintViolationEvent event) {
		if (event.isDirectory())
			return;
		
		this.environment.logger.warn("Fingerprint violated: you\'re running and unofficial version of this mod!");
		this.environment.unofficial = true;
	}
	
	
}
