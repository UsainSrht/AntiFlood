package me.usainsrht.antiflood.listener;

import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;

import java.util.List;

public class PistonListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPistonExtend(BlockPistonExtendEvent event) {
        if (isWaterlogged(event.getBlock()) || containsWaterlogged(event.getBlocks())) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPistonRetract(BlockPistonRetractEvent event) {
        if (isWaterlogged(event.getBlock()) || containsWaterlogged(event.getBlocks())) {
            event.setCancelled(true);
        }
    }

    private boolean containsWaterlogged(List<Block> blocks) {
        if (blocks == null || blocks.isEmpty()) {
            return false;
        }
        for (Block block : blocks) {
            if (isWaterlogged(block)) {
                return true;
            }
        }
        return false;
    }

    private boolean isWaterlogged(Block block) {
        if (block == null) {
            return false;
        }
        BlockData blockData = block.getBlockData();
        return blockData instanceof Waterlogged && ((Waterlogged) blockData).isWaterlogged();
    }
}
