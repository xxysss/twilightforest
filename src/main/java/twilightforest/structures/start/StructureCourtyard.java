package twilightforest.structures.start;

import com.mojang.serialization.Codec;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.TwilightForestMod;
import twilightforest.structures.StructureTFComponentTemplate;
import twilightforest.structures.courtyard.ComponentNagaCourtyardMain;

import static twilightforest.TFFeature.NAGA_COURTYARD;

public class StructureCourtyard extends Structure<NoFeatureConfig> {

	public static final ResourceLocation NAME = TwilightForestMod.prefix("courtyard");

	public StructureCourtyard(Codec<NoFeatureConfig> codec) {
		super(codec);
	}

	@Override
	public GenerationStage.Decoration getDecorationStage() {
		return GenerationStage.Decoration.SURFACE_STRUCTURES;
	}

	@Override
	public IStartFactory<NoFeatureConfig> getStartFactory() {
		return Start::new;
	}

	@Override
	protected boolean func_230363_a_(ChunkGenerator generator, BiomeProvider provider, long seed, SharedSeedRandom random, int chunkX, int chunkZ, Biome biome, ChunkPos structurePos, NoFeatureConfig config) {
		// set the chunkX and chunkZ to the center of the biome
		chunkX = Math.round(chunkX / 16F) * 16;
		chunkZ = Math.round(chunkZ / 16F) * 16;
		int regionOffsetX = Math.abs((chunkX + 64 >> 4) % 8);
		int regionOffsetZ = Math.abs((chunkZ + 64 >> 4) % 8);
		return (regionOffsetX == 5 && regionOffsetZ == 4) || (regionOffsetX == 3 && regionOffsetZ == 4);
	}

	public static class Start extends StructureStart<NoFeatureConfig> {

		public Start(Structure<NoFeatureConfig> p_i225876_1_, int p_i225876_2_, int p_i225876_3_, MutableBoundingBox p_i225876_4_, int p_i225876_5_, long p_i225876_6_) {
			super(p_i225876_1_, p_i225876_2_, p_i225876_3_, p_i225876_4_, p_i225876_5_, p_i225876_6_);
		}

		@Override
		public void func_230364_a_(DynamicRegistries p_230364_1_, ChunkGenerator p_230364_2_, TemplateManager p_230364_3_, int p_230364_4_, int p_230364_5_, Biome p_230364_6_, NoFeatureConfig p_230364_7_) {
			int y = p_230364_2_.getHeight(p_230364_4_, p_230364_5_, Heightmap.Type.WORLD_SURFACE_WG);
			ComponentNagaCourtyardMain start = new ComponentNagaCourtyardMain(NAGA_COURTYARD, rand, 0, (p_230364_4_ << 4) + 7, y, (p_230364_5_ << 4) + 7);
			components.add(start);
			start.buildComponent(start, components, rand);
			components.stream().filter(piece -> piece instanceof StructureTFComponentTemplate).map(StructureTFComponentTemplate.class::cast).forEach(piece -> piece.setup(p_230364_3_, null));
			this.recalculateStructureSize();
			this.func_214626_a(this.rand, 42, 42);
		}
	}
}