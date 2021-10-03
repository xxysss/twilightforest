package twilightforest.world.components.structures.courtyard;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import twilightforest.TwilightForestMod;
import twilightforest.world.components.processors.MossyCobbleTemplateProcessor;
import twilightforest.world.components.structures.TwilightDoubleTemplateStructurePiece;
import twilightforest.world.components.structures.lichtowerrevamp.LichTowerUtil;

import java.util.Random;

public class CourtyardWallCornerInner extends TwilightDoubleTemplateStructurePiece {
    public CourtyardWallCornerInner(ServerLevel level, CompoundTag nbt) {
        super(NagaCourtyardPieces.TFNCWA,
                nbt,
                level,
                LichTowerUtil.readSettings(nbt).addProcessor(CourtyardMain.WALL_PROCESSOR).addProcessor(CourtyardMain.WALL_INTEGRITY_PROCESSOR).addProcessor(BlockIgnoreProcessor.AIR),
                LichTowerUtil.readSettings(nbt).addProcessor(MossyCobbleTemplateProcessor.INSTANCE).addProcessor(CourtyardMain.WALL_DECAY_PROCESSOR)
        );
    }

    public CourtyardWallCornerInner(int i, int x, int y, int z, Rotation rotation, StructureManager structureManager) {
        super(NagaCourtyardPieces.TFNCWA,
                i,
                structureManager,
                new ResourceLocation(TwilightForestMod.ID, "courtyard/courtyard_wall_corner_inner"),
                LichTowerUtil.makeSettings(rotation).addProcessor(CourtyardMain.WALL_PROCESSOR).addProcessor(CourtyardMain.WALL_INTEGRITY_PROCESSOR).addProcessor(BlockIgnoreProcessor.AIR),
                new ResourceLocation(TwilightForestMod.ID, "courtyard/courtyard_wall_corner_inner_decayed"),
                LichTowerUtil.makeSettings(rotation).addProcessor(MossyCobbleTemplateProcessor.INSTANCE).addProcessor(CourtyardMain.WALL_DECAY_PROCESSOR),
                new BlockPos(x, y, z)
        );
    }

    @Override
    protected void handleDataMarker(String label, BlockPos pos, ServerLevelAccessor levelAccessor, Random random, BoundingBox boundingBox) {

    }

    @Override
    public NoiseEffect getNoiseEffect() {
        return NoiseEffect.BEARD;
    }
}