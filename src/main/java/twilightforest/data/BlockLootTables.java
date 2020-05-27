package twilightforest.data;

import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.world.storage.loot.LootTable;
import twilightforest.block.TFBlocks;

import java.util.HashSet;
import java.util.Set;

public class BlockLootTables extends net.minecraft.data.loot.BlockLootTables {
	private final Set<Block> knownBlocks = new HashSet<>();

	@Override
	protected void registerLootTable(Block block, LootTable.Builder builder) {
		super.registerLootTable(block, builder);
		knownBlocks.add(block);
	}

	@Override
	protected void addTables() {
		registerDropSelfLootTable(TFBlocks.oak_log.get());
		registerDropSelfLootTable(TFBlocks.oak_wood.get());
		registerDropSelfLootTable(TFBlocks.oak_sapling.get());
		registerDropSelfLootTable(TFBlocks.twilight_oak_planks.get());
		registerDropSelfLootTable(TFBlocks.twilight_oak_stairs.get());
		registerLootTable(TFBlocks.twilight_oak_slab.get(), droppingSlab(TFBlocks.twilight_oak_slab.get()));
		registerDropSelfLootTable(TFBlocks.twilight_oak_button.get());
		registerDropSelfLootTable(TFBlocks.twilight_oak_fence.get());
		registerDropSelfLootTable(TFBlocks.twilight_oak_gate.get());
		registerDropSelfLootTable(TFBlocks.twilight_oak_plate.get());
		registerLootTable(TFBlocks.twilight_oak_door.get(), (b) -> droppingWhen(b, DoorBlock.HALF, DoubleBlockHalf.LOWER));
		registerDropSelfLootTable(TFBlocks.twilight_oak_trapdoor.get());

		registerDropSelfLootTable(TFBlocks.canopy_log.get());
		registerDropSelfLootTable(TFBlocks.canopy_wood.get());
		registerDropSelfLootTable(TFBlocks.canopy_sapling.get());
		registerDropSelfLootTable(TFBlocks.canopy_planks.get());
		registerDropSelfLootTable(TFBlocks.canopy_stairs.get());
		registerLootTable(TFBlocks.canopy_slab.get(), droppingSlab(TFBlocks.canopy_slab.get()));
		registerDropSelfLootTable(TFBlocks.canopy_button.get());
		registerDropSelfLootTable(TFBlocks.canopy_fence.get());
		registerDropSelfLootTable(TFBlocks.canopy_gate.get());
		registerDropSelfLootTable(TFBlocks.canopy_plate.get());
		registerLootTable(TFBlocks.canopy_door.get(), (b) -> droppingWhen(b, DoorBlock.HALF, DoubleBlockHalf.LOWER));
		registerDropSelfLootTable(TFBlocks.canopy_trapdoor.get());

		registerDropSelfLootTable(TFBlocks.mangrove_log.get());
		registerDropSelfLootTable(TFBlocks.mangrove_wood.get());
		registerDropSelfLootTable(TFBlocks.mangrove_sapling.get());
		registerDropSelfLootTable(TFBlocks.mangrove_planks.get());
		registerDropSelfLootTable(TFBlocks.mangrove_stairs.get());
		registerLootTable(TFBlocks.mangrove_slab.get(), droppingSlab(TFBlocks.mangrove_slab.get()));
		registerDropSelfLootTable(TFBlocks.mangrove_button.get());
		registerDropSelfLootTable(TFBlocks.mangrove_fence.get());
		registerDropSelfLootTable(TFBlocks.mangrove_gate.get());
		registerDropSelfLootTable(TFBlocks.mangrove_plate.get());
		registerLootTable(TFBlocks.mangrove_door.get(), (b) -> droppingWhen(b, DoorBlock.HALF, DoubleBlockHalf.LOWER));
		registerDropSelfLootTable(TFBlocks.mangrove_trapdoor.get());

		registerDropSelfLootTable(TFBlocks.dark_log.get());
		registerDropSelfLootTable(TFBlocks.dark_wood.get());
		registerDropSelfLootTable(TFBlocks.darkwood_sapling.get());
		registerDropSelfLootTable(TFBlocks.dark_planks.get());
		registerDropSelfLootTable(TFBlocks.dark_stairs.get());
		registerLootTable(TFBlocks.dark_slab.get(), droppingSlab(TFBlocks.dark_slab.get()));
		registerDropSelfLootTable(TFBlocks.dark_button.get());
		registerDropSelfLootTable(TFBlocks.dark_fence.get());
		registerDropSelfLootTable(TFBlocks.dark_gate.get());
		registerDropSelfLootTable(TFBlocks.dark_plate.get());
		registerLootTable(TFBlocks.dark_door.get(), (b) -> droppingWhen(b, DoorBlock.HALF, DoubleBlockHalf.LOWER));
		registerDropSelfLootTable(TFBlocks.dark_trapdoor.get());

		registerDropSelfLootTable(TFBlocks.time_planks.get());
		registerDropSelfLootTable(TFBlocks.time_stairs.get());
		registerLootTable(TFBlocks.time_slab.get(), droppingSlab(TFBlocks.time_slab.get()));
		registerDropSelfLootTable(TFBlocks.time_button.get());
		registerDropSelfLootTable(TFBlocks.time_fence.get());
		registerDropSelfLootTable(TFBlocks.time_gate.get());
		registerDropSelfLootTable(TFBlocks.time_plate.get());
		registerLootTable(TFBlocks.time_door.get(), (b) -> droppingWhen(b, DoorBlock.HALF, DoubleBlockHalf.LOWER));
		registerDropSelfLootTable(TFBlocks.time_trapdoor.get());

		registerDropSelfLootTable(TFBlocks.trans_planks.get());
		registerDropSelfLootTable(TFBlocks.trans_stairs.get());
		registerLootTable(TFBlocks.trans_slab.get(), droppingSlab(TFBlocks.trans_slab.get()));
		registerDropSelfLootTable(TFBlocks.trans_button.get());
		registerDropSelfLootTable(TFBlocks.trans_fence.get());
		registerDropSelfLootTable(TFBlocks.trans_gate.get());
		registerDropSelfLootTable(TFBlocks.trans_plate.get());
		registerLootTable(TFBlocks.trans_door.get(), (b) -> droppingWhen(b, DoorBlock.HALF, DoubleBlockHalf.LOWER));
		registerDropSelfLootTable(TFBlocks.trans_trapdoor.get());

		registerDropSelfLootTable(TFBlocks.mine_planks.get());
		registerDropSelfLootTable(TFBlocks.mine_stairs.get());
		registerLootTable(TFBlocks.mine_slab.get(), droppingSlab(TFBlocks.mine_slab.get()));
		registerDropSelfLootTable(TFBlocks.mine_button.get());
		registerDropSelfLootTable(TFBlocks.mine_fence.get());
		registerDropSelfLootTable(TFBlocks.mine_gate.get());
		registerDropSelfLootTable(TFBlocks.mine_plate.get());
		registerLootTable(TFBlocks.mine_door.get(), (b) -> droppingWhen(b, DoorBlock.HALF, DoubleBlockHalf.LOWER));
		registerDropSelfLootTable(TFBlocks.mine_trapdoor.get());
		
		registerDropSelfLootTable(TFBlocks.sort_planks.get());
		registerDropSelfLootTable(TFBlocks.sort_stairs.get());
		registerLootTable(TFBlocks.sort_slab.get(), droppingSlab(TFBlocks.sort_slab.get()));
		registerDropSelfLootTable(TFBlocks.sort_button.get());
		registerDropSelfLootTable(TFBlocks.sort_fence.get());
		registerDropSelfLootTable(TFBlocks.sort_gate.get());
		registerDropSelfLootTable(TFBlocks.sort_plate.get());
		registerLootTable(TFBlocks.sort_door.get(), (b) -> droppingWhen(b, DoorBlock.HALF, DoubleBlockHalf.LOWER));
		registerDropSelfLootTable(TFBlocks.sort_trapdoor.get());
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return knownBlocks;
	}
}