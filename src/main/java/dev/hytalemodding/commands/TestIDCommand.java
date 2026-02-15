package dev.hytalemodding.commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;

public class TestIDCommand extends AbstractPlayerCommand {

    public TestIDCommand() {
        // This defines the command as /testid in the game
        super("testid", "Tests if we can hide the controls menu");
    }

    @Override
    protected void execute(@Nonnull CommandContext context, @Nonnull Store<EntityStore> store, @Nonnull Ref<EntityStore> ref, @Nonnull Player player, @Nonnull World world) {
        // This is the core logic: try to hide the UI component with our guessed ID
        player.getHudManager().hideHudComponents("#Settings_Controls_List");

        // Send a message to yourself so you know the command actually ran
        player.sendMessage(Message.raw("Attempted to hide #Settings_Controls_List. Check if the menu changed!"));
    }
}
