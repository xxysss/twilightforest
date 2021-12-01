package twilightforest.world.components.structures.icetower;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import twilightforest.world.components.structures.TFStructureComponent;
import twilightforest.world.components.structures.TFStructureComponentOld;
import twilightforest.world.registration.TFFeature;

import java.util.Random;

public class IceTowerBridgeComponent extends TFStructureComponentOld {

	private final int length;

	public IceTowerBridgeComponent(StructurePieceSerializationContext ctx, CompoundTag nbt) {
		super(IceTowerPieces.TFITBri, nbt);
		this.length = nbt.getInt("bridgeLength");
	}

	public IceTowerBridgeComponent(TFFeature feature, int index, int x, int y, int z, int length, Direction direction) {
		super(IceTowerPieces.TFITBri, feature, index, x, y, z);
		this.length = length;
		this.setOrientation(direction);

		this.boundingBox = feature.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, length, 6, 5, direction);
	}

	@Override
	protected void addAdditionalSaveData(StructurePieceSerializationContext ctx, CompoundTag tagCompound) {
		super.addAdditionalSaveData(ctx, tagCompound);
		tagCompound.putInt("bridgeLength", this.length);
	}

	@Override
	public void addChildren(StructurePiece parent, StructurePieceAccessor list, Random rand) {
		if (parent != null && parent instanceof TFStructureComponent tfStructureComponent) {
			this.deco = tfStructureComponent.deco;
		}
	}

	@Override
	public void postProcess(WorldGenLevel world, StructureFeatureManager manager, ChunkGenerator generator, Random rand, BoundingBox sbb, ChunkPos chunkPosIn, BlockPos blockPos) {
		generateAirBox(world, sbb, 0, 1, 0, length, 5, 4);

		// make floor/ceiling
		generateBox(world, sbb, 0, 0, 0, length, 0, 4, deco.blockState, deco.blockState, false);
		generateBox(world, sbb, 0, 6, 0, length, 6, 4, deco.blockState, deco.blockState, false);

		// pillars
		for (int x = 2; x < length; x += 3) {
			generateBox(world, sbb, x, 1, 0, x, 5, 0, deco.pillarState, deco.pillarState, false);
			generateBox(world, sbb, x, 1, 4, x, 5, 4, deco.pillarState, deco.pillarState, false);
		}
	}
}
