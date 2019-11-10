package io.th0rgal.oraxen.commands.subcommands;

import io.th0rgal.oraxen.commands.CommandInterface;
import io.th0rgal.oraxen.settings.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandInterface {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!sender.hasPermission("oraxen.command.reload")) {
            Message.DONT_HAVE_PERMISSION.send(sender, "oraxen.command.reload");
            return false;
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;

        }

        return false;
    }
}