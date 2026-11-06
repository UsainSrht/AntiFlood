package me.usainsrht.antiflood.neoforge;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.PistonEvent;

@Mod("antiflood")
public final class AntiFloodNeoForge {

    public AntiFloodNeoForge() {
        NeoForge.EVENT_BUS.addListener(AntiFloodNeoForge::onPistonPre);
    }

    private static void onPistonPre(PistonEvent.Pre event) {
        LevelAccessor level = event.getLevel();
        if (isWaterlogged(level.getBlockState(event.getPos()))) {
            event.setCanceled(true);
            return;
        }
        PistonStructureResolver resolver = event.getStructureHelper();
        if (resolver == null || !resolver.resolve()) {
            return;
        }
        for (BlockPos p : resolver.getToPush()) {
            if (isWaterlogged(level.getBlockState(p))) {
                event.setCanceled(true);
                return;
            }
        }
        for (BlockPos p : resolver.getToDestroy()) {
            if (isWaterlogged(level.getBlockState(p))) {
                event.setCanceled(true);
                return;
            }
        }
    }

    private static boolean isWaterlogged(BlockState state) {
        return state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED);
    }
}
