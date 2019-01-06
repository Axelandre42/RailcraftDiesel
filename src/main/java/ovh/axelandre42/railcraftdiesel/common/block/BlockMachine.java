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
package ovh.axelandre42.railcraftdiesel.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumFacing;
import ovh.axelandre42.railcraftdiesel.common.RailcraftDiesel;
import ovh.axelandre42.railcraftdiesel.common.utils.I18nUtils;

/**
 * @author Alexandre Waeles <www.axelandre42.ovh>
 *
 */
public class BlockMachine extends Block {

	public BlockMachine(String name) {
		super(Material.ROCK);
		
		this.setRegistryName(name);
		this.setTranslationKey(I18nUtils.prepareTranslationKey(name));
		this.setHardness(1.5F);
		this.setSoundType(SoundType.STONE);
		
		this.setDefaultState(this.blockState.getBaseState()
				.withProperty(RailcraftDiesel.machineType, RailcraftDiesel.MachineType.REFINERY)
				.withProperty(RailcraftDiesel.facing, EnumFacing.SOUTH)
				.withProperty(RailcraftDiesel.active, false));
	}
	
	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, RailcraftDiesel.machineType, RailcraftDiesel.facing, RailcraftDiesel.active);
	}

}
