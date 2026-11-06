package me.usainsrht.antiflood.fabric.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Stops pistons from moving waterlogged blocks (or operating while waterlogged themselves). */
@Mixin(PistonBaseBlock.class)
public abstract class PistonBaseBlockMixin {

    @Inject(method = "moveBlocks", at = @At("HEAD"), cancellable = true)
    private void antiflood$blockWaterlogged(Level level, BlockPos pos, Direction direction, boolean extending,
                                            CallbackInfoReturnable<Boolean> cir) {
        if (isWaterlogged(level.getBlockState(pos))) {
            cir.setReturnValue(false);
            return;
        }
        PistonStructureResolver resolver = new PistonStructureResolver(level, pos, direction, extending);
        if (!resolver.resolve()) {
            return; // vanilla will refuse the move anyway
        }
        for (BlockPos p : resolver.getToPush()) {
            if (isWaterlogged(level.getBlockState(p))) {
                cir.setReturnValue(false);
                return;
            }
        }
        for (BlockPos p : resolver.getToDestroy()) {
            if (isWaterlogged(level.getBlockState(p))) {
                cir.setReturnValue(false);
                return;
            }
        }
    }

    private static boolean isWaterlogged(BlockState state) {
        return state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED);
    }
}
