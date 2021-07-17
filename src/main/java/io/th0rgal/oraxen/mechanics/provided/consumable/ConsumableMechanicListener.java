package io.th0rgal.oraxen.mechanics.provided.consumable;

import io.th0rgal.oraxen.items.OraxenItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class ConsumableMechanicListener implements Listener {

    private final ConsumableMechanicFactory factory;

    public ConsumableMechanicListener(ConsumableMechanicFactory factory) {
        this.factory = factory;
    }

    @EventHandler
    public void onItemUsed(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK)
            return;

        ItemStack item = event.getItem();
        String itemID = OraxenItems.getIdByItem(item);
        if (factory.isNotImplementedIn(itemID))
            return;

        Player player = event.getPlayer();
        PlayerInventory inventory = player.getInventory();
        item.setAmount(item.getAmount() -1);
        if(event.getHand().equals(EquipmentSlot.OFF_HAND)){
            inventory.setItem(45, item);
        } else {
            inventory.setItem(inventory.getHeldItemSlot(), item);
        }
    }

}
