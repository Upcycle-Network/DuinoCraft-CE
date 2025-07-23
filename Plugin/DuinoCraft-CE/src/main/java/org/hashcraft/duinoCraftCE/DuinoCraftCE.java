package org.hashcraft.duinoCraftCE;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.hashcraft.duinoCraftCE.handlers.MessageHandler;
import org.jetbrains.annotations.Nullable;

public final class DuinoCraftCE extends JavaPlugin implements Listener {
    MessageHandler messageHandler = new MessageHandler(this);
    @Override
    public void onEnable() {
        DuinoCraftCE plugin = this;
        getLogger().info("DuinoCraft CE is running.");
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getPluginManager().registerEvents(new MessageHandler(this),this);
    }
    @Override
    public void onDisable() {

    }
    @EventHandler
    public void playerJoin (PlayerJoinEvent pje){
        var player = pje.getPlayer();
        @Nullable Component msg = Component.text("Welcome " + messageHandler.txtFormat(3) + player.getName() + "§r to DuinoCraft Community Edition!").color(TextColor.fromHexString("#fa5e1b"));
        pje.joinMessage(msg);
        messageHandler.out(player, "tellraw " + player.getName() + " {\"text\":\""+ messageHandler.txtFormat(9) + "If you have not linked your account, click here to join our Discord Server.\",\"color\":\"#02FF00\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://discord.gg/vH8fxYZcr8\"}}", 10*20, 0, "0", 0);
        messageHandler.out(player, "To log in, use the command /login <DuinoCoin Wallet Name>", 5*20, 1, "#fafa1b", 1);
    }
}
