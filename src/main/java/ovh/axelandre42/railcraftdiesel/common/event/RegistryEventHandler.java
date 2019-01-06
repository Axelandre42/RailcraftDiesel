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
package ovh.axelandre42.railcraftdiesel.common.event;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import ovh.axelandre42.railcraftdiesel.common.RailcraftDiesel;
import ovh.axelandre42.railcraftdiesel.common.block.BlockMachine;

/**
 * @author Alexandre Waeles <www.axelandre42.ovh>
 *
 */
@Mod.EventBusSubscriber
public class RegistryEventHandler {
	
	private BlockMachine blockMachine = new BlockMachine("machine");
	private ItemBlock itemMachine = new ItemBlock(blockMachine);
	
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		RailcraftDiesel.logger.info("Registering blocks...");
		IForgeRegistry<Block> registry = event.getRegistry();
		registry.register(blockMachine);
	}
	
	public void registerItems(RegistryEvent.Register<Item> event) {
		RailcraftDiesel.logger.info("Registering items...");
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(itemMachine);
	}
}
