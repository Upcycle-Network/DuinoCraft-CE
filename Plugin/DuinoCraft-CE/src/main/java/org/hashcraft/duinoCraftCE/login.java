package org.hashcraft.duinoCraftCE;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;
public class login implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("This command can only be used by players in-game.");
            return true;
        }
        if (args.length != 1){
            commandSender.sendMessage("Invalid number of arguments.");
        } else {
            Player player = (Player) commandSender;
            return true;
        }
        return false;
    }

}
