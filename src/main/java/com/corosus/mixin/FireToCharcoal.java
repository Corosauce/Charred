package com.corosus.mixin;

import com.corosus.CharredRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FireBlock.class)
public abstract class FireToCharcoal {

    @Redirect(method = "tryCatchFire",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;removeBlock(Lnet/minecraft/core/BlockPos;Z)Z"))
    public boolean removeBlock(Level instance, BlockPos p_46623_, boolean p_46624_) {
        //hooking code that removes the block on fire
        BlockState state = instance.getBlockState(p_46623_);
        if (BlockTags.LOGS.contains(state.getBlock())) {
            return instance.setBlock(p_46623_, CharredRegistry.BLOCK_CHARRED_LOG.get().defaultBlockState(), 3 | (p_46624_ ? 64 : 0));
        } else {
            return instance.removeBlock(p_46623_, p_46624_);
        }
    }

    @Redirect(method = "tryCatchFire",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z"))
    public boolean setBlock(Level instance, BlockPos p_46601_, BlockState p_46602_, int p_46603_) {
        //hooking code that tries to place more fire in place of the block on fire
        BlockState state = instance.getBlockState(p_46601_);
        if (BlockTags.LOGS.contains(state.getBlock())) {
            return instance.setBlock(p_46601_, CharredRegistry.BLOCK_CHARRED_LOG.get().defaultBlockState(), p_46603_);
        } else {
            return instance.removeBlock(p_46601_, false);
        }
    }
}